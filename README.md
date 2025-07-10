# Aplicación CRUD con Spring Boot (Examen Programación I)

Una aplicación web moderna desarrollada con Spring Boot 3.2, Spring Security, JPA y PostgreSQL. El proyecto implementa operaciones CRUD completas, autenticación de usuarios y una interfaz de usuario amigable con Thymeleaf y Bootstrap.

## 🚀 Características Principales

- **Autenticación de Usuarios**: Sistema de login y registro seguro con Spring Security.
- **Operaciones CRUD**: Gestión completa (Crear, Leer, Actualizar, Eliminar) para Productos y Órdenes.
- **Base de Datos PostgreSQL**: Integración robusta con PostgreSQL a través de Spring Data JPA.
- **Interfaz de Usuario Moderna**: Diseño responsivo y atractivo utilizando plantillas Thymeleaf y Bootstrap 5.
- **Java 21**: Desarrollado con la última versión LTS de Java.
- **Usuario Administrador por Defecto**: Creación automática de un usuario `admin` al iniciar la aplicación para facilitar las pruebas.

## 📋 Prerrequisitos

- **Java 21** o superior.
- Servidor de base de datos **PostgreSQL**.
- **Maven** 3.6+ (o utilizar el `mvnw` wrapper incluido).
- **Git** para el control de versiones.

## 🛠️ Tecnologías Utilizadas

- **Backend**: Spring Boot 3.2.0, Spring Security 6.x, Spring Data JPA.
- **Frontend**: Thymeleaf, Bootstrap 5.1.3, Font Awesome 6.0.0.
- **Base de Datos**: PostgreSQL.
- **Gestión de Dependencias**: Maven.
- **Utilidades**: Lombok para reducir código repetitivo.

## 🗄️ Configuración de la Base de Datos

1.  Asegúrate de tener PostgreSQL instalado y en ejecución.
2.  Crea una nueva base de datos. Por defecto, la aplicación usa el nombre `springboot_crud`.
    ```sql
    CREATE DATABASE springboot_crud;
    ```
3.  (Opcional) Puedes crear un usuario específico para la aplicación:
    ```sql
    CREATE USER tu_usuario WITH PASSWORD 'tu_contraseña';
    GRANT ALL PRIVILEGES ON DATABASE springboot_crud TO tu_usuario;
    ```

## ⚙️ Configuración del Proyecto

La configuración principal se encuentra en `src/main/resources/application.properties`. Asegúrate de ajustar las credenciales de la base de datos a tu entorno local.

```properties
# Configuración de la Base de Datos
spring.datasource.url=jdbc:postgresql://localhost:5432/springboot_crud
spring.datasource.username=postgres
spring.datasource.password=password
spring.datasource.driver-class-name=org.postgresql.Driver

# Configuración de JPA/Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

# Configuración del Servidor
server.port=8080

# Configuración de Thymeleaf (deshabilitar caché para desarrollo)
spring.thymeleaf.cache=false
```

## 🚀 Cómo Ejecutar la Aplicación

### Usando el Maven Wrapper (Recomendado)

1.  **Clona el repositorio**:
    ```bash
    git clone https://github.com/tu_usuario/examen-programacion-1.git
    cd examen-programacion-1
    ```

2.  **Da permisos de ejecución al wrapper** (si es necesario):
    ```bash
    chmod +x mvnw
    ```

3.  **Ejecuta la aplicación**:
    ```bash
    ./mvnw spring-boot:run
    ```

### Usando Maven

1.  **Compila el proyecto**:
    ```bash
    mvn clean compile
    ```

2.  **Ejecuta la aplicación**:
    ```bash
    mvn spring-boot:run
    ```

### Usando el archivo JAR

1.  **Construye el JAR**:
    ```bash
    ./mvnw clean package
    ```

2.  **Ejecuta el JAR**:
    ```bash
    java -jar target/springbootapp-0.0.1-SNAPSHOT.jar
    ```

## 🌐 Acceso a la Aplicación

Una vez que la aplicación esté en ejecución:

-   **URL Principal**: [http://localhost:8080](http://localhost:8080)
-   **Página de Login**: [http://localhost:8080/login](http://localhost:8080/login)
-   **Credenciales por Defecto**:
    -   **Usuario**: `admin`
    -   **Contraseña**: `admin123`

## 📁 Estructura del Proyecto

```
src/
└── main/
    ├── java/com/example/springbootapp/
    │   ├── config/
    │   │   ├── DataLoader.java          # Carga datos iniciales (ej. admin)
    │   │   └── SecurityConfig.java      # Configuración de Spring Security
    │   ├── controller/
    │   │   ├── MainController.java      # Rutas principales (home, login)
    │   │   ├── ProductController.java   # CRUD de Productos
    │   │   ├── OrderController.java     # CRUD de Órdenes
    │   │   └── RegistrationController.java # Registro de usuarios
    │   ├── model/
    │   │   ├── User.java                # Entidad Usuario
    │   │   ├── Product.java             # Entidad Producto
    │   │   └── Order.java               # Entidad Orden
    │   ├── repository/
    │   │   ├── UserRepository.java      # Repositorio para Usuarios
    │   │   ├── ProductRepository.java   # Repositorio para Productos
    │   │   └── OrderRepository.java     # Repositorio para Órdenes
    │   ├── service/
    │   │   ├── UserService.java         # Lógica de negocio para Usuarios
    │   │   ├── ProductService.java      # Lógica de negocio para Productos
    │   │   └── UserDetailsServiceImpl.java # Servicio para la autenticación
    │   └── SpringBootAppApplication.java # Clase principal de la aplicación
    └── resources/
        ├── static/                      # Archivos estáticos (CSS, JS)
        ├── templates/                   # Plantillas Thymeleaf
        │   ├── login.html
        │   ├── register.html
        │   ├── dashboard.html
        │   ├── product/
        │   │   ├── list.html
        │   │   └── form.html
        │   └── order/
        │       ├── list.html
        │       └── form.html
        └── application.properties       # Configuración de la aplicación
pom.xml                                  # Dependencias de Maven
```

## 🔐 Características de Seguridad

-   **Autenticación**: Login basado en formularios con Spring Security.
-   **Autorización**: Rutas protegidas que requieren autenticación.
-   **Cifrado de Contraseñas**: Uso de `BCryptPasswordEncoder` para almacenar las contraseñas de forma segura.
-   **Protección CSRF**: Habilitada por defecto para proteger contra ataques de falsificación de solicitudes.

---

**Desarrollado con ❤️ para el examen final de Programación I.**
