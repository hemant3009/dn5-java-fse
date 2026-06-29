SET SERVEROUTPUT ON;

CREATE OR REPLACE PROCEDURE SquareNum(
    n IN NUMBER,
    s OUT NUMBER
)
AS
BEGIN
    s := n * n;
END;
/

DECLARE
    num NUMBER := 6;
    ans NUMBER;
BEGIN
    SquareNum(num, ans);
    DBMS_OUTPUT.PUT_LINE('Square = ' || ans);
END;
/