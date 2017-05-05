/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyectofincurso.Jf_InicioSesion;
import static proyectofincurso.Jf_InicioSesion.conexion;
import proyectofincurso.ModificarContrasenya;

/**
 *
 * @author ikitess
 */
public class Alter_contrasenya_oracle_y_tabla_clave {

    /**
     * @return the modificarContrasenya
     */
    public ModificarContrasenya getModificarContrasenya() {
        return modificarContrasenya;
    }

    /**
     * @param modificarContrasenya the modificarContrasenya to set
     */
    public void setModificarContrasenya(ModificarContrasenya modificarContrasenya) {
        this.modificarContrasenya = modificarContrasenya;
    }

    Connection accesoDB = Jf_InicioSesion.conexion;
    private ModificarContrasenya modificarContrasenya;

    public Alter_contrasenya_oracle_y_tabla_clave() {
    }

    Alter_contrasenya_oracle_y_tabla_clave(ModificarContrasenya vista_modiContrasenya) {
    }

    public boolean Modificar_contra(int id_clave, String contraseñaNueva, java.sql.Date sqlDateHoy, String nombre) {

        try {
            //Cambiar contraseña en Tabla Clave
            CallableStatement comprobar = conexion.prepareCall("{call CAMBIAR_CONTRA(?,?,?)}");
            comprobar.setInt(1, id_clave);
            comprobar.setString(2, contraseñaNueva);
            comprobar.setDate(3, sqlDateHoy);
            comprobar.executeUpdate();

            comprobar.close();
            //cambiar contraseña del usuario oracle.
            String sql = ""
                    + "		ALTER USER \"" + nombre + "\" IDENTIFIED BY \"" + contraseñaNueva + "\"";
                    
            System.out.println(sql);
            Statement s = conexion.createStatement();
            ResultSet rs = s.executeQuery(sql);

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Clave.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
}
