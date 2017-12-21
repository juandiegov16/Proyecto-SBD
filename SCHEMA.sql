set foreign_key_checks=0;

drop table if exists Ingeniero;

CREATE TABLE IF NOT EXISTS Ingeniero (
    RUCIng CHAR(13) NOT NULL,
    nombreIng VARCHAR(50) NOT NULL,
    direccionIng VARCHAR(100) NOT NULL,
    telefono CHAR(10) NOT NULL,
    PRIMARY KEY (RUCIng)
);

drop table if exists Gasto;
    
CREATE TABLE IF NOT EXISTS Gasto (
    idGasto VARCHAR(30) NOT NULL,
    tipoGasto VARCHAR(30) NOT NULL,
    CHECK (tipoGasto IN (ArriendoLocal , SalarioAsistentes,
        HonorariosContador,
        AportesIESS,
        Combustible,
        InsumosRepuestos,
        MantenimientoVehículo,
        Alimentación,
        Varios)),
    valorGasto NUMERIC NOT NULL,
    fechaGasto DATE NOT NULL,
    RUCIng CHAR(13) NOT NULL,
    FOREIGN KEY (RUCIng)
        REFERENCES Ingeniero (RUCIng),
    PRIMARY KEY (idGasto)
);

drop table if exists Cliente;
    
CREATE TABLE IF NOT EXISTS Cliente (
    cedulaRUC CHAR(13) NOT NULL,
    nombreCliente VARCHAR(50) NOT NULL,
    direccionCliente VARCHAR(100) NOT NULL,
    telefonoCliente CHAR(20) NOT NULL,
    primary key (cedulaRUC)
);
    
drop table if exists OrdenTrabajo;
    
CREATE TABLE IF NOT EXISTS OrdenTrabajo (
    numOrden CHAR(13) NOT NULL,
    fechaOrden DATE NOT NULL,
    PRIMARY KEY (numOrden)
);
    
drop table if exists FacturaServicio;
    
CREATE TABLE IF NOT EXISTS FacturaServicio (
    fecha DATE NOT NULL,
    numFactura CHAR(13) NOT NULL,
    tipoServicio CHAR(13) NOT NULL,
    CHECK (tipoServicio IN (Instalación , Reparación, Mantenimiento, Venta)),
    descripcion VARCHAR(100) NOT NULL,
    valorFactura NUMERIC NOT NULL,
    formaPago CHAR(15) NOT NULL,
    CHECK (formaPago IN (Efectivo , Cheque)),
    numSR CHAR(20) NOT NULL,
    RUCIng CHAR(13) NOT NULL,
    numOrden CHAR(13) NOT NULL,
    cedulaRUC CHAR(13) NOT NULL,
    PRIMARY KEY (numFactura),
    FOREIGN KEY (numOrden)
        REFERENCES OrdenTrabajo (numOrden),
    FOREIGN KEY (cedulaRUC)
        REFERENCES Cliente (cedulaRUC),
    FOREIGN KEY (RUCIng)
        REFERENCES Ingeniero (RUCIng),
    FOREIGN KEY (numSR)
        REFERENCES Repuesto (numSR)
);
    
drop table if exists PartesUtilizadas;
    
CREATE TABLE IF NOT EXISTS PartesUtilizadas (
    numOrden CHAR(13) NOT NULL,
    numSR CHAR(20) NOT NULL,
    FOREIGN KEY (numOrden)
        REFERENCES OrdenTrabajo (numOrden),
    FOREIGN KEY (numSR)
        REFERENCES Repuesto (numSR),
    PRIMARY KEY (numOrden, numSR)
);
    
drop table if exists Repuesto;
    
CREATE TABLE IF NOT EXISTS Repuesto (
    numSR CHAR(20) NOT NULL,
    cantidad INTEGER NOT NULL,
    descripcion VARCHAR(60),
    valorRep NUMERIC NOT NULL,
    frecuenciaUso CHAR(20) NOT NULL,
    CHECK (frecuenciaUso IN (Raro , Ocasional, Regular, Frecuente)),
    numFactura CHAR(13) NOT NULL,
    PRIMARY KEY (numSR),
    FOREIGN KEY (numFactura)
        REFERENCES FacturaServicio (numFactura)
);
    
drop table if exists Recibe;
    
CREATE TABLE IF NOT EXISTS Recibe (
    numFactura CHAR(13) NOT NULL,
    numSB VARCHAR(30) NOT NULL,
    FOREIGN KEY (numFactura)
        REFERENCES FacturaServicio (numFactura),
    FOREIGN KEY (numSB)
        REFERENCES Bote (numSB),
	PRIMARY KEY (numFactura, numSB)
);
    
drop table if exists Bote;    
    
CREATE TABLE IF NOT EXISTS Bote (
    numSB VARCHAR(30) NOT NULL,
    marcaBote CHAR(20) NOT NULL,
    modeloBote VARCHAR(50) NOT NULL,
    eslora INTEGER NOT NULL,
    cedulaRUC CHAR(13) NOT NULL,
    PRIMARY KEY (numSB),
    FOREIGN KEY (cedulaRUC)
        REFERENCES Cliente (cedulaRUC)
);
	
drop table if exists Motor;

CREATE TABLE IF NOT EXISTS Motor (
    numSM VARCHAR(30) NOT NULL,
    marcaMotor CHAR(20) NOT NULL,
    modeloMotor VARCHAR(50) NOT NULL,
    horasOperacion INTEGER,
    tipoPropulsion CHAR(20) NOT NULL,
    numSB VARCHAR(30) NOT NULL,
    CHECK (tipoPropulsion IN (FueraDeBorda , DentroFuera, Interno, Turbina)),
    PRIMARY KEY (numSM),
    FOREIGN KEY (numSB)
        REFERENCES Bote (numSB)
);
	
    
