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
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

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
        Button btna1 = new Button();
        btna1.setText("Añadir");
                btna1.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                añadiCliente c = new añadiCliente();
                try {
                    c.start(primaryStage);
                } catch (Exception ex) {
                    Logger.getLogger(ProyectoBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        Button btn2 = new Button();
        btn2.setText("Consultar");
                btn2.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                consultarBote c = new consultarBote();
                try {
                    c.start(primaryStage);
                } catch (Exception ex) {
                    Logger.getLogger(ProyectoBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        Button btna2 = new Button();
        btna2.setText("Añadir");
        btna2.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                añadiBote c = new añadiBote();
                try {
                    c.start(primaryStage);
                } catch (Exception ex) {
                    Logger.getLogger(ProyectoBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });        
        Button btn3 = new Button();
        btn3.setText("Consultar");
                btn3.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                consultaServicio c = new consultaServicio();
                try {
                    c.start(primaryStage);
                } catch (Exception ex) {
                    Logger.getLogger(ProyectoBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        Button btna3 = new Button();
        btna3.setText("Añadir");
             btna3.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                añadiServicio c = new añadiServicio();
                try {
                    c.start(primaryStage);
                } catch (Exception ex) {
                    Logger.getLogger(ProyectoBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });        
        Button btn4 = new Button();
        btn4.setText("Consultar");
         btn4.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                consultaGasto c = new consultaGasto();
                try {
                    c.start(primaryStage);
                } catch (Exception ex) {
                    Logger.getLogger(ProyectoBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        Button btna4 = new Button();
        btna4.setText("Añadir");
                btna4.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                añadiGasto c = new añadiGasto();
                try {
                    c.start(primaryStage);
                } catch (Exception ex) {
                    Logger.getLogger(ProyectoBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        Button btn5 = new Button();
        btn5.setText("Consultar");
        btn5.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                consultaRepuesto c = new consultaRepuesto();
                try {
                    c.start(primaryStage);
                } catch (Exception ex) {
                    Logger.getLogger(ProyectoBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        Button btna5 = new Button();
        btna5.setText("Añadir");
                btna5.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                añadiRepuesto c = new añadiRepuesto();
                try {
                    c.start(primaryStage);
                } catch (Exception ex) {
                    Logger.getLogger(ProyectoBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        Button btn6 = new Button();
        btn6.setText("Consultar");
        btn6.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                consultaMotor c = new consultaMotor();
                try {
                    c.start(primaryStage);
                } catch (Exception ex) {
                    Logger.getLogger(ProyectoBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        Button btna6 = new Button();
        btna6.setText("Añadir");
                btna6.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                añadiMotor c = new añadiMotor();
                try {
                    c.start(primaryStage);
                } catch (Exception ex) {
                    Logger.getLogger(ProyectoBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
                }
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
        
        GridPane root = new GridPane();
        root.setVgap(10);
        root.setHgap(10);
        root.setStyle("-fx-background-image: url(\"/images/barco.jpg\");-fx-background-size: 500, 700;-fx-background-repeat: no-repeat;");
        
        Label consultarCliente = new Label("Consultar Cliente");
        root.add(consultarCliente,0,0);
        root.add(btn1,1,0);
        root.add(btna1,2,0);        
        Label consultarBote = new Label("Consultar Bote");
        root.add(consultarBote,0,1);
        root.add(btn2,1,1);
        root.add(btna2,2,1);
        Label consultarServicio = new Label("Consultar Servicio-Factura");
        root.add(consultarServicio,0,2);
        root.add(btn3,1,2);
        root.add(btna3,2,2);
        Label consultarGasto = new Label("Consultar Gasto");
        root.add(consultarGasto,0,3);
        root.add(btn4,1,3);
        root.add(btna4,2,3);
        Label consultarRepuesto = new Label("Consultar Repuesto");
        root.add(consultarRepuesto,0,4);
        root.add(btn5,1,4);
        root.add(btna5,2,4);
        Label consultarMotor = new Label("Consultar Motor");
        root.add(consultarMotor,0,5);
        root.add(btn6,1,5);
        root.add(btna6,2,5);
        
        consultarCliente.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                consultarCliente.setScaleX(1.1);
                consultarCliente.setScaleY(1.1);
            }
        });
        consultarCliente.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                consultarCliente.setScaleX(1);
                consultarCliente.setScaleY(1);
            }
        });
        consultarBote.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                consultarBote.setScaleX(1.1);
                consultarBote.setScaleY(1.1);
            }
        });
        consultarBote.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                consultarBote.setScaleX(1);
                consultarBote.setScaleY(1);
            }
        });
        consultarServicio.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                consultarServicio.setScaleX(1.1);
                consultarServicio.setScaleY(1.1);
            }
        });
        consultarServicio.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                consultarServicio.setScaleX(1);
                consultarServicio.setScaleY(1);
            }
        });
        
        consultarGasto.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                consultarGasto.setScaleX(1.1);
                consultarGasto.setScaleY(1.1);
            }
        });
        consultarGasto.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                consultarGasto.setScaleX(1);
                consultarGasto.setScaleY(1);
            }
        });
        
        consultarRepuesto.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                consultarRepuesto.setScaleX(1.1);
                consultarRepuesto.setScaleY(1.1);
            }
        });
        consultarRepuesto.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                consultarRepuesto.setScaleX(1);
                consultarRepuesto.setScaleY(1);
            }
        });
        
        consultarMotor.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                consultarMotor.setScaleX(1.1);
                consultarMotor.setScaleY(1.1);
            }
        });
        consultarMotor.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                consultarMotor.setScaleX(1);
                consultarMotor.setScaleY(1);
            }
        });
        
        consultarBote.setFont(new Font("Arial", 15));
        consultarBote.setWrapText(true);
        consultarBote.setTextFill(Color.BLACK);
        consultarCliente.setFont(new Font("Arial", 15));
        consultarCliente.setWrapText(true);
        consultarCliente.setTextFill(Color.BLACK);
        consultarServicio.setFont(new Font("Arial", 15));
        consultarServicio.setWrapText(true);
        consultarServicio.setTextFill(Color.BLACK);
        consultarGasto.setFont(new Font("Arial", 15));
        consultarGasto.setWrapText(true);
        consultarGasto.setTextFill(Color.BLACK);
        consultarRepuesto.setFont(new Font("Arial", 15));
        consultarRepuesto.setWrapText(true);
        consultarRepuesto.setTextFill(Color.BLACK);
        consultarMotor.setFont(new Font("Arial", 15));
        consultarMotor.setWrapText(true);
        consultarMotor.setTextFill(Color.BLACK);

        root.add(salir, 2,7);
        
        root.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(root); 

        primaryStage.setMinHeight(300);
        primaryStage.setMinWidth(500);
        primaryStage.setMaxHeight(300);
        primaryStage.setMaxWidth(500);
        
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
