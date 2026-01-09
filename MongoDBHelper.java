package taskmanagement;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.types.ObjectId;
import taskmanagement.model.donor;

import java.util.ArrayList;
import java.util.List;

public class MongoDBHelper {
    private static MongoClient mongoClient;
    private static MongoDatabase database;

    static {
        mongoClient = MongoClients.create("mongodb://localhost:27017");
        database = mongoClient.getDatabase("BloodDonationDB");
    }

    public static void addDonor(donor donor) {
        MongoCollection<Document> collection = database.getCollection("Donors");
        Document doc = new Document("name", donor.getName())
                .append("cnic", donor.getCnic())
                .append("age", donor.getAge())
                .append("gender", donor.getGender())
                .append("contactNo", donor.getContactNo())
                .append("bloodType", donor.getBloodType())
                .append("quantity", donor.getQuantity())
                .append("city", donor.getCity());
        collection.insertOne(doc);
    }

    public static String addDonor_return(donor donor) {
        MongoCollection<Document> collection = database.getCollection("Donors");
        Document doc = new Document("name", donor.getName())
                .append("cnic", donor.getCnic())
                .append("age", donor.getAge())
                .append("gender", donor.getGender())
                .append("contactNo", donor.getContactNo())
                .append("bloodType", donor.getBloodType())
                .append("quantity", donor.getQuantity())
                .append("city", donor.getCity());
        collection.insertOne(doc);

        // Return the _id of the inserted document
        return doc.getObjectId("_id").toString();
    }

    public static boolean authenticateAdmin(String name, String password) {
        MongoCollection<Document> collection = database.getCollection("Admins");
        Document query = new Document("name", name).append("password", password);
        Document admin = collection.find(query).first();
        return admin != null;
    }

    public static void addAdmin(String name, String password) {
        MongoCollection<Document> collection = database.getCollection("Admins");
        Document adminDoc = new Document("name", name).append("password", password);
        collection.insertOne(adminDoc);
    }

    public static boolean deleteAdmin(String adminId) {
        MongoCollection<Document> collection = database.getCollection("Admins");
        Document query = new Document("_id", new ObjectId(adminId));
        return collection.deleteOne(query).getDeletedCount() > 0;
    }

    public static String getAllAdmins() {
        MongoCollection<Document> collection = database.getCollection("Admins");
        FindIterable<Document> admins = collection.find();
        StringBuilder result = new StringBuilder("All Admins:\n");
        for (Document admin : admins) {
            for (String key : admin.keySet()) {
                result.append(key).append(": ").append(admin.get(key)).append("\n");
            }
            result.append("\n");
        }
        return result.toString();
    }

    public static boolean deleteDonor(String donorId) {
        MongoCollection<Document> collection = database.getCollection("Donors");
        Document query = new Document("_id", new ObjectId(donorId));
        return collection.deleteOne(query).getDeletedCount() > 0;
    }

    public static donor getDonorById(String donorId) {
        MongoCollection<Document> collection = database.getCollection("Donors");
        Document query = new Document("_id", new ObjectId(donorId));
        Document donorDoc = collection.find(query).first();
        if (donorDoc == null) {
            return null;
        }
        return new donor(
                donorDoc.getString("name"),
                donorDoc.getString("cnic"),
                donorDoc.getInteger("age"),
                donorDoc.getString("gender"),
                donorDoc.getString("contactNo"),
                donorDoc.getString("bloodType"),
                donorDoc.getInteger("quantity"),
                donorDoc.getString("city")
        );
    }

    public static List<donor> getAllDonors() {
        MongoCollection<Document> collection = database.getCollection("Donors");
        List<donor> allDonors = new ArrayList<>();
        FindIterable<Document> donors = collection.find();
        for (Document donorDoc : donors) {
            donor d = new donor(
                    donorDoc.getString("name"),
                    donorDoc.getString("cnic"),
                    donorDoc.getInteger("age"),
                    donorDoc.getString("gender"),
                    donorDoc.getString("contactNo"),
                    donorDoc.getString("bloodType"),
                    donorDoc.getInteger("quantity"),
                    donorDoc.getString("city")
            );
            allDonors.add(d);
        }
        return allDonors;
    }

    public static String getAllDonors1() {
        MongoCollection<Document> collection = database.getCollection("Donors");
        FindIterable<Document> donors = collection.find();
        StringBuilder result = new StringBuilder("All Donors:\n");
        for (Document donor : donors) {
            for (String key : donor.keySet()) {
                result.append(key).append(": ").append(donor.get(key)).append("\n");
            }
            result.append("\n");
        }
        return result.toString();
    }

    public static void updateDonor(String donorId, donor updatedDonor) {
        MongoCollection<Document> collection = database.getCollection("Donors");
        Document query = new Document("_id", new ObjectId(donorId));

        Document update = new Document("$set", new Document("name", updatedDonor.getName())
                .append("cnic", updatedDonor.getCnic())
                .append("age", updatedDonor.getAge())
                .append("gender", updatedDonor.getGender())
                .append("contactNo", updatedDonor.getContactNo())
                .append("bloodType", updatedDonor.getBloodType()));

        collection.updateOne(query, update);
    }

    // Placeholder method to get all donations
    public static String getAllDonations() {
        MongoCollection<Document> collection = database.getCollection("Donations");
        FindIterable<Document> donations = collection.find();
        StringBuilder result = new StringBuilder("All Donations:\n");
        for (Document donation : donations) {
            for (String key : donation.keySet()) {
                result.append(key).append(": ").append(donation.get(key)).append("\n");
            }
            result.append("\n");
        }
        return result.toString();
    }

    // Placeholder method to get all blood banks
    public static String getAllBloodBanks() {
        MongoCollection<Document> collection = database.getCollection("BloodBanks");
        FindIterable<Document> bloodBanks = collection.find();
        StringBuilder result = new StringBuilder("All Blood Banks:\n");
        for (Document bloodBank : bloodBanks) {
            for (String key : bloodBank.keySet()) {
                result.append(key).append(": ").append(bloodBank.get(key)).append("\n");
            }
            result.append("\n");
        }
        return result.toString();
    }

    public static void addDonation(String donorId, String donorName, int quantityInMl) {
        MongoCollection<Document> collection = database.getCollection("Donations");
        Document doc = new Document("donorId", new ObjectId(donorId))
                .append("donorName", donorName)
                .append("quantityInMl", quantityInMl);
        collection.insertOne(doc);
    }

    public static void addBloodBank(String name) {
        MongoCollection<Document> collection = database.getCollection("BloodBanks");
        Document bloodBankDoc = new Document("name", name)
                .append("O+", 0)
                .append("O-", 0)
                .append("A+", 0)
                .append("A-", 0)
                .append("B+", 0)
                .append("B-", 0)
                .append("AB+", 0)
                .append("AB-", 0);
        collection.insertOne(bloodBankDoc);
    }

    public static boolean checkBloodBankExists(String city) {
        MongoCollection<Document> collection = database.getCollection("BloodBanks");
        Document query = new Document("name", city);
        Document bloodBank = collection.find(query).first();
        return bloodBank != null;
    }

    public static void updateBloodBankQuantity(String city, String bloodType, int quantityToAdd) {
        MongoCollection<Document> collection = database.getCollection("BloodBanks");
        Document query = new Document("name", city);
        collection.updateOne(query, Updates.inc(bloodType, quantityToAdd));
    }

    public static void addBloodTransfusion(String donorID, String recipientID, String bloodBankName, String bloodType, int quantity, String date) {
        // Check if the required blood type and quantity are available in the blood bank
        if (isBloodTypeAndQuantityAvailable(bloodBankName, bloodType, quantity)) {
            // Add the transfusion record
            MongoCollection<Document> transfusionCollection = database.getCollection("blood_transfusions");
            Document transfusionDoc = new Document("donorID", donorID)
                    .append("recipientID", recipientID)
                    .append("bloodBankName", bloodBankName)
                    .append("bloodType", bloodType)
                    .append("quantity", quantity)
                    .append("date", date);
            transfusionCollection.insertOne(transfusionDoc);
    
            // Update the blood bank's inventory
            MongoCollection<Document> bloodBankCollection = database.getCollection("BloodBanks");
            Document query = new Document("name", bloodBankName);
            Document bloodBankDoc = bloodBankCollection.find(query).first();
            if (bloodBankDoc != null) {
                int currentQuantity = bloodBankDoc.getInteger(bloodType);
                int updatedQuantity = currentQuantity - quantity;
                bloodBankCollection.updateOne(query, new Document("$set", new Document(bloodType, updatedQuantity)));
            }
        } else {
            throw new IllegalArgumentException("Insufficient blood quantity available in the blood bank.");
        }
    }
    
    

    public static String getAllBloodTransfusions() {
        MongoCollection<Document> collection = database.getCollection("blood_transfusions");
        StringBuilder allTransfusions = new StringBuilder();
        for (Document doc : collection.find()) {
            allTransfusions.append("Donor ID: ").append(doc.getString("donorID"))
                    .append(", Recipient ID: ").append(doc.getString("recipientID"))
                    .append(", Blood Bank: ").append(doc.getString("bloodBankName"))
                    .append(", Blood Type: ").append(doc.getString("bloodType"))
                    .append(", Quantity: ").append(doc.getInteger("quantity"))
                    .append(", Date: ").append(doc.getString("date")).append("\n");
        }
        return allTransfusions.toString();
    }

    public static boolean isDonorAvailable(String donorID) {
        MongoCollection<Document> collection = database.getCollection("Donors");
        Document query = new Document("_id", new ObjectId(donorID));
        return collection.find(query).first() != null;
    }

    public static boolean isRecipientAvailable(String recipientID) {
        MongoCollection<Document> collection = database.getCollection("recipients");
        Document query = new Document("_id", new ObjectId(recipientID));
        return collection.find(query).first() != null;
    }

    public static boolean isBloodBankAvailable(String bloodBankName) {
        MongoCollection<Document> collection = database.getCollection("BloodBanks");
        Document query = new Document("name", bloodBankName);
        return collection.find(query).first() != null;
    }

    public static void addRecipient(String name, String bloodType, String city) {
        MongoCollection<Document> collection = database.getCollection("recipients");
        Document document = new Document("name", name)
                .append("bloodType", bloodType)
                .append("city", city);
        collection.insertOne(document);
    }

    public static String getAllRecipients() {
        MongoCollection<Document> collection = database.getCollection("recipients");
        StringBuilder allRecipients = new StringBuilder();
        for (Document doc : collection.find()) {
            ObjectId id = doc.getObjectId("_id");
            allRecipients.append("ID: ").append(id.toHexString())
                    .append(", Name: ").append(doc.getString("name"))
                    .append(", Blood Type: ").append(doc.getString("bloodType"))
                    .append(", City: ").append(doc.getString("city")).append("\n");
        }
        return allRecipients.toString();
    }

    public static boolean isBloodTypeAndQuantityAvailable(String bloodBankName, String bloodType, int quantity) {
        MongoCollection<Document> collection = database.getCollection("BloodBanks");
        Document doc = collection.find(new Document("name", bloodBankName)).first();
        if (doc != null) {
            Integer availableQuantity = doc.getInteger(bloodType);
            return availableQuantity != null && availableQuantity >= quantity;
        }
        return false;
    }
    
}
