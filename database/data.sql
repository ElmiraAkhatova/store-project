-- *****************************************************************************
-- This script contains INSERT statements for populating tables with seed data
-- *****************************************************************************

BEGIN;
--CREATE TEST USER
INSERT INTO users(id, firstName, lastName, userName, password)
VALUES(1, 'John', 'Smith', 'test', 'test'); 

--CREATE TEST PRODUCT
INSERT INTO products(id, sellerId, category, condition, color, size, price, imgUrl ) 
VALUES('1', '1', 'dress', 'new', 'green', 'S', '59.99', 'https://i.pinimg.com/736x/74/6c/6a/746c6a24c8210317f7b43eb0b74f3962--rockabilly-dresses-s-dresses.jpg');

COMMIT;