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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javax.swing.JOptionPane;

/**
 *
 * @author Harold
 */
public class ProyectoBaseDeDatos extends Application {
    Button eliCli,eliBot,eliSer,eliGas,eliRep,eliMot,eliIng,eliOrd;
    VBox labels,consulta,añadirV,borrarV;
    HBox contenedor,deepB,conTop;
    @Override
    public void start(Stage primaryStage)  {
        String cliente = "cliente",administrador = "administrador";
        
        Button titulo=new Button();
        titulo.setStyle("-fx-background-image: url(\"/images/logo.jpg\");-fx-background-size: 500, 100;-fx-background-repeat: no-repeat;");
        titulo.setPrefSize(500, 100);
        titulo.setDisable(false);
        
        eliCli = new Button("Borrar");
        eliBot = new Button("Borrar");
        eliSer = new Button("Borrar");
        eliGas = new Button("Borrar");
        eliRep = new Button("Borrar");
        eliMot = new Button("Borrar");
        eliIng = new Button("Borrar");
        eliOrd = new Button("Borrar");
        
        labels = new VBox();
        consulta = new VBox();
        añadirV= new VBox();
        borrarV = new VBox();
        
        
        contenedor = new HBox();
        deepB = new HBox();
        
        Borrar(primaryStage);
        
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
        Button btn7 = new Button();
        btn7.setText("Consultar");
        btn7.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                consultarIngeniero c = new consultarIngeniero();
                try {
                    c.start(primaryStage);
                } catch (Exception ex) {
                    Logger.getLogger(ProyectoBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        Button btna7 = new Button();
        btna7.setText("Añadir");
                btna7.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                añadirIngeniero c = new añadirIngeniero();
                try {
                    c.start(primaryStage);
                } catch (Exception ex) {
                    Logger.getLogger(ProyectoBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }); 
        Button btn8 = new Button();
        btn8.setText("Consultar");
        btn8.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                ConsultarOrden c = new ConsultarOrden();
                try {
                    c.start(primaryStage);
                } catch (Exception ex) {
                    Logger.getLogger(ProyectoBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        Button btna8 = new Button();
        btna8.setText("Añadir");
                btna8.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                añadirOrden c = new añadirOrden();
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
        
        BorderPane root = new BorderPane();
          
        Label consultarCliente = new Label("Consultar Cliente");       
        Label consultarBote = new Label("Consultar Bote");   
        Label consultarServicio = new Label("Consultar Servicio-Factura");       
        Label consultarGasto = new Label("Consultar Gasto");      
        Label consultarRepuesto = new Label("Consultar Repuesto");
        Label consultarMotor = new Label("Consultar Motor");
        Label consultarIngeniero = new Label("Consultar Ingeniero");
        Label consultarOrden = new Label("Consultar Orden");
        
        labels.getChildren().addAll(consultarCliente,
                                     consultarBote,
                                     consultarServicio,
                                     consultarGasto,
                                     consultarRepuesto,
                                     consultarMotor,
                                     consultarIngeniero,
                                     consultarOrden);
        labels.setAlignment(Pos.CENTER);
        labels.setSpacing(23);
        
        consulta.getChildren().addAll(btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8);
        consulta.setAlignment(Pos.CENTER);
        consulta.setSpacing(15);
        
        añadirV.getChildren().addAll(btna1,btna2,btna3,btna4,btna5,btna6,btna7,btna8);
        añadirV.setAlignment(Pos.CENTER);
        añadirV.setSpacing(15);
        
        borrarV.getChildren().addAll(eliCli,eliBot,eliSer,eliGas,eliRep,eliMot,eliIng,eliOrd);
        borrarV.setAlignment(Pos.CENTER);
        borrarV.setSpacing(15);

        contenedor.getChildren().addAll(labels,consulta,añadirV,borrarV);
        contenedor.setAlignment(Pos.CENTER);
        contenedor.setSpacing(15);
        contenedor.setStyle("-fx-background-image: url(\"/images/barco.jpg\");-fx-background-size: 500, 700;-fx-background-repeat: no-repeat;");
        
        deepB.getChildren().addAll(salir);
        deepB.setAlignment(Pos.CENTER_RIGHT);
        deepB.setSpacing(15);
        
        
        root.setCenter(contenedor);
        root.setTop(titulo);
        
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
        consultarIngeniero.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                consultarIngeniero.setScaleX(1.1);
                consultarIngeniero.setScaleY(1.1);
            }
        });
        consultarIngeniero.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                consultarIngeniero.setScaleX(1);
                consultarIngeniero.setScaleY(1);
            }
        });
        consultarOrden.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                consultarOrden.setScaleX(1.1);
                consultarOrden.setScaleY(1.1);
            }
        });
        consultarOrden.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                consultarOrden.setScaleX(1);
                consultarOrden.setScaleY(1);
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
        consultarIngeniero.setFont(new Font("Arial", 15));
        consultarIngeniero.setWrapText(true);
        consultarIngeniero.setTextFill(Color.WHITE);
        consultarOrden.setFont(new Font("Arial", 15));
        consultarOrden.setWrapText(true);
        consultarOrden.setTextFill(Color.BLACK);

        root.setBottom(deepB);
        Scene scene = new Scene(root); 

        
        /*String[] options = {"Cliente", "Administrador "};
        int seleccion = JOptionPane.showOptionDialog(null, "Es necesario que seleccione de que tipo es el usuario", "Ingreso al Programa", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null, options, options[0]);
        if(JOptionPane.OK_OPTION == seleccion){
            System.out.println("BIENVENIDO CLIENTE!!!!");
            eliCli.setDisable(true);
            eliBot.setDisable(true);
            eliSer.setDisable(true);
            eliGas.setDisable(true);
            eliRep.setDisable(true);
            eliMot.setDisable(true);
            eliIng.setDisable(true);
            eliOrd.setDisable(true);
            btna1.setDisable(true);
            btna2.setDisable(true);
            btna3.setDisable(true);
            btna4.setDisable(true);
            btna5.setDisable(true);
            btna6.setDisable(true);
            btna7.setDisable(true);
            btna8 .setDisable(true);       
        }else{
            System.out.println("BIENVENIDO ADMINISTRADOR!!!!");

        };*/

        
       
        
        primaryStage.setTitle("Menu Principal");
        primaryStage.setScene(scene);
        primaryStage.setMinHeight(450);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    public void Borrar(Stage primaryStage){
        eliCli.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                EliminarCliente c = new EliminarCliente();
                try {
                    c.start(primaryStage);
                } catch (Exception ex) {
                    Logger.getLogger(ProyectoBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        eliBot.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                EliminarBote c = new EliminarBote();
                try {
                    c.start(primaryStage);
                } catch (Exception ex) {
                    Logger.getLogger(ProyectoBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        eliGas.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                EliminarGasto c = new EliminarGasto();
                try {
                    c.start(primaryStage);
                } catch (Exception ex) {
                    Logger.getLogger(ProyectoBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        eliIng.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                EliminarIngeniero c = new EliminarIngeniero();
                try {
                    c.start(primaryStage);
                } catch (Exception ex) {
                    Logger.getLogger(ProyectoBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        eliMot.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                EliminarMotor c = new EliminarMotor();
                try {
                    c.start(primaryStage);
                } catch (Exception ex) {
                    Logger.getLogger(ProyectoBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        eliOrd.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                EliminarOrden c = new EliminarOrden();
                try {
                    c.start(primaryStage);
                } catch (Exception ex) {
                    Logger.getLogger(ProyectoBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        eliRep.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                EliminarRepuesto c = new EliminarRepuesto();
                try {
                    c.start(primaryStage);
                } catch (Exception ex) {
                    Logger.getLogger(ProyectoBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        eliSer.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                EliminarServicio c = new EliminarServicio();
                try {
                    c.start(primaryStage);
                } catch (Exception ex) {
                    Logger.getLogger(ProyectoBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}
