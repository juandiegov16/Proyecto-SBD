package proyectobasededatos;

import Datos.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
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

/**
 *
 * @author Usuario
 */
public class consultaGasto extends Application{
    VBox barrav ;
    HBox barra, barra2,barra3,barra4,barra5,barrabo,barrati;
    ComboBox cedulas;
    Connection co;
    Statement stm;
    ResultSet re;
    BorderPane root;
    @Override
    public void start(Stage primaryStage) throws Exception {
        barrav = new VBox();
        root = new BorderPane();
        
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
        
        //IMAGEN DE PORTADA
        titulo.setStyle("-fx-background-image: url(\"/images/logo.jpg\");-fx-background-size: 500, 150;-fx-background-repeat: no-repeat;");
        titulo.setPrefSize(500, 150);
        titulo.setDisable(false);
        //
        Button consultar = new Button();
        consultar.setText("CONSULTAR");
        //root.setStyle("-fx-background-image: url(\"/images/barco.jpg\");-fx-background-size: 500, 500;-fx-background-repeat: no-repeat;");
        barrav.setStyle("-fx-background-image: url(\"/images/barco.jpg\");-fx-background-size: 500, 700;-fx-background-repeat: no-repeat;");
        
        //LABELS QUE CONTIENEN LOS CAMPOS DE LA TABLA
        Label idgasto = new Label("Ingrese Id: ");
        idgasto.setFont(new Font("Arial", 15));
        idgasto.setWrapText(true);
        idgasto.setTextFill(Color.BLACK);
        idgasto.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                idgasto.setScaleX(1.1);
                idgasto.setScaleY(1.1);
            }
        });
        idgasto.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                idgasto.setScaleX(1);
                idgasto.setScaleY(1);
            }
        });
        
        Label tipogasto = new Label("Tipo de Gasto: ");
        tipogasto.setFont(new Font("Arial", 15));
        tipogasto.setWrapText(true);
        tipogasto.setTextFill(Color.BLACK);
        tipogasto.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                tipogasto.setScaleX(1.1);
                tipogasto.setScaleY(1.1);
            }
        });
        tipogasto.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                tipogasto.setScaleX(1);
                tipogasto.setScaleY(1);
            }
        });
        
        Label valorgasto = new Label("Valor del Gasto: ");
        valorgasto.setFont(new Font("Arial", 15));
        valorgasto.setWrapText(true);
        valorgasto.setTextFill(Color.BLACK);
        valorgasto.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                valorgasto.setScaleX(1.1);
                valorgasto.setScaleY(1.1);
            }
        });
        valorgasto.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                valorgasto.setScaleX(1);
                valorgasto.setScaleY(1);
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
        
       
        //TEXTFIELD DE CADA UNO DE LOS LABELS
        TextField idgastot = new TextField();
        TextField tipogastot = new TextField();
        TextField valorgastot = new TextField();
        TextField fechat = new TextField();
        TextField rucingt = new TextField();
        //CONTIENEN LOS LABELS Y LOS TEXTFIELD EN ORDEN 
        barra = new HBox();
        barra2=new HBox();
        barra3=new HBox();
        barra4=new HBox();
        barra5=new HBox();
        barrati=new HBox();
        barrabo= new HBox();
        
        barra.getChildren().addAll(idgasto,idgastot);
        barra2.getChildren().addAll(tipogasto,tipogastot);
        barra3.getChildren().addAll(valorgasto,valorgastot);
        barra4.getChildren().addAll(fecha,fechat); 
        barra5.getChildren().addAll(rucing,rucingt);
        
        barrabo.getChildren().addAll(salir, regresar, refrescar, consultar);
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

        barrabo.setAlignment(Pos.CENTER);
        barrabo.setSpacing(15);
        cedulas= new ComboBox();
       
        //contenedor de todos hbox
        barrati.getChildren().add(titulo);
        barrati.setPrefSize(100, 100);
        barrav.getChildren().addAll(barra,barra2,barra3,barra4,barra5);
        barrav.setAlignment(Pos.CENTER);
        barrav.setSpacing(15);
        root.setCenter(barrav);
        root.setBottom(barrabo);
        root.setTop(barrati);
        Scene scene = new Scene(root);       
        primaryStage.setTitle("Consulta Factura-Servicio");
        primaryStage.setScene(scene);
        primaryStage.setMinWidth(500);
        primaryStage.setMinHeight(450);
        primaryStage.show();
        
        refrescar.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                idgastot.clear();
                tipogastot.clear();
                valorgastot.clear();
                fechat.clear();
                rucingt.clear();
                try {
                    Conexion();
                } catch (SQLException ex) {
                    Logger.getLogger(consultaGasto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
   /*     consultar.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                try {
                    Conexion(cedulat,nombret,direcciont,telefonot);
                } catch (SQLException ex) {
                    Logger.getLogger(consultarCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
    }

    public  void Conexion(TextField cedula,TextField nombre,TextField direccion,TextField telefono) throws SQLException{
                    
        try{
            Class.forName("com.mysql.jdbc.Driver");
            co = DriverManager.getConnection("jdbc:mysql://127.0.0.1/taller_re?user=root&password=danny");
            stm = co.createStatement();
            re = stm.executeQuery("Select * from cliente ");
            Cliente c;
            while (re.next()){                 
                if(cedula.getText() == null ? re.getString("cedulaRUC") == null : cedula.getText().equals(re.getString("cedulaRUC"))){
                nombre.setText(re.getString("nombreCliente"));
                direccion.setText(re.getString("direccionCliente"));
                telefono.setText(re.getString("telefonoCliente"));
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
    } */
    public  void Conexion() throws SQLException{
                    
        try{
            Class.forName("com.mysql.jdbc.Driver");
            co = DriverManager.getConnection("jdbc:mysql://127.0.0.1/taller_re?user=root&password=danny");
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
            Logger.getLogger(consultaGasto.class.getName()).log(Level.SEVERE, null,ex);
        }
    } 
}
