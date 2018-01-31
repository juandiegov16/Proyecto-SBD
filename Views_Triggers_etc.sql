use taller;
/*Triggers*/





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
        
        
/*Stored Procedures*/






/*Usuarios*/







/*Índices*/