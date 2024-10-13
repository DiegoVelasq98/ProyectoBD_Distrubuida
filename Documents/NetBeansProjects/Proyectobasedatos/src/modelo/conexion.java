/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;


import java.sql.*; 
import javax.swing.JOptionPane;

public class conexion {
   
    public Connection conexion_bd;
 
    //datos de conexion con Workbench
    private final String puertoMySql ="3306";
    //private final String bdMySql= "proyecto_bd_workbench";
        private final String bdMySql= "proyecto_bd";
    private final String urlConexionSql= String.format("jdbc:mysql://localhost:%s/%s?serverTimezone=UTC", puertoMySql, bdMySql);
    private final String usuarioMySql= "root";
    private final String passwordMySql="diego1234";
    private final String jdbcMySql= "com.mysql.cj.jdbc.Driver";
   
   
   //metodo para abrir la conexion con workbench
    public boolean abrir_conexion_workbench(){
            try{
                Class.forName(jdbcMySql);
                conexion_bd = DriverManager.getConnection(urlConexionSql,usuarioMySql,passwordMySql);
        System.out.println("Conexion exitosa con MySQL");
           return true;
            }catch(Exception ex){
                    System.out.println("Error: " + ex.getMessage());
                   return false;
            }
  
    }
    
    
    //metodo para cerrar la conexion con workbench
    public void cerrar_conexion() {
        
       
       try{
            //conexion_bd.close();
            if (conexion_bd != null && !conexion_bd.isClosed()) {
                conexion_bd.close();
                System.out.println("Conexión cerrada");
            }
        }catch(SQLException ex){
            System.out.println("Error al cerrar la conexión: " + ex.getMessage());
        }
    
}
}



