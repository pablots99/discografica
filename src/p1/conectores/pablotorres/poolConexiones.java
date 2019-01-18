/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1.conectores.pablotorres;

import java.sql.Connection;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author pablo
 */
public class poolConexiones {
        Connection con = null;
        
    public poolConexiones() {
        BasicDataSource bdSource = new BasicDataSource();
        bdSource.setUrl("jdbc:mysql://localhost:3306/discografica");
        bdSource.setUsername("root");
        bdSource.setPassword("root");
        try {
//DataSource nos reserva una conexión y nos la devuelve
            con = bdSource.getConnection();
            if (con != null) {
                System.out.println("Conexión creada satisfactoriamente");
            } else {
                System.out.println("No se puede crear una nueva conexión");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }
    public void cierraPoolConexion(){
        try {
            con.close();
            System.out.println("la conexion pool se ha cerrado");
        } catch (Exception e) {
          System.out.println("Error al Cerrar la pool");

        }
    }
}
