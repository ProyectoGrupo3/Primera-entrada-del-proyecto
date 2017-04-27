package Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleTypes;
import proyectofincurso.InicioSesion;
import proyectofincurso.JF_CT_CRUD;

public class CT_CRUD {

    Connection accesoDB = InicioSesion.conexion;

    public CT_CRUD() {
    }

    @SuppressWarnings("UseSpecificCatch")

    public String insertCT(int Id, String P_CT_nombre, String calle, int numero, String cp, String ciudad, String provincia, String telefono) {

        String rptaRegistro = null;
        long myId = 0;

        try {

            // Ejecutamos la Secuencia para conocer el ID
            String Identificador = "SELECT secuencia_ct.NEXTVAL FROM DUAL";
            Statement sentencia = accesoDB.createStatement();
            PreparedStatement ps = accesoDB.prepareStatement(Identificador);
            synchronized (this) {
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    myId = rs.getLong(1);
                }
            }
            Id = (int) myId;

            // LLAMADA AL PROCEDIMIENTO ALMACENADO EN ORACLE
            CallableStatement cs = accesoDB.prepareCall("{CALL EDITAR_CT(?,?,?,?,?,?,?,?)} ");
            // SE RELLENAN TODOS LOS PARAMETROS
            cs.setInt(1, Id);
            cs.setString(2, P_CT_nombre);
            cs.setString(3, calle);
            cs.setInt(4, numero);
            cs.setString(5, cp);
            cs.setString(6, ciudad);
            cs.setString(7, provincia);
            cs.setString(8, telefono);

            int numFila = cs.executeUpdate();
            if (numFila > 0) {
                rptaRegistro = "Registro ACTUALIZADO";
            }

            sentencia.close();
            cs.close();

        } catch (Exception e) {
        }

        return rptaRegistro;
    }

    public ArrayList<CT> listCT() {
        ArrayList listaCT = new ArrayList();
        CT ct;
        String sql = "{call CONSULTA_CT.BUSCAR_TOTAL_CT(?)}";
        try {
            Statement sentencia = accesoDB.createStatement();
            CallableStatement ps = accesoDB.prepareCall(sql);
            ps.registerOutParameter(1, OracleTypes.CURSOR);
            ps.executeUpdate();
            ResultSet res = (ResultSet) ps.getObject(1);

            while (res.next()) {
                ct = new CT();
                ct.setID(res.getInt(1));
                ct.setNombre(res.getString(2));
                ct.setCalle(res.getString(3));
                ct.setNumero(res.getInt(4));
                ct.setCp(res.getString(5));
                ct.setCiudad(res.getString(6));
                ct.setProvincia(res.getString(7));
                ct.setTelefono(res.getString(8));
                listaCT.add(ct);
            }

        } catch (Exception e) {

        }
        return listaCT;
    }

    public String editarCT(int Id, String nombre, String calle, int numero, String cp, String ciudad, String provincia, String telefono) {

        String rptaEdit = null;
        int numFil = 0;

        try {

            // LLAMADA AL PROCEDIMIENTO ALMACENADO EN ORACLE
            Statement sentencia = accesoDB.createStatement();
            CallableStatement cs = accesoDB.prepareCall("{CALL EDITAR_CT(?,?,?,?,?,?,?,?)} ");
            // SE RELLENAN TODOS LOS PARAMETROS
            cs.setInt(1, Id);
            cs.setString(2, nombre);
            cs.setString(3, calle);
            cs.setInt(4, numero);
            cs.setString(5, cp);
            cs.setString(6, ciudad);
            cs.setString(7, provincia);
            cs.setString(8, telefono);

            numFil = cs.executeUpdate();
            if (numFil > 0) {
                rptaEdit = "Registro ACTUALIZAZO";
            }

        } catch (Exception e) {
        }

        return rptaEdit;
    }

    public int eliminarCT(int Id) {
        int numFil = 0;

        try {
            Statement sentencia = accesoDB.createStatement();
            CallableStatement cs = accesoDB.prepareCall("{CALL eliminar_ct(?)}");
            cs.setInt(1, Id);

            numFil = cs.executeUpdate();
            Conexion.exitConexion();

        } catch (SQLException ex) {
            Logger.getLogger(CT_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numFil;
    }

    public ArrayList<CT> buscarCTxNombre(int id_ct) {
        ArrayList<CT> listaCT = new ArrayList();
        CT ct;
        try {

            Statement sentencia = accesoDB.createStatement();
            CallableStatement cs = accesoDB.prepareCall("{CALL CONSULTA_UN_CT.BUSCAR_UN_CENTRO(?,?,?,?,?,?,?,?,?) }");
            cs.setInt(1, id_ct);
            cs.registerOutParameter(2, Types.NUMERIC);
            cs.registerOutParameter(3, Types.VARCHAR);
            cs.registerOutParameter(4, Types.VARCHAR);
            cs.registerOutParameter(5, Types.NUMERIC);
            cs.registerOutParameter(6, Types.VARCHAR);
            cs.registerOutParameter(7, Types.VARCHAR);
            cs.registerOutParameter(8, Types.VARCHAR);
            cs.registerOutParameter(9, Types.VARCHAR);
            cs.execute();

            //El ct devuelto
            int uno = cs.getInt(2);
            String dos = cs.getString(3);
            String tres = cs.getString(4);
            int cuatro = cs.getInt(5);
            String cinco = cs.getString(6);
            String seis = cs.getString(7);
            String siete = cs.getString(8);
            String ocho = cs.getString(9);
            //Guardar los datos devueltos en lo que se va a poner en la tabla 
            ct = new CT();
            ct.setID(uno);
            ct.setNombre(dos);
            ct.setCalle(tres);
            ct.setNumero(cuatro);
            ct.setCp(cinco);
            ct.setCiudad(seis);
            ct.setProvincia(siete);
            ct.setTelefono(ocho);

            listaCT.add(ct);
            Conexion.exitConexion();

        } catch (Exception e) {

        }
        return listaCT;
    }

}
