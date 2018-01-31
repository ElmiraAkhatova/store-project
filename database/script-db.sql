--Run this manually on windows - create script does not work

--USER TABLE
CREATE TABLE users (
	id SERIAL primary key,
	firstName VARCHAR,
	lastName VARCHAR,
	userName VARCHAR,
	password VARCHAR
);

CREATE SEQUENCE seq_user_id;

--PRODUCT TABLE
CREATE TABLE products (
	id SERIAL primary key,
	sellerId INTEGER REFERENCES users,
	category VARCHAR,
	condition VARCHAR,
	color VARCHAR,
	size VARCHAR,
	price NUMERIC,
	imgUrl VARCHAR
);

CREATE SEQUENCE seq_product_id;

--CREATE TEST USER
INSERT INTO users(id, firstName, lastName, userName, password)
VALUES(1, 'John', 'Smith', 'test', 'test'); 

--CREATE TEST PRODUCT
INSERT INTO products(id, sellerId, category, condition, color, size, price, imgUrl ) 
VALUES('1', '1', 'dress', 'new', 'green', 'S', '59.99', 'https://i.pinimg.com/736x/74/6c/6a/746c6a24c8210317f7b43eb0b74f3962--rockabilly-dresses-s-dresses.jpg');