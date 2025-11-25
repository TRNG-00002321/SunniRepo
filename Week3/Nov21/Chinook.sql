-- Parking Lot*******
-- *                *
-- *                *
--- *****************

-- SETUP:
-- Create a database server (docker)
-- $ docker run --name some-postgres -e POSTGRES_PASSWORD=mysecretpassword -p 5432:5432 -d postgres
--In our case it is MySQL
-- Connect to the server (Azure Data Studio / Database extension)
-- Test your connection with a simple query (like a select)
-- Execute the Chinook database (from the Chinook_pg.sql file to create Chinook resources in your server)

SELECT * FROM actor;

-- Comment can be done single line with --
-- Comment can be done multi line with /* */

/*
DQL - Data Query Language
Keywords:

SELECT - retrieve data, select the columns from the resulting set
FROM - the table(s) to retrieve data from
WHERE - a conditional filter of the data
GROUP BY - group the data based on one or more columns
HAVING - a conditional filter of the grouped data
ORDER BY - sort the data
*/

USE Chinook

-- BASIC CHALLENGES
-- List all customers (full name, customer id, and country) who are not in the USA
select * from Customer where country = 'USA';

-- List all customers from Brazil
select * from Customer where country = 'Brazil';

-- List all sales agents
SELECT * FROM Employee WHERE title LIKE '%Sales%Agent%';

-- Retrieve a list of all countries in billing addresses on invoices
SELECT BillingCountry from Invoice;

-- Retrieve how many invoices there were in 2009, and what was the sales total for that year?
SELECT COUNT(*) as Count, SUM(total) as Sum
FROM Invoice
GROUP BY
    YEAR(`InvoiceDate`)
HAVING
    year = 2009;

-- (challenge: find the invoice count sales total for every year using one query)
SELECT YEAR(InvoiceDate) as year, COUNT(*) as Count, SUM(total) as Sum
FROM Invoice
GROUP BY
    YEAR(`InvoiceDate`)

-- how many line items were there for invoice #37
SELECT InvoiceId, COUNT(*) as LineItems
FROM InvoiceLine
WHERE
    InvoiceId = 37;

-- how many invoices per country? BillingCountry  # of invoices -
SELECT BillingCountry, COUNT(*) as InvoiceCount
FROM Invoice
GROUP BY
    BillingCountry;

-- Retrieve the total sales per country, ordered by the highest total sales first.
SELECT BIllingCountry, SUM(Total) as SalesTotal
FROM Invoice
GROUP BY
    BillingCountry
ORDER BY SalesTotal DESC

-- JOINS CHALLENGES
-- Every Album by Artist
SELECT Album.Title, Artist.Name as Artist
FROM Artist
    JOIN Album USING (ArtistId);

-- (inner keyword is optional for inner join)
-- All songs of the rock genre
SELECT *
FROM Track
    RIGHT JOIN Genre USING (GenreId)
WHERE
    Genre.Name = 'Rock';

-- Show all invoices of customers from brazil (mailing address not billing)
SELECT Invoice.*
FROM Invoice
    JOIN Customer USING (CustomerId)
WHERE
    Customer.Country = 'Brazil';

-- Show all invoices together with the name of the sales agent for each one
SELECT i.*, e.`FirstName`, e.`LastName`
FROM
    Invoice i
    JOIN Customer c ON c.`CustomerId` = i.`CustomerId`
    JOIN Employee e ON c.`SupportRepId` = e.`EmployeeId`

-- Which sales agent made the most sales in 2009?
SELECT e.`FirstName`, e.`LastName`, COUNT(*) AS NumSales
FROM
    Invoice i
    JOIN Customer c ON c.`CustomerId` = i.`CustomerId`
    JOIN Employee e ON c.`SupportRepId` = e.`EmployeeId`
WHERE
    YEAR(`InvoiceDate`) = 2021
GROUP BY
    e.`EmployeeId`

-- How many customers are assigned to each sales agent?
SELECT e.`FirstName`, e.`LastName`, COUNT(*) AS NumCustomers
FROM `Customer` c
    JOIN Employee e ON c.`SupportRepId` = e.`EmployeeId`
GROUP BY
    e.`EmployeeId`

-- Which track was purchased the most in 2010?
SELECT SUM(InvoiceLine.`Quantity`) as Sales, Track.`Name`
FROM Invoice
    JOIN InvoiceLine ON (
        `Invoice`.`InvoiceId` = `InvoiceLine`.`InvoiceId`
    )
    JOIN Track ON (
        `InvoiceLine`.`TrackId` = `Track`.`TrackId`
    )
WHERE
    YEAR(Invoice.`InvoiceDate`) = 2021
GROUP BY
    Track.`Name`
ORDER BY Sales DESC;

SELECT * FROM Track WHERE name = "Dazed And Confused";

SELECT Count(*) as Sales, Track.`Name`
FROM Invoice
    JOIN InvoiceLine ON (
        `Invoice`.`InvoiceId` = `InvoiceLine`.`InvoiceId`
    )
    JOIN Track ON (
        `InvoiceLine`.`TrackId` = `Track`.`TrackId`
    )
WHERE
    YEAR(Invoice.`InvoiceDate`) = 2021
GROUP BY
    Track.`Name`
ORDER BY Sales DESC;

-- Show the top three best selling artists.
SELECT Artist.Name, SUM(`InvoiceLine`.`Quantity`) AS Sales
FROM
    `InvoiceLine`
    JOIN `Track` ON InvoiceLine.`TrackId` = Track.`TrackId`
    JOIN `Album` ON Track.`AlbumId` = Album.`AlbumId`
    JOIN `Artist` ON Album.`ArtistId` = Artist.`ArtistId`
GROUP BY
    Artist.Name
ORDER BY Sales DESC
LIMIT 5;

-- Which customers have the same initials as at least one other customer?

-- Which countries have the most invoices?

-- Which city has the customer with the highest sales total?

-- Who is the highest spending customer?

-- Return the email and full name of of all customers who listen to Rock.

-- Which artist has written the most Rock songs?

-- Which artist has generated the most revenue?

-- ADVANCED CHALLENGES
-- solve these with a mixture of joins, subqueries, CTE, and set operators.
-- solve at least one of them in two different ways, and see if the execution
-- plan for them is the same, or different.

-- 1. which artists did not make any albums at all?

-- 2. which artists did not record any tracks of the Latin genre?

-- 3. which video track has the longest length? (use media type table)

-- 4. boss employee (the one who reports to nobody)

-- 5. how many audio tracks were bought by German customers, and what was
--    the total price paid for them?

-- 6. list the names and countries of the customers supported by an employee
--    who was hired younger than 35.

-- DML exercises

-- 1. insert two new records into the employee table.

-- 2. insert two new records into the tracks table.

-- 3. update customer Aaron Mitchell's name to Robert Walter

-- 4. delete one of the employees you inserted.

-- 5. delete customer Robert Walter.
