DELIMITER $$

CREATE PROCEDURE GetCustomers()
BEGIN
    SELECT
        customerName,
        city,
        state,
        postalCode,
        country
    FROM
        customers
    ORDER BY customerName;
END$$

DELIMITER;

CALL GetCustomers ();

DELIMITER $$

CREATE PROCEDURE GetOfficeByCountry(
    IN countryName VARCHAR(255)
)
BEGIN
    SELECT *
    FROM offices
    WHERE country = countryName;
END $$

DELIMITER;

CALL GetOfficeByCountry ("USA");

DELIMITER $$

CREATE PROCEDURE GetOrderCOuntryByStatus(
    IN orderStatus VARCHAR(25),
    OUT total INT
)
BEGIN
    SELECT COUNT(orderNumber)
    INTO total
    FROM orders
    WHERE status=orderStatus;
END $$

DELIMITER;

CALL GetOrderCOuntryByStatus ("Shipped", @total);

SELECT @total;

DELIMITER $$

CREATE PROCEDURE SetCounter(
    INOUT counter INT,
    IN summand INT
)
BEGIN
    SET counter = counter + summand;
END $$

DELIMITER;

SET @counter = 1;

CALL SetCounter (@counter, 1);

CALL SetCounter (@counter, 1);

CALL SetCounter (@counter, 5);

SELECT @counter

DELIMITER $$

CREATE PROCEDURE GetTotalOrder()
BEGIN
    DECLARE totalOrder INT DEFAULT 0;
    SELECT
        COUNT(*)
    INTO
        totalOrder
    FROM
        orders;
    SELECT totalOrder;
END $$

DELIMITER;

CALL GetTotalOrder ();

DELIMITER $$

CREATE FUNCTION CustomerLevel (
    credit DECIMAL(10, 2)
)
RETURNS VARCHAR(20)
DETERMINISTIC
BEGIN
    DECLARE customerLevel VARCHAR(20);
    IF credit > 50000 THEN
        SET customerLevel = "PLATINUM";
    ELSEIF (credit <= 50000 AND credit >= 10000) THEN
        SET customerLevel = "GOLD";
    ELSEIF credit < 10000 THEN
        SET customerLevel = "SILVER";
    END IF;

    RETURN (customerLevel);
END $$

DELIMITER;

SELECT customerName, CustomerLevel (creditLimit)
FROM customers
ORDER BY customerName;
