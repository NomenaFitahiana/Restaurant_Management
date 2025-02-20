create table if not exists is_composed_by (
    dish_id int references dish(id) on delete cascade,
    ingredient_id int  references ingredient(id) on delete cascade,
    primary key (dish_id, ingredient_id)
);