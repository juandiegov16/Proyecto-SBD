/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectobasededatos;

import Datos.Cliente;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Harold
 */
public class consultarCliente extends Application {
    VBox barrav ;
    HBox barra, barra2,barra3,barra4,barra5,barra6;
    ComboBox cedulas;
    Connection co;
    Statement stm;
    ResultSet re;
    BorderPane root;
    @Override
    public void start(Stage primaryStage) throws Exception {
        barrav = new VBox();
        root = new BorderPane();
        barra = new HBox();
        barra5= new HBox();
        Button refrescar = new Button();
        refrescar.setText("LIMPIAR");
        
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
        Button modificar = new Button();
        modificar.setText("MODIFICAR");
        
        barra6=new HBox();
        titulo.setStyle("-fx-background-image: url(\"/images/logo.jpg\");-fx-background-size: 550, 150;-fx-background-repeat: no-repeat;");
        titulo.setPrefSize(550, 150);
        titulo.setDisable(false);
        Button consultar = new Button();
        consultar.setText("CONSULTAR");
        //root.setStyle("-fx-background-image: url(\"/images/barco.jpg\");-fx-background-size: 500, 500;-fx-background-repeat: no-repeat;");
        barrav.setStyle("-fx-background-image: url(\"/images/barco.jpg\");-fx-background-size: 550, 700;-fx-background-repeat: no-repeat;");
        Label id = new Label("Ingrese numero de cedula: ");
        id.setFont(new Font("Arial", 15));
        id.setWrapText(true);
        id.setTextFill(Color.BLACK);
        id.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                id.setScaleX(1.1);
                id.setScaleY(1.1);
            }
        });
        id.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                id.setScaleX(1);
                id.setScaleY(1);
            }
        });
        Label nombre = new Label("Nombre Cliente: ");
        nombre.setFont(new Font("Arial", 15));
        nombre.setWrapText(true);
        nombre.setTextFill(Color.BLACK);
        nombre.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                nombre.setScaleX(1.1);
                nombre.setScaleY(1.1);
            }
        });
        nombre.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                nombre.setScaleX(1);
                nombre.setScaleY(1);
            }
        });
        Label direccion = new Label("Dirección Cliente: ");
        direccion.setFont(new Font("Arial", 15));
        direccion.setWrapText(true);
        direccion.setTextFill(Color.BLACK);
        direccion.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                direccion.setScaleX(1.1);
                direccion.setScaleY(1.1);
            }
        });
        direccion.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                direccion.setScaleX(1);
                direccion.setScaleY(1);
            }
        });
        Label telefono = new Label("Teléfono Cliente: ");
        telefono.setFont(new Font("Arial", 15));
        telefono.setWrapText(true);
        telefono.setTextFill(Color.BLACK);
        telefono.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                telefono.setScaleX(1.1);
                telefono.setScaleY(1.1);
            }
        });
        telefono.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                telefono.setScaleX(1);
                telefono.setScaleY(1);
            }
        });
        Button añadir = new Button();
        añadir.setText("ACEPTAR");
        
        TextField cedulat = new TextField();
        TextField nombret = new TextField();
        TextField direcciont = new TextField();
        TextField telefonot = new TextField();
        barra2=new HBox();
        barra3=new HBox();
        barra4=new HBox(); 
        barra2.getChildren().addAll(nombre,nombret);
        barra3.getChildren().addAll(direccion,direcciont);
        barra4.getChildren().addAll(telefono,telefonot);  
        barra2.setSpacing(15);
        barra2.setAlignment(Pos.CENTER);
        barra3.setSpacing(15);
        barra3.setAlignment(Pos.CENTER);
        barra4.setSpacing(15);
        barra4.setAlignment(Pos.CENTER);
        barra5.getChildren().addAll(salir, regresar, refrescar, consultar,modificar,añadir);
        barra5.setAlignment(Pos.CENTER);
        barra5.setSpacing(15);
        cedulas= new ComboBox();
        barra.getChildren().addAll(id,cedulat);
        barra.setSpacing(15);
        barra.setAlignment(Pos.CENTER);
        barra6.getChildren().add(titulo);
        barra6.setPrefSize(100, 100);
        barrav.getChildren().addAll(barra,barra2,barra3,barra4);
        barrav.setAlignment(Pos.CENTER);
        barrav.setSpacing(15);
        root.setCenter(barrav);
        root.setBottom(barra5);
        root.setTop(barra6);
        Scene scene = new Scene(root);       
        primaryStage.setTitle("Consulta Cliente");
        primaryStage.setScene(scene);
        primaryStage.setMinWidth(550);
        primaryStage.setMinHeight(450);
        cedulat.setEditable(true);
        nombret.setEditable(false);
        direcciont.setEditable(false);
        telefonot.setEditable(false); 
        primaryStage.show();
        
        refrescar.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                cedulat.clear();
                telefonot.clear();
                direcciont.clear();
                nombret.clear();
                cedulat.setEditable(true);
                nombret.setEditable(false);
                direcciont.setEditable(false);
                telefonot.setEditable(false); 
                try {
                    Conexion();
                } catch (SQLException ex) {
                    Logger.getLogger(consultarCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        consultar.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                try {
                    cedulat.setEditable(true);
                    nombret.setEditable(false);
                    direcciont.setEditable(false);
                    telefonot.setEditable(false); 
                    Conexion(cedulat,nombret,direcciont,telefonot);
                } catch (SQLException ex) {
                    Logger.getLogger(consultarCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        //ACCCION INCOMPLETQA FALTA QUE SE MODIFIQUE
        
        modificar.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                int confirmado = JOptionPane.showConfirmDialog(null,"¿Deseas modificar la información..?");
                String ced = cedulat.getText(), nom= nombret.getText(), dir = direcciont.getText(), tel = telefonot.getText();

                if (JOptionPane.OK_OPTION == confirmado){
                    cedulat.setEditable(true);
                    nombret.setEditable(true);
                    direcciont.setEditable(true);
                    telefonot.setEditable(true);
                    
                }
                } 
            
                
            });
        
        añadir.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
             
                    String ced = cedulat.getText(), nom= nombret.getText(), dir = direcciont.getText(), tel = telefonot.getText();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        co = DriverManager.getConnection("jdbc:mysql://127.0.0.1/taller_re?user=root&password=root");
                        PreparedStatement stm = co.prepareStatement("Update cliente set cedulaRuc = ?, nombrecliente = ?,direccionCliente = ? ,telefonoCliente = ? where cedulaRuc = ?");
                        stm.setString(1,ced);
                        stm.setString(2,nom);
                        stm.setString(3,dir);
                        stm.setString(4,tel);
                        stm.setString(5,ced);
                        stm.executeUpdate();
                        cedulat.clear();
                        telefonot.clear();
                        direcciont.clear();
                        nombret.clear();
                        JOptionPane.showMessageDialog(null, "MODIFICADO CON EXITO");
                        
                    }catch(MySQLIntegrityConstraintViolationException msicve){
                        JOptionPane.showMessageDialog(null, "Datos ya existentes");
                    }catch(ClassNotFoundException exc){
                        exc.printStackTrace();
                    
                    }catch(SQLException ex){
                        Logger.getLogger(consultarCliente.class.getName()).log(Level.SEVERE, null,ex);
                    }
                }
                 
            
        });
        
    }
    public  void Conexion(TextField cedula,TextField nombre,TextField direccion,TextField telefono) throws SQLException{
                    
        try{
            Class.forName("com.mysql.jdbc.Driver");
            co = DriverManager.getConnection("jdbc:mysql://127.0.0.1/taller_re?user=root&password=root");
            stm = co.createStatement();
            re = stm.executeQuery("Select * from cliente ");
            Cliente c;
            while (re.next()){                 
                if(cedula.getText() == null ? re.getString("cedulaRUC") == null : cedula.getText().equals(re.getString("cedulaRUC"))){
                nombre.setText(re.getString("nombreCliente"));
                direccion.setText(re.getString("direccionCliente"));
                telefono.setText(re.getString("telefonoCliente"));
                cedula.setEditable(false);
                nombre.setEditable(false);
                direccion.setEditable(false);
                telefono.setEditable(false); 
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
            re = stm.executeQuery("Select * from cliente ");
            System.out.println("CONEXION EXITOSA");
            Cliente c;
            while (re.next()){                 
                System.out.println(re.getString("nombreCliente")+"--"+re.getString("cedulaRUC"));
                
            }
        }catch (ClassNotFoundException exc){
            exc.printStackTrace();
        }
        catch(SQLException ex){
            Logger.getLogger(consultarCliente.class.getName()).log(Level.SEVERE, null,ex);
        }
    }   
}
