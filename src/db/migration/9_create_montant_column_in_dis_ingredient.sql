alter table price add column montant NUMERIC;

UPDATE price p
SET montant = di.quantity * p.unit_price
FROM dish_ingredient di
WHERE p.ingredient_id = di.ingredient_id;

alter table dish_ingredient drop column montant;