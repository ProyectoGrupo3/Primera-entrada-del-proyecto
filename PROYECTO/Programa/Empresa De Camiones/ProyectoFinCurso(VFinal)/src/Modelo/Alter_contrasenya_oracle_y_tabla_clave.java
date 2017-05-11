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
import proyectofincurso.Jf_ModificarContrasenya;

/**
 *
 * @author ikitess
 */
public class Alter_contrasenya_oracle_y_tabla_clave {

    /**
     * @return the modificarContrasenya
     */
    public Jf_ModificarContrasenya getModificarContrasenya() {
        return modificarContrasenya;
    }

    /**
     * @param modificarContrasenya the modificarContrasenya to set
     */
    public void setModificarContrasenya(Jf_ModificarContrasenya modificarContrasenya) {
        this.modificarContrasenya = modificarContrasenya;
    }

    Connection accesoDB = Jf_InicioSesion.conexion;
    private Jf_ModificarContrasenya modificarContrasenya;

    public Alter_contrasenya_oracle_y_tabla_clave() {
    }

    Alter_contrasenya_oracle_y_tabla_clave(Jf_ModificarContrasenya vista_modiContrasenya) {
    }

    /**
     * Cambia la contraseña de la tabla Clave y la contraseña de usuarios Oracle del Trabajador que se haya pasado
     * @param id_clave clave principal
     * @param contraseñaNueva la nueva contraseña
     * @param sqlDateHoy el dia de hoy
     * @param nombre el nombre de quien se le va a cambiar la contraseña
     * @return true o false
     */
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
