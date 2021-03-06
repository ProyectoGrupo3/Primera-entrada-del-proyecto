package Modelo;

import Controlador.ControladorCRUD_Trabajador;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleTypes;
import proyectofincurso.Jf_InicioSesion;

public class Trabajador_CRUD {

    Connection accesoDB = Jf_InicioSesion.conexion;

    /**
     * Creacion de un trabajador
     *
     * @param ID
     * @param dni
     * @param nombre
     * @param apellido1
     * @param apellido2
     * @param calle
     * @param portal
     * @param piso
     * @param mano
     * @param telefono_p
     * @param movil_em
     * @param salario
     * @param fecha_nac
     * @param categoria
     * @param ct
     * @return
     * @throws ParseException
     */
    public String insertTrabajador(int ID, String dni, String nombre, String apellido1, String apellido2, String calle, String portal, String piso, String mano, String telefono_p, String movil_em, double salario, java.sql.Date fecha_nac, String categoria, int ct) throws ParseException {

        String rptaRegistro = null;
        long myId = 0;
        ID = 0;

        try {
            // LLAMADA AL PROCEDIMIENTO ALMACENADO EN ORACLE
            CallableStatement cs = accesoDB.prepareCall("{CALL INSERTAR_UPDATE_TRABAJADOR(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
            // SE RELLENAN TODOS LOS PARAMETROS
            cs.setInt(1, ID);
            cs.setString(2, dni);
            cs.setString(3, nombre);
            cs.setString(4, apellido1);
            cs.setString(5, apellido2);
            cs.setString(6, calle);
            cs.setString(7, portal);
            cs.setString(8, piso);
            cs.setString(9, mano);
            cs.setString(10, telefono_p);
            cs.setString(11, movil_em);
            cs.setDouble(12, salario);
            cs.setDate(13, fecha_nac);
            cs.setString(14, categoria);
            cs.setInt(15, ct);

            int numFila = cs.executeUpdate();
            if (numFila > 0) {
                rptaRegistro = "Registro insertado";
            }
            cs.close();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        return rptaRegistro;
    }

    /**
     * Listado de trabajadores.
     *
     * @return
     */
    public ArrayList<Trabajador> listTrabajador() {
        ArrayList listaTrabajador = new ArrayList();
        Trabajador trabajador;

        try {
            CallableStatement cs = accesoDB.prepareCall("{CALL P_LISTA_TRABAJADOR (?)}");
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            ResultSet rs = (ResultSet) cs.getObject(1);

            while (rs.next()) {
                trabajador = new Trabajador();
                trabajador.setID_trabajador(rs.getInt(1));
                trabajador.setDni(rs.getString(2));
                trabajador.setNombre(rs.getString(3));
                trabajador.setApellido1(rs.getString(4));
                trabajador.setApellido2(rs.getString(5));
                trabajador.setCalle(rs.getString(6));
                trabajador.setPortal(rs.getString(7));
                trabajador.setPiso(rs.getString(8));
                trabajador.setMano(rs.getString(9));
                trabajador.setTelef_personal(rs.getString(10));
                trabajador.setMovil_empresa(rs.getString(11));
                trabajador.setSalario(rs.getDouble(12));
                trabajador.setFecha_nac(rs.getDate(13));
                trabajador.setCategoria(rs.getString(14));
                trabajador.setCt(rs.getInt(15));

                listaTrabajador.add(trabajador);
            }
            cs.close();
            rs.close();

        } catch (Exception e) {

        }

        return listaTrabajador;
    }

    /**
     * Editar un trabajador.
     *
     * @param ID
     * @param dni
     * @param nombre
     * @param apellido1
     * @param apellido2
     * @param calle
     * @param portal
     * @param piso
     * @param mano
     * @param telefono_p
     * @param movil_em
     * @param salario
     * @param fecha_nac
     * @param categoria
     * @param ct
     * @return
     */
    public int editarTrabajador(int ID, String dni, String nombre, String apellido1, String apellido2, String calle, String portal, String piso, String mano, String telefono_p, String movil_em, double salario, Date fecha_nac, String categoria, int ct) {

        String rptaEdit = null;
        int numFil = 0;
        // FORMATEAR la fecha
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        fecha_nac = new java.sql.Date(fecha_nac.getTime());

        try {
            CallableStatement cs = accesoDB.prepareCall("{CALL INSERTAR_UPDATE_TRABAJADOR(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
            cs.setInt(1, ID);
            cs.setString(2, dni);
            cs.setString(3, nombre);
            cs.setString(4, apellido1);
            cs.setString(5, apellido2);
            cs.setString(6, calle);
            cs.setString(7, portal);
            cs.setString(8, piso);
            cs.setString(9, mano);
            cs.setString(10, telefono_p);
            cs.setString(11, movil_em);
            cs.setDouble(12, salario);
            cs.setDate(13, fecha_nac);
            cs.setString(14, categoria);
            cs.setInt(15, ct);

            numFil = cs.executeUpdate();
            if (numFil > 0) {
                rptaEdit = "Registro ACTUALIZAZO";
            }
            cs.close();

        } catch (SQLException ex) {
            Logger.getLogger(CT_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numFil;
    }

    /**
     * Eliminación de un trabajador
     *
     * @param Id
     * @return
     */
    public int eliminarTrabajador(int Id) {
        int numFil = 0;

        try {
            CallableStatement cs = accesoDB.prepareCall("{CALL BORRAR_TRABAJADOR(?) }");
            cs.setInt(1, Id);

            numFil = cs.executeUpdate();
            cs.close();

        } catch (SQLException ex) {
            Logger.getLogger(Trabajador_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numFil;
    }

    /**
     * Busqueda de un trabajador por nombre
     *
     * @param nombreBuscado
     * @return
     */
    public ArrayList<Trabajador> buscarTrabajadorxNombre(String nombreBuscado) {
        ArrayList<Trabajador> listaTrabajador = new ArrayList();
        Trabajador trabajador;
        try {
            /*            PreparedStatement ps = accesoDB.prepareStatement("SELECT * FROM TRABAJADOR WHERE NOMBRE LIKE (?)");
            ps.setString(1, nombreBuscado);
            ResultSet rs = ps.executeQuery();*/
            CallableStatement cs = accesoDB.prepareCall("{CALL P_SELECT_TRABAJADOR (?,?)}");
            cs.setString(1, nombreBuscado);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.execute();
            ResultSet rs = (ResultSet) cs.getObject(2);

            while (rs.next()) {
                trabajador = new Trabajador();
                trabajador.setID_trabajador(rs.getInt(1));
                trabajador.setDni(rs.getString(2));
                trabajador.setNombre(rs.getString(3));
                trabajador.setApellido1(rs.getString(4));
                trabajador.setApellido2(rs.getString(5));
                trabajador.setCalle(rs.getString(6));
                trabajador.setPortal(rs.getString(7));
                trabajador.setPiso(rs.getString(8));
                trabajador.setMano(rs.getString(9));
                trabajador.setTelef_personal(rs.getString(10));
                trabajador.setMovil_empresa(rs.getString(11));
                trabajador.setSalario(rs.getDouble(12));
                trabajador.setFecha_nac(rs.getDate(13));
                trabajador.setCategoria(rs.getString(14));
                trabajador.setCt(rs.getInt(15));

                listaTrabajador.add(trabajador);

            }
            cs.close();
            rs.close();

        } catch (Exception e) {

        }
        return listaTrabajador;
    }

    public ArrayList<CT> listCT() {
        ArrayList listaCT = new ArrayList();
        CT ct;
        String sql = "{call CONSULTA_CT.BUSCAR_TOTAL_CT(?)}";
        try {
            //Statement sentencia = accesoDB.createStatement();
            CallableStatement rp = accesoDB.prepareCall(sql);
            rp.registerOutParameter(1, OracleTypes.CURSOR);
            rp.executeUpdate();
            ResultSet res = (ResultSet) rp.getObject(1);
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

}
