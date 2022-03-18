package com.simona.project1.controller;
import com.simona.project1.dao.ClientRepository;
import com.simona.project1.dao.OrderRepository;
import com.simona.project1.dao.ProductRepository;
import com.simona.project1.model.Client;
import com.simona.project1.model.Product;
import com.simona.project1.service.IUserService;
import com.simona.project1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    public UserController(ProductRepository productRepository, OrderRepository orderRepository, ClientRepository clientRepository) {
        userActions = new UserService(productRepository, orderRepository, clientRepository);
    }

    /**
     * Returneaza toate produsele din categoria data ca parametru
     * @param category
     * @return
     */
    @GetMapping(path="/allProdCateg/{category}")
    public @ResponseBody List<Product> getProductsbyCategory(@PathVariable String category){
        return userActions.getProductsbyCategory(category);
    }

    /**
     * Returneaza toate produsele
     * @return
     */
    @GetMapping(path="/allProd")
    public @ResponseBody List<Product> getAllProducts(){
        return userActions.getAllProducts();
    }


    /**
     * Returneaza toate produsele aflate in stoc
     * @return
     */
    @GetMapping(path="/allProdAv")
    public @ResponseBody List<Product> getAllAvailableProducts(){
        return userActions.getAllAvailableProducts();
    }

    /**
     * Adauga o comanda in functie de id-ul produsului, cantitate si client
     * @param id_product
     * @param quantity
     * @param client
     */
    @PostMapping(path="/addOrder/{id_product}/{quantity}")
    public void addOrder(@PathVariable int id_product,@PathVariable int quantity,@RequestBody Client client){
        userActions.addOrder(id_product,quantity,client);
    }

    /**
     * Returneaza toate produsele din price range-ul transmis ca parametru [minPrice,maxPrice]
     * @param minPrice
     * @param maxPrice
     * @return
     */
    @GetMapping(path="/allProdRange/{minPrice}/{maxPrice}")
    public @ResponseBody List<Product> getAllProductsByPriceRange(@PathVariable int minPrice,@PathVariable int maxPrice){
        return userActions.getAllProductsByPriceRange(minPrice, maxPrice);
    }

    /**
     * Sterge o comanda dupa id
     * @param id_product
     */
    @GetMapping(path="/deleteOrder/{id_product}")
    public @ResponseBody void deleteOrder(@PathVariable int id_product){
        userActions.deleteOrder(id_product);
    }

}
