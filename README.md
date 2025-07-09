# Spring Boot CRUD Application

A modern Spring Boot 3.2.0 application with user authentication, CRUD operations, and PostgreSQL database integration.

## 🚀 Features

- **User Authentication** with Spring Security
- **CRUD Operations** for Products, Users, and Orders
- **PostgreSQL Database** integration with JPA/Hibernate
- **Modern UI** with Bootstrap and Thymeleaf templates
- **Java 21** support
- **Default Admin User** creation on startup
- **Responsive Design** with Font Awesome icons

## 📋 Prerequisites

- **Java 21** or higher
- **PostgreSQL** database server
- **Maven** 3.6+ (or use the included Maven wrapper)
- **Git** (for version control)

## 🛠️ Technology Stack

- **Spring Boot** 3.2.0
- **Spring Security** 6.x
- **Spring Data JPA** with Hibernate
- **Thymeleaf** template engine
- **PostgreSQL** database
- **Bootstrap** 5.1.3
- **Font Awesome** 6.0.0
- **Maven** for dependency management
- **Lombok** for reducing boilerplate code

## 🗄️ Database Setup

1. Install PostgreSQL on your system
2. Create a database named `springboot_crud`:
   ```sql
   CREATE DATABASE springboot_crud;
   ```
3. Create a user (optional):
   ```sql
   CREATE USER springboot_user WITH PASSWORD 'password';
   GRANT ALL PRIVILEGES ON DATABASE springboot_crud TO springboot_user;
   ```

## ⚙️ Configuration

The application is configured through `src/main/resources/application.properties`:

```properties
# Database Configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/springboot_crud
spring.datasource.username=postgres
spring.datasource.password=password
spring.datasource.driver-class-name=org.postgresql.Driver

# JPA/Hibernate Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

# Server Configuration
server.port=8080

# Thymeleaf Configuration
spring.thymeleaf.cache=false
```

**Note**: Update the database credentials according to your PostgreSQL setup.

## 🚀 Running the Application

### Using Maven Wrapper (Recommended)

1. **Clone the repository**:
   ```bash
   git clone <repository-url>
   cd springbootapp
   ```

2. **Make the Maven wrapper executable**:
   ```bash
   chmod +x mvnw
   ```

3. **Run the application**:
   ```bash
   ./mvnw spring-boot:run
   ```

### Using Maven

1. **Compile the project**:
   ```bash
   mvn clean compile
   ```

2. **Run the application**:
   ```bash
   mvn spring-boot:run
   ```

### Using JAR file

1. **Build the JAR**:
   ```bash
   ./mvnw clean package
   ```

2. **Run the JAR**:
   ```bash
   java -jar target/springbootapp-0.0.1-SNAPSHOT.jar
   ```

## 🌐 Accessing the Application

Once the application is running:

- **Main URL**: http://localhost:8080
- **Login Page**: http://localhost:8080/login
- **Default Credentials**: 
  - Username: `admin`
  - Password: `admin123`

## 📁 Project Structure

```
src/
├── main/
│   ├── java/com/example/springbootapp/
│   │   ├── config/
│   │   │   └── SecurityConfig.java          # Security configuration
│   │   ├── controller/
│   │   │   ├── MainController.java          # Home and login routes
│   │   │   ├── ProductController.java       # Product CRUD operations
│   │   │   ├── UserController.java          # User management
│   │   │   └── OrderController.java         # Order management
│   │   ├── model/
│   │   │   ├── User.java                    # User entity
│   │   │   ├── Product.java                 # Product entity
│   │   │   └── Order.java                   # Order entity
│   │   ├── repository/
│   │   │   ├── UserRepository.java          # User data access
│   │   │   ├── ProductRepository.java       # Product data access
│   │   │   └── OrderRepository.java         # Order data access
│   │   ├── service/
│   │   │   ├── UserService.java             # User business logic
│   │   │   ├── ProductService.java          # Product business logic
│   │   │   ├── OrderService.java            # Order business logic
│   │   │   └── UserDetailsServiceImpl.java  # Security user details
│   │   └── SpringBootAppApplication.java    # Main application class
│   └── resources/
│       ├── templates/
│       │   ├── login.html                   # Login page
│       │   ├── product/                     # Product templates
│       │   │   ├── list.html
│       │   │   └── form.html
│       │   ├── user/                        # User templates
│       │   │   ├── list.html
│       │   │   └── form.html
│       │   └── order/                       # Order templates
│       │       ├── list.html
│       │       └── form.html
│       └── application.properties           # Application configuration
└── pom.xml                                  # Maven dependencies
```

## 🔐 Security Features

- **Authentication**: Form-based login with Spring Security
- **Password Encryption**: BCrypt password encoding
- **Session Management**: Secure session handling
- **CSRF Protection**: Enabled by default
- **Role-based Access**: Basic ROLE_USER implementation

## 🗃️ Database Schema

The application automatically creates the following tables:

### Users Table
- `id` (BIGSERIAL, Primary Key)
- `username` (VARCHAR, Unique)
- `password` (VARCHAR, Encrypted)
- `email` (VARCHAR)

### Products Table
- `id` (BIGSERIAL, Primary Key)
- `name` (VARCHAR)
- `price` (DECIMAL)
- `description` (TEXT)

### Orders Table
- `id` (BIGSERIAL, Primary Key)
- `user_id` (BIGINT, Foreign Key → users.id)
- `product_id` (BIGINT, Foreign Key → products.id)
- `quantity` (INTEGER)

## 🔧 Development

### Adding New Features

1. **Models**: Create new entities in `src/main/java/com/example/springbootapp/model/`
2. **Repositories**: Add data access interfaces in `src/main/java/com/example/springbootapp/repository/`
3. **Services**: Implement business logic in `src/main/java/com/example/springbootapp/service/`
4. **Controllers**: Create web controllers in `src/main/java/com/example/springbootapp/controller/`
5. **Templates**: Add Thymeleaf templates in `src/main/resources/templates/`

### Hot Reload

The application includes Spring Boot DevTools for hot reload during development. Changes to:
- Java classes (with IDE recompilation)
- Templates and static resources
- Configuration files

Will be automatically reloaded without restarting the application.

## 🐛 Troubleshooting

### Common Issues

1. **Database Connection Error**:
   - Verify PostgreSQL is running
   - Check database credentials in `application.properties`
   - Ensure the database exists

2. **Port Already in Use**:
   - Change the port in `application.properties`: `server.port=8081`
   - Or kill the process using port 8080: `lsof -ti:8080 | xargs kill -9`

3. **Java Version Issues**:
   - Ensure Java 21 is installed: `java -version`
   - Set JAVA_HOME environment variable

4. **Maven Issues**:
   - Clear Maven cache: `./mvnw clean`
   - Verify Maven wrapper permissions: `chmod +x mvnw`

## 📝 API Endpoints

### Authentication
- `GET /login` - Login page
- `POST /login` - Process login
- `POST /logout` - Logout

### Products
- `GET /products` - List all products
- `GET /products/new` - New product form
- `POST /products` - Create product
- `GET /products/{id}/edit` - Edit product form
- `PUT /products/{id}` - Update product
- `DELETE /products/{id}` - Delete product

### Users
- `GET /users` - List all users
- `GET /users/new` - New user form
- `POST /users` - Create user
- `GET /users/{id}/edit` - Edit user form
- `PUT /users/{id}` - Update user
- `DELETE /users/{id}` - Delete user

### Orders
- `GET /orders` - List all orders
- `GET /orders/new` - New order form
- `POST /orders` - Create order
- `GET /orders/{id}/edit` - Edit order form
- `PUT /orders/{id}` - Update order
- `DELETE /orders/{id}` - Delete order

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/new-feature`)
3. Commit your changes (`git commit -am 'Add new feature'`)
4. Push to the branch (`git push origin feature/new-feature`)
5. Create a Pull Request

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 📞 Support

For support and questions:
- Create an issue in the repository
- Check the troubleshooting section
- Review Spring Boot documentation

## 🔄 Version History

- **v1.0.0** - Initial release with basic CRUD operations
  - Spring Boot 3.2.0
  - Java 21 support
  - PostgreSQL integration
  - User authentication
  - Modern Bootstrap UI

---

**Built with ❤️ using Spring Boot and Java 21**
