# Proiect1-PS
Proiectul pe care doresc sa il dezvolt este o aplicatie online prin intermediul careia se pot cumpara flori (florarie online). 
Aplicatia contine o baza de date formata din 3 tabele(product, order, client).
In cele 2 clase, UserController si AdminController avem toate actiunile pe care le pot face userii si adminul.
In interfata IServiceUser sunt toate operatiile pe produse+orders care este implementata in ServiceUser, iar in interfata 
IServiceAdmin sunt toate metodele la care are acces adminul, atat cele din IServiceUser (care sunt pentru clienti) cat si altele
specifice acestui tip de utilizator, implementate in IProdDetails.
Operatiile CRUD sunt implementate in clasele Repository (operatiile de baza de care ne folosim in implementarile interfetelor).

TEMA 2 Am integrat factory pattern in proiect anume pentru user. pentru a adauga un user se alege client/admin pentru a se insera in tabela tipul de user potrivit. In adminController sunt toate metodele care se pot folosi pentru admin anume : returneaza toate produsele/ comenzile/ clientii, filtreaza produsele available, filtreaza orders dupa min si max price, returneaza produsele dupa categorie, sterge produsul dupa id si userul dupa email. Pentru user, toate functionalitatie se afla in userController si metodele implementate sunt : returneaza toat produsele, produsele filtrate dupa categorie, produsele disponibile, adauga comanda, sterge comanda, se poate loga si se poate autentifica. (login si signup.


Endpoints : 
  Pentru partea de administratie : 
 
http://localhost:8080/admin/products : afiseaza toate produsele

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

Pentru partea de user : 

http://localhost:8080/user/orders/products : afiseaza toate produsele

http://localhost:8080/user/orders/products_available : afiseaza toate produsele care se afla pe stoc

http://localhost:8080/user/products/{categorie} : afiseaza toate produsele din categoria categorie

http://localhost:8080/user/orders/{id_product}/{quantity} : adauga o comanda cu produsul al caurui id este id_product cu cantitatea quantity

http://localhost:8080/user/products/{minPrice}/{maxPrice} : afiseaza toate produsele in range-ul de pret [minPrice, maxPrice]

http://localhost:8080/user/orders/{id} : sterge comanda cu id-ul id (DELETE)
                        
Toate endpoint-urile au 4 metode implementate: GET, POST, PUT, DELETE

GET - returneaza toate entitățile din baza de date

POST - inserează o entitate dacă toate detaliile date sunt corecte și returneaza  200 sau 400 dacă nu a fost efectuat cu succes

PUT - actualizează o entitate dacă toate detaliile date sunt corecte și returneaza 200 sau 400 dacă nu a fost efectuat cu succes

DELETE - șterge o entitate dacă toate detaliile date sunt corecte și returneaza 200 sau 400 dacă nu a fost efectuat cu succes


![flow](https://user-images.githubusercontent.com/72413699/168095340-433a1194-a71d-4502-bbbf-3b5cb6303656.jpg)


DATABASE DIAGRAM 

![DB](https://user-images.githubusercontent.com/72413699/168095497-b7daa14b-340a-40b5-b11c-b49a3b1aad4f.png)


PROJECT DIAGRAM 

![proj](https://user-images.githubusercontent.com/72413699/168095559-876e3156-2a20-4ce0-b1db-b035ddfe043b.png)


INTERGATA GRAFICA 

Pentru interfata grafica avem 6 pagini conectate intre ele in felul urmator 

![image](https://user-images.githubusercontent.com/72413699/170631311-18e07a25-7e1a-48a9-b498-de7485d52e73.png)

Prima pagina, main page este pagina principala a aplicatiei. De pe aceasta pagina putem naviga in 3 alte locuri : pagina de log in (butonul de log in), pagina cu produsele disponibile (Butonul " What we offer?" ), pagina cu descrierea firmei (Butonul "Who are we? ").

![image](https://user-images.githubusercontent.com/72413699/170631439-f1946e73-4db7-4e75-8447-92f3044d7097.png)

Pagina About este una destul de straight forward, contine doar o mica descriere si nu se navigheaza nicaieri. 

![image](https://user-images.githubusercontent.com/72413699/170631580-2df74336-e89c-4a9e-9c8d-4a93a6e08daf.png)

Pagina cu produsele este la fel una destul de simpla, contine doar o insiruire a produselor disponibile si a pretului pe care il au. Pentru aseara pagina am folosit o get pentru a lua datele din db, am folosit api-ul constuit in backend si am primit ca raspuns la cererea facuta spre backend o lista de produse din care am procesat doar campul de name si price, punandu-le pe fiecare intr-o lista si afisandu-le pe ecran 

![image](https://user-images.githubusercontent.com/72413699/170631794-4a673cd7-ee51-4c24-984e-5c8785a9ff6a.png)


Pagina de log in este prima pagina putin mai complexa, contine 2 text field uri si 2 butoane. Aceasta pagina are rolul de a lua datele introduse de client si de a verifica daca in db exista un client inregistrat cu acele credentiale. Se face din nou un apel la backend cu api-ul construit si se primeste o lista de clienti. Se itereaza lista respectiva si in cazul in care am gasit un set de credentiale care sa se potriveasca, punem o variabila pe true si redirectionam la pagina clients 
De asemenea, avem buton pentru sign in care redirectioneaza userul la o alta pagina pentru a se putea inregistra in aplicatie 

![image](https://user-images.githubusercontent.com/72413699/170632020-d242c82e-1215-4e60-9314-075992d8c416.png)



Pagina de sign in contine un form care trebuie completat de utilizator si datele se vor salva in baza de date. Se va crea un obiect cu datele trimise si avel obiect se la transmite prin metoda put, folosindu-ne de api-ul creat in backend pentru a ne lega frontend ul de back si de db. 

![image](https://user-images.githubusercontent.com/72413699/170633237-1979b5f4-471d-40f9-9b95-6237b0b7c5f5.png)


Pagina Clients page, momentan nu are nimic randat pe ea, in viitor aici ar trebui sa fie produsele disponibile, pretul lor si o optiune de a adauga in cos produsul, iar mai apoi finalizare cumparaturi. 
![image](https://user-images.githubusercontent.com/72413699/170633368-3723ac2e-def1-4d1d-a5e1-55e01e80d3fd.png)


De asemenea ca dezvoltari ulterioare, avand in vedere ca am mentionat de comenzile online, as considera necesar sa existe in database, fine inca un tabel si id-ul clientului si adresa lui + adresa la care sa se faca livrarea, fie sa se adauge aceste campuri in tabela user.

O alta dezvoltare ulterioara: pagina de admin, ar trebui creata, ar trebui sa poata face modificari directe asupra db-ului, adaugari de prpoduse/ stergere de produse. updatari de produse etc. Ar trebui sa aiba acces si pe partea de client, sa stearga contul acestuia in cazuri exceptionale.
De asemenea, un alt improvment ar fi ca si clientul sa poata sa lase review uri la produs si de ce nu, un anumit rating la fiecare in parte, asta facand mai interactiva pagina.

