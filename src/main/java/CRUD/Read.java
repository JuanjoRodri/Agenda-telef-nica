/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD;

/**
 *
 * @author juanj
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Read  {
    

    public Contacto leerContacto (int id_contacto){
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/tareas";
        String user = "root";
        String pass = "";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        Contacto c = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, pass);

            String query = "SELECT * FROM contacto WHERE id_contacto = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, id_contacto);
            rs = ps.executeQuery();

            if (rs.next()) {
                c = new Contacto();
                c.setId_contacto(rs.getInt("id_contacto"));
                c.setNombre(rs.getString("nombre"));
                c.setApellido1(rs.getString("apellido1"));
                c.setApellido2(rs.getString("apellido2"));
                c.setTelefono(rs.getInt("telefono"));
                c.setCorreoElectronico(rs.getString("correo_electronico"));
                c.setEmpresa(rs.getString("empresa"));
                c.setInformacionAdicional(rs.getString("informacion"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Contacto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Tarea.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return t;
    }  
}
