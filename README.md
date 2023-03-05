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

![0. szintű DFD](https://github.com/omii623/JobOn/blob/4555cb311f46a420dde4d971d60ee2ed60ab6dc5/Diagrams/AFD/0szint_afd.jpg "0. szintű DFD:")

A DFD 1. szintje: <br/>
Logikai:<br/>
![1. szintű logikai DFD](https://github.com/omii623/JobOn/blob/4555cb311f46a420dde4d971d60ee2ed60ab6dc5/Diagrams/AFD/Logikai/1szint_logikai_afd.jpg "1. szintű logikai DFD:")<br/>

Fizikai:<br/>
![1. szintű fizikai DFD](https://github.com/omii623/JobOn/blob/4555cb311f46a420dde4d971d60ee2ed60ab6dc5/Diagrams/AFD/Fizikai/1szint_fizikai_afd.jpg "1. szintű logikai DFD:")<br/>

A DFD 2. szintje:<br/>
Logikai:<br/>
![2. szintű logikai DFD](https://github.com/omii623/JobOn/blob/4555cb311f46a420dde4d971d60ee2ed60ab6dc5/Diagrams/AFD/Logikai/2szint_regisztracio_logikai_afd.jpg "2. szintű logikai DFD:")<br/>

![2. szintű logikai DFD](https://github.com/omii623/JobOn/blob/4555cb311f46a420dde4d971d60ee2ed60ab6dc5/Diagrams/AFD/Logikai/2szint_bejelentkezes_logikai_afd.jpg "2. szintű logikai DFD:")<br/>

![2. szintű logikai DFD](https://github.com/omii623/JobOn/blob/4555cb311f46a420dde4d971d60ee2ed60ab6dc5/Diagrams/AFD/Logikai/2szint_allasokKeresese_logikai_afd.jpg "2. szintű logikai DFD:")<br/>

![2. szintű logikai DFD](https://github.com/omii623/JobOn/blob/4555cb311f46a420dde4d971d60ee2ed60ab6dc5/Diagrams/AFD/Logikai/2szint_megfeleloAllasok_logikai_afd.jpg "2. szintű logikai DFD:")<br/>

![2. szintű logikai DFD](https://github.com/omii623/JobOn/blob/4555cb311f46a420dde4d971d60ee2ed60ab6dc5/Diagrams/AFD/Logikai/2szint_allasMeghirdetes_logikai_afd.jpg "2. szintű logikai DFD:")<br/>

![2. szintű logikai DFD](https://github.com/omii623/JobOn/blob/4555cb311f46a420dde4d971d60ee2ed60ab6dc5/Diagrams/AFD/Logikai/2szint_jelentkezesekMegtekintese_logikai_afd.jpg "2. szintű logikai DFD:")<br/>
<br/>
Fizikai:<br/>

![2. szintű fizikai DFD](https://github.com/omii623/JobOn/blob/4555cb311f46a420dde4d971d60ee2ed60ab6dc5/Diagrams/AFD/Fizikai/2szint_regisztracio_fizikai_afd.jpg "2. szintű fizikai DFD:")<br/>

![2. szintű fizikai DFD](https://github.com/omii623/JobOn/blob/4555cb311f46a420dde4d971d60ee2ed60ab6dc5/Diagrams/AFD/Fizikai/2szint_bejelentkezes_fizikai_afd.jpg "2. szintű fizikai DFD:")<br/>

![2. szintű fizikai DFD](https://github.com/omii623/JobOn/blob/4555cb311f46a420dde4d971d60ee2ed60ab6dc5/Diagrams/AFD/Fizikai/2szint_allasokKeresese_fizikai_afd.jpg "2. szintű fizikai DFD:")<br/>

![2. szintű fizikai DFD](https://github.com/omii623/JobOn/blob/4555cb311f46a420dde4d971d60ee2ed60ab6dc5/Diagrams/AFD/Fizikai/2szint_megfeleloAllasok_fizikai_afd.jpg "2. szintű fizikai DFD:")<br/>

![2. szintű fizikai DFD](https://github.com/omii623/JobOn/blob/4555cb311f46a420dde4d971d60ee2ed60ab6dc5/Diagrams/AFD/Fizikai/2szint_allasMeghirdetes_fizikai_afd.jpg "2. szintű fizikai DFD:")<br/>

![2. szintű fizikai DFD](https://github.com/omii623/JobOn/blob/4555cb311f46a420dde4d971d60ee2ed60ab6dc5/Diagrams/AFD/Fizikai/2szint_jelentkezesekMegtekintese_fizikai_afd.jpg "2. szintű fizikai DFD:")<br/>

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


