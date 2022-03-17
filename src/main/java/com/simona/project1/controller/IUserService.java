package com.simona.project1.controller;

import com.simona.project1.model.Client;
import com.simona.project1.model.Product;

import java.util.List;

public interface IUserService {
    List<Product> getProductsbyCategory(String category);
    List<Product> getAllProducts();
    List<Product> getAllProductsByPriceRange(int minPrice, int maxPrice);
    List<Product> getAllAvailableProducts();
    void addOrder(int id_product, int quantity, Client client);
    void deleteOrder(int id_product);

}
