<h2>Autocesta project in Java</h2>
<b>Autocesta project</b> - jednostavni projekt koji se 
bavi informacijama vezanim
uz autoceste
<br><br>
Osobni cilj ovog projekta bio je upoznati se još bliže sa radom 
sa Springboot-om i građenje backenda i povezati HTML i CSS sa svim
tim i napraviti uredan frontend koji sadrži sve potrebne informacije.
Bitno mi je bilo da se upoznam s različitim validacijama podataka,
punjenjem podataka koje želim da budu tu kada korisnik pokrene aplikaciju
i da napravim nešto što se poslije može nadograđivati sa dodatnim 
funkcionalnostima. Bilo je također zabavno integrirati PlateRecogniser API
za prepoznavanje hrvatskih registarskih oznaka.
<br><br>
<h3>DataSeeder (umetanje preddefiniranih podataka)</h3>
Pošto ne želimo korisniku dati mogućnost da dodaje autoceste
koje ne postoje u Hrvatskoj, a želimo da ima mogućnost odabira između
stvarnih cesta i naplatnih postaja na njima, potrebno je određene
podatke odmah ubaciti u bazu prilikom pokretanja aplikacije.

<h3>Baza podataka</h3>
Za lokalno pokretanje aplikacije, potrebno je napraviti SQL bazu
`autocestadb`. 
```sql
CREATE DATABASE autocestadb;
USE autocestadb;
```
Ako dođe do promjena u DataSeeder.java, potrebno je izbrisati bazu
i ponovo je kreirati.
```sql
DROP DATABASE autocestadb;
CREATE DATABASE autocestadb;
USE autocestadb;
```
<br>

Ovisno o url-u lokalne MySQL baze, potrebno je u `src/main/resources/application.properties`
promjeniti prve tri linije:
```
spring.datasource.url=jdbc:mysql://localhost:3306/autocestadb
spring.datasource.username=root
spring.datasource.password=root
```
(staviti druge podatke za port, username i password ako se razlikuju
na lokalnoj bazi)
<br><br>
Frontend aplikacije je napravljen na hrvatskom jeziku, pošto se radi
o hrvatskim cestama, neovisno o tome što je backend na engleskom.






