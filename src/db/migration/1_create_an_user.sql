do
$$
    begin
        if not exists(
            select 1 from pg_roles where rolname = 'library'
        ) then
            create user "library" with password 'library0';

            grant select on all tables in schema public to "library";
            grant insert, update, delete on all tables in schema public to "library";
            grant USAGE on SCHEMA public TO library;
            grant USAGE on ALL SEQUENCES IN SCHEMA public TO library;

grant REFERENCES on ALL TABLES IN SCHEMA public TO library;
alter DEFAULT PRIVILEGES IN SCHEMA public
grant
select, insert,
update, delete on TABLES to libary;

GRANT CREATE ON SCHEMA public TO library;


        end if;
    end;
$$;

create database if not exists restaurant_management;

 /*GRANT CONNECT ON DATABASE mydatabase TO myuser;
\c mydatabase
GRANT USAGE ON SCHEMA public TO myuser;
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA public TO myuser;
GRANT USAGE, SELECT, UPDATE ON ALL SEQUENCES IN SCHEMA public TO myuser;*/


/*DO $$ 
DECLARE 
    r RECORD;
BEGIN
    FOR r IN (SELECT tablename FROM pg_tables WHERE schemaname = 'public') 
    LOOP
        EXECUTE format('ALTER TABLE public.%I OWNER TO library', r.tablename);
    END LOOP;
END $$;*/
