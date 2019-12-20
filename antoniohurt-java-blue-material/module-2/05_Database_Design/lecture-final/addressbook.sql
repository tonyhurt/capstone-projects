DROP TABLE IF EXISTS contact_address;
DROP TABLE IF EXISTS contact;
DROP TABLE IF EXISTS address;

CREATE TABLE contact 
(
        contact_id serial primary key,
        first_name varchar(35) not null,
        last_name varchar(35) not null,
        date_added timestamp not null,
        last_updated timestamp
);

CREATE TABLE address
(
        address_id serial primary key,
        line_one varchar(255) not null,
        line_two varchar(255),
        co varchar(255),
        city varchar(35) not null,
        province varchar(25) not null,
        postal_code varchar(20) not null,
        type varchar(10) not null,
        type_other varchar(100),
        country_code char(3) DEFAULT ('USA'),
        
        constraint ck_address_type check ( type IN ('HOME', 'WORK', 'BILLING', 'SHIPPING', 'OTHER') ),
        constraint ck_type_other check ( (type = 'OTHER' AND type_other IS NOT NULL) OR (type <> 'OTHER' AND type_other IS NULL) )

);

CREATE TABLE contact_address
(
        contact_id int,
        address_id int,
        
        constraint fk_contact_contact_id foreign key (contact_id) REFERENCES contact(contact_id),
        constraint fk_address_address_id foreign key (address_id) REFERENCES address(address_id)
)