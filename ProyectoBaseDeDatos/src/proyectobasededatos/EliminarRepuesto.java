/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectobasededatos;

import Datos.Cliente;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Harold
 */
public class EliminarRepuesto extends Application{
    BorderPane root;
    Button regresar,aceptar,salir,titulo;
    Label cedula;
    HBox contLabels,contBoton,contTop;
    TextField txtid;
    Connection co;
    Statement stm;
    ResultSet re;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        txtid = new TextField();
        titulo=new Button();
        root = new BorderPane();
        regresar = new Button("Regresar");
        aceptar = new Button("Aceptar");
        salir = new Button("Salir");
        cedula = new Label("Ingrese Id: ");
        contLabels = new HBox();
        contBoton = new HBox();
        contTop = new HBox();
        
        contLabels.setStyle("-fx-background-image: url(\"/images/barco.jpg\");-fx-background-size: 500, 700;-fx-background-repeat: no-repeat;");
        titulo.setStyle("-fx-background-image: url(\"/images/logo.jpg\");-fx-background-size: 500, 150;-fx-background-repeat: no-repeat;");
        titulo.setPrefSize(500, 150);
        titulo.setDisable(false);
        
        Botones(primaryStage);
        acciones();
        
        contTop.getChildren().add(titulo);
        contTop.setPrefSize(100, 100);
        
        contBoton.getChildren().addAll(salir,regresar,aceptar);
        contBoton.setAlignment(Pos.CENTER);
        contBoton.setSpacing(15);
        
        contLabels.getChildren().addAll(cedula,txtid);
        contLabels.setAlignment(Pos.CENTER);
        contLabels.setSpacing(15);
        
        root.setCenter(contLabels);
        root.setTop(contTop);
        root.setBottom(contBoton);
        
        Scene scene = new Scene(root);       
        primaryStage.setTitle("Borrar Repuesto");
        primaryStage.setScene(scene);
        primaryStage.setMinHeight(450);
        primaryStage.show();
        Conexion();
    
    }
    public void Botones(Stage primaryStage){
        regresar.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                ProyectoBaseDeDatos m = new ProyectoBaseDeDatos();
                m.start(primaryStage);
            }
        });
        salir.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
            }
        });
        aceptar.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
             
                    String ced = txtid.getText();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        co = DriverManager.getConnection("jdbc:mysql://127.0.0.1/taller_re?user=root&password=root");
                        PreparedStatement stm = co.prepareStatement("Delete From repuesto where numSR = ?");
                        stm.setString(1,ced);
                        
                        stm.executeUpdate();
                        txtid.clear();
                        
                        JOptionPane.showMessageDialog(null, "Borrado CON EXITO");
                        
                        
                    }catch(MySQLIntegrityConstraintViolationException msicve){
                        JOptionPane.showMessageDialog(null, "Asociado a otra tabla, implemente la eliminacion por cascada");
                    }catch(ClassNotFoundException exc){
                        exc.printStackTrace();
                    
                    }catch(SQLException ex){
                        Logger.getLogger(consultarCliente.class.getName()).log(Level.SEVERE, null,ex);
                    }
                }
                 
            
        });
    }
    public void acciones(){
        cedula.setFont(new Font("Arial", 15));
        cedula.setWrapText(true);
        cedula.setTextFill(Color.WHITE);
        cedula.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                cedula.setScaleX(1.1);
                cedula.setScaleY(1.1);
            }
        });
        cedula.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                cedula.setScaleX(1);
                cedula.setScaleY(1);
            }
        });
    }
    public  void Conexion(TextField serial,TextField cantidad,TextField descripcion,TextField valorRep, TextField frecUso, TextField factura) throws SQLException{
                    
        try{
            Class.forName("com.mysql.jdbc.Driver");
            co = DriverManager.getConnection("jdbc:mysql://127.0.0.1/taller_re?user=root&password=root");
            stm = co.createStatement();
            re = stm.executeQuery("Select * from repuesto ");
            Cliente c;
            while (re.next()){                 
                if(serial.getText() == null ? re.getString("numSR") == null : serial.getText().equals(re.getString("numSR"))){
                cantidad.setText(re.getString("cantidad"));
                descripcion.setText(re.getString("descripcion"));
                valorRep.setText(re.getString("valorRep"));
                frecUso.setText(re.getString("frecuenciaUso"));
                factura.setText(re.getString("numFactura"));
                cantidad.setEditable(false);
                descripcion.setEditable(false);
                valorRep.setEditable(false);
                frecUso.setEditable(false);
                factura.setEditable(false);
                }
            }
        }catch (ClassNotFoundException exc){
            exc.printStackTrace();
        }
        catch(SQLException ex){
            Logger.getLogger(consultarCliente.class.getName()).log(Level.SEVERE, null,ex);
        }
    } 
    public  void Conexion() throws SQLException{
                    
        try{
            Class.forName("com.mysql.jdbc.Driver");
            co = DriverManager.getConnection("jdbc:mysql://127.0.0.1/taller_re?user=root&password=root");
            stm = co.createStatement();
            re = stm.executeQuery("Select * from repuesto ");
            System.out.println("CONEXION EXITOSA");
            Cliente c;
            while (re.next()){                 
                System.out.println(re.getString("numSR")+"--"+re.getString("cantidad"));
                
            }
        }catch (ClassNotFoundException exc){
            exc.printStackTrace();
        }
        catch(SQLException ex){
            Logger.getLogger(consultaGasto.class.getName()).log(Level.SEVERE, null,ex);
        }
    }
    

    
}


