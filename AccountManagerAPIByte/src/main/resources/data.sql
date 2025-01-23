

INSERT INTO account (id, number, name, description, registration_date, status)
VALUES
    (1, 1001, 'Juan Perez', 'Personal account', CURRENT_DATE, 'ACTIVE'),
    (2, 1002, 'Maria Perez', 'Personal account', CURRENT_DATE, 'ACTIVE'),
    (3, 1003, 'Ernesto Perez', 'Corporate account', CURRENT_DATE, 'INACTIVE');

INSERT INTO account_properties (account_id, properties_key, properties_value)
VALUES
    (1, 'currency', 'USD'),
    (1, 'region', 'North America'),
    (2, 'currency', 'EUR'),
    (2, 'region', 'Europe'),
    (3, 'currency', 'GBP'),
    (3, 'region', 'UK');
