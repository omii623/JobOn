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

Csapattagok és a rájuk osztott feladatok listaszerű felsorolása.

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

## Az EK-diagram leképezése relációsémákra:

Relációsémák megadása.

## A relációsémák normalizálása:

Normalizálás „táblázatos" formában.

## Táblák leírása:

Tábla1: _Tábla1 tartalmának leírása._

| **Név** | **Típus** | **Leírás** |
| ------- | --------- | ---------- |
| Attr1   | Típus1    | Leírás1    |
| Attr2   | Típus2    | Leírás2    |

## Szerep-funkció mátrix:

<div  align="center">
  <img src="https://raw.githubusercontent.com/omii623/JobOn/master/Diagrams/szerep_funkcio/szerep_funkcio.png" width="400">
</div>

## Egyed-esemény mátrix:

<div  align="center">
  <img src="https://raw.githubusercontent.com/omii623/JobOn/master/Diagrams/egyed_esemeny/egyed_esemeny.png" width="400">
</div>

## Funkció megadása:

## Egyéb:


