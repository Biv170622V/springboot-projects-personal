Cart and Product Management System

This project is a **Spring Boot** application that demonstrates a **Cart and Product Management System**. It allows users to manage products and carts with functionalities like adding products to a cart, retrieving cart details, and handling many-to-many relationships between carts and products.

## Features
- CRUD operations for **Products** and **Carts**.
- Add products to a cart.
- Fetch cart details with associated products.
- Handles **lazy loading** of entities using Hibernate.
- Uses **Spring Data JPA** for database interactions.
- RESTful API for interacting with the system.

## Tech Stack
- **Java 17** (or compatible JDK)
- **Spring Boot 3.x**
- **Spring Data JPA**
- **Hibernate**
- **MySQL** (or any relational database)
- **Lombok** (optional, for boilerplate reduction)
- **Maven** for dependency management

---

## Setup and Installation

### Prerequisites
- JDK 17 or higher
- MySQL installed and running
- Maven installed (optional, IDEs handle this)

### Database Configuration
1. Update the `application.properties` file in `src/main/resources` to match your MySQL configuration:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/cart_product_db
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```

2. Create the database:
   ```sql
   CREATE DATABASE cart_product_db;
   ```

### Build and Run
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/cart-product-management.git
   cd cart-product-management
   ```

2. Build the project using Maven:
   ```bash
   mvn clean install
   ```

3. Run the application:
   ```bash
   mvn spring-boot:run
   ```
   The application will start on [http://localhost:8080](http://localhost:8080).

---

## API Endpoints

### Product APIs
- **Create Product**  
  `POST /products`  
  **Request Body:**
  ```json
  {
      "name": "Product Name",
      "price": 100.0
  }
  ```
  **Response:**  
  Returns the created product.

- **Get All Products**  
  `GET /products`  
  **Response:**  
  Returns a list of all products.

- **Delete Product**  
  `DELETE /products/{productId}`

---

### Cart APIs
- **Create Cart**  
  `POST /carts`  
  **Request Body:**
  ```json
  {
      "userName": "John Doe"
  }
  ```
  **Response:**  
  Returns the created cart.

- **Add Product to Cart**  
  `POST /carts/{cartId}/products/{productId}`  
  **Response:**  
  Returns the updated cart.

- **Get Cart Details**  
  `GET /carts/{cartId}`  
  **Response:**  
  Returns the cart with its associated products.

---

## Database Schema
- **Cart Table**
  - `id`: Primary Key
  - `user_name`: Name of the cart owner

- **Product Table**
  - `id`: Primary Key
  - `name`: Product name
  - `price`: Product price

- **Cart_Product Table (Join Table)**
  - `cart_id`: Foreign Key referencing Cart
  - `product_id`: Foreign Key referencing Product

---

## Project Structure
```
src/main/java/com/example/firstproject
├── Controller
│   ├── CartController.java
│   └── ProductController.java
├── Entity
│   ├── Cart.java
│   ├── Product.java
├── Repository
│   ├── CartRepository.java
│   └── ProductRepository.java
├── Service
│   ├── CartService.java
│   └── ProductService.java
└── FirstprojectApplication.java
```

