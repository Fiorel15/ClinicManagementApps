/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Klinik;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class Koneksi {
    public static Connection getConnection() {
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/aplikasi_klinik";
        String user = "root";
        String password = "";
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return conn;
    }
    
    public static void main(String[] args) {
        try {
            Connection con = Koneksi.getConnection();
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println(String.format("Connected to database %s " + "successfully.", con.getCatalog()));
        } catch(ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find the driver in the classpath!", e);
        } catch (SQLException e) {
            System.out.println(e);
        } catch(Exception e) {
            e.printStackTrace();
      }
    }
}
