package com.simona.project1;

import com.simona.project1.controller.AdminController;
import com.simona.project1.controller.UserController;
import com.simona.project1.dao.OrderRepository;
import com.simona.project1.dao.ProductRepository;
import com.simona.project1.dao.UserRepository;
import com.simona.project1.model.Order;
import com.simona.project1.model.Product;
import com.simona.project1.model.user.BasicUser;
import com.simona.project1.model.user.Client;
import com.simona.project1.service.AdminService;
import com.simona.project1.service.IAdminService;
import com.simona.project1.service.IUserService;
import com.simona.project1.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class Project1ApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate = new JdbcTemplate();
    @Test
    void contextLoads() {
        ProductRepository productRepository= new ProductRepository(jdbcTemplate);
        UserRepository clientRepository = new UserRepository(jdbcTemplate);
        OrderRepository orderRepository = new OrderRepository(jdbcTemplate);

        IUserService prodDetails = new UserService(productRepository,orderRepository, clientRepository);
        IAdminService admActions = new AdminService(prodDetails,clientRepository,productRepository,orderRepository);

        AdminController admin = new AdminController(admActions);
        UserController userController = new UserController(productRepository,orderRepository,clientRepository);

        Product product = new Product("lalele", "bucata", 10, 100);
        Client client = new Client("Rus Simona","russimona1200@gmail.com", "0700000000", "password");
        admin.addProduct(product);


        boolean result = userController.login("russ@gmail.com", "password");
        assertEquals(result, false);

        result = userController.login("russimona1200@gmail.com", "password");
        assertEquals(result, true);


        Product product1 = admin.getProductById(1);
        assertEquals(product.getName(), product1.getName());

        List<Client> clients = admin.getAllClients();
        assertEquals(clients.isEmpty(), false);


        admin.deleteUser("russimona1200@gmail.com");


        boolean res = userController.login("russimona1200@gmail.com", "pass");
        assertEquals(res, false);

        List<Order> orders = admin.getAllOrders();
        assertEquals(orders.isEmpty(), false);

        List<Order>orders1 = admin.getOrderPriceRange(0,0);
        assertEquals(orders1.isEmpty(), true);


        List<Order>orders2 = admin.getOrderPriceRange(10,50);
        assertEquals(orders2.isEmpty(), false);


    }
}
