# Proiect1-PS
TEMA 1
Proiectul pe care doresc sa il dezvolt este o aplicatie online prin intermediul careia se pot cumpara flori (florarie online). 
Aplicatia contine o baza de date formata din 3 tabele(product, order, client).
In cele 2 clase, UserController si AdminController avem toate actiunile pe care le pot face userii si adminul.
In interfata IServiceUser sunt toate operatiile pe produse+orders care este implementata in ServiceUser, iar in interfata 
IServiceAdmin sunt toate metodele la care are acces adminul, atat cele din IServiceUser (care sunt pentru clienti) cat si altele
specifice acestui tip de utilizator, implementate in IProdDetails.
Operatiile CRUD sunt implementate in clasele Repository (operatiile de baza de care ne folosim in implementarile interfetelor).
Id urile se genereaza in functie de id-ul maxim existent in tabel la care se adauga 1. In cazul in care tabelul este empty se incepe cu id-ul 1.
Pe aceeasi idee se genereaza si orderNumber.


TEMA 2
Am integrat factory pattern in proiect anume pentru user. pentru a adauga un user se alege client/admin  pentru a se insera in tabela tipul de user potrivit.
In adminController sunt toate metodele care se pot folosi pentru admin anume : returneaza toate produsele/ comenzile/ clientii, filtreaza produsele available, filtreaza orders dupa min si max price, returneaza produsele dupa categorie, sterge produsul dupa id si userul dupa email. Pentru user, toate functionalitatie se afla in userController si metodele implementate sunt : returneaza toat produsele, produsele filtrate dupa categorie, produsele disponibile, adauga comanda, sterge comanda, se poate loga si se poate autentifica. (login si signup.
