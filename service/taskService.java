package taskmanagement.service;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import taskmanagement.model.task;
import taskmanagement.model.project;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class taskService {
    private MongoCollection<Document> taskCollection;
    private MongoCollection<Document> projectCollection;
    private MongoClient mongoClient;

    public taskService() {
        mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("task_management");
        taskCollection = database.getCollection("tasks");
        projectCollection = database.getCollection("projects");
    }

    // task CRUD operations
    public void addTask(task task) {
        Document doc = new Document("name", task.getName())
                .append("description", task.getDescription())
                .append("deadline", task.getDeadline())
                .append("priority", task.getPriority())
                .append("status", task.getStatus());
        taskCollection.insertOne(doc);
    }

    public List<task> getAllTasks() {
        List<task> tasks = new ArrayList<>();
        for (Document doc : taskCollection.find()) {
            task task = new task();
            task.setId(doc.getObjectId("_id"));
            task.setName(doc.getString("name"));
            task.setDescription(doc.getString("description"));
            task.setDeadline(doc.getString("deadline"));
            task.setPriority(doc.getString("priority"));
            task.setStatus(doc.getString("status"));
            tasks.add(task);
        }
        return tasks;
    }

    public void updateTask(ObjectId id, String status) {
        taskCollection.updateOne(eq("_id", id), new Document("$set", new Document("status", status)));
    }

    public void deleteTask(ObjectId id) {
        taskCollection.deleteOne(eq("_id", id));
    }

    // project CRUD operations
    public void addProject(project project) {
        Document doc = new Document("name", project.getName())
                .append("description", project.getDescription());
        projectCollection.insertOne(doc);
    }

    public List<project> getAllProjects() {
        List<project> projects = new ArrayList<>();
        for (Document doc : projectCollection.find()) {
            project project = new project();
            project.setId(doc.getObjectId("_id"));
            project.setName(doc.getString("name"));
            project.setDescription(doc.getString("description"));
            projects.add(project);
        }
        return projects;
    }

    public void updateProject(ObjectId id, String name, String description) {
        Document update = new Document("name", name).append("description", description);
        projectCollection.updateOne(eq("_id", id), new Document("$set", update));
    }

    public void deleteProject(ObjectId id) {
        projectCollection.deleteOne(eq("_id", id));
    }

    // Close MongoClient connection
    public void close() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }

    @Override
    protected void finalize() throws Throwable {
        close();
        super.finalize();
    }
}
