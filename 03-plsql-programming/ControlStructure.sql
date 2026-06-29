SET SERVEROUTPUT ON;

DECLARE
    marks NUMBER := 80;
BEGIN
    IF marks >= 75 THEN
        DBMS_OUTPUT.PUT_LINE('Passed with Grade A');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Passed');
    END IF;

    FOR i IN 1..5 LOOP
        DBMS_OUTPUT.PUT_LINE(i);
    END LOOP;

    CASE
        WHEN marks >= 75 THEN
            DBMS_OUTPUT.PUT_LINE('Excellent');
        WHEN marks >= 50 THEN
            DBMS_OUTPUT.PUT_LINE('Good');
        ELSE
            DBMS_OUTPUT.PUT_LINE('Poor');
    END CASE;
END;
/