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