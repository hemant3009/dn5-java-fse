SET SERVEROUTPUT ON;

BEGIN
    FOR rec IN (
        SELECT c.CustomerID, c.Name, l.LoanID, l.InterestRate
        FROM   Customers c
        JOIN   Loans l ON l.CustomerID = c.CustomerID
        WHERE  MONTHS_BETWEEN(SYSDATE, c.DOB) / 12 > 60
    ) LOOP
        UPDATE Loans
        SET    InterestRate = InterestRate - 1
        WHERE  LoanID = rec.LoanID;
 
        DBMS_OUTPUT.PUT_LINE(
            'Customer ' || rec.Name ||
            ' (ID ' || rec.CustomerID || ') - Loan ' || rec.LoanID ||
            ': interest rate reduced from ' || rec.InterestRate ||
            '% to ' || (rec.InterestRate - 1) || '%'
        );
    END LOOP;
 
    COMMIT;
END;
/
 
ALTER TABLE Customers ADD (IsVIP VARCHAR2(5) DEFAULT 'FALSE');
 
BEGIN
    FOR rec IN (
        SELECT CustomerID, Name, Balance
        FROM   Customers
    ) LOOP
        IF rec.Balance > 10000 THEN
            UPDATE Customers
            SET    IsVIP = 'TRUE'
            WHERE  CustomerID = rec.CustomerID;
 
            DBMS_OUTPUT.PUT_LINE(
                'Customer ' || rec.Name || ' (ID ' || rec.CustomerID ||
                ') promoted to VIP. Balance: $' || rec.Balance
            );
        ELSE
            UPDATE Customers
            SET    IsVIP = 'FALSE'
            WHERE  CustomerID = rec.CustomerID;
        END IF;
    END LOOP;
 
    COMMIT;
END;
/
 
BEGIN
    FOR rec IN (
        SELECT c.Name, l.LoanID, l.LoanAmount, l.EndDate
        FROM   Loans l
        JOIN   Customers c ON c.CustomerID = l.CustomerID
        WHERE  l.EndDate BETWEEN SYSDATE AND SYSDATE + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE(
            'REMINDER: Dear ' || rec.Name ||
            ', your loan #' || rec.LoanID ||
            ' of $' || rec.LoanAmount ||
            ' is due on ' || TO_CHAR(rec.EndDate, 'DD-Mon-YYYY') ||
            '. Please arrange payment.'
        );
    END LOOP;
END;
/
 
