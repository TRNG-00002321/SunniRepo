SELECT
    contactfirstname,
    contactlastname
FROM customers
ORDER BY contactLastName DESC;

SELECT
    contactfirstname,
    contactlastname
FROM customers
ORDER BY
    contactLastName,
    contactFirstName;

SELECT firstname, lastname, jobTitle
FROM employees
WHERE
    jobTitle = 'Sales Rep'

SELECT firstname, lastname, jobTitle
FROM employees
WHERE
    jobTitle = 'Sales Rep'
    AND officeCode = 1;

SELECT firstname, lastname, jobTitle
FROM employees
WHERE
    jobTitle = 'Sales Rep'
    OR officeCode = 1;

SELECT firstname, lastname, jobTitle
FROM employees
WHERE
    jobTitle = 'Sales Rep'

SELECT firstname, lastname, jobTitle
FROM employees
WHERE
    officeCode BETWEEN 3 AND 7;

SELECT firstname, lastname, jobTitle
FROM employees
WHERE
    lastName LIKE '%son'

SELECT lastname FROM employees ORDER BY lastName;

SELECT DISTINCT lastname FROM employees ORDER BY lastName;

SELECT officecode, city FROM customers WHERE city IN ('USA');

SELECT
    productCode,
    productName,
    buyPrice
FROM products
WHERE
    buyprice BETWEEN 90 AND 100;

SELECT
    employeeNumber,
    lastname,
    firstname
FROM employees
WHERE
    firstName LIKE 'a%';

SELECT
    employeeNumber,
    lastname,
    firstname
FROM employees
WHERE
    firstName LIKE 'T_m';

SELECT customerNumber FROM customers LIMIT 5

SELECT
    customerName,
    country,
    salesrepemployeenumber
from customers
WHERE
    salesrepemployeenumber IS NULL

SELECT
    customerName,
    country,
    salesrepemployeenumber
from customers
WHERE
    salesrepemployeenumber IS NOT NULL

SELECT e.employeeNumber, e.firstname as employee, c.customernumber, c.contactfirstname as customer
FROM employees e
    INNER JOIN customers c ON c.contactFirstName = e.firstName;

SELECT e.employeeNumber, e.firstname as employee, c.customernumber, c.contactfirstname as customer
FROM employees e
    LEFT JOIN customers c USING ()
SELECT e.member_id, e.name as employee, c.committee_id c.name AS commitee
FROM employees
    LEFT JOIN commitees c USING (name)

SELECT d.*, o.status
FROM orderdetails d
    LEFT JOIN orders o on d.orderNumber = o.orderNumber
WHERE
    o.status = "SHIPPED"

SELECT status, SUM(quantityOrdered * priceEach) AS total
FROM orders
    INNER JOIN orderdetails using (ordernumber)
GROUP BY
    status

SELECT YEAR(orderDate) AS year, SUM(quantityOrdered * priceEach) AS total
FROM orders
    INNER JOIN orderdetails using (orderNumber)
WHERE
    status = 'Shipped'
GROUP BY
    year
HAVING
    year > 2004

CREATE VIEW emp_view AS
SELECT
    employeeNumber,
    firstName,
    officecode
FROM employees;
