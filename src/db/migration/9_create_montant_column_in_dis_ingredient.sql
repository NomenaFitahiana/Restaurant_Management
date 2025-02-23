alter table dish_ingredient add column montant NUMERIC;

update dish_ingredient di set montant = di.quantity * p.unit_price from price p where p.ingredient_id = di.ingredient_id ;

