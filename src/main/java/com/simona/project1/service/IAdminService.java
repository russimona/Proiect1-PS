package com.simona.project1.service;

import com.simona.project1.model.Order;
import com.simona.project1.model.Product;
import com.simona.project1.model.user.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IAdminService {
    /**
     *Adauga un produs in tabela Product
     * Daca produsul exista deja se va updata la noile valori, altfel va fi adaugat ca produs nou
     * @param product
     */
    Product addProduct(Product product);

    /**
     * Cauta produsul dupa id si il sterge
     * @param id
     */
    void deleteProduct(Integer id);

    /**
     * Cauta comanda dupa id si o sterge
     * @param id
     */
    void deleteOrder(Integer id);

    /**
     * Returneaza o lista cu toate comenzile
     * @return
     */
    List<Order> getAllOrders();

    /**
     * Filtreaza lista de comenzi in functie de minValue si maxValue
     * Va returna o lista cu comenzile a carui pret sunt intre cele 2 range-uri
     * @param minValue
     * @param maxValue
     * @return
     */
    List<Order> getOrderPriceRange(double minValue, double maxValue);

    /**
     * Returneaza o lista cu toti clientii
     * @return
     */
    List<Client> getAllClients();

    /**
     * Filtreaza lista cu produse si le returneaza doar pe cele a caror categorie este cea pe care o dam ca parametru
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
     * Filtreaza lista cu toate produsele si le pastreaza doar pe cele a caror pret este intre minPrice si maxPrice
     * @param minPrice
     * @param maxPrice
     * @return
     */
    List<Product> getAllProductsByPriceRange(int minPrice, int maxPrice);

    /**
     * Returneaza o lista cu produsele aflate pe stoc
     * @return
     */
    List<Product> getAllAvailableProducts();

    /**
     * Adauga o comanda pentru produsul a carui id il dam ca parametru cu id-ul clientului pe care il dam ca parametru
     * @param id_product
     * @param quantity
     * @param user
     */
    Order addOrder(int id_product, int quantity, Client user);

    /**
     * cauta comanda a carui id il primeste ca parametru si il sterge
     * @param id_product
     */
    void deleteOrder(int id_product);

    /**
     * returneaza produsul a carui id este dat ca parametru
     * @param id
     * @return
     */
    Product getProductById(int id);

    void deleteClient(String username);

}
