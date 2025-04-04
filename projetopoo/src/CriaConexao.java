package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CriaConexao {

    public static Connection getConexao() throws SQLException {
        try {
            // Driver do PostgreSQL
            Class.forName("org.postgresql.Driver");
            System.out.println("Conectando ao banco de dados PostgreSQL.");

            String url = "jdbc:postgresql://localhost:5432/biblioteca";
            String usuario = "postgres";
            String senha = "postgres";

            return DriverManager.getConnection(url, usuario, senha);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver PostgreSQL não encontrado!", e);
        }
    }
}
