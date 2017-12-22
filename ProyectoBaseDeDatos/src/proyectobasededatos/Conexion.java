/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectobasededatos;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Conexion {
    Connection co;
    Statement stm;
    
    public Conexion() throws SQLException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            co = DriverManager.getConnection("jdbc:mysql://127.0.0.1/Taller?user=root&password=danny");
            stm = co.createStatement();
            ResultSet re = stm.executeQuery("Select * from ingeniero ");
            
            while (re.next()){
                System.out.println(re.getString("nombreIng"));
                System.out.println(re.getString("direccionIng"));
            }
        }
        catch (ClassNotFoundException exc){
            exc.printStackTrace();
        }
        catch(SQLException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null,ex);
        }
    }
    public static void main (String[] args) throws SQLException{
        
        Conexion co= new Conexion();
        
    }
}
