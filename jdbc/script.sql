CREATE DATABASE demo_jdbc;
USE demo_jdbc;
DROP TABLE users;
CREATE TABLE IF NOT EXISTS users(
	id_user INT NOT NULL AUTO_INCREMENT,
	first_name VARCHAR(150),
    last_name VARCHAR(150),
    PRIMARY KEY(id_user)
);
