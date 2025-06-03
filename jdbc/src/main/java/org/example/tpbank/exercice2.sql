DROP DATABASE tp_jdbc;
CREATE DATABASE IF NOT EXISTS  tp_jdbc;

USE tp_jdbc;

CREATE TABLE IF NOT EXISTS customers(
	id_customer INT NOT NULL AUTO_INCREMENT,
	first_name VARCHAR(150) NOT NULL,
    last_name VARCHAR(150) NOT NULL,
    phone_nbr  VARCHAR(15),
    PRIMARY KEY(id_customer)
);

CREATE TABLE IF NOT EXISTS accounts(
	id_account INT NOT NULL AUTO_INCREMENT,
	id_customer INT NOT NULL,
    PRIMARY KEY(id_account),
    CONSTRAINT fk_customer_id FOREIGN KEY(id_customer) REFERENCES customers(id_customer)
);

CREATE TABLE IF NOT EXISTS operations(
	id_operation INT NOT NULL AUTO_INCREMENT,
	amount DOUBLE(255,2) NOT NULL,
    operation_status VARCHAR(10) NOT NULL CHECK(operation_status="DEPOSIT" OR operation_status="WITHDRAWL"),
	id_account INT NOT NULL,
    PRIMARY KEY(id_operation),
    CONSTRAINT fk_account_id FOREIGN KEY(id_account) REFERENCES accounts(id_account)
);

INSERT INTO customers (first_name, last_name, phone_nbr) VALUES
('Alice', 'Martin', '0612345678'),
('Bob', 'Dupont', '0678123456'),
('Claire', 'Durand', '0654321876');

INSERT INTO accounts (id_customer) VALUES
(1), -- compte pour Alice
(2), -- compte pour Bob
(3); -- compte pour Claire

INSERT INTO operations (amount, operation_status, id_account) VALUES
(1500.00, 'DEPOSIT', 1),
(-200.00, 'WITHDRAWL', 1),
(500.00, 'DEPOSIT', 2),
(-100.00, 'WITHDRAWL', 2),
(750.00, 'DEPOSIT', 3);


SELECT a.id_account, a.id_customer, c.first_name, c.last_name, c.phone_nbr,SUM(amount) AS total_amount
FROM accounts AS a
INNER JOIN customers AS c ON a.id_customer=c.id_customer
INNER JOIN operations AS o ON o.id_account=a.id_account
GROUP BY a.id_account
HAVING a.id_account=1;

SELECT * FROM customers;
SELECT * FROM accounts;
SELECT * FROM operations;

