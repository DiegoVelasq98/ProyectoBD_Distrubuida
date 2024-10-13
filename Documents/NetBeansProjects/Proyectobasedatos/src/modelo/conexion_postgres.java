/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Diego
 */
import javax.swing.JOptionPane;
import java.sql.*; 
import java.net.URL;


public class conexion_postgres {
    
    
    public Connection conexion_bdpg;

    //Conexion com Postgress
    private final String puertoPostgres ="5432";
    private final String bdPostgres= "proyecto_bd_postgres";
    private final String urlConexionPostgres= String.format("jdbc:postgresql://localhost:%s/%s", puertoPostgres, bdPostgres);
    private final String usuarioPostgres= "postgres";
    private final String passworrdPostgres="Ferxxo1998";
    private final String jdbcPostgres= "org.postgresql.Driver";

 

       public boolean abrir_conexion_postgres(){
            try{
                Class.forName(jdbcPostgres);
                conexion_bdpg = DriverManager.getConnection(urlConexionPostgres,usuarioPostgres,passworrdPostgres);
                
        System.out.println("Conexion exitosa con Postgres");
        return true;
              // return conexion_bdpg;
            }catch(Exception ex){
                    System.out.println("Error: " + ex.getMessage());
                            return true;

                 //  return conexion_bdpg;
            }   
    
}

    public void cerrar_conexion() {
        
        try{
            //conexion_bd.close();
            if (conexion_bdpg != null && !conexion_bdpg.isClosed()) {
                conexion_bdpg.close();
                System.out.println("Conexión cerrada");
            }
        }catch(SQLException ex){
            System.out.println("Error al cerrar la conexión: " + ex.getMessage());
        }
    }
    
}
