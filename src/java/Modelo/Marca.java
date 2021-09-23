/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author Alejandra Morales
 */
public class Marca {
    private int id;
     ConexionBD cn;
    
    public Marca(){}
    public Marca(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public HashMap drop_marca(){
        HashMap<String,String>drop = new HashMap();
        try{
            cn=new ConexionBD();
            String query="SELECT id_marca as id,marca FROM marcas;";
            cn.abrir_ConexionBD();
            ResultSet consulta = cn.ConexionBD.createStatement().executeQuery(query);
            while(consulta.next()){
                drop.put(consulta.getString("id"), consulta.getString("marca"));
            }
            
            cn.cerrar_ConexionBD();
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }

        return drop;
    }
    
   protected void agregar(){}
   protected void mostrar(){}
   protected void modificar(){}
   protected void eliminar(){}
    
}
