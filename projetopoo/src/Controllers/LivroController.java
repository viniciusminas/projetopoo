package Controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.Livro;

public class LivroController {

    private Connection conexao;

    // Estabelece uma conexão
    public LivroController() throws SQLException {
        this.conexao = CriaConexao.getConexao();
    }

    public void postLivro(Livro l) throws SQLException {
        String sql = "INSERT INTO LIVRO VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement stmt;

        stmt = this.conexao.PreparedStatement(sql);

        stmt.setBoolean(1, l.isReservado());



    }
}
