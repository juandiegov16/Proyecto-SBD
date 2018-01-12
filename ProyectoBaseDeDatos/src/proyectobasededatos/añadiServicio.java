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
public class añadiServicio {
    VBox barrav ;
    HBox barra, barra2,barra3,barra4,barra5,barra6,barra7,barra8,barra9,barra10,barrabo,barrati;
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
        //root.setStyle("-fx-background-image: url(\"/images/barco.jpg\");-fx-background-size: 500, 500;-fx-background-repeat: no-repeat;");
        barrav.setStyle("-fx-background-image: url(\"/images/barco.jpg\");-fx-background-size: 550, 950;-fx-background-repeat: no-repeat;");
        
        //LABELS QUE CONTIENEN LOS CAMPOS DE LA TABLA
        Label idfactura = new Label("Ingrese numero de factura: ");
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
        
        Label fecha = new Label("Ingrese Fecha: ");
        fecha.setFont(new Font("Arial", 15));
        fecha.setWrapText(true);
        fecha.setTextFill(Color.BLACK);
        fecha.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                fecha.setScaleX(1.1);
                fecha.setScaleY(1.1);
            }
        });
        fecha.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                fecha.setScaleX(1);
                fecha.setScaleY(1);
            }
        });
        
        Label servicio = new Label("Ingrese Tipo de Servicio: ");
        servicio.setFont(new Font("Arial", 15));
        servicio.setWrapText(true);
        servicio.setTextFill(Color.BLACK);
        servicio.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                servicio.setScaleX(1.1);
                servicio.setScaleY(1.1);
            }
        });
        servicio.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                servicio.setScaleX(1);
                servicio.setScaleY(1);
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
        
        Label valor = new Label("Ingrese Valor de la Factura: ");
        valor.setFont(new Font("Arial", 15));
        valor.setWrapText(true);
        valor.setTextFill(Color.BLACK);
        valor.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                valor.setScaleX(1.1);
                valor.setScaleY(1.1);
            }
        });
        valor.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                valor.setScaleX(1);
                valor.setScaleY(1);
            }
        });
        
        Label formapago = new Label("Ingrese Forma de Pago: ");
        formapago.setFont(new Font("Arial", 15));
        formapago.setWrapText(true);
        formapago.setTextFill(Color.BLACK);
        formapago.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                formapago.setScaleX(1.1);
                formapago.setScaleY(1.1);
            }
        });
        formapago.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                formapago.setScaleX(1);
                formapago.setScaleY(1);
            }
        });
        
        Label numsr = new Label("Ingrese Número Serial de Repuesto: ");
        numsr.setFont(new Font("Arial", 15));
        numsr.setWrapText(true);
        numsr.setTextFill(Color.BLACK);
        numsr.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                numsr.setScaleX(1.1);
                numsr.setScaleY(1.1);
            }
        });
        numsr.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                numsr.setScaleX(1);
                numsr.setScaleY(1);
            }
        });
        
        Label rucing = new Label("Ingrese RUC del Ingeniero: ");
        rucing.setFont(new Font("Arial", 15));
        rucing.setWrapText(true);
        rucing.setTextFill(Color.BLACK);
        rucing.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                rucing.setScaleX(1.1);
                rucing.setScaleY(1.1);
            }
        });
        rucing.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                rucing.setScaleX(1);
                rucing.setScaleY(1);
            }
        });
        
        Label numorden = new Label("Ingrese Número de Orden: ");
        numorden.setFont(new Font("Arial", 15));
        numorden.setWrapText(true);
        numorden.setTextFill(Color.BLACK);
        numorden.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                numorden.setScaleX(1.1);
                numorden.setScaleY(1.1);
            }
        });
        numorden.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                numorden.setScaleX(1);
                numorden.setScaleY(1);
            }
        });
        
        Label cedularuc = new Label("Ingrese Número de Cédula: ");
        cedularuc.setFont(new Font("Arial", 15));
        cedularuc.setWrapText(true);
        cedularuc.setTextFill(Color.BLACK);
        cedularuc.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                cedularuc.setScaleX(1.1);
                cedularuc.setScaleY(1.1);
            }
        });
        cedularuc.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                cedularuc.setScaleX(1);
                cedularuc.setScaleY(1);
            }
        });
        //TEXTFIELD DE CADA UNO DE LOS LABELS
        TextField facturat = new TextField();
        TextField fechat = new TextField();
        TextField serviciot = new TextField();
        TextField descripciont = new TextField();
        TextField valort = new TextField();
        TextField formapagot = new TextField();
        TextField numsrt = new TextField();
        TextField rucingt = new TextField();
        TextField numordent = new TextField();
        TextField cedularuct = new TextField();
        //CONTIENEN LOS LABELS Y LOS TEXTFIELD EN ORDEN 
        barra = new HBox();
        barra2=new HBox();
        barra3=new HBox();
        barra4=new HBox();
        barra5=new HBox();
        barra6=new HBox();
        barra7=new HBox();
        barra8=new HBox();
        barra9=new HBox();
        barra10=new HBox();
        barrati=new HBox();
        barrabo= new HBox();
        
        barra.getChildren().addAll(idfactura,facturat);
        barra2.getChildren().addAll(fecha,fechat);
        barra3.getChildren().addAll(servicio,serviciot);
        barra4.getChildren().addAll(descripcion,descripciont); 
        barra5.getChildren().addAll(valor,valort);
        barra6.getChildren().addAll(formapago,formapagot);
        barra7.getChildren().addAll(numsr,numsrt);
        barra8.getChildren().addAll(rucing,rucingt);
        barra9.getChildren().addAll(numorden,numordent);
        barra10.getChildren().addAll(cedularuc,cedularuct);
        
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
        barra7.setSpacing(15);
        barra7.setAlignment(Pos.CENTER);
        barra8.setSpacing(15);
        barra8.setAlignment(Pos.CENTER);
        barra9.setSpacing(15);
        barra9.setAlignment(Pos.CENTER);
        barra10.setSpacing(15);
        barra10.setAlignment(Pos.CENTER);
        barrabo.setAlignment(Pos.CENTER);
        barrabo.setSpacing(15);
        cedulas= new ComboBox();
       
        //contenedor de todos hbox
        barrati.getChildren().add(titulo);
        barrati.setPrefSize(100, 100);
        barrav.getChildren().addAll(barra,barra2,barra3,barra4,barra5,barra6,barra7,barra8,barra9,barra10);
        barrav.setAlignment(Pos.CENTER);
        barrav.setSpacing(15);
        root.setCenter(barrav);
        root.setBottom(barrabo);
        root.setTop(barrati);
        Scene scene = new Scene(root);       
        primaryStage.setTitle("Consulta Factura-Servicio");
        primaryStage.setScene(scene);
        primaryStage.setMinWidth(550);
        primaryStage.setMinHeight(600);
        primaryStage.show();
        
        refrescar.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                facturat.clear();
                fechat.clear();
                serviciot.clear();
                descripciont.clear();
                valort.clear();
                formapagot.clear();
                numsrt.clear();
                rucingt.clear();
                numordent.clear();
                cedularuct.clear();
               
            }
        });
    }
}
