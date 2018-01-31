-- *************************************************************************************************
-- This script creates all of the database objects (tables, sequences, etc) for the database
-- *************************************************************************************************

BEGIN;

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

COMMIT;