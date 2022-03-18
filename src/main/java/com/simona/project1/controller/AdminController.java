package com.simona.project1.controller;

import com.simona.project1.model.Client;
import com.simona.project1.model.Order;
import com.simona.project1.model.Product;
import com.simona.project1.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path="admin")
public class AdminController {
    @Autowired
    IAdminService admActions;
    public AdminController(IAdminService admActions){
        this.admActions = admActions;
    }

    /**
     * adauga produsul product
     * @param product
     */
    @PostMapping(path="/addProduct")
    public void addProduct(@RequestBody Product product){
        admActions.addProduct(product);
    }

    /**
     * Sterge produsul cu id ul dat ca parametru
     * @param id
     */
    @GetMapping(path="/deleteP/{id}")
    public @ResponseBody void deleteProduct(@PathVariable Integer id){
        admActions.deleteProduct(id);
    }

    /**
     * Sterge comanda cu id ul dat ca parametru
     * @param id
     */
    @GetMapping(path="/deleteO/{id}")
    public @ResponseBody void deleteOrder(@PathVariable Integer id){
        admActions.deleteOrder(id);
    }

    /**
     * Sterge clientul cu id ul dat ca parametru
     * @param id
     */
    @GetMapping(path="/deleteC/{id}")
    public @ResponseBody void deleteClient(@PathVariable Integer id){
        admActions.deleteClient(id);
    }

    /**
     * Returneaza toate comenzile
     * @return
     */
    @GetMapping(path="/allO")
    public @ResponseBody List<Order> getAllOrders(){
        return admActions.getAllOrders();
    }

    /**
     * Returneaza comenzile cu pretul in range-ul [minValue,maxValue]
     * @param minValue
     * @param maxValue
     * @return
     */
    @GetMapping("path=/orderPriceRange/{minValue}/{maxValue}")
    public @ResponseBody List<Order> getOrderPriceRange(@PathVariable double minValue,@PathVariable double maxValue){
        return admActions.getOrderPriceRange(minValue, maxValue);
    }

    /**
     * Returneaza toti clientii
     * @return
     */
    @GetMapping(path="/allC")
    public @ResponseBody List<Client> getAllClient(){
        return admActions.getAllClients();
    }

    /**
     * Returneaza toate produsele din categoria data ca parametru
     * @param category
     * @return
     */
    @GetMapping(path="/prodByCateg/{categ}")
    public @ResponseBody List<Product> getProductsbyCategory(@PathVariable String category){
        return admActions.getProductsbyCategory(category);
    }

    /**
     * Returneaza toate produsele
     * @return
     */
    @GetMapping(path="/allP")
    public @ResponseBody List<Product> getAllProducts(){
        return  admActions.getAllProducts();
    }

    /**
     * Returneaza toate produsele din price range-ul transmis ca parametru [minPrice,maxPrice]
     * @param minPrice
     * @param maxPrice
     * @return
     */
    @GetMapping(path="/allPRange/{minPrice}/{maxPrice}")
    public @ResponseBody List<Product> getAllProductsByPriceRange(@PathVariable int minPrice,@PathVariable int maxPrice){
        return admActions.getAllProductsByPriceRange(minPrice,maxPrice);
    }

    /**
     * Returneaza toate produsele aflate in stoc
     * @return
     */
    @GetMapping(path="/allAvProd")
    public @ResponseBody List<Product> getAllAvailableProducts(){
        return admActions.getAllAvailableProducts();
    }

    /**
     * Adauga o comanda in functie de id-ul produsului, cantitate si client
     * @param id_product
     * @param quantity
     * @param client
     */
    @PostMapping(path="/addOrder/{id_product}/{quantity}")
    public void addOrder(@PathVariable int id_product,@PathVariable int quantity,@RequestBody Client client){
        admActions.addOrder(id_product,quantity,client);
    }

    /**
     * Sterge o comanda dupa id
     * @param id_product
     */

    @GetMapping (path="/deleteO/{id_product}")
    public @ResponseBody void deleteOrder(@PathVariable int id_product){
        admActions.deleteOrder(id_product);
    }

    /**
     * Returneza un produs anume dupa id
     * @param id_product
     * @return
     */
    @GetMapping(path="/prodById/{id}")
    public @ResponseBody Product getProductById(@PathVariable int id_product) { return admActions.getProductById(id_product);}
}
