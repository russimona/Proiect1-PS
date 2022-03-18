package com.simona.project1.service;

import com.simona.project1.dao.ClientRepository;
import com.simona.project1.dao.OrderRepository;
import com.simona.project1.dao.ProductRepository;
import com.simona.project1.model.Client;
import com.simona.project1.model.Order;
import com.simona.project1.model.Product;
import com.simona.project1.service.IUserService;
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

    /**
     * Returneaza doar produsele din categoria category data ca parametru
     * Parcurge lista de produse si le salveaza doar pe cele care au categoria cea data ca si parametru
     * @param category
     * @return
     */

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

    /**
     * Returneaza o lista cu toate produsele
     * @return
     */
    @Override
    public @ResponseBody List<Product> getAllProducts() {
        return productRepository.getProducts();
    }

    /**
     * Returneaza o lista cu produsele a carui pret este intre minPrice si maxPrice
     * Parcurge lista si le pastreaza doar pe cele a carui pret este in range ul respectiv
     * @param minPrice
     * @param maxPrice
     * @return
     */
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

    /**
     * Returneaza o lista cu toate produsele a caror cantitate este > 0 (toate produsele aflate in stoc)
     * @return
     */
    @Override
    public List<Product> getAllAvailableProducts() {
        return productRepository.getProductsAvailable();
    }

    /**
     * Adauga o comanda pentru produsul a carui id il dam ca parametru cu id-ul clientului pe care il dam ca parametru
     * Prima data se genereaza un orger id si un order number (daca lista de order este empty se incepe cu 1, in caz contrar
     * se va lua numarul maxim si se va adauga 1 pentru a fi valid)
     * Se cauta clientul, in cazul in care nu a mai comandat si nu este in baza de date se va adauga, in caz contrar
     * @param id_product
     * @param quantity
     * @param client
     */
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

    /**
     * Cauta comanda a carui id il dam ca si parametru si o sterge
     * @param id_product
     */
    @Override
    public void deleteOrder(int id_order) {
        orderRepository.deleteOrderById(id_order);
    }

}
