    SELECT  CEGNEV, POZICIO, MUNKAKOR
    FROM "C##SAELDC"."ALLASAJANLAT", "C##SAELDC"."MUNKALTATO"
    WHERE "C##SAELDC"."ALLASAJANLAT".FID="C##SAELDC"."MUNKALTATO".ID AND MUNKAKOR='Informatikus';  --megfelelő munkakör

    SELECT *
    FROM "C##SAELDC"."ALLASAJANLAT"
    WHERE CURRENT_DATE-LÉTREHOZÁS_IDEJE<31;  --30 napnál frissebb hirdetések

    SELECT COUNT(*), SZAKMA
    FROM "C##SAELDC"."ALLASKERESO", "C##SAELDC"."SZAKMA"
    WHERE ALLASKERESO.ID=SZAKMA.FID
    GROUP BY SZAKMA;                 -- statisztika: milyen szakmából hány ember

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

    
    SELECT POZICIO, COUNT(*) AS Jelentkezok_szama
    FROM "C##SAELDC"."JELENTKEZES", "C##SAELDC"."ALLASAJANLAT"
    WHERE "C##SAELDC"."JELENTKEZES".AID="C##SAELDC"."ALLASAJANLAT".ID
    GROUP BY POZICIO
    ORDER BY Jelentkezok_szama;                                         --statisztika: melyik pozícióra hányan jelentkeztek


    SELECT TELJES_NEV, POZICIO
    FROM "C##SAELDC"."JELENTKEZES", "C##SAELDC"."ALLASAJANLAT", "C##SAELDC"."ALLASKERESO"
    WHERE "C##SAELDC"."JELENTKEZES".AID="C##SAELDC"."ALLASAJANLAT".ID AND "C##SAELDC"."JELENTKEZES".FID="C##SAELDC"."ALLASKERESO".ID  --ki melyik állásra jelentkezett