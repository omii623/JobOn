# Adatbázis alapú rendszerek

**2022-2023/2**

**IB152L-2**

### JobOn

Készítette:
 * Rekecki Petra
 * Molnár Dávid
 * Tóth Tamás

Értékelési mód: Csapat

## Munka felosztása

 * Rekecki Petra
    * Feladat szöveges leírása
    * Követelménykatalógus
    * EK-diagram
    * Normalizálás
    * Táblák
 * Molnár Dávid
    * Adatfolyam diagram összes szint
    * Logo tervezés
 * Tóth Tamás
    * Egyed esemény mátrix
    * Szerep-funkció mátrix
    * Funkció megadása
    * Munka felosztás

## Feladat szöveges leírása

Az álláskeresést nagyban megkönnyíti egy közös platform az álláskeresők és a munkaadók között. A JobOn erre kínál megoldást, egy könnyen kezelhető és átlátható felületet nyújt mindkét fél számára. A munkaadóknak lehetőségük van egy adatlapot kitölteni a cégük adatairól, valamint több állásajánlatot is meghirdetni. Az álláskeresők is rendelkeznek egy adatlappal, melyben személyes adataik szerepelnek. Az álláskeresők számára az általuk megadott adatok alapján is kínál az oldal állásajánlatok, valamint szűrők segítségével is tudnak keresni az ajánlatok között.

## Követelménykatalógus

### Funkcionális követelmények
  * Felhasználói munkamenet megvalósítása több jogosultsági szinttel (admin, felhasználó, vendég)
    * admin: moderálás
    * felhasználó 1. (álláskereső): CV-k feltöltése, jelentkezni állásra, álláskeresés szűrökkel
    * felhasználó 2. (munkáltató): állás meghirdetése
    * vendég (nem bejelentkezett felhasználó): álláskeresés szűrökkel
  * Felhasználók kezelése
    * Regisztráció (e-mail cím, név, jelszó)
    * Bejelentkezés
    * Jelszócsere
    * Adatlapok (álláskereső, munkáltató)
    * CV feltöltése (akár több is)
  * Állásajánlatok keresése
    * Szűrés több szempont alapján (pozíció, város, bér...)
    * Ajánlatok listázása a szempontok súlyozása alapján
  * Jelentkezés állásajánlatra
  * Állás meghirdetése
  * Statisztikák több szempont alapján (munkakör, életkor...)
  * Állásajánlatok automatikus küldése a felhasználónak
  
### Nem funkcionális követelmények
  * A kliens oldal platform- és böngészőfüggetlen legyen
  * Reszponzív megjelenés
  * Adatvédelem
  * Átlátható, könnyű használhatóság (aloldalak használata, navigáció mindig elérhető)
  * Inaktív felhasználók passziválása
  

## Adatfolyam diagram (DFD):

A DFD 0. szintje:
<br/>
<div  align="center">
  <img src="https://raw.githubusercontent.com/omii623/JobOn/master/Diagrams/AFD/0szint_afd.jpg" width="800">
</div>
<br/>
A DFD 1. szintje: <br/>
Logikai:<br/>
<div  align="center">
  <img src="https://raw.githubusercontent.com/omii623/JobOn/master/Diagrams/AFD/Logikai/1szint_logikai_afd.jpg" width="800">
</div><br/>

Fizikai:<br/>
<div  align="center">
  <img src="https://raw.githubusercontent.com/omii623/JobOn/master/Diagrams/AFD/Fizikai/1szint_fizikai_afd.jpg" width="800">
</div><br/>
<br/>

A DFD 2. szintje:<br/>
Logikai:<br/>

<div  align="center">
  <img src="https://raw.githubusercontent.com/omii623/JobOn/master/Diagrams/AFD/Logikai/2szint_regisztracio_logikai_afd.jpg" width="800">
</div><br/>

<div  align="center">
  <img src="https://raw.githubusercontent.com/omii623/JobOn/master/Diagrams/AFD/Logikai/2szint_bejelentkezes_logikai_afd.jpg" width="800">
</div><br/>

<div  align="center">
  <img src="https://raw.githubusercontent.com/omii623/JobOn/master/Diagrams/AFD/Logikai/2szint_allasokKeresese_logikai_afd.jpg" width="800">
</div><br/>

<div  align="center">
  <img src="https://raw.githubusercontent.com/omii623/JobOn/master/Diagrams/AFD/Logikai/2szint_megfeleloAllasok_logikai_afd.jpg" width="800">
</div><br/>

<div  align="center">
  <img src="https://raw.githubusercontent.com/omii623/JobOn/master/Diagrams/AFD/Logikai/2szint_allasMeghirdetes_logikai_afd.jpg" width="800">
</div><br/>

<div  align="center">
  <img src="https://raw.githubusercontent.com/omii623/JobOn/master/Diagrams/AFD/Logikai/2szint_jelentkezesekMegtekintese_logikai_afd.jpg" width="800">
</div><br/>

<br/>
Fizikai:<br/>

<div  align="center">
  <img src="https://raw.githubusercontent.com/omii623/JobOn/master/Diagrams/AFD/Fizikai/2szint_regisztracio_fizikai_afd.jpg" width="800">
</div><br/>

<div  align="center">
  <img src="https://raw.githubusercontent.com/omii623/JobOn/master/Diagrams/AFD/Fizikai/2szint_bejelentkezes_fizikai_afd.jpg" width="800">
</div><br/>

<div  align="center">
  <img src="https://raw.githubusercontent.com/omii623/JobOn/master/Diagrams/AFD/Fizikai/2szint_allasokKeresese_fizikai_afd.jpg" width="800">
</div><br/>

<div  align="center">
  <img src="https://raw.githubusercontent.com/omii623/JobOn/master/Diagrams/AFD/Fizikai/2szint_megfeleloAllasok_fizikai_afd.jpg" width="800">
</div><br/>

<div  align="center">
  <img src="https://raw.githubusercontent.com/omii623/JobOn/master/Diagrams/AFD/Fizikai/2szint_allasMeghirdetes_fizikai_afd.jpg" width="800">
</div><br/>

<div  align="center">
  <img src="https://raw.githubusercontent.com/omii623/JobOn/master/Diagrams/AFD/Fizikai/2szint_jelentkezesekMegtekintese_fizikai_afd.jpg" width="800">
</div><br/>
<br/>

## EK-diagram:

<br/>
<div  align="center">
  <img src="https://raw.githubusercontent.com/omii623/JobOn/master/Diagrams/EK/EK.jpg" width="800">
</div>
<br/>

## Az EK-diagram leképezése relációsémákra:

<div  align="center">
  <img src="https://raw.githubusercontent.com/omii623/JobOn/master/Diagrams/Relaciosemak/Relaciosemak.png" width="800">
</div>
<br/>

## A relációsémák normalizálása:

1NF: minden elem atomi <br/>
2NF: 4 táblában csak egy attribútumból áll a kulcs, ezért azok egyértelműen 2NF-ben vannak, és 
a másik 3 táblában is minden másodlagos attribútum teljesen függ bármely kulcstól. <br/>
3NF: minden másodlagos attribútum közvetlenül függ bármely kulcstól. <br/>

## Táblák leírása:

<div  align="center">
  <img src="https://raw.githubusercontent.com/omii623/JobOn/master/Diagrams/Relaciosemak/felhasznalo.png" width="800">
</div>
<br/>

<div  align="center">
  <img src="https://raw.githubusercontent.com/omii623/JobOn/master/Diagrams/Relaciosemak/allaskereso.png" width="800">
</div>
<br/>

<div  align="center">
  <img src="https://raw.githubusercontent.com/omii623/JobOn/master/Diagrams/Relaciosemak/munkaltato.png" width="800">
</div>
<br/>

<div  align="center">
  <img src="https://raw.githubusercontent.com/omii623/JobOn/master/Diagrams/Relaciosemak/allasajanlat.png" width="800">
</div>
<br/>

<div  align="center">
  <img src="https://raw.githubusercontent.com/omii623/JobOn/master/Diagrams/Relaciosemak/szakma.png" width="800">
</div>
<br/>

<div  align="center">
  <img src="https://raw.githubusercontent.com/omii623/JobOn/master/Diagrams/Relaciosemak/cv.png" width="800">
</div>
<br/>

<div  align="center">
  <img src="https://raw.githubusercontent.com/omii623/JobOn/master/Diagrams/Relaciosemak/jelentkezes.png" width="800">
</div>
<br/>

## Szerep-funkció mátrix:

<div  align="center">
  <img src="https://raw.githubusercontent.com/omii623/JobOn/master/Diagrams/szerep_funkcio/szerep_funkcio.png" width="400">
</div>

## Egyed-esemény mátrix:

<div  align="center">
  <img src="https://raw.githubusercontent.com/omii623/JobOn/master/Diagrams/egyed_esemeny/egyed_esemeny.png" width="400">
</div>

## Megvalósított összetett lekérdezések:
<br>
1.
<div>
SELECT AVG(EXTRACT(YEAR FROM CURRENT_DATE)-EXTRACT(YEAR FROM SZULETESI_DATUM)) AS atlageletkor, SZAKMA
<br>
FROM "C##SAELDC"."ALLASKERESO", "C##SAELDC"."SZAKMA"
<br>
WHERE ALLASKERESO.ID=SZAKMA.FID
<br>
GROUP BY SZAKMA
<br>
ORDER BY atlageletkor;
</div>
<br>
<div>
Helye a programkódban: jobon-app/src/main/java/hu/jobon/database/Database.java 46.sor
</div>
<br>
<div>
Statisztika az átlagéletkorról szakmánként
</div>

<br>
2.
<div>
SELECT MIN(ORABER), MUNKAKOR
<br>
FROM "C##SAELDC"."ALLASAJANLAT", "C##SAELDC"."MUNKALTATO"
<br>
WHERE "C##SAELDC"."ALLASAJANLAT"."FID" = "C##SAELDC"."MUNKALTATO"."ID" AND VAROS='varos'
<br>
GROUP BY MUNKAKOR; 
</div>
<br>
<div>
Helye a programkódban: jobon-app/src/main/java/hu/jobon/database/Database.java 48.sor és 646.sor
</div>
<br>
<div>
Statisztika a minimum órabérekről munkakörök szerint a választott városban
</div>

<br>
3.
<div>
SELECT MAX(ORABER), MUNKAKOR
<br>
FROM "C##SAELDC"."ALLASAJANLAT", "C##SAELDC"."MUNKALTATO"
<br>
WHERE "C##SAELDC"."ALLASAJANLAT"."FID" = "C##SAELDC"."MUNKALTATO"."ID" AND VAROS='varos'
<br>
GROUP BY MUNKAKOR; 
</div>
<br>
<div>
Helye a programkódban: jobon-app/src/main/java/hu/jobon/database/Database.java 48.sor és 671.sor
</div>
<br>
<div>
Statisztika a maximum órabérekről munkakörök szerint a választott városban
</div>

<br>
4.
<div>
SELECT POZICIO, COUNT(*) AS jelentkezok_szama
<br>
FROM "C##SAELDC"."JELENTKEZES", "C##SAELDC"."ALLASAJANLAT"
<br>
WHERE "C##SAELDC"."JELENTKEZES".AID="C##SAELDC"."ALLASAJANLAT".ID AND "C##SAELDC"."ALLASAJANLAT"."FID"=felhasznalo.getID()
<br>
GROUP BY POZICIO
<br>
ORDER BY Jelentkezok_szama;  
</div>
<br>
<div>
Helye a programkódban: jobon-app/src/main/java/hu/jobon/database/Database.java 47.sor
</div>
<br>
<div>
Statisztika a jelentkezők számáról pozíció szerint az adott munkáltatónál
</div>

<br>
5.
<div>
SELECT  *
FROM "C##SAELDC"."ALLASAJANLAT", "C##SAELDC"."MUNKALTATO", "C##SAELDC"."ALLASKERESO"
<br>
WHERE "C##SAELDC"."ALLASAJANLAT"."FID"="C##SAELDC"."MUNKALTATO"."ID" AND "C##SAELDC"."ALLASKERESO"."ID"=felhasznalo.getID() 
<br>
AND ORABER> (SELECT AVG(ORABER) FROM "C##SAELDC"."ALLASAJANLAT") AND "C##SAELDC"."MUNKALTATO"."VAROS"="C##SAELDC"."ALLASKERESO"."VAROS";

</div>
<br>
<div>
Helye a programkódban: jobon-app/src/main/java/hu/jobon/database/Database.java 38.sor
</div>
<br>
<div>
Statisztika az átlagtól jobban fizető munkakörökről a felhasznaló városában
</div>

<br>
6.
<div>
SELECT COUNT(*), VAROS
<br>
FROM "C##SAELDC"."FELHASZNALO", "C##SAELDC"."ALLASKERESO"
<br>
WHERE "C##SAELDC"."FELHASZNALO"."ID"="C##SAELDC"."ALLASKERESO"."ID" 
<br>
GROUP BY VAROS;
</div>
<br>
<div>
Helye a programkódban: jobon-app/src/main/java/hu/jobon/database/Database.java 59.sor
</div>
<br>
<div>
Statisztika az álláskeresők számáról városonként 
</div>

## Függvények/eljárások és triggerek:
<br>
1F.
<div>
CREATE FUNCTION szakmabeliekSzama(p_szakma IN C##SAELDC.SZAKMA.szakma%TYPE)RETURN NUMBER
<br>
IS
<br>
szam NUMBER :=0;
<br>
BEGIN
<br>
SELECT COUNT(*) INTO szam
<br>
FROM C##SAELDC.SZAKMA
<br>
WHERE p_szakma=SZAKMA.szakma; 
<br>
RETURN szam;
<br>
END;
</div>

<br>
2E.
<div>
CREATE OR REPLACE PROCEDURE newSzakma(p_id IN NUMBER, p_szakma IN VARCHAR2)
<br>
IS BEGIN
<br>
INSERT INTO "C##SAELDC"."SZAKMA" (SZAKMA,FID) values (p_szakma, p_id);
<br>
END;
</div>

<br>
1T.
<div>
CREATE OR REPLACE TRIGGER log_trigger
<br>
AFTER UPDATE OR INSERT OF ALLASKERESO ON 'utolsó belépés'
<br>
FOR EACH ROW
<br>
WHEN (OLD.'utolsó belépés' != NEW.'utolsó belépés')
<br>
BEGIN
<br>
      INSERT INTO log_table (id, login) VALUES (NEW.id, NEW.'utolsó belépés')
<br>
END;
<br>
/
</div>

<br>
2T.
<div>
CREATE OR REPLACE TRIGGER off_trigger
<br>
BEFORE DELETE OR INSERT OR UPDATE
<br>
ON JELENTKEZES
<br>
BEGIN
<br>
     IF TO_CHAR(SYSDATE, 'HH24:MI') < '08:00' THEN  
     <br>
     RAISE_APPLICATION_ERROR(-20111, 'Nem lehet jelenleg módosítani.');
     <br>
     END IF;
     <br>
     IF TO_CHAR(SYSDATE, 'HH24:MI') > '20:00' THEN  
     <br>
     RAISE_APPLICATION_ERROR(-20111, 'Nem lehet jelenleg módosítani.');
     <br>
     END IF;
     <br>
END;
<br>
/
</div>

## Fordításhoz/futtatáshoz szükséges eszközök:
