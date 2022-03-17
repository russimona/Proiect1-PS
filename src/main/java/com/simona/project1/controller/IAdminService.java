package com.simona.project1.controller;

import com.simona.project1.model.Client;
import com.simona.project1.model.Order;
import com.simona.project1.model.Product;

import java.util.List;

public interface IAdminService {
    public void addProduct(Product product);
    public void deleteProduct(Integer id);
    public void deleteOrder(Integer id);
    public void deleteClient(Integer id);
    public List<Order> getAllOrders();
    public List<Order> getOrderPriceRange(double minValue, double maxValue);
    public List<Client> getAllClients();
    List<Product> getProductsbyCategory(String category);
    List<Product> getAllProducts();
    List<Product> getAllProductsByPriceRange(int minPrice, int maxPrice);
    List<Product> getAllAvailableProducts();
    void addOrder(int id_product, int quantity,Client client);
    void deleteOrder(int id_product);
    public Product getProductById(int id);

}
