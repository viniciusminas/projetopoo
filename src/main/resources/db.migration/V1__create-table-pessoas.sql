CREATE TABLE pessoas (
                         id BIGSERIAL PRIMARY KEY,
                         nome VARCHAR(100) NOT NULL,
                         email VARCHAR(100) NOT NULL UNIQUE,
                         tel VARCHAR(20) NOT NULL UNIQUE,
                         endereco VARCHAR(200) NOT NULL
);
