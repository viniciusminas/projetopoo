CREATE TABLE multas (
                        id SERIAL PRIMARY KEY,
                        valor NUMERIC(10, 2) NOT NULL,
                        descricao VARCHAR(255),
                        data_multa DATE NOT NULL,
                        pago BOOLEAN NOT NULL DEFAULT FALSE,
                        pessoa_id BIGINT NOT NULL,
                        CONSTRAINT fk_pessoa FOREIGN KEY (pessoa_id) REFERENCES pessoas(id)
);

