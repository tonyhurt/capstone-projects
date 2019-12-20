DROP TABLE IF EXISTS invoices;
DROP TABLE IF EXISTS pets_procedures;
DROP TABLE IF EXISTS pets_owners;
DROP TABLE IF EXISTS pets;
DROP TABLE IF EXISTS procedures;
DROP TABLE IF EXISTS owners;

CREATE TABLE pets_procedures
(
        pet_id serial primary key,
        procedure_code serial not null
);

CREATE TABLE pets_owners
(
        pet_id serial primary key,
        owner_id serial not null
);

CREATE TABLE procedures 
(
        procedure_code serial primary key,
        name varchar(255) not null,
        date char(10) not null,
        cost varchar(10) not null,
        tax varchar(10) not null,
        total varchar(10) not null
);

CREATE TABLE owners
(
        owner_id serial primary key,
        name varchar(255) not null,
        pet_id int not null,
        address varchar(255) not null
        
);
        
CREATE TABLE pets 
(
        pet_id serial primary key,
        name varchar(255) not null,
        owner_id int not null,
        age char(3) not null,
        pet_type varchar(20) not null,
        procedure_code int not null,
        visit_date char(10) not null,
        
        constraint fk_procedure_procedure_code foreign key (procedure_code) REFERENCES procedures(procedure_code),
        constraint fk_owner_owner_id foreign key (owner_id) REFERENCES owners(owner_id)
);

CREATE TABLE invoices
(
        invoice_number serial primary key,
        procedure_code int not null,
        pet_id int not null,
        owner_id int not null,
        
        constraint fk_procedure_procedure_code foreign key (procedure_code) REFERENCES procedures(procedure_code),
        constraint fk_pet_pet_id foreign key (pet_id) REFERENCES pets(pet_id),
        constraint fk_owner_owner_id foreign key (owner_id) REFERENCES owners(owner_id)
);

