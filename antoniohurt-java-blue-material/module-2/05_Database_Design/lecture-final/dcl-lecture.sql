-- Create a new User with a Password
CREATE USER john WITH PASSWORD '123';

-- Grant SELECT ON a table to a user
GRANT SELECT ON clients TO john;

-- Grant INSERT ON a table to a user
GRANT INSERT ON clients TO john;

-- Grant SELECT ON a sequence to a user
GRANT USAGE, SELECT ON SEQUENCE clients_client_id_seq TO john;

-- Revoke SELECT ON a table from a user
REVOKE SELECT ON clients FROM john;