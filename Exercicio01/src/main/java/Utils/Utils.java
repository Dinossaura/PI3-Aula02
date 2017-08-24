/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Constantes.PrincipalConstantes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Mayra Pereira
 */
public class Utils {
    public static Connection getConnection(){
        Connection connection = null;
        
        try {            
            String dbURL = PrincipalConstantes.DB_ADDRESS;
            Properties properties = new Properties();
            properties.put("user", PrincipalConstantes.DB_USER);
            properties.put("password", PrincipalConstantes.DB_PASS);
            
            connection = DriverManager.getConnection(dbURL, properties);
            
             
        }catch(SQLException e){
            e.printStackTrace();
        }
        return connection;    
    }
}
