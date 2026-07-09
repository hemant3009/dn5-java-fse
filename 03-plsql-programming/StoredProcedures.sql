SET SERVEROUTPUT ON;

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    UPDATE Accounts
    SET    Balance      = Balance * 1.01,
           LastModified = SYSDATE
    WHERE  AccountType = 'Savings';
 
    DBMS_OUTPUT.PUT_LINE(
        SQL%ROWCOUNT || ' savings account(s) credited with 1% monthly interest.'
    );
 
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error processing interest: ' || SQLERRM);
END ProcessMonthlyInterest;
/
 
-- Test
BEGIN
    ProcessMonthlyInterest;
END;
/
 
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department   IN Employees.Department%TYPE,
    p_bonus_pct    IN NUMBER
) IS
BEGIN
    IF p_bonus_pct <= 0 THEN
        DBMS_OUTPUT.PUT_LINE('Bonus percentage must be positive.');
        RETURN;
    END IF;
 
    UPDATE Employees
    SET    Salary = Salary + (Salary * p_bonus_pct / 100)
    WHERE  Department = p_department;
 
    IF SQL%ROWCOUNT = 0 THEN
        DBMS_OUTPUT.PUT_LINE('No employees found in department: ' || p_department);
    ELSE
        DBMS_OUTPUT.PUT_LINE(
            SQL%ROWCOUNT || ' employee(s) in ' || p_department ||
            ' received a ' || p_bonus_pct || '% bonus.'
        );
    END IF;
 
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error updating bonus: ' || SQLERRM);
END UpdateEmployeeBonus;
/
 
-- Test: 10% bonus for IT department
BEGIN
    UpdateEmployeeBonus('IT', 10);
END;
/
 
CREATE OR REPLACE PROCEDURE TransferFunds (
    p_source_account IN Accounts.AccountID%TYPE,
    p_target_account IN Accounts.AccountID%TYPE,
    p_amount         IN NUMBER
) IS
    v_source_balance Accounts.Balance%TYPE;
    e_insufficient_funds EXCEPTION;
BEGIN
    IF p_amount <= 0 THEN
        DBMS_OUTPUT.PUT_LINE('Transfer amount must be positive.');
        RETURN;
    END IF;
 
    -- Lock the source row and check balance
    SELECT Balance
    INTO   v_source_balance
    FROM   Accounts
    WHERE  AccountID = p_source_account
    FOR UPDATE;
 
    IF v_source_balance < p_amount THEN
        RAISE e_insufficient_funds;
    END IF;
 
    -- Debit source
    UPDATE Accounts
    SET    Balance      = Balance - p_amount,
           LastModified = SYSDATE
    WHERE  AccountID = p_source_account;
 
    -- Credit target
    UPDATE Accounts
    SET    Balance      = Balance + p_amount,
           LastModified = SYSDATE
    WHERE  AccountID = p_target_account;
 
    IF SQL%ROWCOUNT = 0 THEN
        RAISE NO_DATA_FOUND;  -- target account does not exist
    END IF;
 
    COMMIT;
    DBMS_OUTPUT.PUT_LINE(
        'Transferred $' || p_amount || ' from account ' ||
        p_source_account || ' to account ' || p_target_account || '.'
    );
EXCEPTION
    WHEN e_insufficient_funds THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE(
            'Transfer failed: insufficient funds in account ' ||
            p_source_account || ' (balance: $' || v_source_balance || ').'
        );
    WHEN NO_DATA_FOUND THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transfer failed: account not found.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transfer failed: ' || SQLERRM);
END TransferFunds;
/
 
-- Test: transfer $200 from account 1 to account 2
BEGIN
    TransferFunds(1, 2, 200);
END;
/
 
