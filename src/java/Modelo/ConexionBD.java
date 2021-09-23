/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Alejandra Morales
 */
public class ConexionBD {
   public Connection ConexionBD;
    public final String bd = "segundo_parcial";
    public final String urlConexion = String.format("jdbc:mysql://localhost:3306/%s",bd) ;
    public final String usuario = "root";
    public final String contra = "umg$2019";
    public final String jdbc = "com.mysql.cj.jdbc.Driver";
    
    public void abrir_ConexionBD(){
        try{
            Class.forName(jdbc);
           ConexionBD = DriverManager.getConnection(urlConexion,usuario,contra);
           JOptionPane.showMessageDialog(null,"Conexion Exitosa....","Exito",JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception ex){
            System.out.println("Error...." + ex.getMessage());
           }
        
    }
    public void cerrar_ConexionBD(){
        try{
        ConexionBD.close();
        }catch(SQLException ex){
            System.out.println("Error..." +ex.getMessage());
        }
    }
}
