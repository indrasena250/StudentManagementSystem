# 🎓 Student Management System (Java + MySQL)

A **console-based Java application** to manage student information in educational institutions.  
This system supports adding, viewing, updating, deleting, and searching student records, with an admin login system for security.

---

## 🚀 Features

- **Admin Login** – Secure login to access the system  
- **Add Student** – Add new student records (Name, Age, Course, Grade)  
- **View Students** – List all students with their details  
- **Update Student** – Update student information by ID  
- **Delete Student** – Remove student records by ID  
- **Search Student** – Search students by name (partial match)  

---

## 🛠️ Technology Stack

- **Java (Core)**
- **MySQL** – Database for storing students and admin info
- **JDBC** – Java Database Connectivity to connect Java with MySQL
- **VS Code** – IDE for development

---

## 💾 Database Setup

1. Create the database:

```sql
CREATE DATABASE student_db;
USE student_db;
````

2. Create the `students` table:

```sql
CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    age INT,
    course VARCHAR(100),
    grade VARCHAR(10)
);
```

3. Create the `admins` table:

```sql
CREATE TABLE admins (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50),
    password VARCHAR(50)
);

-- Add default admin
INSERT INTO admins(username, password) VALUES('admin','admin123');
```

---

## ⚙️ How to Run

1. **Clone or download** the project.
2. **Add MySQL Connector/J JAR** to your project (`lib/mysql-connector-j-9.5.0.jar`).
3. Update **DBConnection.java** with your MySQL username and password:

```java
conn = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/student_db",
    "root",
    "your_password_here"
);
```

4. Open terminal in `src` folder and compile:

```bash
javac -cp "../lib/mysql-connector-j-9.5.0.jar" *.java
```

5. Run the program:

```bash
java -cp "../lib/mysql-connector-j-9.5.0.jar;." Main
```

6. **Login** using default admin credentials:

```
Username: admin
Password: admin123
```

7. Use the **menu** to manage students.

---


## ✅ Project Structure

```
StudentManagementSystem/
├── lib/
│   └── mysql-connector-j-9.5.0.jar
├── src/
│   ├── Main.java
│   ├── DBConnection.java
│   ├── StudentDAO.java
│   └── AdminDAO.java
├── README.md
```

---

## 📌 Notes

* Default admin username/password: `admin` / `admin123`
* Passwords are stored in plain text (for learning purposes only).
* Recommended: Change password or implement password hashing for production.

---

## 📁 Future Enhancements

* Implement a **GUI version** using Java Swing/JavaFX
* Export students data to **CSV or Excel**
* Multiple admin users with role-based access
* Password hashing for security

```
