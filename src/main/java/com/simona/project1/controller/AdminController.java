package com.simona.project1.controller;

import com.simona.project1.model.Order;
import com.simona.project1.model.Product;
import com.simona.project1.model.user.Client;
import com.simona.project1.service.AdminService;
import com.simona.project1.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "admin")
public class AdminController {

    AdminService admActions;

    @Autowired
    public AdminController(AdminService admActions) {
        this.admActions = admActions;
    }

    /**
     * adauga produsul product
     *
     * @param product
     */
    @PostMapping(path = "/products")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product newProducts = admActions.addProduct(product);
        if (newProducts != null) {
            return new ResponseEntity<>(newProducts, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }


    /**
     * Sterge produsul cu id ul dat ca parametru
     *
     * @param id
     */
    @DeleteMapping(path = "/products/{id}")
    public @ResponseBody
    void deleteProduct(@PathVariable Integer id) {
        admActions.deleteProduct(id);
    }

    /**
     * Sterge comanda cu id ul dat ca parametru
     *
     * @param id
     */
    @DeleteMapping(path = "/orders/{id}") //orders/{id} - DELETE ---- //orders/{id} - GET
    public @ResponseBody
    void deleteOrder(@PathVariable Integer id) {
        admActions.deleteOrder(id);
    }


    /**
     * Returneaza toate comenzile
     *
     * @return
     */
    @GetMapping(path = "/orders") //orders
    public @ResponseBody
    List<Order> getAllOrders() {
        return admActions.getAllOrders();
    }

    /**
     * Returneaza toti clientii
     *
     * @return
     */
    @GetMapping(path = "/users")
    public @ResponseBody
    List<Client> getAllClients() {
        return admActions.getAllClients();
    }

    /**
     * Returneaza comenzile cu pretul in range-ul [minValue,maxValue]
     *
     * @param minValue
     * @param maxValue
     * @return
     */
    @GetMapping("path=/orders/{minValue}/{maxValue}")
    public @ResponseBody
    List<Order> getOrderPriceRange(@PathVariable double minValue, @PathVariable double maxValue) {
        return admActions.getOrderPriceRange(minValue, maxValue);
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
        return admActions.getProductsbyCategory(category);
    }

    /**
     * Returneaza toate produsele
     *
     * @return
     */
    @GetMapping(path = "/products")
    public @ResponseBody
    List<Product> getAllProducts() {
        return admActions.getAllProducts();
    }

    /**
     * Returneaza toate produsele din price range-ul transmis ca parametru [minPrice,maxPrice]
     *
     * @param minPrice
     * @param maxPrice
     * @return
     */
    @GetMapping(path = "/products/{minPrice}/{maxPrice}")
    public @ResponseBody
    List<Product> getAllProductsByPriceRange(@PathVariable int minPrice, @PathVariable int maxPrice) {
        return admActions.getAllProductsByPriceRange(minPrice, maxPrice);
    }

    /**
     * Returneaza toate produsele aflate in stoc
     *
     * @return
     */
    @GetMapping(path = "/products_available")
    public @ResponseBody
    List<Product> getAllAvailableProducts() {
        return admActions.getAllAvailableProducts();
    }

    /**
     * Sterge o comanda dupa id
     *
     * @param id_product
     */
    @DeleteMapping(path = "/orders/{id_product}")
    public @ResponseBody
    void deleteOrder(@PathVariable int id_product) {
        admActions.deleteOrder(id_product);
    }

    /**
     * Sterge o comanda dupa id
     *
     * @param email
     */
    @DeleteMapping(path = "/users/{email}")
    public @ResponseBody
    void deleteUser(@PathVariable String email) {
        admActions.deleteClient(email);
    }

    /**
     * Returneza un produs anume dupa id
     *
     * @param id_product
     * @return
     */
    @GetMapping(path = "/products/{id_product}")
    public @ResponseBody
    Product getProductById(@PathVariable int id_product) {
        return admActions.getProductById(id_product);
    }
}
