SET SERVEROUTPUT ON;

DECLARE
    CURSOR c1 IS
        SELECT CustomerID, Name, Balance
        FROM Customers;

BEGIN
    DBMS_OUTPUT.PUT_LINE('Customer Status');

    FOR c IN c1 LOOP

        IF c.Balance > 10000 THEN
            DBMS_OUTPUT.PUT_LINE(c.Name || ' is a VIP Customer');
        ELSE
            DBMS_OUTPUT.PUT_LINE(c.Name || ' is a Regular Customer');
        END IF;

        CASE
            WHEN c.Balance > 10000 THEN
                DBMS_OUTPUT.PUT_LINE('High Balance');
            WHEN c.Balance >= 1000 THEN
                DBMS_OUTPUT.PUT_LINE('Medium Balance');
            ELSE
                DBMS_OUTPUT.PUT_LINE('Low Balance');
        END CASE;

        DBMS_OUTPUT.PUT_LINE('--------------------');

    END LOOP;

END;
/