-- *****************************************************************************
-- This script contains INSERT statements for populating tables with seed data
-- *****************************************************************************

BEGIN;

-- INSERT statements go here
INSERT INTO product(id, category, condition, color, size, price, imgUrl ) VALUES('1', 'dreess', 'new', 'green', 'S', '59.99', 'https://i.pinimg.com/736x/74/6c/6a/746c6a24c8210317f7b43eb0b74f3962--rockabilly-dresses-s-dresses.jpg');

COMMIT;