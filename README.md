# Blood Management System (MongoDB + Java GUI)

## Project Overview
The **Blood Management System** is a database-driven application developed to manage blood donors, recipients, blood banks, donations, and transfusion records efficiently.

This project was implemented in two phases:
- **Mid Term**: SQL-based system with Command Line Interface (CLI)
- **Final Term**: MongoDB-based system with **Graphical User Interface (GUI)**

The final version improves usability by introducing a Java Swing GUI and migrating the database to **MongoDB** for better scalability and flexibility.

---

## Objectives
- Manage donor and recipient records efficiently
- Track blood donations and transfusions
- Maintain blood bank information
- Provide an interactive and user-friendly GUI
- Demonstrate NoSQL (MongoDB) integration with Java

---

## Technologies Used
- **Programming Language**: Java
- **GUI Framework**: Java Swing
- **Database**: MongoDB
- **Database Connector**: MongoDB Java Driver
- **Development Environment**: NetBeans / IntelliJ IDEA
- **Data Format**: JSON

---

## Database Details
- Database Name: **BloodDonationDB**
- Collections:
  - Admins
  - Donors
  - Recipients
  - BloodBanks
  - Donations
  - Blood_Transfusions

The provided `.json` files can be imported directly into MongoDB.

---

## How to Run the Project

### 1️⃣ Prerequisites
- Java JDK 8 or later
- MongoDB installed and running
- IDE (NetBeans / IntelliJ)

---

### 2️⃣ Import Database
```bash
mongoimport --db BloodDonationDB --collection Donors --file BloodDonationDB.Donors.json --jsonArray

