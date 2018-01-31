-- *************************************************************************************************
-- This script creates all of the database objects (tables, sequences, etc) for the database
-- *************************************************************************************************

BEGIN;

-- CREATE statements go here

CREATE TABLE product (
	id SERIAL primary key,
	category VARCHAR,
	condition VARCHAR,
	color VARCHAR,
	size VARCHAR,
	price NUMERIC,
	imgUrl VARCHAR
);

CREATE SEQUENCE seq_product_id;

COMMIT;