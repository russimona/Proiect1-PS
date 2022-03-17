package com.simona.project1.controller;
import com.simona.project1.dao.ClientRepository;
import com.simona.project1.dao.OrderRepository;
import com.simona.project1.dao.ProductRepository;
import com.simona.project1.model.Client;
import com.simona.project1.model.Product;
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

    @GetMapping(path="/allProdCateg/{category}")
    public @ResponseBody List<Product> getProductsbyCategory(@PathVariable String category){
        return userActions.getProductsbyCategory(category);
    }


    @GetMapping(path="/allProd")
    public @ResponseBody List<Product> getAllProducts(){
        return userActions.getAllProducts();
    }



    @GetMapping(path="/allProdAv")
    public @ResponseBody List<Product> getAllAvailableProducts(){
        return userActions.getAllAvailableProducts();
    }

    public void addOrder(int id_product, int quantity, Client client){
        userActions.addOrder(id_product,quantity,client);
    }


    @GetMapping(path="/allProdRange/{minPrice}/{maxPrice}")
    public @ResponseBody List<Product> getAllProductsByPriceRange(@PathVariable int minPrice,@PathVariable int maxPrice){
        return userActions.getAllProductsByPriceRange(minPrice, maxPrice);
    }

    @GetMapping(path="/deleteOrder/{id_product}")
    public @ResponseBody void deleteOrder(@PathVariable int id_product){
        userActions.deleteOrder(id_product);
    }

}
