/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectSQL;

/**
 *
 * @author ADMIN
 */
import java.sql.Connection;
import java.sql.DriverManager;
public class ConnectSQL {
    private static String url="jdbc:postgresql://localhost:5432/Project";
    private static String username="postgres";
    private static String password="123456";
    public static Connection getConnection()
    {
         Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return conn;
            
    }
    public static void main(String[] args) {
        ConnectSQL p = new ConnectSQL();
        p.getConnection();
         
    }
}
