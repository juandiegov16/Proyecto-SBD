/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectobasededatos;

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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Harold
 */
public class consultarCliente extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        HBox barra = new HBox();
        HBox barra2 = new HBox();
        Button aceptar = new Button();
        aceptar.setText("ACEPTAR");
        
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
        //root.setStyle("-fx-background-image: url(\"/images/barco.jpg\");-fx-background-size: 500, 500;-fx-background-repeat: no-repeat;");
        barra.setStyle("-fx-background-image: url(\"/images/barco.jpg\");-fx-background-size: 500, 700;-fx-background-repeat: no-repeat;");
        Label id = new Label("Ingrese numero de cedula: ");
        id.setFont(new Font("Arial", 15));
        id.setWrapText(true);
        id.setTextFill(Color.WHITE);
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
        barra.setSpacing(15);
        TextField texto = new TextField();
        barra.getChildren().addAll(id,texto);
        barra.setAlignment(Pos.CENTER);
        barra2.getChildren().addAll(salir, regresar, aceptar);
        barra2.setAlignment(Pos.CENTER);
        barra2.setSpacing(15);
        root.setCenter(barra);
        root.setBottom(barra2);
        Scene scene = new Scene(root, 500, 300);       
        primaryStage.setTitle("Menu Principal");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
