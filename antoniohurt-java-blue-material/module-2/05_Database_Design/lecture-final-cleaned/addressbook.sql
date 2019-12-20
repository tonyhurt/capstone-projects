-- DROP TABLEs at the top of the script are not required, however, they allow the script to be 
-- run multiple times to include changes, so they are recommended.  It is common to have these during
-- development and then remove or comment them before release.

DROP TABLE contact_email;
DROP TABLE contact_phone;
DROP TABLE contact_address;
DROP TABLE address;
DROP TABLE contact;
DROP TABLE phone;
DROP TABLE email;

CREATE TABLE contact (
        -- serial create a sequence for the column
        -- primary key defines a single column as the tables primary key so it must be UNIQUE and NOT NULL
        contact_id serial primary key,
        -- not null means the column must have a value for the row.  The effectively marks it as a required field.
        first_name varchar(35) not null,
        last_name varchar(35) not null,
        date_added timestamp not null,
        last_updated timestamp
);

CREATE TABLE address (
        address_id serial primary key,
        line_one varchar(255) not null,
        line_two varchar(255),
        careof varchar(255),
        city varchar(64),
        state_province varchar(32),
        postal_code varchar(20),
        -- DEFAULT sets a default value for the column.  If the value for the column is null it will auto-populate this value.
        country_code char(3) DEFAULT('USA'),
        address_type varchar(10),
        other_type varchar(25),
        
        -- Adds a CHECK constraint that requires the address_type column to only contain one of the listed values
        --   Syntax:  CHECK ( SQL boolean condition )  where if the condition is TRUE then the check passes and the
        --            data is allowed, and if the condition is FALSE the data is rejected.
        constraint chk_address_address_type check ( address_type IN ( 'HOME', 'SHIPPING', 'BILLING', 'WORK', 'OTHER' ) ),
        -- Adds a CHECK create that creates a conditionally required field.   When address_type is OTHER, then other_type cannot be null 
        --   when address_type is NOT OTHER then other_type must be null
        constraint chk_address_other_type check ( (address_type = 'OTHER' AND other_type IS NOT NULL) OR (address_type <> 'OTHER' AND other_type IS NULL ) )
);

-- Join Table to create a many-to-many relationship between contact and address
CREATE TABLE contact_address (
        -- When a serial column is referenced in another table the database can be either int or bigint
        contact_id int,
        address_id int,
        -- Creates a composite primary key, in this case contact_id and address_id will together form the Primary Key
        PRIMARY KEY (contact_id, address_id),  
        -- Adds a Foreign key constraint
        --   Syntax:  FOREIGN KEY (column_from_this_table) REFERENCES other_table(column_on_other_table)
        constraint fk_contact_address_contact_id foreign key (contact_id) references contact(contact_id),
        constraint fk_contact_address_address_id foreign key (address_id) references address(address_id)
);

CREATE TABLE phone (
        phone_id serial primary key,
        number varchar(20) not null,
        area_code char(3),
        international_code char(2) DEFAULT('01'),
        extension varchar(10),
        phone_type varchar(10),
        other_type varchar(25),
        
        constraint chk_phone_phone_type check ( phone_type IN ( 'HOME', 'WORK', 'MOBILE', 'OTHER' ) ),
        constraint chk_phone_other_type check ( (phone_type = 'OTHER' AND other_type IS NOT NULL) OR (phone_type <> 'OTHER' AND other_type IS NULL ) )
);

CREATE TABLE contact_phone (
        contact_id int,
        phone_id int,
        
        PRIMARY KEY (contact_id, phone_id),  
        constraint fk_contact_phone_contact_id foreign key (contact_id) references contact(contact_id),
        constraint fk_contact_phone_phone_id foreign key (phone_id) references phone(phone_id)
);

CREATE TABLE email (
        email_id serial primary key,
        -- unique creates a column where each value must be unique for the table.  This only allows 1 entry for each unique email address,
        --   however, that email address can be shared by multiple contacts via the table relationships
        address varchar(255) unique not null,
        email_type varchar(10),
        other_type varchar(25),
        
        constraint chk_email_email_type check ( email_type IN ( 'PERSONAL', 'WORK', 'OTHER' ) ),
        constraint chk_email_other_type check ( (email_type = 'OTHER' AND other_type IS NOT NULL) OR (email_type <> 'OTHER' AND other_type IS NULL ) )
);

CREATE TABLE contact_email (
        contact_id int,
        email_id int,
        
        PRIMARY KEY (contact_id, email_id),  
        constraint fk_contact_email_contact_id foreign key (contact_id) references contact(contact_id),
        constraint fk_contact_email_email_id foreign key (email_id) references email(email_id)
);