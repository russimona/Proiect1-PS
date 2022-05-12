package com.simona.project1.service;

import com.simona.project1.model.Order;
import com.simona.project1.model.Product;
import com.simona.project1.model.user.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserService {
    /**
     * Returneaza doar produsele din categoria category data ca parametru
     * @param category
     * @return
     */
    List<Product> getProductsbyCategory(String category);

    /**
     * Returneaza o lista cu toate produsele
     * @return
     */
    List<Product> getAllProducts();

    /**
     * Returneaza o lista cu produsele a carui pret este intre minPrice si maxPrice
     * @param minPrice
     * @param maxPrice
     * @return
     */
    List<Product> getAllProductsByPriceRange(int minPrice, int maxPrice);

    /**
     * Returneaza o lista cu toate produsele a caror cantitate este > 0 (toate produsele aflate in stoc)
     * @return
     */
    List<Product> getAllAvailableProducts();

    /**
     * Adauga o comanda pentru produsul a carui id il dam ca parametru cu id-ul clientului pe care il dam ca parametru
     * @param id_product
     * @param quantity
     * @param client
     * @return
     */
    Order addOrder(int id_product, int quantity, Client client);

    /**
     * Cauta comanda a carui id il dam ca si parametru si o sterge
     * @param id_product
     */
    void deleteOrder(int id_product);

    boolean login(String username, String password);
    void deleteAccount(String username);

    void signup(Client client);

}
