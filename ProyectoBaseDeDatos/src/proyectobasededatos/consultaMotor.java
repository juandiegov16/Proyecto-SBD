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
public class consultaMotor {
    VBox barrav ;
    HBox barra, barra2,barra3,barra4,barra5,barra6,barrabo,barrati;
    ComboBox cedulas;
    Connection co;
    Statement stm;
    ResultSet re;
    BorderPane root;
    String tempo;
    
    public void start(Stage primaryStage) throws Exception {
        barrav = new VBox();
        root = new BorderPane();
        
        Button refrescar = new Button();
        refrescar.setText("LIMPIAR");
        Button añadir = new Button();
        añadir.setText("ACEPTAR");
        Button modificar = new Button();
        modificar.setText("MODIFICAR");
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
        titulo.setStyle("-fx-background-image: url(\"/images/logo.jpg\");-fx-background-size: 500, 100;-fx-background-repeat: no-repeat;");
        titulo.setPrefSize(500, 100);
        titulo.setDisable(false);
        //
        Button consultar = new Button();
        consultar.setText("CONSULTAR");
        //root.setStyle("-fx-background-image: url(\"/images/barco.jpg\");-fx-background-size: 500, 500;-fx-background-repeat: no-repeat;");
        barrav.setStyle("-fx-background-image: url(\"/images/barco.jpg\");-fx-background-size: 500, 700;-fx-background-repeat: no-repeat;");
        
        //LABELS QUE CONTIENEN LOS CAMPOS DE LA TABLA
        Label serialmo = new Label("Ingrese el n° Serial del Motor: ");
        serialmo.setFont(new Font("Arial", 15));
        serialmo.setWrapText(true);
        serialmo.setTextFill(Color.BLACK);
        serialmo.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                serialmo.setScaleX(1.1);
                serialmo.setScaleY(1.1);
            }
        });
        serialmo.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                serialmo.setScaleX(1);
                serialmo.setScaleY(1);
            }
        });
        
        Label marcamo = new Label("Marca Motor: ");
        marcamo.setFont(new Font("Arial", 15));
        marcamo.setWrapText(true);
        marcamo.setTextFill(Color.BLACK);
        marcamo.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                marcamo.setScaleX(1.1);
                marcamo.setScaleY(1.1);
            }
        });
        marcamo.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                marcamo.setScaleX(1);
                marcamo.setScaleY(1);
            }
        });
        
        Label modelomo = new Label("Modelo Motor: ");
        modelomo.setFont(new Font("Arial", 15));
        modelomo.setWrapText(true);
        modelomo.setTextFill(Color.BLACK);
        modelomo.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                modelomo.setScaleX(1.1);
                modelomo.setScaleY(1.1);
            }
        });
        modelomo.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                modelomo.setScaleX(1);
                modelomo.setScaleY(1);
            }
        });
        
        Label horaso = new Label("Horas de Operación: ");
        horaso.setFont(new Font("Arial", 15));
        horaso.setWrapText(true);
        horaso.setTextFill(Color.BLACK);
        horaso.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                horaso.setScaleX(1.1);
                horaso.setScaleY(1.1);
            }
        });
        horaso.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                horaso.setScaleX(1);
                horaso.setScaleY(1);
            }
        });
        
        Label tipopro = new Label("Tipo de Propulsión: ");
        tipopro.setFont(new Font("Arial", 15));
        tipopro.setWrapText(true);
        tipopro.setTextFill(Color.BLACK);
        tipopro.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                tipopro.setScaleX(1.1);
                tipopro.setScaleY(1.1);
            }
        });
        tipopro.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                tipopro.setScaleX(1);
                tipopro.setScaleY(1);
            }
        });
        
        Label numsb = new Label("Número Serial del Bote: ");
        numsb.setFont(new Font("Arial", 15));
        numsb.setWrapText(true);
        numsb.setTextFill(Color.BLACK);
        numsb.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                numsb.setScaleX(1.1);
                numsb.setScaleY(1.1);
            }
        });
        numsb.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                numsb.setScaleX(1);
                numsb.setScaleY(1);
            }
        });
        
        //TEXTFIELD DE CADA UNO DE LOS LABELS
        TextField serialmot = new TextField();
        TextField marcamot = new TextField();
        TextField modelomot = new TextField();
        TextField horasot = new TextField();
        TextField tipoprot = new TextField();
        TextField numsbt = new TextField();
        //CONTIENEN LOS LABELS Y LOS TEXTFIELD EN ORDEN 
        barra = new HBox();
        barra2=new HBox();
        barra3=new HBox();
        barra4=new HBox();
        barra5=new HBox();
        barra6=new HBox();
        barrati=new HBox();
        barrabo= new HBox();
        
        barra.getChildren().addAll(serialmo,serialmot);
        barra2.getChildren().addAll(marcamo,marcamot);
        barra3.getChildren().addAll(modelomo,modelomot);
        barra4.getChildren().addAll(horaso,horasot);
        barra5.getChildren().addAll(tipopro,tipoprot); 
        barra6.getChildren().addAll(numsb,numsbt);
        
        barrabo.getChildren().addAll(salir, regresar, refrescar, consultar,modificar,añadir);
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
        barrati.setPrefSize(500, 100);
        barrav.getChildren().addAll(barra,barra2,barra3,barra4,barra5,barra6);
        barrav.setAlignment(Pos.CENTER);
        barrav.setSpacing(15);
        root.setCenter(barrav);
        root.setBottom(barrabo);
        root.setTop(barrati);
        Scene scene = new Scene(root);       
        primaryStage.setTitle("Consulta Motor");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        refrescar.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                serialmot.clear();
                marcamot.clear();
                modelomot.clear();
                horasot.clear();
                tipoprot.clear();
                numsbt.clear();
                try {
                    Conexion();
                } catch (SQLException ex) {
                    Logger.getLogger(consultaRepuesto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    
        consultar.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                try {
                    serialmot.setEditable(true);
                    marcamot.setEditable(false);
                    modelomot.setEditable(false);
                    horasot.setEditable(false);
                    tipoprot.setEditable(false);
                    numsbt.setEditable(false);
                    Conexion(serialmot,marcamot,modelomot,horasot,tipoprot,numsbt);
                } catch (SQLException ex) {
                    Logger.getLogger(consultarCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        modificar.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                int confirmado = JOptionPane.showConfirmDialog(null,"¿Deseas modificar la información..?");
                String serial = serialmot.getText(), marca= marcamot.getText(), model = modelomot.getText(), hora = horasot.getText(),tipo = tipoprot.getText(),num = numsbt.getText();
                tempo = serialmot.getText();
                if (JOptionPane.OK_OPTION == confirmado){
                    
                    serialmot.setEditable(true);
                    marcamot.setEditable(true);
                    modelomot.setEditable(true);
                    horasot.setEditable(true);
                    tipoprot.setEditable(true);
                    numsbt.setEditable(true);
                }
                } 
            
                
        });
        añadir.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
             
                    String serial = serialmot.getText(), marca= marcamot.getText(), model = modelomot.getText(), hora = horasot.getText(),tipo = tipoprot.getText(),num = numsbt.getText();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        co = DriverManager.getConnection("jdbc:mysql://127.0.0.1/taller_re?user=root&password=root");
                        PreparedStatement stm = co.prepareStatement("Update motor set numSM = ?, marcaMotor = ?,modeloMotor = ? ,horasOperacion = ?,tipoPropulsion = ?,numSB = ? where numSB = ?");
                        stm.setString(1,serial);
                        stm.setString(2,marca);
                        stm.setString(3,model);
                        stm.setString(4,hora);
                        stm.setString(5,tipo);
                        stm.setString(6,num);
                        stm.setString(7,tempo);
                        stm.executeUpdate();
                        serialmot.clear();
                        marcamot.clear();
                        modelomot.clear();
                        horasot.clear();
                        tipoprot.clear();
                        numsbt.clear();
                
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

    public  void Conexion(TextField serial,TextField cantidad,TextField descripcion,TextField valorRep, TextField frecUso, TextField factura) throws SQLException{
                    
        try{
            Class.forName("com.mysql.jdbc.Driver");
            co = DriverManager.getConnection("jdbc:mysql://127.0.0.1/taller_re?user=root&password=root");
            stm = co.createStatement();
            re = stm.executeQuery("Select * from motor ");
            Cliente c;
            while (re.next()){                 
                if(serial.getText() == null ? re.getString("numSM") == null : serial.getText().equals(re.getString("numSM"))){
                cantidad.setText(re.getString("marcaMotor"));
                descripcion.setText(re.getString("modeloMotor"));
                valorRep.setText(re.getString("horasOperacion"));
                frecUso.setText(re.getString("tipoPropulsion"));
                factura.setText(re.getString("numSB"));
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
            re = stm.executeQuery("Select * from motor ");
            System.out.println("CONEXION EXITOSA");
            Cliente c;
            while (re.next()){                 
                System.out.println(re.getString("numSM")+"--"+re.getString("marcaMotor")+"--"+re.getString("modeloMotor")+"--"+re.getString("horasOperacion")+"--"+re.getString("tipoPropulsion")+"--"+re.getString("numSB"));
                
            }
        }catch (ClassNotFoundException exc){
            exc.printStackTrace();
        }
        catch(SQLException ex){
            Logger.getLogger(consultaGasto.class.getName()).log(Level.SEVERE, null,ex);
        }
    } 
}
