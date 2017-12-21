/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectobasededatos;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

/**
 *
 * @author Harold
 */
public class ProyectoBaseDeDatos extends Application {
    
    @Override
    public void start(Stage primaryStage)  {
               
        Button btn1 = new Button();
        btn1.setText("Consultar");
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                consultarCliente c = new consultarCliente();
                try {
                    c.start(primaryStage);
                } catch (Exception ex) {
                    Logger.getLogger(ProyectoBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        Button btn2 = new Button();
        btn2.setText("Consultar");
        Button btn3 = new Button();
        btn3.setText("Consultar");
        Button btn4 = new Button();
        btn4.setText("Consultar");
        Button btn5 = new Button();
        btn5.setText("Consultar");
        
        Button salir = new Button();
        salir.setText("SALIR");
        salir.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
            }
        });
        
        GridPane root = new GridPane();
        
        
        Label consultarCliente = new Label("consultar Cliente");
        root.add(consultarCliente,0,0);
        root.add(btn1,1,0);
                
        Label consultarBote = new Label("consultar Bote");
        root.add(consultarBote,0,1);
        root.add(btn2,1,1);
        
        Label consultarServicio = new Label("consultar Servicio");
        root.add(consultarServicio,0,2);
        root.add(btn3,1,2);
        
        Label consultarRepuesto = new Label("consultar Repuesto");
        root.add(consultarRepuesto,0,3);
        root.add(btn4,1,3);
        
        Label consultarGasto = new Label("consultar Gasto");
        root.add(consultarGasto,0,4);
        root.add(btn5,1,4);
        
        root.add(salir, 2,6);
        
        root.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(root, 500, 500);       
        
        
        primaryStage.setTitle("Menu Principal");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
