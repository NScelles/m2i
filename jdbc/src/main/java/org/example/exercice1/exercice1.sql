USE demo_jdbc;

DROP TABLE student;

CREATE TABLE IF NOT EXISTS student(
	id_student INT NOT NULL AUTO_INCREMENT,
	first_name VARCHAR(150),
    last_name VARCHAR(150),
	id_class INT NOT NULL,
    degree_date  VARCHAR(150),
    PRIMARY KEY(id_student)
);
