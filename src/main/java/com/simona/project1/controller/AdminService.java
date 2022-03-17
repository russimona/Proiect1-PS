package com.simona.project1.controller;

import com.simona.project1.dao.ClientRepository;
import com.simona.project1.dao.OrderRepository;
import com.simona.project1.dao.ProductRepository;
import com.simona.project1.model.Client;
import com.simona.project1.model.Order;
import com.simona.project1.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService implements IAdminService {

    private IUserService userService;
    private ClientRepository clientRepository;
    private ProductRepository productRepository;
    private  OrderRepository orderRepository;

    public AdminService(IUserService userService, ClientRepository clientRepository, ProductRepository productRepository, OrderRepository orderRepository){
        this.userService = userService;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public void addProduct(Product product) {
        int maxId;
        if(productRepository.getProducts().isEmpty()){
            maxId = 1;
        }else{
            maxId = productRepository.findMaxId()+ 1;
        }
        Product prod = productRepository.findById(product.getId_product());
        if(prod == null){

            product.setId_product(maxId);
            productRepository.saveProduct(product);
        }else{
            productRepository.updateProduct(product);
        }
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteProductById(id);
    }

    @Override
    public void deleteOrder(Integer id) {
        orderRepository.deleteOrderById(id);
    }

    @Override
    public void deleteClient(Integer id) {
        clientRepository.deleteClientById(id);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.getOrder();
    }

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

    @Override
    public List<Client> getAllClients() {
        return clientRepository.getClient();
    }

    @Override
    public List<Product> getProductsbyCategory(String category) {
        return userService.getProductsbyCategory(category);
    }


    @Override
    public List<Product> getAllProducts() {
        return userService.getAllProducts();
    }

    @Override
    public List<Product> getAllProductsByPriceRange(int minPrice, int maxPrice) {
        return userService.getAllProductsByPriceRange(minPrice,maxPrice);
    }

    @Override
    public List<Product> getAllAvailableProducts() {
        return userService.getAllAvailableProducts();
    }

    @Override
    public void addOrder(int id_product, int quantity, Client client) {
        userService.addOrder(id_product, quantity, client);
    }

    @Override
    public void deleteOrder(int id_product) {
        userService.deleteOrder(id_product);
    }

    @Override
    public Product getProductById(int id) {
        return productRepository.findById(id);
    }
}
