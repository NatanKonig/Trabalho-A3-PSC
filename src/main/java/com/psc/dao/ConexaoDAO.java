package com.psc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author mario
 */
public class ConexaoDAO {
    public Connection conectaBD() {
        Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/seu_banco?user=root&password=sua_senha";
            conn = DriverManager.getConnection(url);
            System.out.println("Conexão realizada com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro na conexão: " + e.getMessage());
        }
        return conn;
    }
}