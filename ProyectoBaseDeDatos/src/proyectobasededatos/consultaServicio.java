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
import javafx.application.Application;
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
public class consultaServicio extends Application{
    VBox barrav ;
    HBox barra, barra2,barra3,barra4,barra5,barra6,barra7,barra8,barra9,barra10,barrabo,barrati;
    ComboBox cedulas;
    Connection co;
    Statement stm;
    ResultSet re;
    BorderPane root;
    String tempo;
    @Override
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
        titulo.setStyle("-fx-background-image: url(\"/images/logo.jpg\");-fx-background-size: 550, 150;-fx-background-repeat: no-repeat;");
        titulo.setPrefSize(550, 150);
        titulo.setDisable(false);
        //
        Button consultar = new Button();
        consultar.setText("CONSULTAR");
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
        
        Label fecha = new Label("Fecha: ");
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
        
        Label servicio = new Label("Tipo de Servicio: ");
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
        
        Label descripcion = new Label("Descripción: ");
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
        
        Label valor = new Label("Valor de la Factura: ");
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
        
        Label formapago = new Label("Forma de Pago: ");
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
        
        Label numsr = new Label("Número Serial de Repuesto: ");
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
        
        Label rucing = new Label("RUC del Ingeniero: ");
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
        
        Label numorden = new Label("Número de Orden: ");
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
        
        Label cedularuc = new Label("Número de Cédula: ");
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
                try {
                    Conexion();
                } catch (SQLException ex) {
                    Logger.getLogger(consultaServicio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        consultar.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                try {
                    facturat.setEditable(true);
                    fechat.setEditable(false);
                    serviciot.setEditable(false);
                    descripciont.setEditable(false);
                    valort.setEditable(false);
                    formapagot.setEditable(false);
                    numsrt.setEditable(false);
                    rucingt.setEditable(false);
                    numordent.setEditable(false);
                    cedularuct.setEditable(false);
                    Conexion(facturat,fechat,serviciot,descripciont,valort,formapagot,numsrt,rucingt,numordent,cedularuct);
                } catch (SQLException ex) {
                    Logger.getLogger(consultarCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        modificar.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                int confirmado = JOptionPane.showConfirmDialog(null,"¿Deseas modificar la información..?");
                String fecha = fechat.getText(), numfact= facturat.getText(), tipoServ = serviciot.getText(), descr = descripciont.getText(),valor = valort.getText(),formPag = formapagot.getText(),numSR = numsrt.getText(),RUCIng = rucingt.getText(),numOrd = numordent.getText(),cedula = cedularuct.getText();
                tempo =  facturat.getText();
                if (JOptionPane.OK_OPTION == confirmado){
                    
                    facturat.setEditable(true);
                    fechat.setEditable(true);
                    serviciot.setEditable(true);
                    descripciont.setEditable(true);
                    valort.setEditable(true);
                    formapagot.setEditable(true);
                    numsrt.setEditable(true);
                    rucingt.setEditable(true);
                    numordent.setEditable(true);
                    cedularuct.setEditable(true);
                }
                } 
            
                
            });
        añadir.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
             
                    String fecha = fechat.getText(), numfact= facturat.getText(), tipoServ = serviciot.getText(), descr = descripciont.getText(),valor = valort.getText(),formPag = formapagot.getText(),numSR = numsrt.getText(),RUCIng = rucingt.getText(),numOrd = numordent.getText(),cedula = cedularuct.getText();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        co = DriverManager.getConnection("jdbc:mysql://127.0.0.1/taller_re?user=root&password=root");
                        PreparedStatement stm = co.prepareStatement("Update facturaservicio set fecha = ?, numFactura = ?,tipoServicio = ? ,descripcion = ?,valorFactura = ?,formaPago = ?,numSR = ?,RUCIng = ?,numOrden = ?,cedulaRUC = ? where numFactura = ?");
                        stm.setString(1,fecha);
                        stm.setString(2,numfact);
                        stm.setString(3,tipoServ);
                        stm.setString(4,descr);
                        stm.setString(5,valor);
                        stm.setString(6,formPag);
                        stm.setString(7,numSR);
                        stm.setString(8,RUCIng);
                        stm.setString(9,numOrd);
                        stm.setString(10,cedula);
                        
                        
                        stm.setString(11,tempo);
                        stm.executeUpdate();
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

    public  void Conexion(TextField fecha,TextField numFact,TextField tipoServ,TextField descr, TextField valorFact, TextField formPag, TextField numSR,TextField rucIng,TextField numOrd,TextField cedula) throws SQLException{
                    
        try{
            Class.forName("com.mysql.jdbc.Driver");
            co = DriverManager.getConnection("jdbc:mysql://127.0.0.1/taller_re?user=root&password=root");
            stm = co.createStatement();
            re = stm.executeQuery("Select * from facturaservicio ");
            Cliente c;
            while (re.next()){                 
                if(numFact.getText() == null ? re.getString("numFactura") == null : fecha.getText().equals(re.getString("numFactura"))){
                fecha.setText(re.getString("fecha"));
                tipoServ.setText(re.getString("tipoServicio"));
                descr.setText(re.getString("descripcion"));
                valorFact.setText(re.getString("valorFactura"));
                formPag.setText(re.getString("formaPago"));
                numSR.setText(re.getString("numSR"));
                rucIng.setText(re.getString("RUCIng"));
                numOrd.setText(re.getString("numOrden"));
                cedula.setText(re.getString("cedulaRUC"));
                
                numFact.setEditable(false);
                tipoServ.setEditable(false);
                descr.setEditable(false);
                valorFact.setEditable(false);
                formPag.setEditable(false);
                numSR.setEditable(false);
                rucIng.setEditable(false);
                numOrd.setEditable(false);
                cedula.setEditable(false);
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
            re = stm.executeQuery("Select * from facturaservicio ");
            System.out.println("CONEXION EXITOSA");
            Cliente c;
            while (re.next()){                 
                System.out.println(re.getString("numFactura")+"--"+re.getString("fecha"));
                
            }
        }catch (ClassNotFoundException exc){
            exc.printStackTrace();
        }
        catch(SQLException ex){
            Logger.getLogger(consultaGasto.class.getName()).log(Level.SEVERE, null,ex);
        }
    } 
}
