package com.simona.project1;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.simona.project1.controller.AdminController;
import com.simona.project1.model.Order;
import com.simona.project1.model.Product;
import com.simona.project1.model.user.Client;
import com.simona.project1.service.AdminService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.doThrow;

@WebMvcTest(AdminController.class)
class AdminControllerTest {

    @InjectMocks
    private AdminController adminController;

    @MockBean
    private AdminService adminService;

    @MockBean
    private JdbcTemplate jdbcTemplate;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addNewProductTestSuccess() {
        Product p = new Product(1, "Lalele", "Buchet", 100, 40);

        Mockito.when(adminService.addProduct(p)).thenReturn(p);
        adminController.addProduct(p);
        Assertions.assertEquals(p,p);
    }

    @Test
    void addNewProductTestError() {
        Product p = new Product(1, "Lalele", "Buchet", 100, 40);

        doThrow(new IllegalArgumentException(""))
                .when(adminService)
                .addProduct(p);

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            adminController.addProduct(p);
        }, "Exception was expected");

        Assertions.assertEquals("", exception.getMessage());
    }

    @Test
    void getAllProductsTestSuccess(){
        List<Product> expectedResult = new ArrayList<>();
        Product p = new Product(1, "Lalele", "Buchet", 100, 40);
        expectedResult.add(p);

        Mockito.when(adminService.getAllProducts()).thenReturn(expectedResult);
        List<Product> result = adminController.getAllProducts();
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    void getAllOrdersTestSuccess(){
        List<Order> expectedResult = new ArrayList<>();
        Order o = new Order(1,17.0,12,1,"client@client.com");
        expectedResult.add(o);

        Mockito.when(adminService.getAllOrders()).thenReturn(expectedResult);
        List<Order> result = adminController.getAllOrders();
        Assertions.assertEquals(expectedResult, result);
    }


    @Test
    void getAllClientTestSuccess(){
        List<Client> expectedResult = new ArrayList<>();
        Client c = new Client("Simona", "simona@simona.com", "076666666", "password");
        expectedResult.add(c);

        Mockito.when(adminService.getAllClients()).thenReturn(expectedResult);
        List<Client> result = adminController.getAllClients();
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    void getAllProductsAvailableTestSuccess(){
        List<Product> expectedResult = new ArrayList<>();
        Product p = new Product(1, "Lalele", "Buchet", 100, 40);
        Product p1 = new Product(2, "Trandafiri", "Bucata", 0, 15);
        expectedResult.add(p);

        Mockito.when(adminService.getAllAvailableProducts()).thenReturn(expectedResult);
        List<Product> result = adminController.getAllAvailableProducts();
        Assertions.assertEquals(expectedResult, result);
    }



}
