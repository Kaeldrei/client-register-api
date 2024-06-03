CREATE TABLE clients(
    id BIGSERIAL PRIMARY KEY NOT NULL,
    full_name VARCHAR(255) NOT NULL,
    social_name VARCHAR(255),
    birth_date DATE NOT NULL,
    gender VARCHAR(255),
    cpf VARCHAR(15) NOT NULL,
    rg VARCHAR(12) NOT NULL,
    email VARCHAR(255)
);