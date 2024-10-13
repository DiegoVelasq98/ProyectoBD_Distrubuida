/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.sql.*; 
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.table.DefaultTableModel;





public class Cliente_postgres extends Persona {
    private String nit;
    private int id;
    conexion cn;
    conexion_postgres cnpg;
    
    public Cliente_postgres (){}

    public Cliente_postgres(int id, String nit, String dpi, String nombre1, String nombre2, String apellido1, String apellido2, String direccion, String telcasa, String telmovil, String salariobase, String bonificacion) {
        super(dpi, nombre1, nombre2, apellido1, apellido2, direccion, telcasa, telmovil, salariobase, bonificacion);
        this.nit = nit;
        this.id= id;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    
   public DefaultTableModel leerpostgres(){
    DefaultTableModel tabla= new DefaultTableModel();
    
    try{
       
        cnpg = new conexion_postgres ();
     
       cnpg.abrir_conexion_postgres();
        String query;
       query= "Select id_cliente as id, nit, dpi, primer_nombre, segundo_nombre,primer_apellido, segundo_apellido,direccion, tel_casa, tel_movil, salario, bonificacion From cliente;";
      ResultSet consulta= cnpg.conexion_bdpg.createStatement().executeQuery(query);
        
       String encabezado[]= {"Id","NIT", "DPI","Primer Nombre", "Segundo Nombre", "Primer Apellido", "Segundo Apellido", "Dirección", "Teléfono Casa", "Teléfono Movil", "Salario", "Bonificiacion"};
       tabla.setColumnIdentifiers(encabezado);
        String datos [] = new String[12];
       while(consulta.next())
       {
           datos[0]= consulta.getString("id");
           datos[1]= consulta.getString("nit");
           datos[2]= consulta.getString("dpi");
           datos[3]= consulta.getString("primer_nombre");
           datos[4]= consulta.getString("segundo_nombre");
           datos[5]= consulta.getString("primer_apellido");
           datos[6]= consulta.getString("segundo_apellido");
           datos[7]= consulta.getString("direccion");
           datos[8]= consulta.getString("tel_casa");
           datos[9]= consulta.getString("tel_movil");
           datos[10]= consulta.getString("salario");
           datos[11]= consulta.getString("bonificacion");
           tabla.addRow(datos);
     
       }
            cnpg.cerrar_conexion();
        
    }catch(SQLException ex){
    
        System.out.println("Error: "+ex.getMessage());
    }
    
    return tabla;
    }

    
    
    @Override
public void agregar() {
    try {
        // Primero, verificar si el DPI ya existe en PostgreSQL
        if (dpiExiste(this.getDpi())) {
            JOptionPane.showMessageDialog(null, "El DPI ya existe en la base de datos de PostgreSQL.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Salir del método si el DPI ya existe
        }

        PreparedStatement parametro;
        String query = "INSERT INTO cliente(nit, dpi, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, direccion, tel_casa, tel_movil, salario, bonificacion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        
        // Primero agregar en PostgreSQL
        cnpg = new conexion_postgres();
        cnpg.abrir_conexion_postgres();
        
        parametro = cnpg.conexion_bdpg.prepareStatement(query);
        parametro.setString(1, this.getNit());
        parametro.setString(2, this.getDpi());
        parametro.setString(3, this.getNombre1());
        parametro.setString(4, this.getNombre2());
        parametro.setString(5, this.getApellido1());
        parametro.setString(6, this.getApellido2());
        parametro.setString(7, this.getDireccion());
        parametro.setString(8, this.getTelcasa());
        parametro.setString(9, this.getTelmovil());
        parametro.setString(10, this.getSalariobase());
        parametro.setString(11, this.getBonificacion());
        
        int executarPostgres = parametro.executeUpdate();
        cnpg.cerrar_conexion();

        // Si el insert en PostgreSQL fue exitoso, replicar en MySQL (Workbench)
        if (executarPostgres > 0) {
            cn = new conexion();
            cn.abrir_conexion_workbench();
            
            parametro = cn.conexion_bd.prepareStatement(query);
            parametro.setString(1, this.getNit());
            parametro.setString(2, this.getDpi());
            parametro.setString(3, this.getNombre1());
            parametro.setString(4, this.getNombre2());
            parametro.setString(5, this.getApellido1());
            parametro.setString(6, this.getApellido2());
            parametro.setString(7, this.getDireccion());
            parametro.setString(8, this.getTelcasa());
            parametro.setString(9, this.getTelmovil());
            parametro.setString(10, this.getSalariobase());
            parametro.setString(11, this.getBonificacion());

            int executarWorkbench = parametro.executeUpdate();
            cn.cerrar_conexion();
            
            JOptionPane.showMessageDialog(null, "Registro ingresado en PostgreSQL y replicado en Workbench.", "Agregar", JOptionPane.INFORMATION_MESSAGE);
        }
        
        
         // Construir la consulta SQL con los valores recién insertados
        String queryInsert = "INSERT INTO cliente(nit, dpi, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, direccion, tel_casa, tel_movil, salario, bonificacion) " +
                             "VALUES ('" + this.getNit() + "', '" + this.getDpi() + "', '" + this.getNombre1() + "', '" + this.getNombre2() + "', '" + this.getApellido1() + "', '" + this.getApellido2() + "', '" + this.getDireccion() + "', '" + this.getTelcasa() + "', '" + this.getTelmovil() + "', '" + this.getSalariobase() + "', '" + this.getBonificacion() + "');";

        // Guardar en la bitácora en el archivo txt
        registrarBitacoraEnTXT("INSERT", "cliente", queryInsert);
        
    } catch (SQLException ex) {
        System.out.println("Error: " + ex.getMessage());
    } finally {
        cnpg.cerrar_conexion(); 
    }
}

private boolean dpiExiste(String dpi) {
    boolean existe = false;
    String query = "SELECT COUNT(*) AS total FROM cliente WHERE dpi = ?;";
    try {
        cnpg = new conexion_postgres();
        cnpg.abrir_conexion_postgres();
        
        PreparedStatement parametro = cnpg.conexion_bdpg.prepareStatement(query);
        parametro.setString(1, dpi);
        
        ResultSet resultado = parametro.executeQuery();
        if (resultado.next()) {
            existe = resultado.getInt("total") > 0; // Si el total es mayor que 0, el DPI existe
        }
    } catch (SQLException ex) {
        System.out.println("Error al verificar DPI: " + ex.getMessage());
    } finally {
        cnpg.cerrar_conexion(); 
    }
    return existe;
}

@Override
public void actualizar() {
    try {
        // Validar si el nuevo DPI ya existe en la base de datos (excluyendo el del cliente actual)
        if (!validarDpiDuplicado(this.getDpi(), this.getId())) {
            // Preparar la actualización si el DPI no está duplicado
            PreparedStatement parametro;
            String query = "UPDATE cliente SET nit = ?, dpi = ?, primer_nombre = ?, segundo_nombre = ?, primer_apellido = ?, segundo_apellido = ?, direccion = ?, tel_casa = ?, tel_movil = ?, salario = ?, bonificacion = ? WHERE id_cliente = ?;";

            // Actualización en PostgreSQL
            cnpg = new conexion_postgres();
            cnpg.abrir_conexion_postgres();
            parametro = cnpg.conexion_bdpg.prepareStatement(query);
            parametro.setString(1, this.getNit());
            parametro.setString(2, this.getDpi());
            parametro.setString(3, this.getNombre1());
            parametro.setString(4, this.getNombre2());
            parametro.setString(5, this.getApellido1());
            parametro.setString(6, this.getApellido2());
            parametro.setString(7, this.getDireccion());
            parametro.setString(8, this.getTelcasa());
            parametro.setString(9, this.getTelmovil());
            parametro.setString(10, this.getSalariobase());
            parametro.setString(11, this.getBonificacion());
            parametro.setInt(12, this.getId());
            int executarPostgres = parametro.executeUpdate();
            cnpg.cerrar_conexion();

            // Si la actualización en PostgreSQL fue exitosa, replicar en Workbench
            if (executarPostgres > 0) {
                cn = new conexion();
                cn.abrir_conexion_workbench();
                parametro = cn.conexion_bd.prepareStatement(query);
                parametro.setString(1, this.getNit());
                parametro.setString(2, this.getDpi());
                parametro.setString(3, this.getNombre1());
                parametro.setString(4, this.getNombre2());
                parametro.setString(5, this.getApellido1());
                parametro.setString(6, this.getApellido2());
                parametro.setString(7, this.getDireccion());
                parametro.setString(8, this.getTelcasa());
                parametro.setString(9, this.getTelmovil());
                parametro.setString(10, this.getSalariobase());
                parametro.setString(11, this.getBonificacion());
                parametro.setInt(12, this.getId());
                int executarWorkbench = parametro.executeUpdate();
                cn.cerrar_conexion();

                // Confirmación de éxito en ambas BD
                if (executarWorkbench > 0) {
                    JOptionPane.showMessageDialog(null, "Datos actualizados exitosamente en ambas bases de datos.", "Actualización", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } else {
            // Si el DPI ya existe, mostrar mensaje de error
            JOptionPane.showMessageDialog(null, "El DPI ingresado ya existe, no se puede duplicar.", "Error de Actualización", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException ex) {
        System.out.println("Error al actualizar: " + ex.getMessage());
    }
}

// Método para validar si el DPI ya existe (excluyendo el cliente actual)
private boolean validarDpiDuplicado(String dpi, int id_cliente) {
    boolean existe = false;
    try {
        // Validar en PostgreSQL
        cnpg = new conexion_postgres();
        cnpg.abrir_conexion_postgres();
        String query = "SELECT COUNT(*) AS cantidad FROM cliente WHERE dpi = ? AND id_cliente != ?;";
        PreparedStatement parametro = cnpg.conexion_bdpg.prepareStatement(query);
        parametro.setString(1, dpi);
        parametro.setInt(2, id_cliente);
        ResultSet resultado = parametro.executeQuery();
        if (resultado.next()) {
            existe = resultado.getInt("cantidad") > 0;
        }
        cnpg.cerrar_conexion();

        // Si no existe en PostgreSQL, validar en Workbench
        if (!existe) {
            cn = new conexion();
            cn.abrir_conexion_workbench();
            parametro = cn.conexion_bd.prepareStatement(query);
            parametro.setString(1, dpi);
            parametro.setInt(2, id_cliente);
            resultado = parametro.executeQuery();
            if (resultado.next()) {
                existe = resultado.getInt("cantidad") > 0;
            }
            cn.cerrar_conexion();
        }
        
    } catch (SQLException ex) {
        System.out.println("Error al validar DPI: " + ex.getMessage());
    }
    return existe;
}






@Override
public void eliminar() {
    try {
        PreparedStatement parametro;
        String query = "DELETE FROM cliente WHERE id_cliente = ?";

        // Eliminación en PostgreSQL
        cnpg = new conexion_postgres();
        cnpg.abrir_conexion_postgres();
        parametro = cnpg.conexion_bdpg.prepareStatement(query);
        parametro.setInt(1, getId());
        int executarPostgres = parametro.executeUpdate();
        cnpg.cerrar_conexion();

        // Si la eliminación en PostgreSQL fue exitosa, replicar en Workbench
        if (executarPostgres > 0) {
            cn = new conexion();
            cn.abrir_conexion_workbench();
            parametro = cn.conexion_bd.prepareStatement(query);
            parametro.setInt(1, getId());
            int executarWorkbench = parametro.executeUpdate();
            cn.cerrar_conexion();

            // Confirmación de éxito en ambas BD
            if (executarWorkbench > 0) {
                JOptionPane.showMessageDialog(null, "Registro eliminado exitosamente en ambas bases de datos.", "Eliminación", JOptionPane.INFORMATION_MESSAGE);
            }
        }

    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Error al eliminar el registro: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}




//Bitacora, metodo que crea archivo de bitacora
 public void registrarBitacoraEnTXT(String accion, String tabla, String query) {
    String rutaArchivo = "C:\\Users\\Diego\\Desktop\\bitacora\\bitacoraPostgres.txt"; 
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    String fechaActual = LocalDateTime.now().format(dtf);
    
    String contenido = "Fecha: " + fechaActual + "\n" +
                       "Acción: " + accion + "\n" +
                       "Tabla: " + tabla + "\n" +
                       "Consulta SQL: " + query + "\n" +
                       "-------------------------\n";
    
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
        writer.write(contenido);
    } catch (IOException e) {
        System.out.println("Error al escribir en la bitácora: " + e.getMessage());
    }
}
    

 //Bitacora, metodo que registra el ultimo insert en el arcchivo

public void generarBitacoraConInsert() {
 
    String nit = this.getNit();
    String dpi = this.getDpi();
    String primerNombre = this.getNombre1();
    String segundoNombre = this.getNombre2();
    String primerApellido = this.getApellido1();
    String segundoApellido = this.getApellido2();
    String direccion = this.getDireccion();
    String telCasa = this.getTelcasa();
    String telMovil = this.getTelmovil();
    String salario = this.getSalariobase();
    String bonificacion = this.getBonificacion();

    String query = "INSERT INTO cliente(nit, dpi, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, direccion, tel_casa, tel_movil, salario, bonificacion) " +
                   "VALUES ('" + nit + "', '" + dpi + "', '" + primerNombre + "', '" + segundoNombre + "', '" + primerApellido + "', '" + segundoApellido + "', '" + direccion + "', '" + telCasa + "', '" + telMovil + "', '" + salario + "', '" + bonificacion + "');";
    
    registrarBitacoraEnTXT("INSERT", "cliente", query);
    
    JOptionPane.showMessageDialog(null, "Bitácora generada correctamente", "Bitácora", JOptionPane.INFORMATION_MESSAGE);
}

 
 
  
    
}
