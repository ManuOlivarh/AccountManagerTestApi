-- Crear tabla account
CREATE TABLE account (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         number BIGINT NOT NULL,
                         name VARCHAR(255),
                         description VARCHAR(255),
                         registration_date DATE,
                         status VARCHAR(20)
);

-- Crear tabla account_properties para almacenar la colección @ElementCollection
CREATE TABLE account_properties (
                                    account_id BIGINT NOT NULL, -- Clave foránea que referencia a account
                                    properties_key VARCHAR(255) NOT NULL,
                                    properties_value VARCHAR(255),
                                    PRIMARY KEY (account_id, properties_key),
                                    FOREIGN KEY (account_id) REFERENCES account(id)
);
