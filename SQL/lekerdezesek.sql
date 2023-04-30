    SELECT  *
    FROM "C##SAELDC"."ALLASAJANLAT", "C##SAELDC"."MUNKALTATO", , "C##SAELDC"."SZAKMA"
    WHERE "C##SAELDC"."ALLASAJANLAT".FID="C##SAELDC"."MUNKALTATO".ID AND 4="C##SAELDC"."SZAKMA".FID AND MUNKAKOR=SZAKMA;  --megfelelő munkakör

    SELECT *
    FROM "C##SAELDC"."ALLASAJANLAT"
    WHERE CURRENT_DATE-LÉTREHOZÁS_IDEJE<31;  --30 napnál frissebb hirdetések

    --1.összetett lekérdezés
    SELECT AVG(EXTRACT(YEAR FROM CURRENT_DATE)-EXTRACT(YEAR FROM SZULETESI_DATUM)) AS atlageletkor, SZAKMA
    FROM "C##SAELDC"."ALLASKERESO", "C##SAELDC"."SZAKMA"
    WHERE ALLASKERESO.ID=SZAKMA.FID
    GROUP BY SZAKMA
    ORDER BY atlageletkor;                                -- statisztika: átlagéletkor szakmánként

    --2.összetett lekérdezés
    SELECT COUNT(*), SZAKMA
    FROM "C##SAELDC"."ALLASKERESO", "C##SAELDC"."SZAKMA"
    WHERE ALLASKERESO.ID=SZAKMA.FID
    GROUP BY SZAKMA;                 -- statisztika: milyen szakmából hány ember

    --1.függvény
    CREATE FUNCTION szakmabeliekSzama(p_szakma IN C##SAELDC.SZAKMA.szakma%TYPE)RETURN NUMBER
    IS
    szam NUMBER :=0;
    BEGIN
    SELECT COUNT(*) INTO szam
    FROM C##SAELDC.SZAKMA
    WHERE p_szakma=SZAKMA.szakma; 

    RETURN szam;
    END;


    SELECT EXTRACT(YEAR FROM CURRENT_DATE)-EXTRACT(YEAR FROM SZULETESI_DATUM) AS KOR, COUNT(*) AS DB
    FROM "C##SAELDC"."ALLASKERESO"
    GROUP BY  EXTRACT(YEAR FROM SZULETESI_DATUM)
    ORDER BY EXTRACT(YEAR FROM CURRENT_DATE)-EXTRACT(YEAR FROM SZULETESI_DATUM);       -- statisztika kor alapján


    SELECT MIN(ORABER), MUNKAKOR
    FROM "C##SAELDC"."ALLASAJANLAT"
    WHERE MUNKAKOR='Informatikus'
    GROUP BY MUNKAKOR;
                                            -- bérezési intervallumok
    SELECT MAX(ORABER), MUNKAKOR
    FROM "C##SAELDC"."ALLASAJANLAT"
    WHERE MUNKAKOR='Informatikus'
    GROUP BY MUNKAKOR;

    --3.összetett lekérdezés
    SELECT MIN(ORABER), MUNKAKOR
    FROM "C##SAELDC"."ALLASAJANLAT", "C##SAELDC"."MUNKALTATO"
    WHERE "C##SAELDC"."ALLASAJANLAT"."FID" = "C##SAELDC"."MUNKALTATO"."ID" AND MUNKAKOR='Informatikus'
    GROUP BY MUNKAKOR;                          -- bérezési intervallumok városonként

    --4.összetett lekérdezés
    SELECT MAX(ORABER), MUNKAKOR
    FROM "C##SAELDC"."ALLASAJANLAT", "C##SAELDC"."MUNKALTATO"
    WHERE "C##SAELDC"."ALLASAJANLAT"."FID" = "C##SAELDC"."MUNKALTATO"."ID" AND MUNKAKOR='Informatikus'
    GROUP BY MUNKAKOR; 

    --5.összetett lekérdezés
    SELECT POZICIO, COUNT(*) AS jelentkezok_szama
    FROM "C##SAELDC"."JELENTKEZES", "C##SAELDC"."ALLASAJANLAT"
    WHERE "C##SAELDC"."JELENTKEZES".AID="C##SAELDC"."ALLASAJANLAT".ID
    GROUP BY POZICIO
    ORDER BY Jelentkezok_szama;                                         --statisztika: melyik pozícióra hányan jelentkeztek


    SELECT TELJES_NEV, POZICIO
    FROM "C##SAELDC"."JELENTKEZES", "C##SAELDC"."ALLASAJANLAT", "C##SAELDC"."ALLASKERESO"
    WHERE "C##SAELDC"."JELENTKEZES".AID="C##SAELDC"."ALLASAJANLAT".ID AND "C##SAELDC"."JELENTKEZES".FID="C##SAELDC"."ALLASKERESO".ID  --ki melyik állásra jelentkezett


    --6.összetett lekérdezés
    --átlagtól jobban fizető munkakörök a felhasznaló városában
    SELECT  *
    FROM "C##SAELDC"."ALLASAJANLAT", "C##SAELDC"."MUNKALTATO", "C##SAELDC"."ALLASKERESO"
    WHERE "C##SAELDC"."ALLASAJANLAT"."FID"="C##SAELDC"."MUNKALTATO"."ID" AND "C##SAELDC"."ALLASKERESO"."ID"=2 
    AND ORABER> (SELECT AVG(ORABER) FROM "C##SAELDC"."ALLASAJANLAT") AND "C##SAELDC"."MUNKALTATO"."VAROS"="C##SAELDC"."ALLASKERESO"."VAROS";

    --2.függvény 
    CREATE OR REPLACE PROCEDURE newSzakma(p_id IN NUMBER, p_szakma IN VARCHAR2)
    IS BEGIN
    INSERT INTO "C##SAELDC"."SZAKMA" (SZAKMA,FID) values (p_szakma, p_id);
    END;

    --1.trigger
    CREATE OR REPLACE TRIGGER log_trigger
    AFTER UPDATE OR INSERT OF ALLASKERESO ON 'utolsó belépés'
    FOR EACH ROW
    WHEN (OLD.'utolsó belépés' != NEW.'utolsó belépés')
    BEGIN
        INSERT INTO log_table (id, login) VALUES (NEW.id, NEW.'utolsó belépés')
    END;
    /
    
    --2.trigger
    CREATE OR REPLACE TRIGGER log_trigger
    AFTER UPDATE OF UTOLSO_BELEPES ON ALLASKERESO
    FOR EACH ROW
    WHEN (OLD.UTOLSO_BELEPES != NEW.UTOLSO_BELEPES)
    BEGIN
        INSERT INTO log_table (ID, login) VALUES (:NEW.id, :NEW.UTOLSO_BELEPES);
    END;
    /

    --2.trigger
    CREATE OR REPLACE TRIGGER off_trigger
    BEFORE DELETE OR INSERT OR UPDATE
    ON JELENTKEZES
    BEGIN
        IF TO_CHAR(SYSDATE, 'HH24:MI') < '08:00' THEN  
            RAISE_APPLICATION_ERROR(-20111, 'Nem lehet jelenleg módosítani.');
        END IF;
        IF TO_CHAR(SYSDATE, 'HH24:MI') > '20:00' THEN  
            RAISE_APPLICATION_ERROR(-20111, 'Nem lehet jelenleg módosítani.');
        END IF;
    END;
    /