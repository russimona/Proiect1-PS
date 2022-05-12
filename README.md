# Proiect1-PS
Proiectul pe care doresc sa il dezvolt este o aplicatie online prin intermediul careia se pot cumpara flori (florarie online). 
Aplicatia contine o baza de date formata din 3 tabele(product, order, client).
In cele 2 clase, UserController si AdminController avem toate actiunile pe care le pot face userii si adminul.
In interfata IServiceUser sunt toate operatiile pe produse+orders care este implementata in ServiceUser, iar in interfata 
IServiceAdmin sunt toate metodele la care are acces adminul, atat cele din IServiceUser (care sunt pentru clienti) cat si altele
specifice acestui tip de utilizator, implementate in IProdDetails.
Operatiile CRUD sunt implementate in clasele Repository (operatiile de baza de care ne folosim in implementarile interfetelor).


Endpoints : 
  Pentru partea de administratie : http://localhost:8080/admin/products : afiseaza toate produsele
                                   http://localhost:8080/admin/products/{id} : afiseaza produsul cu id-ul id (GET)
                                   http://localhost:8080/admin/products/{id} : sterge produsul cu id-ul id (DELETE)
                                   http://localhost:8080/admin/products/products_available : afiseaza toate produsele care se afla pe stoc
                                   http://localhost:8080/admin/products/{minPrice}/{maxPrice} : afiseaza toate produsele in range-ul de pret [minPrice, maxPrice]
                                   http://localhost:8080/admin/products/{categorie} : afiseaza toate produsele din categoria categorie
                                   http://localhost:8080/admin/users : afiseaza toti clientii
                                   http://localhost:8080/admin/users/{email} : afiseaza toti clientii tu email-ul email
                                   http://localhost:8080/admin/orders : afiseaza toate comenzile 
                                   http://localhost:8080/admin/orders/{id} : afiseaza comanda cu id-ul id
                                   http://localhost:8080/admin/orders/{minPrice}/{maxPrice} : afiseaza toate comenzile in range-ul de pret [minPrice, maxPrice]
                                   http://localhost:8080/admin/orders/{id} : sterge comanda cu id-ul id (DELETE)
Pentru partea de user : http://localhost:8080/user/orders/products : afiseaza toate produsele
                        http://localhost:8080/user/orders/products_available : afiseaza toate produsele care se afla pe stoc
                        http://localhost:8080/user/products/{categorie} : afiseaza toate produsele din categoria categorie
                        http://localhost:8080/user/orders/{id_product}/{quantity} : adauga o comanda cu produsul al caurui id este id_product cu cantitatea quantity
                        http://localhost:8080/user/products/{minPrice}/{maxPrice} : afiseaza toate produsele in range-ul de pret [minPrice, maxPrice]
                        http://localhost:8080/user/orders/{id} : sterge comanda cu id-ul id (DELETE)
                        
Toate endpoint-urile au 4 metode implementate: GET, POST, PUT, DELETE

GET - returneaza toate entitățile din baza de date
POST - inserează o entitate dacă toate detaliile date sunt corecte și returneaza  200 sau 400 dacă nu a fost efectuat cu succes
PUT - actualizează o entitate dacă toate detaliile date sunt corecte și returneaza 200 sau 400 dacă nu a fost efectuat cu succes
DELETE - șterge o entitate dacă toate detaliile date sunt corecte și returneaza 200 sau 400 dacă nu a fost efectuat cu succe  

![flow](https://user-images.githubusercontent.com/72413699/168095340-433a1194-a71d-4502-bbbf-3b5cb6303656.jpg)


DATABASE DIAGRAM 

![DB](https://user-images.githubusercontent.com/72413699/168095497-b7daa14b-340a-40b5-b11c-b49a3b1aad4f.png)


PROJECT DIAGRAM 

![proj](https://user-images.githubusercontent.com/72413699/168095559-876e3156-2a20-4ce0-b1db-b035ddfe043b.png)

    
