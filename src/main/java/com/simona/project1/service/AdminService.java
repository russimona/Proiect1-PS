package com.simona.project1.service;

import com.simona.project1.dao.UserRepository;
import com.simona.project1.dao.OrderRepository;
import com.simona.project1.dao.ProductRepository;
import com.simona.project1.model.Order;
import com.simona.project1.model.Product;
import com.simona.project1.model.user.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService implements IAdminService {

    private IUserService userService;
    private UserRepository userRepository;
    private ProductRepository productRepository;
    private  OrderRepository orderRepository;

    @Autowired
    public AdminService(IUserService userService, UserRepository userRepository, ProductRepository productRepository, OrderRepository orderRepository){
        this.userService = userService;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    /**
     *Adauga un produs in tabela Product
     * Daca produsul exista deja se va updata la noile valori, altfel va fi adaugat ca produs nou
     * Id-ul se autogenereaza -> daca lista de produse este goala de va incepe cu id-ul 1, altfel se va retura id-ul
     * maxim si va adauga 1 pentru a fi valabil
     * @param product
     */
    @Override
    public Product addProduct(Product product) {
        int maxId;
        if(productRepository.getProducts().isEmpty()){
            maxId = 1;
        } else {
            maxId = productRepository.findMaxId()+ 1;
        }
        Product prod = productRepository.findById(product.getId_product());
        if(prod == null){

            product.setId_product(maxId);
            productRepository.saveProduct(product);
        }else{
            productRepository.updateProduct(product);
        }
        return product;
    }

    /**
     * Cauta produsul dupa id si il sterge
     * @param id
     */
    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteProductById(id);
    }

    /**
     * Cauta comanda dupa id si o sterge
     * @param id
     */
    @Override
    public void deleteOrder(Integer id) {
        orderRepository.deleteOrderById(id);
    }


    /**
     * Returneaza o lista cu toate comenzile
     * @return
     */
    @Override
    public List<Order> getAllOrders() {
        return orderRepository.getOrder();
    }

    /**
     * Filtreaza lista de comenzi in functie de minValue si maxValue
     * Va returna o lista cu comenzile a carui pret sunt intre cele 2 range-uri
     * @param minValue
     * @param maxValue
     * @return
     */
    @Override
    public List<Order> getOrderPriceRange(double minValue, double maxValue) {
        List<Order> order = orderRepository.getOrder();
        List<Order> rez = new ArrayList<>();
        for(Order o: order){
            if(o.getTotal_price()<=maxValue&&o.getTotal_price()>=minValue){
                rez.add(o);
            }
        }
        return rez;
    }

   /**
     * Returneaza o lista cu toti clientii
     * @return
     */
    @Override
    public List<Client> getAllClients() {
        return userRepository.getClients();
    }



    /**
     * Filtreaza lista cu produse si le returneaza doar pe cele a caror categorie este cea pe care o dam ca parametru
     * @param category
     * @return
     */
    @Override
    public List<Product> getProductsbyCategory(String category) {
        return userService.getProductsbyCategory(category);
    }

    /**
     * Returneaza o lista cu toate produsele
     * @return
     */
    @Override
    public List<Product> getAllProducts() {
        return userService.getAllProducts();
    }

    /**
     * Filtreaza lista cu toate produsele si le pastreaza doar pe cele a caror pret este intre minPrice si maxPrice
     * @param minPrice
     * @param maxPrice
     * @return
     */
    @Override
    public List<Product> getAllProductsByPriceRange(int minPrice, int maxPrice) {
        return userService.getAllProductsByPriceRange(minPrice,maxPrice);
    }

    /**
     * Returneaza o lista cu produsele aflate pe stoc
     * @return
     */
    @Override
    public List<Product> getAllAvailableProducts() {
        return userService.getAllAvailableProducts();
    }

    /**
     * Adauga o comanda pentru produsul a carui id il dam ca parametru cu id-ul clientului pe care il dam ca parametru
     * @param id_product
     * @param quantity
     * @param user
     */
    @Override
    public Order addOrder(int id_product, int quantity, Client user) {
        return userService.addOrder(id_product, quantity, user);
    }

    /**
     * cauta comanda a carui id il primeste ca parametru si il sterge
     * @param id_product
     */
    @Override
    public void deleteOrder(int id_product) {
        userService.deleteOrder(id_product);
    }

    /**
     * returneaza produsul a carui id este dat ca parametru
     * @param id
     * @return
     */
    @Override
    public Product getProductById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public void deleteClient(String email) {
        userRepository.deleteUserByEmail(email);
    }
}
