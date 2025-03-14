do
$$
    begin
        if not exists (
            select from pg_type where typname = 'UNIT'
        ) then
            create type "UNIT" as enum ('G', 'L', 'U');
        end if;
    end;
$$

create table if not exists ingredient (
    id serial primary key,
    name varchar(20),
    last_modification_date TIMESTAMP,
    unit_price integer,
    unit char check (unit in ('G', 'L', 'U'))
);