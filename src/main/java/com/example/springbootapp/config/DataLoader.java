package com.example.springbootapp.config;

import com.example.springbootapp.model.Product;
import com.example.springbootapp.model.User;
import com.example.springbootapp.service.ProductService;
import com.example.springbootapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Override
    public void run(String... args) throws Exception {
        // Crear usuarios de prueba solo si no existen
        if (userService.findAll().isEmpty()) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setEmail("admin@example.com");
            admin.setPassword("admin123");
            userService.save(admin);

            User user1 = new User();
            user1.setUsername("usuario1");
            user1.setEmail("usuario1@example.com");
            user1.setPassword("password123");
            userService.save(user1);

            User user2 = new User();
            user2.setUsername("usuario2");
            user2.setEmail("usuario2@example.com");
            user2.setPassword("password123");
            userService.save(user2);

            System.out.println("✅ Usuarios de prueba creados:");
            System.out.println("   - admin / admin123");
            System.out.println("   - usuario1 / password123");
            System.out.println("   - usuario2 / password123");
        }

        // Crear productos de prueba solo si no existen
        if (productService.findAll().isEmpty()) {
            Product product1 = new Product();
            product1.setName("Laptop Dell XPS 13");
            product1.setPrice(899.99);
            product1.setDescription("Laptop ultrabook con pantalla InfinityEdge y procesador Intel Core i7");
            productService.save(product1);

            Product product2 = new Product();
            product2.setName("Mouse Logitech MX Master 3");
            product2.setPrice(99.99);
            product2.setDescription("Mouse ergonómico inalámbrico con scroll electromagnético");
            productService.save(product2);

            Product product3 = new Product();
            product3.setName("Teclado Mecánico Razer BlackWidow V3");
            product3.setPrice(139.99);
            product3.setDescription("Teclado mecánico para gaming con switches Green y iluminación RGB");
            productService.save(product3);

            Product product4 = new Product();
            product4.setName("Monitor Samsung 27'' 4K");
            product4.setPrice(329.99);
            product4.setDescription("Monitor profesional 4K UHD con tecnología HDR10");
            productService.save(product4);

            Product product5 = new Product();
            product5.setName("Auriculares Sony WH-1000XM4");
            product5.setPrice(249.99);
            product5.setDescription("Auriculares inalámbricos con cancelación de ruido adaptativa");
            productService.save(product5);

            System.out.println("✅ Productos de prueba creados:");
            System.out.println("   - 5 productos con precios y descripciones");
        }
    }
}
