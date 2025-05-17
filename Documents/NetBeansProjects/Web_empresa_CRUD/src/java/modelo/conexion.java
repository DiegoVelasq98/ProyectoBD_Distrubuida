package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class conexion {

    public Connection conexion_bd;

    private final String puertoMySql = "3306";
    private final String bdMySql = "banco_distribuido"; 
    private final String urlConexionSql = String.format("jdbc:mysql://localhost:%s/%s?serverTimezone=UTC", puertoMySql, bdMySql);
    private final String usuarioMySql = "root";
    private final String passwordMySql = "diego1234";
    private final String jdbcMySql = "com.mysql.cj.jdbc.Driver";

    public boolean abrir_conexion_workbench() {
        try {
            Class.forName(jdbcMySql);
            conexion_bd = DriverManager.getConnection(urlConexionSql, usuarioMySql, passwordMySql);
            System.out.println("Conexión exitosa con MySQL");
            return true;
        } catch (Exception ex) {
            System.out.println("Error al conectar: " + ex.getMessage());
            return false;
        }
    }

    public void cerrar_conexion() {
        try {
            if (conexion_bd != null && !conexion_bd.isClosed()) {
                conexion_bd.close();
                System.out.println("Conexión cerrada");
            }
        } catch (SQLException ex) {
            System.out.println("Error al cerrar conexión: " + ex.getMessage());
        }
    }

    // 📌 Método para insertar Cliente
    public boolean insertarCliente(Cliente c) {
        if (!abrir_conexion_workbench()) return false;

        try {
            String sql = "INSERT INTO cliente(nombre, dpi, direccion, telefono) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conexion_bd.prepareStatement(sql);
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getDpi());
            ps.setString(3, c.getDireccion());
            ps.setString(4, c.getTelefono());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al insertar cliente: " + e.getMessage());
            return false;
        } finally {
            cerrar_conexion();
        }
    }

    // 📌 Método para insertar Cuenta
    public boolean insertarCuenta(Cuenta c) {
        if (!abrir_conexion_workbench()) return false;

        try {
            String sql = "INSERT INTO cuenta(id_cliente, numero_cuenta, tipo, saldo) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conexion_bd.prepareStatement(sql);
            ps.setInt(1, c.getIdCliente());
            ps.setString(2, c.getNumeroCuenta());
            ps.setString(3, c.getTipo());
            ps.setDouble(4, c.getSaldo());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al insertar cuenta: " + e.getMessage());
            return false;
        } finally {
            cerrar_conexion();
        }
    }

    // 📌 Método para insertar Usuario
    public boolean insertarUsuario(String usuario, String contrasena, String rol) {
        if (!abrir_conexion_workbench()) return false;

        try {
            String sql = "INSERT INTO usuario(usuario, contrasena, rol) VALUES (?, ?, ?)";
            PreparedStatement ps = conexion_bd.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, contrasena);
            ps.setString(3, rol);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al insertar usuario: " + e.getMessage());
            return false;
        } finally {
            cerrar_conexion();
        }
    }

    // 📌 Método para listar clientes (útil en cuenta.jsp)
    public List<Cliente> listarClientes() {
        List<Cliente> lista = new ArrayList<>();
        if (!abrir_conexion_workbench()) return lista;

        try {
            String sql = "SELECT * FROM cliente";
            PreparedStatement ps = conexion_bd.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("dpi"),
                    rs.getString("direccion"),
                    rs.getString("telefono")
                );
                lista.add(c);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar clientes: " + e.getMessage());
        } finally {
            cerrar_conexion();
        }
        return lista;
    }
}
