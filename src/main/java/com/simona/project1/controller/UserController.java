package com.simona.project1.controller;
import com.simona.project1.dao.UserRepository;
import com.simona.project1.dao.OrderRepository;
import com.simona.project1.dao.ProductRepository;
import com.simona.project1.model.Order;
import com.simona.project1.model.Product;
import com.simona.project1.model.user.Client;
import com.simona.project1.service.IUserService;
import com.simona.project1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping(path="user")
public class UserController {
    @Autowired
    private IUserService userActions;

    public UserController(){

    }

    public UserController(ProductRepository productRepository, OrderRepository orderRepository, UserRepository clientRepository) {
        userActions = new UserService(productRepository, orderRepository, clientRepository);
    }

    /**
     * Returneaza toate produsele din categoria data ca parametru
     *
     * @param category
     * @return
     */
    @GetMapping(path = "/products/{categ}")
    public @ResponseBody
    List<Product> getProductsbyCategory(@PathVariable String category) {
        return userActions.getProductsbyCategory(category);
    }

    /**
     * Returneaza toate produsele
     * @return
     */
    @GetMapping(path="/products")
    public @ResponseBody List<Product> getAllProducts(){
        return userActions.getAllProducts();
    }

    /**
     * Returneaza toate produsele aflate in stoc
     * @return
     */
    @GetMapping(path="/products_available")
    public @ResponseBody List<Product> getAllAvailableProducts(){
        return userActions.getAllAvailableProducts();
    }

    /**
     * Adauga o comanda in functie de id-ul produsului, cantitate si client
     *
     * @param id_product
     * @param quantity
     * @param client
     */
    @PostMapping(path = "/orders/{id_product}/{quantity}")
    public ResponseEntity<Order> addOrder(@PathVariable int id_product, @PathVariable int quantity, @RequestBody Client client) {
        Order newOrder = userActions.addOrder(id_product, quantity, client);
        if (newOrder != null) {
            return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Returneaza toate produsele din price range-ul transmis ca parametru [minPrice,maxPrice]
     * @param minPrice
     * @param maxPrice
     * @return
     */
    @GetMapping(path="/products/{minPrice}/{maxPrice}")
    public @ResponseBody List<Product> getAllProductsByPriceRange(@PathVariable int minPrice,@PathVariable int maxPrice){
        return userActions.getAllProductsByPriceRange(minPrice, maxPrice);
    }

    /**
     * Sterge o comanda dupa id
     * @param id_product
     */
    @DeleteMapping(path="/order/{id_product}")
    public @ResponseBody void deleteOrder(@PathVariable int id_product){
        userActions.deleteOrder(id_product);
    }


    @GetMapping(path="/login/{username}/{password}")
    /**
     * Cauta in tabela client daca exista deja logat un client cu credentialele caz in care va returna true, altfel
     * se va returna false (fie sunt gresite credentialele fie nu se gaseste un client stocat in db)
     * @param username
     * @param password
     * @return
     */
    public @ResponseBody boolean login(@PathVariable String username,@PathVariable String password){
        return userActions.login(username, password);
    }

    public void signin(Client client){
        userActions.signup(client);
    }
}
