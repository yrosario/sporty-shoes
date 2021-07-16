
INSERT INTO customer(first_name, last_name, address, birthday, email)
VALUES("John", "Gomes", "653 Yello Street", "1983-11-01", "jgomes@gmailc.om");

INSERT INTO customer(first_name, last_name, address, birthday, email)
VALUES("Matis", "Irvin", "33 Boston Street", "1992-09-04", "mirvin@gmail.com");

INSERT INTO customer(first_name, last_name, address, birthday, email)
VALUES("Marry", "Gomes", "653 Yello Street", "1981-02-09", "mgomes@gmail.com");

CREATE TABLE product(
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(255),
	gender VARCHAR(1),
	style VARCHAR(30),
	brand VARCHAR(30),
	size FLOAT,
	qty INT,
	PRIMARY KEY(id)
);


