CREATE DATABASE IF NOT EXISTS dealership_db;

USE dealership_db;

CREATE TABLE vehicle (
    vin VARCHAR(50) PRIMARY KEY,
    mf_year INT NOT NULL CHECK (mf_year > 1800),
    make VARCHAR(15) NOT NULL,
    model VARCHAR(15) NOT NULL,
    color VARCHAR(15),
    fuel_type VARCHAR(15) NOT NULL,
    CONSTRAINT fuel_type_chk CHECK (
        fuel_type IN (
            "GAS",
            "DIESEL",
            "HYBRID",
            "ELECTRIC"
        )
    ),
    vehicle_condition VARCHAR(15) NOT NULL,
    CONSTRAINT vehicle_condition_chk CHECK (
        vehicle_condition IN ("NEW", "USED")
    )
);

CREATE TABLE customer (
    driver_license VARCHAR(15) PRIMARY KEY,
    name VARCHAR(15) NOT NULL,
    email VARCHAR(15) UNIQUE NOT NULL,
    phone VARCHAR(25) UNIQUE NOT NULL
);

CREATE TABLE sale (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    vin VARCHAR(15),
    driver_license VARCHAR(15),
    sale_date DATE NOT NULL,
    sale_price DECIMAL(10, 2) NOT NULL,
    CONSTRAINT fk_vehicle FOREIGN KEY (vin) REFERENCES vehicle (vin),
    CONSTRAINT fk_customer FOREIGN KEY (driver_license) REFERENCES customer (driver_license)
);

ALTER TABLE vehicle RENAME TO vehicles;

INSERT INTO
    vehicles
VALUES (
        '8998w42n2323',
        2000,
        'Toyota',
        'Corolla',
        'red',
        'GAS',
        'USED'
    ),
    (
        '65598v7vv039',
        2012,
        'Toyota',
        'Tundra',
        'blue',
        'GAS',
        'USED'
    ),
    (
        '97bb8t85v8v8',
        2013,
        'Lexus',
        'GS400',
        'white',
        'HYBRID',
        'USED'
    ),
    (
        '24oi242o2530',
        2025,
        'Tesla',
        'Model S',
        'black',
        'ELECTRIC',
        'NEW'
    ),
    (
        '97h978240824',
        1997,
        'Ford',
        'F150',
        'red',
        'DIESEL',
        'USED'
    );

INSERT INTO
    customer
VALUES (
        'D239400000',
        'Alice',
        '123-456-7890',
        'alice@email.com'
    ),
    (
        'D239400001',
        'Bob',
        '234-567-8901',
        'bob@email.com'
    ),
    (
        'D239400002',
        'Charlie',
        '345-678-9012',
        'charlie@email.com'
    ),
    (
        'D239400003',
        'Debrah',
        '456-789-0123',
        'deborah@email.com'
    );

INSERT INTO
    sale
VALUES (
        1,
        '8998w42n2323',
        'D239400000',
        '2023-01-15',
        15000.00
    ),
    (
        2,
        '65598v7vv039',
        'D239400001',
        '2023-02-20',
        28000.00
    ),
    (
        3,
        '97bb8t85v8v8',
        'D239400002',
        '2023-03-10',
        35000.00
    ),
    (
        4,
        '24oi242o2530',
        'D239400003',
        '2023-04-05',
        80000.00
    );

SELECT * FROM vehicles WHERE year > 2005;

UPDATE customer
SET
    phone = '999-888-7777'
WHERE
    driver_license = 'D239400002';

DELETE FROM sale WHERE id = 2;
