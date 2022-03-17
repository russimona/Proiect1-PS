package com.simona.project1;

import com.simona.project1.controller.*;
import com.simona.project1.controller.IUserService;
import com.simona.project1.dao.ClientRepository;
import com.simona.project1.dao.OrderRepository;
import com.simona.project1.dao.ProductRepository;
import com.simona.project1.model.Client;
import com.simona.project1.model.Order;
import com.simona.project1.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringBootApplication
public class Project1Application implements CommandLineRunner {

    @Autowired
     JdbcTemplate jdbcTemplate = new JdbcTemplate();
    public static void main(String[] args) {
        SpringApplication.run(Project1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        ProductRepository productRepository= new ProductRepository(jdbcTemplate);
        ClientRepository clientRepository = new ClientRepository(jdbcTemplate);
        OrderRepository orderRepository = new OrderRepository(jdbcTemplate);

        IUserService prodDetails = new UserService(productRepository,orderRepository, clientRepository);
        IAdminService admActions = new AdminService(prodDetails,clientRepository,productRepository,orderRepository);

        AdminController admin = new AdminController(admActions);
        UserController userController = new UserController(productRepository,orderRepository,clientRepository);

        Product product1 = new Product("Buchet 15 lalele", "Buchet", 50, 150);
        Product product2 = new Product("Buchet all white", "Buchet", 50, 200);
        Product product3 = new Product("Buchet golden cup", "Buchet", 50, 125);
        Product product4 = new Product("Cutie white royal", "Aranjament", 50, 250);
        Product product5 = new Product("Aranjament Chic gift", "Aranjament", 50, 245);
        Product product6 = new Product("Trandafir alb", "Floare", 50, 15);


        admin.addProduct(product1);
        admin.addProduct(product2);
        admin.addProduct(product3);
        admin.addProduct(product4);
        admin.addProduct(product5);
        admin.addProduct(product6);

        List<Product> prod = admin.getAllProductsByPriceRange(130,200);
        System.out.println("\nProducts in a range: ");
        for(Product p : prod) {
            System.out.println(p.getName() + " " + p.getPrice());
        }

        System.out.println("\nAll orders :");
        List<Order> rez = admin.getAllOrders();
        for(Order p : rez){
            System.out.println(p.getOrder_number()+ " "+p.getTotal_price());
        }

        Client client = new Client("Ana Maria", "ana@maria", "0766234871");
        Order order = new Order(2, 14.0,1,2,1);

        System.out.println("\nAll product before delete");
        prod = admin.getAllProducts();
        for(Product p : prod) {
            System.out.println(p.getId_product()+" "+ p.getName() + " " + p.getPrice());
        }

        admin.deleteProduct(2);
        System.out.println("\nAll product after delete");
        prod = admin.getAllProducts();
        for(Product p : prod) {
            System.out.println(p.getId_product()+" "+p.getName() + " " + p.getPrice());
        }
        admActions.deleteProduct(2);
        userController.addOrder(4,3,client);
    }
}
