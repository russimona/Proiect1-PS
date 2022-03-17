package com.simona.project1.controller;

import com.simona.project1.model.Client;
import com.simona.project1.model.Order;
import com.simona.project1.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path="admin")
public class AdminController {
    @Autowired
    IAdminService admActions;
    public AdminController(IAdminService admActions){
        this.admActions = admActions;
    }

    public void addProduct(Product product){
        admActions.addProduct(product);
    }

    @GetMapping(path="/deleteP/{id}")
    public @ResponseBody void deleteProduct(@PathVariable Integer id){
        admActions.deleteProduct(id);
    }

    @GetMapping(path="/deleteO/{id}")
    public @ResponseBody void deleteOrder(@PathVariable Integer id){
        admActions.deleteOrder(id);
    }

    @GetMapping(path="/deleteC/{id}")
    public @ResponseBody void deleteClient(@PathVariable Integer id){
        admActions.deleteClient(id);
    }

    @GetMapping(path="/allO")
    public @ResponseBody List<Order> getAllOrders(){
        return admActions.getAllOrders();
    }

    @GetMapping("path=/orderPriceRange/{minValue}/{maxValue}")
    public @ResponseBody List<Order> getOrderPriceRange(@PathVariable double minValue,@PathVariable double maxValue){
        return admActions.getOrderPriceRange(minValue, maxValue);
    }

    @GetMapping(path="/allC")
    public @ResponseBody List<Client> getAllClient(){
        return admActions.getAllClients();
    }

    @GetMapping(path="/prodByCateg/{categ}")
    public @ResponseBody List<Product> getProductsbyCategory(@PathVariable String category){
        return admActions.getProductsbyCategory(category);
    }

    @GetMapping(path="/allP")
    public @ResponseBody List<Product> getAllProducts(){
        return  admActions.getAllProducts();
    }

    @GetMapping(path="/allPRange/{minPrice}/{maxPrice}")
    public @ResponseBody List<Product> getAllProductsByPriceRange(@PathVariable int minPrice,@PathVariable int maxPrice){
        return admActions.getAllProductsByPriceRange(minPrice,maxPrice);
    }

    @GetMapping(path="/allAvProd")
    public @ResponseBody List<Product> getAllAvailableProducts(){
        return admActions.getAllAvailableProducts();
    }

    public void addOrder(int id_product, int quantity, Client client){
        admActions.addOrder(id_product,quantity,client);
    }

    public void deleteOrder(int id_product){
        admActions.deleteOrder(id_product);
    }

    @GetMapping(path="/prodById/{id}")
    public @ResponseBody Product getProductById(@PathVariable int id_product) { return admActions.getProductById(id_product);}
}
