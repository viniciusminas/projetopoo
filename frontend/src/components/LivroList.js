import React, { useEffect, useState } from 'react';
import axios from 'axios';

const LivroList = () => {
    const [livros, setLivros] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:8080/livros')
            .then(response => {
                setLivros(response.data);
            })
            .catch(error => {
                console.error('Erro ao buscar livros:', error);
            });
    }, []);

    return (
        <div>
            <h2>Lista de Livros</h2>
            <ul>
                {livros.map((livro) => (
                    <li key={livro.id}>
                        <strong>{livro.titulo}</strong> - {livro.autor}
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default LivroList;
