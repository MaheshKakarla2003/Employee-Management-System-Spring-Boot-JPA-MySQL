# Employee Management System (Spring Boot + JPA + MySQL)

A backend-only Spring Boot project built to understand and implement **JPA relationships**, including:

- **One-to-Many / Many-to-One** → Department ↔ Employee  
- **One-to-One** → Employee ↔ ParkingPass  
- **Many-to-Many** → Employee ↔ Project  

The project follows clean architecture using DTOs, a service layer, mappers, exception handling, and layered design.

---

## 📌 Features

### 🟦 Department Management
- Create, update, delete departments  
- Retrieve all departments or by ID  
- Fetch employees inside a department    

### 🟩 Employee Management
- Create, update, delete employees  
- Assign employee to a department  
- Add / remove projects for an employee  
- Handle one-to-one ParkingPass  
- Fetch employee with related details  

### 🟧 Parking Pass (1 : 1)
- Assign a ParkingPass to an employee  
- Update ParkingPass details  
- Delete / revoke ParkingPass  
- Each employee can have **only one** parking pass  

### 🟨 Project Management (Many : Many)
- Create and update projects  
- Assign employees to a project  
- Remove employees from a project  
- View employees working on a project  

---

## 🧩 Entity Relationships

```text
Department 1 ----- * Employee
Employee   1 ----- 1 ParkingPass
Employee   * ----- * Project
```

---

## 🛠 Technologies Used

- Java 17+  
- Spring Boot  
- Spring Data JPA (Hibernate)  
- MySQL  
- Lombok  
- Jakarta Validation  
- Maven  

---

## 📂 Project Structure

```text
src/main/java/com/employee/management
│
├── controller
├── dto
│   ├── request
│   └── response
├── entity
├── exception
├── mapper
├── repository
├── service
│   └── impl
└── EmployeeManagementApplication.java
```

---

## ⚙️ Setup

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/<your-username>/<your-repo>.git
cd <your-repo>
```

### 2️⃣ Create MySQL Database

```sql
CREATE DATABASE employee_management;
```

### 3️⃣ Update application.properties

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/database_name
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

### 4️⃣ Run the Application

```bash
mvn spring-boot:run
```
---

## ❗ Global Error Handling

- Resource not found  
- Validation errors  
- Duplicate entries  
- Database constraint violations  
- Internal server errors  

Error response fields:
- timestamp  
- status  
- message  
- path  

---

## 📘 What This Project Teaches

- REST API design  
- JPA entity relationships  
- Owning vs inverse sides  
- DTO pattern  
- Service-layer architecture  
- Exception handling  
- Clean backend structure  

---

## 📌 Final Notes

This project helps understand core Spring Boot backend concepts and JPA relationship mappings.  
Feel free to fork and enhance!
