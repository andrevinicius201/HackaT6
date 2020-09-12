ALTER TABLE stickers
DROP COLUMN columns_quantity,
DROP COLUMN rows_quantity;

ALTER TABLE prizes
ADD COLUMN columns_quantity INT NOT NULL;

ALTER TABLE prizes
ADD COLUMN rows_quantity INT NOT NULL;