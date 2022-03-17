package com.simona.project1.controller;

import com.simona.project1.dao.ClientRepository;
import com.simona.project1.dao.OrderRepository;
import com.simona.project1.dao.ProductRepository;
import com.simona.project1.model.Client;
import com.simona.project1.model.Order;
import com.simona.project1.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserService implements IUserService {
    private ProductRepository productRepository;
    private OrderRepository orderRepository;
    private ClientRepository clientRepository;

    public UserService(ProductRepository productRepository, OrderRepository orderRepository, ClientRepository clientRepository){
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Product> getProductsbyCategory(String category) {
        List<Product> prod = productRepository.getProducts();
        List<Product> rez = new ArrayList<>();
        for(Product p : prod){
            if(p.getCategory().equals(category)){
                rez.add(p);
            }
        }
        return rez;
    }

    @Override

    public @ResponseBody List<Product> getAllProducts() {
        return productRepository.getProducts();
    }

    @Override
    public List<Product> getAllProductsByPriceRange(int minPrice, int maxPrice) {
        List <Product> allProd = productRepository.getProducts();
        List <Product> rez = new ArrayList<>();
        for(Product p : allProd){
            if(p.getPrice()<=maxPrice && p.getPrice()>=minPrice){
                rez.add(p);
            }
        }
        return rez;
    }

    @Override
    public List<Product> getAllAvailableProducts() {
        return productRepository.getProductsAvailable();
    }

    @Override
    public void addOrder(int id_product, int quantity, Client  client) {
        Product product = productRepository.findById(id_product);
        if(product != null && product.getStoc()-quantity>=0){

            double price = product.getPrice();
            int ord_number;
            if(orderRepository.getOrder().isEmpty()){
                ord_number = 1;
            }else{
                ord_number = orderRepository.findMaxOrderNumber()+ 1;
            }

            int maxId;
            if(orderRepository.getOrder().isEmpty()){
                maxId = 1;
            }else{
                maxId = orderRepository.findMaxId()+ 1;
            }

            Client verify = clientRepository.findByNameEmailPhone(client.getName(), client.getEmail(), client.getPhone_number());
            if(verify == null){
                clientRepository.saveClient(client);
            }
            product.setStoc(product.getStoc()-quantity);
            System.out.println(product.getStoc());
            productRepository.updateProduct(product);
            Order order = new Order(maxId, price*quantity, ord_number,id_product,client.getId_client());
            orderRepository.saveOrder(order);
        }

    }

    @Override
    public void deleteOrder(int id_order) {
        orderRepository.deleteOrderById(id_order);
    }

}
