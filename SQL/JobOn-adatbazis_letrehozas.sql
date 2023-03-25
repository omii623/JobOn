CREATE SEQUENCE dept_seq START WITH 1;

CREATE TABLE "FELHASZNALO" 
   (	
    "ID" NUMBER(10) DEFAULT dept_seq.nextval NOT NULL, 
	"EMAIL_CIM" VARCHAR2(50), 
	"JELSZO" VARCHAR2(50), 
	"TIPUS" NUMBER(1),
    PRIMARY KEY(ID)
   );
   
   Insert into FELHASZNALO (EMAIL_CIM,JELSZO,TIPUS) values ('admin@admin.hu','admin789',1);
   Insert into FELHASZNALO (EMAIL_CIM,JELSZO,TIPUS) values ('abrahamrozsa53@gmail.com','W4y5T5h2Ps',2);
   Insert into FELHASZNALO (EMAIL_CIM,JELSZO,TIPUS) values ('arok.imola@gmail.com','9v0F9Zv4Gj',2);
   Insert into FELHASZNALO (EMAIL_CIM,JELSZO,TIPUS) values ('bajuszildi@gmail.com','UKPR3zIr4c',3);
   Insert into FELHASZNALO (EMAIL_CIM,JELSZO,TIPUS) values ('barna.ferenc@gmail.com','nx0eqq1Uyj',2);
   Insert into FELHASZNALO (EMAIL_CIM,JELSZO,TIPUS) values ('bicskei.amanda8@gmail.com','U8QZd1m4C8',2);
   Insert into FELHASZNALO (EMAIL_CIM,JELSZO,TIPUS) values ('bicskei.noemi@gmail.com','23x08U72kA',2);
   Insert into FELHASZNALO (EMAIL_CIM,JELSZO,TIPUS) values ('botimeszaros@gmail.com','jVKHK6O6io',2);
   Insert into FELHASZNALO (EMAIL_CIM,JELSZO,TIPUS) values ('csabaiflora@gmail.com','gQQMIoNOje',2);
   Insert into FELHASZNALO (EMAIL_CIM,JELSZO,TIPUS) values ('csikos8flora@gmail.com','nkK1yxRiA6',2);
   Insert into FELHASZNALO (EMAIL_CIM,JELSZO,TIPUS) values ('dudasolga@gmail.com','ctI7jh6Jrk',3);
   Insert into FELHASZNALO (EMAIL_CIM,JELSZO,TIPUS) values ('eolivere@gmail.com','Cmy01DpDrA',2);
   Insert into FELHASZNALO (EMAIL_CIM,JELSZO,TIPUS) values ('erno1010@gmail.com','EW5XOT9JC0',2);
   Insert into FELHASZNALO (EMAIL_CIM,JELSZO,TIPUS) values ('evelin.toth5@gmail.com','Q0pX3Eg0D4',2);
   Insert into FELHASZNALO (EMAIL_CIM,JELSZO,TIPUS) values ('farkas.nikii@gmail.com','i7lR9S17I8',2);
   Insert into FELHASZNALO (EMAIL_CIM,JELSZO,TIPUS) values ('hanna.kormoci@gmail.com','6oyT06jt6w',3);
   Insert into FELHASZNALO (EMAIL_CIM,JELSZO,TIPUS) values ('harmathemma2020@gmail.com','UK5d6v8wfa',2);
   Insert into FELHASZNALO (EMAIL_CIM,JELSZO,TIPUS) values ('horvathpeter@gmail.com','56E608AjTQ',2);
   Insert into FELHASZNALO (EMAIL_CIM,JELSZO,TIPUS) values ('juliafodor@gmail.com','9Gu1yB793Q',3);
   Insert into FELHASZNALO (EMAIL_CIM,JELSZO,TIPUS) values ('karolapro@gmail.com','DwF4Q73Sg8',2);
   Insert into FELHASZNALO (EMAIL_CIM,JELSZO,TIPUS) values ('kiraly.fanni@gmail.com','5L23aU1zmO',3);
   Insert into FELHASZNALO (EMAIL_CIM,JELSZO,TIPUS) values ('kis.laszlo19@gmail.com','b5Lk8qKPeq',3);
   Insert into FELHASZNALO (EMAIL_CIM,JELSZO,TIPUS) values ('kocsis.izabella@gmail.com','DFr6A57P4Z',3);
   Insert into FELHASZNALO (EMAIL_CIM,JELSZO,TIPUS) values ('konczevi@gmail.com','n2h2CxamYl',3);
   Insert into FELHASZNALO (EMAIL_CIM,JELSZO,TIPUS) values ('leaposa18@gmail.com','0zy6hgOo19',3);
   Insert into FELHASZNALO (EMAIL_CIM,JELSZO,TIPUS) values ('luciiiif@gmail.com','tfj8VgpU7a',2);
   Insert into FELHASZNALO (EMAIL_CIM,JELSZO,TIPUS) values ('melinda8nagy@gmail.com','72p0v8nHR0',3);
   Insert into FELHASZNALO (EMAIL_CIM,JELSZO,TIPUS) values ('molnar.petra@gmail.com','ua0IejZ5s6',3);
   Insert into FELHASZNALO (EMAIL_CIM,JELSZO,TIPUS) values ('muhikaroly@gmail.com','CFd4kVe9yv',3);
   Insert into FELHASZNALO (EMAIL_CIM,JELSZO,TIPUS) values ('nagyandi@gmail.com','B237ExzU82',3);
   Insert into FELHASZNALO (EMAIL_CIM,JELSZO,TIPUS) values ('petrajuhasz@gmail.com','G4bi9gJfZ1',3);
   Insert into FELHASZNALO (EMAIL_CIM,JELSZO,TIPUS) values ('puskas.h@gmail.com','37yICzY6lM',3);
   Insert into FELHASZNALO (EMAIL_CIM,JELSZO,TIPUS) values ('rekanyilas@gmail.com','H3bj195OOl',2);
   Insert into FELHASZNALO (EMAIL_CIM,JELSZO,TIPUS) values ('rozsafanni@gmail.com','D7i5F15FJU',3);
   Insert into FELHASZNALO (EMAIL_CIM,JELSZO,TIPUS) values ('sasoma@gmail.com','bdpxN00x5X',3);
   Insert into FELHASZNALO (EMAIL_CIM,JELSZO,TIPUS) values ('sotisanyi@gmail.com','8IPqO1mPz8',3);
   Insert into FELHASZNALO (EMAIL_CIM,JELSZO,TIPUS) values ('szabonorbii@gmail.com','lT6534zO9s',3);
   Insert into FELHASZNALO (EMAIL_CIM,JELSZO,TIPUS) values ('szeprami20@gmail.com','U16RBg6son',3);
   Insert into FELHASZNALO (EMAIL_CIM,JELSZO,TIPUS) values ('tamaskovacs@gmail.com','Tm71t5O9DR',2);
   Insert into FELHASZNALO (EMAIL_CIM,JELSZO,TIPUS) values ('thilda444@gmail.com','032Mv71P17',2);
   Insert into FELHASZNALO (EMAIL_CIM,JELSZO,TIPUS) values ('varga.balint10@gmail.com','nD8sx63ilW',3);
   Insert into FELHASZNALO (EMAIL_CIM,JELSZO,TIPUS) values ('vasjozsi@gmail.com','7G8u0ln99M',3);
   Insert into FELHASZNALO (EMAIL_CIM,JELSZO,TIPUS) values ('viktor.hollo@gmail.com','SnO8u6fz3w',2);
   
   ---------------------------------------------------------------------------------------------
   
   CREATE TABLE "ALLASKERESO" 
   (	
  
    "ID" NUMBER(10) NOT NULL, 
	"TELJES_NEV" VARCHAR2(50), 
	"SZULETESI_DATUM" DATE, 
	"VAROS" VARCHAR2(50),
    "CIM" VARCHAR2(50),
    PRIMARY KEY(ID),
    FOREIGN KEY(ID) REFERENCES FELHASZNALO(ID)
   );
   
    Insert into ALLASKERESO (ID,TELJES_NEV,SZULETESI_DATUM,VAROS,CIM) values (2,'Ábrahám Rózsa',DATE '1975-03-09','Debrecen','Dáni utca 68');
    Insert into ALLASKERESO (ID,TELJES_NEV,SZULETESI_DATUM,VAROS,CIM) values (3,'Árok Imola',DATE '1981-11-23','Budapest','Holló utca 7');
    Insert into ALLASKERESO (ID,TELJES_NEV,SZULETESI_DATUM,VAROS,CIM) values (5,'Barna Ferenc',DATE '1989-08-31','Debrecen','Lengyel utca 26');
    Insert into ALLASKERESO (ID,TELJES_NEV,SZULETESI_DATUM,VAROS,CIM) values (6,'Bicskei Amanda',DATE '1985-06-13','Budapest','Remény utca 11');
    Insert into ALLASKERESO (ID,TELJES_NEV,SZULETESI_DATUM,VAROS,CIM) values (7,'Bicskei Noémi',DATE '1995-10-07','Budapest','Sólyom utca 48');
    Insert into ALLASKERESO (ID,TELJES_NEV,SZULETESI_DATUM,VAROS,CIM) values (8,'Mészáros Botond',DATE '1993-06-16','Szeged','Czékus utca 40');
    Insert into ALLASKERESO (ID,TELJES_NEV,SZULETESI_DATUM,VAROS,CIM) values (9,'Csabai Flóra',DATE '1998-05-18','Budapest','Sándorfalvi út 15');
    Insert into ALLASKERESO (ID,TELJES_NEV,SZULETESI_DATUM,VAROS,CIM) values (10,'Csíkos Flóra',DATE '1980-02-26','Szeged','Közép fasor 67');
    Insert into ALLASKERESO (ID,TELJES_NEV,SZULETESI_DATUM,VAROS,CIM) values (12,'Eszes Olivér',DATE '1978-12-10','Debrecen','Réti utca 4');
    Insert into ALLASKERESO (ID,TELJES_NEV,SZULETESI_DATUM,VAROS,CIM) values (13,'Habonyi Ernő',DATE '1996-04-21','Szeged','Kálvária sugárút 77');
    Insert into ALLASKERESO (ID,TELJES_NEV,SZULETESI_DATUM,VAROS,CIM) values (14,'Tóth Evelin',DATE '1999-09-07','Debrecen','Béke utca 8');
    Insert into ALLASKERESO (ID,TELJES_NEV,SZULETESI_DATUM,VAROS,CIM) values (15,'Farkas Nikolett',DATE '2000-07-14','Szeged','Bakonyi utca 22');
    Insert into ALLASKERESO (ID,TELJES_NEV,SZULETESI_DATUM,VAROS,CIM) values (17,'Körmöci Hanna',DATE '1985-01-26','Budapest','Makai út 16');
    Insert into ALLASKERESO (ID,TELJES_NEV,SZULETESI_DATUM,VAROS,CIM) values (18,'Harmath Emma',DATE '1987-03-27','Budapest','Csillag tér 9');
    Insert into ALLASKERESO (ID,TELJES_NEV,SZULETESI_DATUM,VAROS,CIM) values (20,'Horváth Péter',DATE '1991-07-13','Debrecen','Fonógyári út 53');
    Insert into ALLASKERESO (ID,TELJES_NEV,SZULETESI_DATUM,VAROS,CIM) values (26,'Farkas Luca',DATE '1996-06-04','Budapest','Orgona utca 64');
    Insert into ALLASKERESO (ID,TELJES_NEV,SZULETESI_DATUM,VAROS,CIM) values (33,'Nyilas Réka',DATE '1979-09-17','Budapest','Galagonya utca 29');
    Insert into ALLASKERESO (ID,TELJES_NEV,SZULETESI_DATUM,VAROS,CIM) values (39,'Kovács Tamás',DATE '1988-11-25','Szeged','Piszke utca 14');
    Insert into ALLASKERESO (ID,TELJES_NEV,SZULETESI_DATUM,VAROS,CIM) values (40,'Tari Hilda',DATE '1994-02-09','Debrecen','Nyár köz 21');
    Insert into ALLASKERESO (ID,TELJES_NEV,SZULETESI_DATUM,VAROS,CIM) values (43,'Holló Viktor',DATE '1994-04-17','Szeged','Gyálai út 87');
	
   ---------------------------------------------------------------------------------------------------
   
   CREATE TABLE "MUNKALTATO" 
   (	
  
    "ID" NUMBER(10) NOT NULL, 
	"CEGNEV" VARCHAR2(50),  
	"TELEFONSZAM" VARCHAR2(15),
    "EMAIL_CIM_HIVATALOS" VARCHAR2(50),
	"MEGALAPITAS_EVE" DATE,
	"VAROS" VARCHAR2(50),
    "CIM" VARCHAR2(50),
    PRIMARY KEY(ID),
    FOREIGN KEY(ID) REFERENCES FELHASZNALO(ID)
   );
   
       Insert into MUNKALTATO (ID,CEGNEV,TELEFONSZAM,EMAIL_CIM_HIVATALOS,MEGALAPITAS_EVE,VAROS,CIM) values (4,'Vodafone Magyarország Zrt.','+36833701478','info@vodafon.hu',DATE '2005-01-01','Szeged','Kérész utca 10');
       Insert into MUNKALTATO (ID,CEGNEV,TELEFONSZAM,EMAIL_CIM_HIVATALOS,MEGALAPITAS_EVE,VAROS,CIM) values (11,'Adevinta Classified Media Hungary Kft.','+36581970514','info@adevinta.hu',DATE '2008-01-01','Budapest','Meggyfa utca 8');
       Insert into MUNKALTATO (ID,CEGNEV,TELEFONSZAM,EMAIL_CIM_HIVATALOS,MEGALAPITAS_EVE,VAROS,CIM) values (16,'LPP Hungary Kft. - RESERVED','+36514782946','info@lpphungary.hu',DATE '2000-01-01','Szeged','Liszt utca 10');
       Insert into MUNKALTATO (ID,CEGNEV,TELEFONSZAM,EMAIL_CIM_HIVATALOS,MEGALAPITAS_EVE,VAROS,CIM) values (21,'Musashi Hungary Füzesabony Kft.','+36862747513','info@musashi.hu',DATE '2010-01-01','Debrecen','Dózsa utca 3');
       Insert into MUNKALTATO (ID,CEGNEV,TELEFONSZAM,EMAIL_CIM_HIVATALOS,MEGALAPITAS_EVE,VAROS,CIM) values (22,'Hegedűs és társai Bt.','+36420064208','hegedus@gmail.com',DATE '1996-01-01','Szeged','Vásártér sor 92');
       Insert into MUNKALTATO (ID,CEGNEV,TELEFONSZAM,EMAIL_CIM_HIVATALOS,MEGALAPITAS_EVE,VAROS,CIM) values (23,'ZeinaHotels','+36628775893','info@zeinahotels.hu',DATE '2003-01-01','Debrecen','Bokor utca 102');
       Insert into MUNKALTATO (ID,CEGNEV,TELEFONSZAM,EMAIL_CIM_HIVATALOS,MEGALAPITAS_EVE,VAROS,CIM) values (24,'HAVANCSÁK KFT.','+36702436536','havancsak@gmail.com',DATE '2001-01-01','Budapest','Garam utca 17');
       Insert into MUNKALTATO (ID,CEGNEV,TELEFONSZAM,EMAIL_CIM_HIVATALOS,MEGALAPITAS_EVE,VAROS,CIM) values (25,'SEMILAB zrt','+36906958591','info@semilab.hu',DATE '1998-01-01','Szeged','Czékus utca 55');
       Insert into MUNKALTATO (ID,CEGNEV,TELEFONSZAM,EMAIL_CIM_HIVATALOS,MEGALAPITAS_EVE,VAROS,CIM) values (27,'Nemzeti Élelmiszerlánc-Biztonsági Hivatal','+36437379982','kisboglarka@gmail.com',DATE '2013-01-01','Szeged','Szabadság tér 67');
       Insert into MUNKALTATO (ID,CEGNEV,TELEFONSZAM,EMAIL_CIM_HIVATALOS,MEGALAPITAS_EVE,VAROS,CIM) values (28,'Tesco Global Áruházak Zrt.','+36997737370','info@tesco.hu',DATE '2004-01-01','Budapest','Árpa utca 15');
       Insert into MUNKALTATO (ID,CEGNEV,TELEFONSZAM,EMAIL_CIM_HIVATALOS,MEGALAPITAS_EVE,VAROS,CIM) values (29,'RWA Magyarország Kft.','+36710548444','info@rwahungary.hu',DATE '1986-01-01','Debrecen','Feketesas utca 42');
       Insert into MUNKALTATO (ID,CEGNEV,TELEFONSZAM,EMAIL_CIM_HIVATALOS,MEGALAPITAS_EVE,VAROS,CIM) values (30,'Budapest Airport Zrt.','+36129035327','katonapeter@gmail.com',DATE '2011-01-01','Szeged','Gyár utca 5');
       Insert into MUNKALTATO (ID,CEGNEV,TELEFONSZAM,EMAIL_CIM_HIVATALOS,MEGALAPITAS_EVE,VAROS,CIM) values (31,'ORLEN Unipetrol Hungary Kft.','+36165700365','info@orlen.hu',DATE '2015-01-01','Budapest','Lengyel utca 19');
       Insert into MUNKALTATO (ID,CEGNEV,TELEFONSZAM,EMAIL_CIM_HIVATALOS,MEGALAPITAS_EVE,VAROS,CIM) values (32,'Toyota Anyagmozgatás Magyaro. Kft.','+36935963782','info@toyotahungary.hu',DATE '2006-01-01','Szeged','Hangya utca 13');
       Insert into MUNKALTATO (ID,CEGNEV,TELEFONSZAM,EMAIL_CIM_HIVATALOS,MEGALAPITAS_EVE,VAROS,CIM) values (34,'MVM Next Energiakereskedelmi Zrt.','+36353231551','laszloandra@gmail.com',DATE '2012-01-01','Szeged','Horgony utca 1');
       Insert into MUNKALTATO (ID,CEGNEV,TELEFONSZAM,EMAIL_CIM_HIVATALOS,MEGALAPITAS_EVE,VAROS,CIM) values (35,'Kis Nápoly Kft.','+36132591166','info@kisnapoly.hu',DATE '1999-01-01','Debrecen','Barátság utca 18');
       Insert into MUNKALTATO (ID,CEGNEV,TELEFONSZAM,EMAIL_CIM_HIVATALOS,MEGALAPITAS_EVE,VAROS,CIM) values (36,'PIKOPACK Zrt.','+36504774020','info@pikopack.hu',DATE '2007-01-01','Szeged','Bajai út 33');
       Insert into MUNKALTATO (ID,CEGNEV,TELEFONSZAM,EMAIL_CIM_HIVATALOS,MEGALAPITAS_EVE,VAROS,CIM) values (37,'Rondo Hullámkartongyártó Kft.','+36661078028','info@rondo.hu',DATE '2003-01-01','Budapest','Fontos Sándor utca 7');
       Insert into MUNKALTATO (ID,CEGNEV,TELEFONSZAM,EMAIL_CIM_HIVATALOS,MEGALAPITAS_EVE,VAROS,CIM) values (38,'PLANNING & TRADING Kft.','+36382901664','info@plantrad.hu',DATE '2013-01-01','Szeged','Tisza Lajos körút 107');
       Insert into MUNKALTATO (ID,CEGNEV,TELEFONSZAM,EMAIL_CIM_HIVATALOS,MEGALAPITAS_EVE,VAROS,CIM) values (41,'Columbus Klímaértékesítő Kft.','+36562292227','info@columbus.hu',DATE '2005-01-01','Debrecen','Kavics utca 3');
       Insert into MUNKALTATO (ID,CEGNEV,TELEFONSZAM,EMAIL_CIM_HIVATALOS,MEGALAPITAS_EVE,VAROS,CIM) values (42,'BKK Zrt.','+36185904407','info@bkk.hu',DATE '1998-01-01','Budapest','Zápor út ');
	   
	   
	 ---------------------------------------------------------------------------------------------------
   
   CREATE SEQUENCE dept_seq START WITH 1;
   
   CREATE TABLE "ALLASAJANLAT" 
   (	
  
    "ID" NUMBER(10) DEFAULT dept_seq.nextval NOT NULL,  
    "FID" NUMBER(10) NOT NULL, 
    "ORABER" NUMBER(10) NOT NULL, 
	"POZICIO" VARCHAR2(50),  
	"MUNKAKOR" VARCHAR2(50),
	"LÉTREHOZÁS_IDEJE" DATE,
    "LEIRAS" VARCHAR2(200),
    PRIMARY KEY(ID),
    FOREIGN KEY(FID) REFERENCES FELHASZNALO(ID)
   );  
   
   Insert into ALLASAJANLAT (FID,ORABER,POZICIO,MUNKAKOR,LÉTREHOZÁS_IDEJE,LEIRAS) values (4,3000,'Conversational Ai Bot Developer','Informatikus', DATE '2023-03-23','Elvárások: Angol felsőfok, 1-3 év szakmai tapasztalat, Főiskola');
   Insert into ALLASAJANLAT (FID,ORABER,POZICIO,MUNKAKOR,LÉTREHOZÁS_IDEJE,LEIRAS) values (4,2000,'Senior Customer Insight Expert','Közgazdasz', DATE '2023-03-23','Elvárások: Angol középfok, 5-10 év szakmai tapasztalat, Főiskola');
   Insert into ALLASAJANLAT (FID,ORABER,POZICIO,MUNKAKOR,LÉTREHOZÁS_IDEJE,LEIRAS) values (11,1500,'Telefonos Értékesítő Munkatárs','Ügyfélszolgálat',DATE '2023-03-23','Elvárások: Nem igényel nyelvtudást, 1-3 év szakmai tapasztalat, Középiskola');
   Insert into ALLASAJANLAT (FID,ORABER,POZICIO,MUNKAKOR,LÉTREHOZÁS_IDEJE,LEIRAS) values (11,2000,'Recruiter vállalati oldalra','HR',DATE '2023-03-23','Elvárások: Angol középfok, 1-3 év szakmai tapasztalat, Középiskola');
   Insert into ALLASAJANLAT (FID,ORABER,POZICIO,MUNKAKOR,LÉTREHOZÁS_IDEJE,LEIRAS) values (16,2500,'Eladó (RESERVED - (Shopmark)','Közgazdász',DATE '2023-03-23','Elvárások: Nem igényel nyelvtudást, 1-3 év szakmai tapasztalat, Középiskola');
   Insert into ALLASAJANLAT (FID,ORABER,POZICIO,MUNKAKOR,LÉTREHOZÁS_IDEJE,LEIRAS) values (21,2300,'CNC Gépkezelő','Gépész',DATE '2023-03-23','Elvárások: Nem igényel nyelvtudást, Nem igényel tapasztalatot, Szakiskola / szakmunkás képző');
   Insert into ALLASAJANLAT (FID,ORABER,POZICIO,MUNKAKOR,LÉTREHOZÁS_IDEJE,LEIRAS) values (22,1500,'CNC marós / Szikraforgácsoló','Szakmunka',DATE '2023-03-23','Elvárások: Nem igényel nyelvtudást, 3-5 év szakmai tapasztalat, Szakiskola / szakmunkás képző');
   Insert into ALLASAJANLAT (FID,ORABER,POZICIO,MUNKAKOR,LÉTREHOZÁS_IDEJE,LEIRAS) values (23,1800,'Reggeliztető szakács','Szakács',DATE '2023-03-23','Elvárások: Nem igényel nyelvtudást, 1-3 év szakmai tapasztalat, Szakiskola / szakmunkás képző');
   Insert into ALLASAJANLAT (FID,ORABER,POZICIO,MUNKAKOR,LÉTREHOZÁS_IDEJE,LEIRAS) values (24,2000,'Bolti eladó','Közgazdász',DATE '2023-03-23','Elvárások: Nem igényel nyelvtudást, 1-3 év szakmai tapasztalat, Középiskola');
   Insert into ALLASAJANLAT (FID,ORABER,POZICIO,MUNKAKOR,LÉTREHOZÁS_IDEJE,LEIRAS) values (25,2500,'Méréstechnikai Laborasszisztens','Kémikus',DATE '2023-03-23','Elvárások: Angol középfok, 1-3 év szakmai tapasztalat, Főiskola');
   Insert into ALLASAJANLAT (FID,ORABER,POZICIO,MUNKAKOR,LÉTREHOZÁS_IDEJE,LEIRAS) values (25,2800,'Applikációs Projekt Menedzser','Informatikus',DATE '2023-03-23','Elvárások: Angol középfok, 1-3 év szakmai tapasztalat, Egyetem');
   Insert into ALLASAJANLAT (FID,ORABER,POZICIO,MUNKAKOR,LÉTREHOZÁS_IDEJE,LEIRAS) values (27,2300,'Pénzügyi ügyintéző','Közgazdasz',DATE '2023-03-23','Elvárások: Nem igényel nyelvtudást, Nem igényel tapasztalatot, Középiskola');
   Insert into ALLASAJANLAT (FID,ORABER,POZICIO,MUNKAKOR,LÉTREHOZÁS_IDEJE,LEIRAS) values (27,1800,'Államháztartási gazdasági referens','Közgazdasz',DATE '2023-03-23','Elvárások: Nem igényel nyelvtudást, 3-5 év szakmai tapasztalat, Főiskola');
   Insert into ALLASAJANLAT (FID,ORABER,POZICIO,MUNKAKOR,LÉTREHOZÁS_IDEJE,LEIRAS) values (28,2000,'Áruházi munkatárs','Közgazdász',DATE '2023-03-23','Elvárások: Nem igényel nyelvtudást, Nem igényel tapasztalatot, Általános iskola');
   Insert into ALLASAJANLAT (FID,ORABER,POZICIO,MUNKAKOR,LÉTREHOZÁS_IDEJE,LEIRAS) values (29,1800,'HR Generalist','HR',DATE '2023-03-23','Elvárások: Angol középfok, 1-3 év szakmai tapasztalat, Középiskola, B kategóriás jogosítvány');
   Insert into ALLASAJANLAT (FID,ORABER,POZICIO,MUNKAKOR,LÉTREHOZÁS_IDEJE,LEIRAS) values (30,2800,'Létesítményi tűzoltó szerparancsnok','Tűzoltó',DATE '2023-03-23','Elvárások: Nem igényel nyelvtudást, 1-3 év szakmai tapasztalat, Középiskola, B kategóriás jogosítvány');
   Insert into ALLASAJANLAT (FID,ORABER,POZICIO,MUNKAKOR,LÉTREHOZÁS_IDEJE,LEIRAS) values (31,2000,'Gazdasági munkatárs','Közgazdasz',DATE '2023-03-23','Elvárások: Angol alapfok, 1-3 év szakmai tapasztalat, Főiskola');
   Insert into ALLASAJANLAT (FID,ORABER,POZICIO,MUNKAKOR,LÉTREHOZÁS_IDEJE,LEIRAS) values (32,1500,'Recepciós','Ügyfélszolgálat',DATE '2023-03-23','Elvárások: Angol felsőfok és Magyar anyanyelvi szint, Pályakezdő/friss diplomás, Középiskola');
   Insert into ALLASAJANLAT (FID,ORABER,POZICIO,MUNKAKOR,LÉTREHOZÁS_IDEJE,LEIRAS) values (32,2000,'Szerviz Technikus','Kémikus',DATE '2023-03-23','Elvárások: Angol alapfok és Magyar anyanyelvi szint, Pályakezdő/friss diplomás, Általános iskola');
   Insert into ALLASAJANLAT (FID,ORABER,POZICIO,MUNKAKOR,LÉTREHOZÁS_IDEJE,LEIRAS) values (34,3000,'Digitális fejlesztési vezető','Informatikus',DATE '2023-03-23','Elvárások: Angol középfok, 5-10 év szakmai tapasztalat, Főiskola');
   Insert into ALLASAJANLAT (FID,ORABER,POZICIO,MUNKAKOR,LÉTREHOZÁS_IDEJE,LEIRAS) values (35,1600,'Pultos/Pizzaszakács','Szakács',DATE '2023-03-23','Elvárások: Nem igényel nyelvtudást, Nem igényel tapasztalatot, Szakiskola / szakmunkás képző');
   Insert into ALLASAJANLAT (FID,ORABER,POZICIO,MUNKAKOR,LÉTREHOZÁS_IDEJE,LEIRAS) values (35,1500,'Szakács','Szakács',DATE '2023-03-23','Elvárások: Nem igényel nyelvtudást, 1-3 év szakmai tapasztalat, Szakiskola / szakmunkás képző');
   Insert into ALLASAJANLAT (FID,ORABER,POZICIO,MUNKAKOR,LÉTREHOZÁS_IDEJE,LEIRAS) values (36,1800,'Minőségellenőr','Szakmunka',DATE '2023-03-23','Elvárások: Nem igényel nyelvtudást, Nem igényel tapasztalatot, Középiskola');
   Insert into ALLASAJANLAT (FID,ORABER,POZICIO,MUNKAKOR,LÉTREHOZÁS_IDEJE,LEIRAS) values (37,2000,'Junior gépkezelő','Gépész',DATE '2023-03-23','Elvárások: Nem igényel nyelvtudást, Nem igényel tapasztalatot, Szakiskola / szakmunkás képző');
   Insert into ALLASAJANLAT (FID,ORABER,POZICIO,MUNKAKOR,LÉTREHOZÁS_IDEJE,LEIRAS) values (37,2500,'Senior gépkezelő','Gépész',DATE '2023-03-23','Elvárások: Nem igényel nyelvtudást, 1-3 év szakmai tapasztalat, Szakiskola / szakmunkás képző');
   Insert into ALLASAJANLAT (FID,ORABER,POZICIO,MUNKAKOR,LÉTREHOZÁS_IDEJE,LEIRAS) values (38,1800,'Logisztikai munkatárs (Fuvarszervező)','Logisztika',DATE '2023-03-23','Elvárások: Nem igényel nyelvtudást, 1-3 év szakmai tapasztalat, Középiskola');
   Insert into ALLASAJANLAT (FID,ORABER,POZICIO,MUNKAKOR,LÉTREHOZÁS_IDEJE,LEIRAS) values (41,1500,'Szervíz ügyintéző','Ügyfélszolgálat',DATE '2023-03-23','Elvárások: Angol alapfok, Nem igényel tapasztalatot, Középiskola');
   Insert into ALLASAJANLAT (FID,ORABER,POZICIO,MUNKAKOR,LÉTREHOZÁS_IDEJE,LEIRAS) values (42,2500,'Információbiztonsági felelős','Informatikus',DATE '2023-03-23','Elvárások: Angol középfok, 1-3 év szakmai tapasztalat, Főiskola');
	---------------------------------------------------------------------------------------------------
   
   CREATE TABLE "SZAKMA" 
   (	
  
    "SZAKMA" VARCHAR2(50),  
    "FID" NUMBER(10) NOT NULL, 
    PRIMARY KEY(SZAKMA, FID),
	FOREIGN KEY(FID) REFERENCES FELHASZNALO(ID)
   );  
   
   Insert into SZAKMA (SZAKMA,FID) values ('Informatikus',2);
   Insert into SZAKMA (SZAKMA,FID) values ('Kémikus',2);
   Insert into SZAKMA (SZAKMA,FID) values ('Szakács',3);
   Insert into SZAKMA (SZAKMA,FID) values ('Gépész',5);
   Insert into SZAKMA (SZAKMA,FID) values ('Tűzoltó',6);
   Insert into SZAKMA (SZAKMA,FID) values ('Szakács',7);
   Insert into SZAKMA (SZAKMA,FID) values ('Közgazdász',8);
   Insert into SZAKMA (SZAKMA,FID) values ('Tanár',8);
   Insert into SZAKMA (SZAKMA,FID) values ('HR',9);
   Insert into SZAKMA (SZAKMA,FID) values ('Informatikus',10);
   Insert into SZAKMA (SZAKMA,FID) values ('Közgazdász',12);
   Insert into SZAKMA (SZAKMA,FID) values ('Kémikus',13);
   Insert into SZAKMA (SZAKMA,FID) values ('Tűzoltó',14);
   Insert into SZAKMA (SZAKMA,FID) values ('Ügyfélszolgálat',15);
   Insert into SZAKMA (SZAKMA,FID) values ('Közgazdász',17);
   Insert into SZAKMA (SZAKMA,FID) values ('Mérnök',17);
   Insert into SZAKMA (SZAKMA,FID) values ('Gépész',18);
   Insert into SZAKMA (SZAKMA,FID) values ('Informatikus',18);
   Insert into SZAKMA (SZAKMA,FID) values ('Gépész',20);
   Insert into SZAKMA (SZAKMA,FID) values ('Szakács',26);
   Insert into SZAKMA (SZAKMA,FID) values ('Szakmunka',26);
   Insert into SZAKMA (SZAKMA,FID) values ('Szakács',33);
   Insert into SZAKMA (SZAKMA,FID) values ('Szakmunka',33);
   Insert into SZAKMA (SZAKMA,FID) values ('Informatikus',39);
   Insert into SZAKMA (SZAKMA,FID) values ('Szakács',40);
   Insert into SZAKMA (SZAKMA,FID) values ('Tűzoltó',43);
   ---------------------------------------------------------------------------------------------------
   
   CREATE TABLE "CV" 
   (	
  
    "ONELETRAJZ" VARCHAR2(200),  
    "FID" NUMBER(10) NOT NULL, 
    PRIMARY KEY(ONELETRAJZ, FID),
	FOREIGN KEY(FID) REFERENCES FELHASZNALO(ID)
   );  
   
    Insert into CV (ONELETRAJZ,FID) values ('abrahamrozsa_magyar.png',2);
    Insert into CV (ONELETRAJZ,FID) values ('arokimola_magyae.png',3);
    Insert into CV (ONELETRAJZ,FID) values ('barnaferenc_magyar.png',5);
    Insert into CV (ONELETRAJZ,FID) values ('barnaferenc_angol.png',5);
    Insert into CV (ONELETRAJZ,FID) values ('bicskeiamanda_angol.png',6);
    Insert into CV (ONELETRAJZ,FID) values ('bicskeinoemi_magyar.png',7);
    Insert into CV (ONELETRAJZ,FID) values ('meszarosbotond_magyar',8);
    Insert into CV (ONELETRAJZ,FID) values ('csabaiflora_magyar.png',9);
    Insert into CV (ONELETRAJZ,FID) values ('csikosflora_magyar.png',10);
    Insert into CV (ONELETRAJZ,FID) values ('csikosflora_angol.png',10);
    Insert into CV (ONELETRAJZ,FID) values ('eszesoliver_magyar.png',12);
    Insert into CV (ONELETRAJZ,FID) values ('habonyierno_magyar.png',13);
    Insert into CV (ONELETRAJZ,FID) values ('tothevelin_magyar.png',14);
    Insert into CV (ONELETRAJZ,FID) values ('farkasnikolett_magyar.png',15);
    Insert into CV (ONELETRAJZ,FID) values ('kormocihanna_magyar.png',17);
    Insert into CV (ONELETRAJZ,FID) values ('harmathemma_magyar.png',18);
    Insert into CV (ONELETRAJZ,FID) values ('horvathpeter_magyar.png',20);
    Insert into CV (ONELETRAJZ,FID) values ('farkasluca_magyar.png',26);
    Insert into CV (ONELETRAJZ,FID) values ('nyilasrek_magyar.pnga',33);
    Insert into CV (ONELETRAJZ,FID) values ('kovacstamas_magyar.png',39);
    Insert into CV (ONELETRAJZ,FID) values ('tarihilda_magyar.png',40);
    Insert into CV (ONELETRAJZ,FID) values ('holloviktor_magyar.png',43);
    Insert into CV (ONELETRAJZ,FID) values ('holloviktor_angol.png',43);
   ---------------------------------------------------------------------------------------------------
   
   CREATE SEQUENCE dept_seq START WITH 1;
   
   CREATE TABLE "JELENTKEZES" 
   (	
   "ID" NUMBER(10) DEFAULT dept_seq.nextval NOT NULL, 
    "AID" NUMBER(10),  
    "FID" NUMBER(10) NOT NULL, 
    PRIMARY KEY(ID),
	FOREIGN KEY(FID) REFERENCES FELHASZNALO(ID),
	FOREIGN KEY(AID) REFERENCES ALLASAJANLAT(ID)
   );  
   
    Insert into JELENTKEZES (AID,FID) values (1,2);
    Insert into JELENTKEZES (AID,FID) values (1,10);
    Insert into JELENTKEZES (AID,FID) values (5,12);
    Insert into JELENTKEZES (AID,FID) values (6,5);
    Insert into JELENTKEZES (AID,FID) values (7,33);
    Insert into JELENTKEZES (AID,FID) values (8,3);
    Insert into JELENTKEZES (AID,FID) values (8,40);
    Insert into JELENTKEZES (AID,FID) values (10,13);
    Insert into JELENTKEZES (AID,FID) values (10,2);
    Insert into JELENTKEZES (AID,FID) values (12,17);
    Insert into JELENTKEZES (AID,FID) values (13,17);
    Insert into JELENTKEZES (AID,FID) values (16,6);
    Insert into JELENTKEZES (AID,FID) values (16,43);
    Insert into JELENTKEZES (AID,FID) values (16,14);
    Insert into JELENTKEZES (AID,FID) values (18,15);
    Insert into JELENTKEZES (AID,FID) values (19,2);
    Insert into JELENTKEZES (AID,FID) values (20,7);
    Insert into JELENTKEZES (AID,FID) values (21,26);
    Insert into JELENTKEZES (AID,FID) values (25,20);
    Insert into JELENTKEZES (AID,FID) values (25,18);
    Insert into JELENTKEZES (AID,FID) values (26,26);
    Insert into JELENTKEZES (AID,FID) values (28,20);
	