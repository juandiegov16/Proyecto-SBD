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
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class añadiRepuesto {
    VBox barrav ;
    HBox barra, barra2,barra3,barra4,barra5,barra6,barrabo,barrati;
    ComboBox cedulas;
    Connection co;
    Statement stm;
    ResultSet re;
    BorderPane root;
    
    public void start(Stage primaryStage) throws Exception {
        barrav = new VBox();
        root = new BorderPane();
        
        Button refrescar = new Button();
        refrescar.setText("LIMPIAR");
        Button añadir = new Button();
        añadir.setText("AÑADIR");
      
        Button titulo=new Button();
        Button regresar = new Button();
        regresar.setText("REGRESAR");
        regresar.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                ProyectoBaseDeDatos m = new ProyectoBaseDeDatos();
                m.start(primaryStage);
            }
        });
        
        Button salir = new Button();
        salir.setText("SALIR");
        salir.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
            }
        });
        
        //IMAGEN DE PORTADA
        titulo.setStyle("-fx-background-image: url(\"/images/logo.jpg\");-fx-background-size: 550, 150;-fx-background-repeat: no-repeat;");
        titulo.setPrefSize(550, 150);
        titulo.setDisable(false);
        //
        Button consultar = new Button();
        consultar.setText("CONSULTAR");
        //root.setStyle("-fx-background-image: url(\"/images/barco.jpg\");-fx-background-size: 500, 500;-fx-background-repeat: no-repeat;");
        barrav.setStyle("-fx-background-image: url(\"/images/barco.jpg\");-fx-background-size: 550, 700;-fx-background-repeat: no-repeat;");
        
        //LABELS QUE CONTIENEN LOS CAMPOS DE LA TABLA
        Label serialre = new Label("Ingrese el n° Serial del Repuesto: ");
        serialre.setFont(new Font("Arial", 15));
        serialre.setWrapText(true);
        serialre.setTextFill(Color.BLACK);
        serialre.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                serialre.setScaleX(1.1);
                serialre.setScaleY(1.1);
            }
        });
        serialre.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                serialre.setScaleX(1);
                serialre.setScaleY(1);
            }
        });
        
        Label cantidad = new Label("Ingrese Cantidad: ");
        cantidad.setFont(new Font("Arial", 15));
        cantidad.setWrapText(true);
        cantidad.setTextFill(Color.BLACK);
        cantidad.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                cantidad.setScaleX(1.1);
                cantidad.setScaleY(1.1);
            }
        });
        cantidad.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                cantidad.setScaleX(1);
                cantidad.setScaleY(1);
            }
        });
        
        Label descripcion = new Label("Ingrese Descripción: ");
        descripcion.setFont(new Font("Arial", 15));
        descripcion.setWrapText(true);
        descripcion.setTextFill(Color.BLACK);
        descripcion.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                descripcion.setScaleX(1.1);
                descripcion.setScaleY(1.1);
            }
        });
        descripcion.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                descripcion.setScaleX(1);
                descripcion.setScaleY(1);
            }
        });
        
        Label valorrep = new Label("Ingrese Valor del Repuesto: ");
        valorrep.setFont(new Font("Arial", 15));
        valorrep.setWrapText(true);
        valorrep.setTextFill(Color.BLACK);
        valorrep.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                valorrep.setScaleX(1.1);
                valorrep.setScaleY(1.1);
            }
        });
        valorrep.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                valorrep.setScaleX(1);
                valorrep.setScaleY(1);
            }
        });
        
        Label frecuencia = new Label("Ingrese Frecuencia de Uso: ");
        frecuencia.setFont(new Font("Arial", 15));
        frecuencia.setWrapText(true);
        frecuencia.setTextFill(Color.BLACK);
        frecuencia.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                frecuencia.setScaleX(1.1);
                frecuencia.setScaleY(1.1);
            }
        });
        frecuencia.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                frecuencia.setScaleX(1);
                frecuencia.setScaleY(1);
            }
        });
        
        Label idfactura = new Label("Ingrese Número de Factura: ");
        idfactura.setFont(new Font("Arial", 15));
        idfactura.setWrapText(true);
        idfactura.setTextFill(Color.BLACK);
        idfactura.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                idfactura.setScaleX(1.1);
                idfactura.setScaleY(1.1);
            }
        });
        idfactura.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                idfactura.setScaleX(1);
                idfactura.setScaleY(1);
            }
        });
        
        //TEXTFIELD DE CADA UNO DE LOS LABELS
        TextField serialret = new TextField();
        TextField cantidadt = new TextField();
        TextField descripciont = new TextField();
        TextField valorrept = new TextField();
        TextField frecuenciat = new TextField();
        TextField idfacturat = new TextField();
        //CONTIENEN LOS LABELS Y LOS TEXTFIELD EN ORDEN 
        barra = new HBox();
        barra2=new HBox();
        barra3=new HBox();
        barra4=new HBox();
        barra5=new HBox();
        barra6=new HBox();
        barrati=new HBox();
        barrabo= new HBox();
        
        barra.getChildren().addAll(serialre,serialret);
        barra2.getChildren().addAll(cantidad,cantidadt);
        barra3.getChildren().addAll(descripcion,descripciont);
        barra4.getChildren().addAll(valorrep,valorrept);
        barra5.getChildren().addAll(frecuencia,frecuenciat); 
        barra6.getChildren().addAll(idfactura,idfacturat);
        
        barrabo.getChildren().addAll(salir, regresar, refrescar,añadir);
        barra.setSpacing(15);
        barra.setAlignment(Pos.CENTER);
        barra2.setSpacing(15);
        barra2.setAlignment(Pos.CENTER);
        barra3.setSpacing(15);
        barra3.setAlignment(Pos.CENTER);
        barra4.setSpacing(15);
        barra4.setAlignment(Pos.CENTER);
        barra5.setSpacing(15);
        barra5.setAlignment(Pos.CENTER);
        barra6.setSpacing(15);
        barra6.setAlignment(Pos.CENTER);
        
        barrabo.setAlignment(Pos.CENTER);
        barrabo.setSpacing(15);
        cedulas= new ComboBox();
       
        //contenedor de todos hbox
        barrati.getChildren().add(titulo);
        barrati.setPrefSize(100, 100);
        barrav.getChildren().addAll(barra,barra2,barra3,barra4,barra5,barra6);
        barrav.setAlignment(Pos.CENTER);
        barrav.setSpacing(15);
        root.setCenter(barrav);
        root.setBottom(barrabo);
        root.setTop(barrati);
        Scene scene = new Scene(root);       
        primaryStage.setTitle("Añadir Repuesto");
        primaryStage.setScene(scene);
        primaryStage.setMinWidth(550);
        primaryStage.setMinHeight(450);
        primaryStage.show();
        
        refrescar.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                serialret.clear();
                cantidadt.clear();
                descripciont.clear();
                valorrept.clear();
                frecuenciat.clear();
                idfacturat.clear();
                try {
                    Conexion();
                } catch (SQLException ex) {
                    Logger.getLogger(consultaRepuesto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        añadir.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
             
                    String serial = serialret.getText(), cant= cantidadt.getText(), desc = descripciont.getText(), valor = valorrept.getText(),frec = frecuenciat.getText(),fact = idfacturat.getText();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        co = DriverManager.getConnection("jdbc:mysql://127.0.0.1/taller_re?user=root&password=root");
                        PreparedStatement stm = co.prepareStatement("INSERT into repuesto(numSR,cantidad,descripcion,valorRep,frecuenciaUso,numFactura) VALUES (?,?,?,?,?,?)");
                        stm.setString(1,serial);
                        stm.setString(2,cant);
                        stm.setString(3,desc);
                        stm.setString(4,valor);
                        stm.setString(5,frec);
                        stm.setString(6,fact);                      
                        stm.executeUpdate();
                        serialret.clear();
                        cantidadt.clear();
                        descripciont.clear();
                        valorrept.clear();
                        frecuenciat.clear();
                        idfacturat.clear();
                
                        JOptionPane.showMessageDialog(null, "AÑADIDO CON EXITO");
                        
                        
                    }catch(MySQLIntegrityConstraintViolationException msicve){
                        JOptionPane.showMessageDialog(null, "Datos ya existentes o factura no existe");
                        msicve.printStackTrace();
                    }catch(ClassNotFoundException exc){
                        exc.printStackTrace();
                    
                    }catch(SQLException ex){
                        Logger.getLogger(consultarCliente.class.getName()).log(Level.SEVERE, null,ex);
                    }
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
                System.out.println(re.getString("numSR")+"--"+re.getString("cantidad")+"--"+re.getString("descripcion")+"--"+re.getString("valorRep")+"--"+re.getString("frecuenciaUso")+"--"+re.getString("numFactura"));
                
            }
        }catch (ClassNotFoundException exc){
            exc.printStackTrace();
        }
        catch(SQLException ex){
            Logger.getLogger(consultaGasto.class.getName()).log(Level.SEVERE, null,ex);
        }
    } 
}
