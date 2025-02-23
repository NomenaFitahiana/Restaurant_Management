alter table ingredient drop column unit_price;

create table if not exists price (
    id int primary key, 
    unit_price float,
    montant float,
    addedon TIMESTAMP,
);

alter table price add column ingredient_id int;

alter table price add constraint fk_ingredient foreign key (ingredient_id) references ingredient (id) on delete cascade;

