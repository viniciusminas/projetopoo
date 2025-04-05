CREATE TABLE livros (
                        id BIGSERIAL PRIMARY KEY,
                        titulo VARCHAR(100) NOT NULL,
                        autor VARCHAR(100) NOT NULL,
                        ano INTEGER NOT NULL,
                        edicao INTEGER NOT NULL,
                        reservado BOOLEAN DEFAULT FALSE NOT NULL
);