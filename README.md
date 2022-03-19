# Proiect1-PS
Proiectul pe care doresc sa il dezvolt este o aplicatie online prin intermediul careia se pot cumpara flori (florarie online). 
Aplicatia contine o baza de date formata din 3 tabele(product, order, client).
In cele 2 clase, UserController si AdminController avem toate actiunile pe care le pot face userii si adminul.
In interfata IServiceUser sunt toate operatiile pe produse+orders care este implementata in ServiceUser, iar in interfata 
IServiceAdmin sunt toate metodele la care are acces adminul, atat cele din IServiceUser (care sunt pentru clienti) cat si altele
specifice acestui tip de utilizator, implementate in IProdDetails.
Operatiile CRUD sunt implementate in clasele Repository (operatiile de baza de care ne folosim in implementarile interfetelor).
Id urile se genereaza in functie de id-ul maxim existent in tabel la care se adauga 1. In cazul in care tabelul este empty se incepe cu id-ul 1.
Pe aceeasi idee se genereaza si orderNumber.
