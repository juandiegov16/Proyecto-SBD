#Mostrar datos del ingeniero
SELECT 
    *
FROM
    ingeniero;

#Mostrar suma de gastos totales
SELECT 
    SUM(valorGasto) as GranTotal
FROM
    gasto;
    
#Mostrar suma de gastos para el mes de marzo (como ejemplo)
SELECT 
    SUM(valorGasto) as totalMes, month(fechaGasto) as mes
FROM
    gasto
WHERE
    DATE(MONTH(fechaGasto) = 03);
    
#Mostrar suma de gastos para el año 2017 (como ejemplo)
SELECT 
    SUM(valorGasto) AS totalAnual, YEAR(fechaGasto) AS año
FROM
    gasto
WHERE
    DATE(YEAR(fechaGasto) = 2017);
    
#Mostrar todos los motores, con los botes a los que pertenecen
SELECT 
    m.*, b.numSB, b.marcaBote, b.modeloBote
FROM
    motor m
        LEFT JOIN
    bote b ON b.numSB = m.numSB;
    
#Mostrar botes por cliente
SELECT 
    c.nombreCliente, b.numSB
FROM
    cliente c
        INNER JOIN
    bote b ON c.cedulaRUC = b.cedulaRUC
GROUP BY c.cedulaRUC;

#Mostrar motores por bote
SELECT 
    b.numSB, m.numSM
FROM
    bote b
        INNER JOIN
    motor m ON b.numSB = m.numSB
GROUP BY b.numSB;

#Mostrar repuestos agotados
SELECT 
    numSR, descripcion, valorRep
FROM
    repuesto
WHERE
    cantidad = 0;
    
#Mostrar datos de factura, con el nombre del cliente
SELECT 
    f.fecha,
    f.numFactura,
    f.tipoServicio,
    f.descripcion,
    f.valorFactura,
    f.formaPago,
    c.nombreCliente
FROM
    facturaservicio f
        INNER JOIN
    cliente c ON c.cedulaRUC = f.cedulaRUC;
    
#Mostrar botes ordenados por tamaño
SELECT 
    numSB, marcaBote, modeloBote, eslora
FROM
    bote
ORDER BY eslora DESC;    