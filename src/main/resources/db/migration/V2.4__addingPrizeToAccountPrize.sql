ALTER TABLE account_prize
ADD COLUMN prize_id NUMERIC,
ADD CONSTRAINT fk_prize 
FOREIGN KEY (prize_id) 
REFERENCES prizes (id);