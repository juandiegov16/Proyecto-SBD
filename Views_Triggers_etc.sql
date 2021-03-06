use taller;
/*Stored Procedures*/
delimiter //
CREATE PROCEDURE datosCliente (IN cedulaCliente int)
BEGIN
	select nombreCliente, direccionCliente, telefonoCliente
    from cliente
    where cedulaCliente = cedulaRUC;
END//
delimiter ;

delimiter //
CREATE PROCEDURE datosBote (IN serialBote int)
BEGIN
	select b.modeloBote, b.marcaBote, b.eslora, c.nombreCliente as 'Dueño'
    from bote b inner join cliente c on b.cedulaRUC = c.cedulaRUC
    where serialBote = numSB;
END//
delimiter ;

/*Vistas*/
	#Muestra los botes de los clientes, cada uno con sus respectivos motores.
drop view if exists botesMotoresCliente;
CREATE VIEW botesMotoresCliente AS
    SELECT 
        c.nombreCliente,
        b.numSB AS '# Serial Bote',
        b.modeloBote,
        m.numSM,
        m.marcaMotor,
        m.modeloMotor
    FROM
        cliente c
            INNER JOIN
        bote b ON b.cedulaRUC = c.cedulaRUC
            INNER JOIN
        motor m ON m.numSB = b.numSB;
        
	#Muestra descripciones de repuestos, y en qué servicio fueron empleados
drop view if exists repuestoServicio;
CREATE VIEW repuestoServicio AS
    SELECT 
        r.descripcion,
        f.fecha,
        f.numFactura AS '# Factura',
        t.numOrden AS '# Orden'
    FROM
        facturaservicio f
            INNER JOIN
        repuesto r ON f.numFactura = r.numFactura
            INNER JOIN
        partesutilizadas p ON r.numSR = p.numSR
            INNER JOIN
        ordentrabajo t ON p.numOrden = t.numOrden;
        
	#Muestra todos los botes, y los servicios que han recibido
drop view if exists boteServicio;
CREATE VIEW boteServicio AS
    SELECT 
        b.numSB AS '# Serial Bote',
        b.modeloBote,
        f.descripcion AS 'Descripción Servicio',
        f.fecha,
        f.numFactura AS '# Factura'
    FROM
        bote b
            INNER JOIN
        recibe re ON b.numSB = re.numSB
            INNER JOIN
        facturaservicio f ON re.numFactura = f.numFactura;
        
	#Muestra clientes con los servicios que han recibido sus botes
drop view if exists servicioCliente;
CREATE VIEW servicioCliente AS
    SELECT 
        c.nombreCliente,
        b.numSB AS '# Serial Bote',
        b.modeloBote,
        f.descripcion AS 'Descripción Servicio',
        f.fecha,
        f.numFactura AS '# Factura'
    FROM
        cliente c
            INNER JOIN
        bote b ON c.cedulaRUC = b.cedulaRUC
            INNER JOIN
        recibe re ON b.numSB = re.numSB
            INNER JOIN
        facturaservicio f ON re.numFactura = f.numFactura;   
    
    #Muestra ordenes de trabajo con sus correspondientes facturas
drop view if exists ordenFactura;
CREATE VIEW ordenFactura AS
    SELECT 
        o.numOrden AS '# Orden',
        f.numFactura AS '# Factura',
        f.fecha,
        f.descripcion AS 'Descripción Servicio'
    FROM
        ordentrabajo o
            INNER JOIN
        facturaservicio f ON f.numOrden = o.numOrden;
        
        
/*Triggers*/

	#Emite alerta tras inserción de bote
delimiter //
create trigger insercionBote after insert on bote for each row
begin
	SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'HA INSERTADO EXITOSAMENTE UN BOTE.';
end//
delimiter ;

	#Emite alerta tras borrado de cliente
delimiter //
create trigger borradoCliente after delete on cliente for each row
begin
	SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'HA BORRADO EXITOSAMENTE UN CLIENTE.';
end//
delimiter ;


/*Usuarios*/
	#Admin de la base de datos, tiene todos los permisos en todas las tablas. Puede otorgar permisos
create user 'admin'@'localhost' identified by 'drios';
grant all privileges on taller.* to 'admin'@'localhost' with grant option;
	
    #Ingeniero, usuario tipo admin pero no puede otorgar permisos
create user 'carlos'@'localhost' identified by 'ceva57';
grant all privileges on taller.* to 'carlos'@'localhost';
grant execute on taller.* to 'carlos'@'localhost';

	#Cliente. Sólo puede ver la información que contiene la base de datos, no tiene permitido alterarla. No puede ejecutar SP's
create user 'cliente'@'localhost' identified by '1234';
grant select on taller.* to 'cliente'@'localhost';

	#Asistente. Puede insertar datos pero no borrarlos.
create user 'maria'@'localhost' identified by 'mech70';
grant select, insert, update, create, alter on taller.* to 'maria'@'localhost';
grant execute on taller.* to 'maria'@'localhost';

	#Usuario de prueba.
create user 'prueba'@'localhost' identified by 'root';
GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, DROP, 
    INDEX, ALTER, CREATE TEMPORARY TABLES 
ON *.* TO 'prueba'@'localhost';

/*Índices*/
CREATE INDEX specsBote
ON bote(numSB, marcaBote, modeloBote, eslora);

CREATE INDEX specsRepuesto
ON repuesto(numSR, descripcion, valorRep, frecuenciaUso);

CREATE INDEX clientes
ON cliente(nombreCliente);

CREATE INDEX specsMotor
ON motor(numSM, marcaMotor, modeloMotor, horasOperacion, tipoPropulsion);

CREATE INDEX gastos
on gasto(tipoGasto, valorGasto, fechaGasto);