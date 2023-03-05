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

A DFD 1. szintje:

![Alt text](https://github.com/omii623/JobOn/blob/6f9553d1db61bc2ff18c0ffc6c7c1f4fe461fa32/Diagrams/1szint_logikai_afd.jpg.jpg "1. szintű logikai AFD:")

A DFD 2. szintje:

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

<table>
  <tr>
    <th></th>
    <th><SPAN STYLE="writing-mode: vertical-lr; transform: rotate(180deg);">Bejelenkezés</SPAN></th>
    <th><SPAN STYLE="writing-mode: vertical-lr; transform: rotate(180deg);"></SPAN></th>
    <th><SPAN STYLE="writing-mode: vertical-lr; transform: rotate(180deg);"></SPAN></th>
    <th><SPAN STYLE="writing-mode: vertical-lr; transform: rotate(180deg);"></SPAN></th>
    <th><SPAN STYLE="writing-mode: vertical-lr; transform: rotate(180deg);"></SPAN></th>
    <th><SPAN STYLE="writing-mode: vertical-lr; transform: rotate(180deg);"></SPAN></th>
  </tr>
  <tr>
    <th>Vendég</th>
    <td>🟥</td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <th>Álláskereső</th>
    <td>🟩</td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <th>Munkáltató</th>
    <td>🟩</td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <th>Admin</th>
    <td>🟩</td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
</table>

## Egyed-esemény mátrix:

## Funkció megadása:

## Egyéb:


