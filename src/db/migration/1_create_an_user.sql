do
$$
    begin
        if not exists(
            select 1 from pg_roles where rname = 'restauration'
        ) then
            create user 'nomena' with password 'library';

            grant select on all table in schema public to "nomena";
            grant insert, update, delete on all table in schema public to "nomena";
    end;
$$