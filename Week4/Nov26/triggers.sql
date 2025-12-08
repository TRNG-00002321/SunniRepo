CREATE TABLE employee_audit (
    id INT AUTO_INCREMENT PRIMARY KEY,
    employeeNumber INT NOT NULL,
    lastName VARCHAR(50) NOT NULL,
    changedat DATETIME DEFAULT NULL,
    action VARCHAR(50) DEFAULT NULL
);

CREATE TRIGGER before_employee_update
    BEFORE UPDATE ON employees
    FOR EACH ROW
INSERT INTO employee_audit
SET
    action = 'update',
    employeeNumber = OLD.employeeNumber,
    lastName = OLD.lastName,
    changedat = NOW();

UPDATE employees
SET
    lastName = 'Phan'
WHERE
    employeeNumber = 1056;

SELECT * FROM employee_audit;
