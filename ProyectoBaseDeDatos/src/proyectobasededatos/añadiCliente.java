/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectobasededatos;

import java.sql.Connection;
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

/**
 *
 * @author Usuario
 */
public class añadiCliente {
    VBox barrav ;
    HBox barra, barra2,barra3,barra4,barra5,barra6;
    ComboBox cedulas;
    Connection co;
    Statement stm;
    ResultSet re;
    BorderPane root;
   
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
        
        barra6=new HBox();
        titulo.setStyle("-fx-background-image: url(\"/images/logo.jpg\");-fx-background-size: 500, 150;-fx-background-repeat: no-repeat;");
        titulo.setPrefSize(500, 150);
        titulo.setDisable(false);
        Button añadir = new Button();
        añadir.setText("AÑADIR");
        //root.setStyle("-fx-background-image: url(\"/images/barco.jpg\");-fx-background-size: 500, 500;-fx-background-repeat: no-repeat;");
        barrav.setStyle("-fx-background-image: url(\"/images/barco.jpg\");-fx-background-size: 500, 700;-fx-background-repeat: no-repeat;");
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
        Label nombre = new Label("Ingrese Nombre Cliente: ");
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
        Label direccion = new Label("Ingrese Dirección Cliente: ");
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
        Label telefono = new Label("Ingrese Teléfono Cliente: ");
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
        barra5.getChildren().addAll(salir, regresar, refrescar, añadir);
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
        primaryStage.setTitle("Añadir Cliente");
        primaryStage.setScene(scene);
        primaryStage.setMinHeight(450);
        primaryStage.show();
        
        refrescar.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                cedulat.clear();
                telefonot.clear();
                direcciont.clear();
                nombret.clear();
                
                
            }
        });
        refrescar.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
               //AQUI DEBES PONER LA CONEXION Y ENVIAR LOS DATOS DE LOS CUADROS DE TEXTO AL MYSQL CON INSERT
                
            }
        });
    }
}
