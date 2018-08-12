
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BancoDados {
    public Connection connection = null;
    private final String DRIVER = 
            "com.mysql.jdbc.Driver";
    private final String LOCAL = "acme";
    private final String URL = "jdbc:mysql://"
            + "localhost:3306/" + LOCAL;
    private final String LOGIN = "root";
    private final String SENHA = "";
    public void conectar() {
        try {
            Class.forName(DRIVER);
            this.connection = DriverManager.
                    getConnection(URL, LOGIN, SENHA);            
        } catch (Exception e) {
            System.err.println(e);
            e.printStackTrace();
        }
    }
    public void desconectar() {
        try {
            this.connection.close();
        } catch (SQLException ex) {
            System.err.println(ex);
            ex.printStackTrace();
        }    }
}
