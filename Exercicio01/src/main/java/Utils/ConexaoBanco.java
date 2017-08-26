/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Mayra Pereira
 */
public class ConexaoBanco{
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
       Connection conn = null;

    // Passo 1: Registrar o driver JDBC
    Class.forName("org.apache.derby.jdbc.ClientDataSource");

    // Passo 2: Abrir a conexão
    conn = DriverManager.getConnection(
	    "jdbc:derby://localhost:1527/produtobd;SecurityMechanism=3",
	    "app", // usuário BD
	    "app"); // senha BD
    return conn;
  }

}
