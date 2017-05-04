/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyectofincurso.InicioSesion;
import static proyectofincurso.InicioSesion.conexion;
import proyectofincurso.ModificarContrasenya;

/**
 *
 * @author ikitess
 */
public class Modificar_contrasenya {

    Connection accesoDB = InicioSesion.conexion;

    public Modificar_contrasenya() {
    }

    Modificar_contrasenya(ModificarContrasenya vista_modiContrasenya) {
    }

    public void Modificar_contra(int id_clave, String contraseñaNueva, java.sql.Date sqlDateHoy, String nombre) {

        try {
            //llamar al procedimiento
            CallableStatement comprobar = conexion.prepareCall("{call CAMBIAR_CONTRA(?,?,?)}");
            comprobar.setInt(1, id_clave);
            comprobar.setString(2, contraseñaNueva);
            comprobar.setDate(3, sqlDateHoy);
            comprobar.executeUpdate();

            comprobar.close();
            String sql = "-- USER SQL\n"
                    + "		ALTER USER \"" + nombre + "\" IDENTIFIED BY \"" + contraseñaNueva + "\"\n"
                    + "		DEFAULT TABLESPACE \"USERS\"\n"
                    + "		TEMPORARY TABLESPACE \"TEMP\"\n"
                    + "		ACCOUNT UNLOCK ;";
            Statement s = conexion.createStatement();
            ResultSet rs = s.executeQuery(sql);

        } catch (SQLException ex) {
            Logger.getLogger(Clave.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
