/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectobasededatos;

import Datos.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
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
public class añadiBote {
      VBox barrav ;
    HBox barra, barra2,barra3,barra4,barra5,barra6,barra7;
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
        Button añadir = new Button();
        añadir.setText("AÑADIR");
        
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
        //root.setStyle("-fx-background-image: url(\"/images/barco.jpg\");-fx-background-size: 500, 500;-fx-background-repeat: no-repeat;");
        barrav.setStyle("-fx-background-image: url(\"/images/barco.jpg\");-fx-background-size: 500, 700;-fx-background-repeat: no-repeat;");
        Label serial = new Label("Ingrese el Serial: ");
        serial.setFont(new Font("Arial", 15));
        serial.setWrapText(true);
        serial.setTextFill(Color.BLACK);
        serial.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                serial.setScaleX(1.1);
                serial.setScaleY(1.1);
            }
        });
        serial.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                serial.setScaleX(1);
                serial.setScaleY(1);
            }
        });
        Label marca = new Label("Ingrese Marca del bote: ");
        marca.setFont(new Font("Arial", 15));
        marca.setWrapText(true);
        marca.setTextFill(Color.BLACK);
        marca.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                marca.setScaleX(1.1);
                marca.setScaleY(1.1);
            }
        });
        marca.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                marca.setScaleX(1);
                marca.setScaleY(1);
            }
        });
        Label modelo = new Label("Ingrese Modelo: ");
        modelo.setFont(new Font("Arial", 15));
        modelo.setWrapText(true);
        modelo.setTextFill(Color.BLACK);
        modelo.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                modelo.setScaleX(1.1);
                modelo.setScaleY(1.1);
            }
        });
        modelo.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                modelo.setScaleX(1);
                modelo.setScaleY(1);
            }
        });
        Label longitud = new Label("Ingrese Longuitud Bote: ");
        longitud.setFont(new Font("Arial", 15));
        longitud.setWrapText(true);
        longitud.setTextFill(Color.BLACK);
        longitud.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                longitud.setScaleX(1.1);
                longitud.setScaleY(1.1);
            }
        });
        longitud.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                longitud.setScaleX(1);
                longitud.setScaleY(1);
            }
        });
        Label cedula = new Label("Ingrese Cedula Cliente: ");
        cedula.setFont(new Font("Arial", 15));
        cedula.setWrapText(true);
        cedula.setTextFill(Color.BLACK);
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
        TextField serialt = new TextField();
        TextField marcat = new TextField();
        TextField modelot = new TextField();
        TextField longuitudt = new TextField();
        TextField cedulat = new TextField();
        barra2=new HBox();
        barra3=new HBox();
        barra4=new HBox(); 
        barra7=new HBox();
        barra.getChildren().addAll(serial,serialt);
        barra2.getChildren().addAll(marca,marcat);
        barra3.getChildren().addAll(modelo,modelot);
        barra4.getChildren().addAll(longitud,longuitudt);
        barra7.getChildren().addAll(cedula,cedulat);
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
        barra7.setSpacing(15);
        barra7.setAlignment(Pos.CENTER);
        barra.setSpacing(15);
        barra.setAlignment(Pos.CENTER);
        barra6.getChildren().add(titulo);
        barra6.setPrefSize(100, 100);
        barrav.getChildren().addAll(barra,barra2,barra3,barra4,barra7);
        barrav.setAlignment(Pos.CENTER);
        barrav.setSpacing(15);
        barrav.setPrefHeight(400);
        root.setCenter(barrav);
        root.setBottom(barra5);
        root.setTop(barra6);
        Scene scene = new Scene(root);       
        primaryStage.setTitle("Añadir Bote");
        primaryStage.setScene(scene);
        primaryStage.setMinHeight(450);

        primaryStage.show();
        
        refrescar.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                serialt.clear();
                marcat.clear();
                modelot.clear();
                longuitudt.clear();
                cedulat.clear();
               
            }
        });

    }
 
}
