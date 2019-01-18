/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1.conectores.pablotorres;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JLabel;

/**
 *
 * @author pablo
 */
public class GestorConexion {
        Connection conn1 = null;
        boolean conectado = false;
    public  GestorConexion() {
         try {
            String url1 = "jdbc:mysql://localhost:3306/discografica";
            String user = "root";
            String password = "";
            conn1 = (Connection) DriverManager.getConnection(url1, user, password);
            if (conn1 != null) {
                System.out.println("Conectado a discográfica");
              conectado = true;
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: dirección o usuario/clave no válida");
            ex.printStackTrace();
            conectado = false;
        }
        
    }
    public void cierra_conexion(){
        try {
            conn1.close();
            System.out.println("Conexion Cerrada");
        } catch (Exception e) {
            System.out.println("Error al Cerrar la conexion");
            e.printStackTrace();
        }
}
    public void inserta(){
        try{
        Statement st = conn1.createStatement();

        st.executeUpdate("ALTER TABLE album ADD anno_salida YEAR ");
        st.close();
        }catch (Exception e) {
            System.out.println("Error al insertar la tabla");
            e.printStackTrace();
        }
    }
     public void borra(){
        try{
        Statement st = conn1.createStatement();

        st.executeUpdate("ALTER TABLE album ADD anno_salida YEAR ");
        st.close();
        }catch (Exception e) {
            System.out.println("Error al insertar la tabla");
            e.printStackTrace();
        }
    }
}


