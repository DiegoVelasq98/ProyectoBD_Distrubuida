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




//clase herada de Persona que obtiene los datos
public class Cliente extends Persona {
    private String nit;
    private int id;
    conexion cn;
    conexion_postgres cnpg;
    
    public Cliente (){}

    public Cliente(int id, String nit, String dpi, String nombre1, String nombre2, String apellido1, String apellido2, String direccion, String telcasa, String telmovil, String salariobase, String bonificacion) {
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

    

    //metodo de leer con TableModel para que muestre los datos ingresados en la tabla
   public DefaultTableModel leer(){
    DefaultTableModel tabla= new DefaultTableModel();
    
    try{
        cn = new conexion ();
      cn.abrir_conexion_workbench();
        String query;
       query= "Select id_cliente as id, nit, dpi, primer_nombre, segundo_nombre,primer_apellido, segundo_apellido,direccion, tel_casa, tel_movil, salario, bonificacion From cliente;";
      ResultSet consulta= cn.conexion_bd.createStatement().executeQuery(query);
        
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
            cn.cerrar_conexion();
        
    }catch(SQLException ex){
    
        System.out.println("Error: "+ex.getMessage());
    }
    
    return tabla;
    }

    
   //metodo que permite hacer insert en la tabla de la base de datos
    public void agregar() {
    try {
        
        // valida si el DPI ya existe en Workbench para agregarlo
        if (dpiExiste(this.getDpi())) {
            JOptionPane.showMessageDialog(null, "El DPI ya existe en la base de datos Workbench.", "Error", JOptionPane.ERROR_MESSAGE);
            return; 
        }

        
        PreparedStatement parametro;
        String query = "insert into cliente(nit, dpi, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, direccion, tel_casa, tel_movil, salario, bonificacion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        
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
        
        int executar = parametro.executeUpdate();
        JOptionPane.showMessageDialog(null, Integer.toString(executar) + " Registro Ingresado en Workbench", "Agregar", JOptionPane.INFORMATION_MESSAGE);
        
        // Cerrar conexión Workbench
        cn.cerrar_conexion();

        
        //Replica el insert que se hizo en Workbench para aplicarlo en Postgres
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

        executar = parametro.executeUpdate();
        
        //Muestra mensaje de que permitio el insert y que se replica automaticamente en la otra BD
        JOptionPane.showMessageDialog(null, Integer.toString(executar) + " Registro replicado en PostgreSQL", "Agregar", JOptionPane.INFORMATION_MESSAGE);

        // Cerrar conexión PostgreSQL
        cnpg.cerrar_conexion();
       
        
          // Construir la consulta SQL con los valores recién insertados
        String queryInsert = "INSERT INTO cliente(nit, dpi, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, direccion, tel_casa, tel_movil, salario, bonificacion) " +
                             "VALUES ('" + this.getNit() + "', '" + this.getDpi() + "', '" + this.getNombre1() + "', '" + this.getNombre2() + "', '" + this.getApellido1() + "', '" + this.getApellido2() + "', '" + this.getDireccion() + "', '" + this.getTelcasa() + "', '" + this.getTelmovil() + "', '" + this.getSalariobase() + "', '" + this.getBonificacion() + "');";

        // Guardar en la bitácora en el archivo txt
        registrarBitacoraEnTXT("INSERT", "cliente", queryInsert);
        
        
    } catch (SQLException ex) {
        System.out.println("Error: " + ex.getMessage());
    } finally {
        cn.cerrar_conexion(); 
    }
}

    
    //metodo que valida si el DPI ya esta registrado en la BD
private boolean dpiExiste(String dpi) {
    boolean existe = false;
    String query = "SELECT COUNT(*) AS total FROM cliente WHERE dpi = ?;";
    try {
        cn = new conexion();
        cn.abrir_conexion_workbench();
        
        PreparedStatement parametro = cn.conexion_bd.prepareStatement(query);
        parametro.setString(1, dpi);
        
        ResultSet resultado = parametro.executeQuery();
        if (resultado.next()) {
            existe = resultado.getInt("total") > 0; // Si el total es mayor que 0, el DPI existe
        }
    } catch (SQLException ex) {
        System.out.println("Error al verificar DPI: " + ex.getMessage());
    } finally {
        cn.cerrar_conexion(); 
    }
    return existe;
}



    

//Metodo que recibe los parametros para actualizar el campo a seleccionar en la tabla
@Override
public void actualizar() {
    try {
        
        // Validar si el nuevo DPI ya existe en la base de datos
        if (!validarDpiDuplicado(this.getDpi(), this.getId())) {
            
            // Preparar la actualización si el DPI no está duplicado para permitir hacer update
            PreparedStatement parametro;
            String query = "update cliente set nit = ?, dpi = ?, primer_nombre = ?, segundo_nombre = ?, primer_apellido = ?, segundo_apellido = ?, direccion = ?, tel_casa = ?, tel_movil = ?, salario = ?, bonificacion = ? WHERE id_cliente = ?;";
            
            // Actualización en Workbench
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
            int executar = parametro.executeUpdate();
            cn.cerrar_conexion();

            // Actualización en PostgreSQL
            conexion_postgres cnpg = new conexion_postgres();
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

            
            // Confirmación que en ambas BD se hizo el update
            if (executar > 0 && executarPostgres > 0) {
                JOptionPane.showMessageDialog(null, "Datos actualizados exitosamente en ambas bases de datos.", "Actualización", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            // Si el DPI ya existe, mostrar mensaje de error que no permite
            JOptionPane.showMessageDialog(null, "El DPI ingresado ya existe, no se puede duplicar.", "Error de Actualización", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException ex) {
        System.out.println("Error al actualizar: " + ex.getMessage());
    }
}


// Método para validar si el DPI ya existe o esta duplicado
private boolean validarDpiDuplicado(String dpi, int id_cliente) {
    boolean existe = false;
    try {
        // Validar en Workbench
        cn = new conexion();
        cn.abrir_conexion_workbench();
        String query = "SELECT COUNT(*) AS cantidad FROM cliente WHERE dpi = ? AND id_cliente != ?;";
        PreparedStatement parametro = cn.conexion_bd.prepareStatement(query);
        parametro.setString(1, dpi);
        parametro.setInt(2, id_cliente);
        ResultSet resultado = parametro.executeQuery();
        if (resultado.next()) {
            existe = resultado.getInt("cantidad") > 0;
        }
        cn.cerrar_conexion();

        // Validar en PostgreSQL
        conexion_postgres cnpg = new conexion_postgres();
        cnpg.abrir_conexion_postgres();
        parametro = cnpg.conexion_bdpg.prepareStatement(query);
        parametro.setString(1, dpi);
        parametro.setInt(2, id_cliente);
        resultado = parametro.executeQuery();
        if (resultado.next()) {
            existe = resultado.getInt("cantidad") > 0;
        }
        cnpg.cerrar_conexion();
        
    } catch (SQLException ex) {
        System.out.println("Error al validar DPI: " + ex.getMessage());
    }
    return existe;
}


//metodo que permite eliminar el cliente seleccionado de la BD
@Override
public void eliminar() {
    try {
        PreparedStatement parametro;
        String query = "delete from cliente where id_cliente=?";

        // Elimina el cliente en Workbench
        cn = new conexion();
        cn.abrir_conexion_workbench();
        parametro = cn.conexion_bd.prepareStatement(query);
        parametro.setInt(1, getId());
        int executar = parametro.executeUpdate();
        System.out.println("Se borró el registro en Workbench: " + Integer.toString(executar));
        cn.cerrar_conexion();

        // Elimina el cliente en PostgreSQL
        conexion_postgres cnpg = new conexion_postgres();
        cnpg.abrir_conexion_postgres();
        parametro = cnpg.conexion_bdpg.prepareStatement(query);
        parametro.setInt(1, getId());
        int executarPostgres = parametro.executeUpdate();
        System.out.println("Se borró el registro en PostgreSQL: " + Integer.toString(executarPostgres));
        cnpg.cerrar_conexion();

        // Mensaje de confirmación si se borró en ambas BD y hace un refresh en la tabla
        if (executar > 0 && executarPostgres > 0) {
            JOptionPane.showMessageDialog(null, "Datos eliminados exitosamente en ambas bases de datos.", "Registro eliminado", JOptionPane.INFORMATION_MESSAGE);
        }
    } catch (SQLException ex) {
        System.out.println("Error al eliminar: " + ex.getMessage());
    }
}




//Bitacora, metodo que crea archivo de bitacora
 public void registrarBitacoraEnTXT(String accion, String tabla, String query) {
    String rutaArchivo = "C:\\Users\\Diego\\Desktop\\bitacora\\bitacoraWorkbench.txt"; 
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
