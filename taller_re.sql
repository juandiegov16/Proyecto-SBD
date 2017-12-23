CREATE DATABASE  IF NOT EXISTS `taller_re` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `taller_re`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: taller_re
-- ------------------------------------------------------
-- Server version	5.7.20-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bote`
--

DROP TABLE IF EXISTS `bote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bote` (
  `numSB` int(30) NOT NULL,
  `marcaBote` char(20) NOT NULL,
  `modeloBote` varchar(50) NOT NULL,
  `eslora` int(11) NOT NULL,
  `cedulaRUC` int(13) NOT NULL,
  PRIMARY KEY (`numSB`),
  UNIQUE KEY `numSB` (`numSB`),
  UNIQUE KEY `cedulaRUC` (`cedulaRUC`),
  CONSTRAINT `bote_ibfk_1` FOREIGN KEY (`cedulaRUC`) REFERENCES `cliente` (`cedulaRUC`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bote`
--

LOCK TABLES `bote` WRITE;
/*!40000 ALTER TABLE `bote` DISABLE KEYS */;
INSERT INTO `bote` VALUES (5,'Fusion','Tahoe',25,942135688),(10,'Mercury','Boston',2,968532545),(12,'Yanmar','Whaler',15,998272302),(13,'Clarion','Todomar',36,985455255);
/*!40000 ALTER TABLE `bote` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `cedulaRUC` int(13) NOT NULL,
  `nombreCliente` varchar(50) NOT NULL,
  `direccionCliente` varchar(100) NOT NULL,
  `telefonoCliente` int(20) NOT NULL,
  PRIMARY KEY (`cedulaRUC`),
  UNIQUE KEY `cedulaRUC` (`cedulaRUC`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (935642854,'Andrea Elizaga','Guasmo Sur',935687452),(942135688,'Leonel Tufiño','Alborada 6ta etapa',954545256),(968532545,'Rodrigo Borja','Floresta',915648235),(985455255,'Josefina Rivadeneira','Florida',985721546),(985745854,'Carlos Leon','Mapasingue',975684255),(985784131,'Ana Zurita','Ceibos Norte',991458725),(998272302,'Jorge Andrade','Alborada 6ta etapa',998123490);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facturaservicio`
--

DROP TABLE IF EXISTS `facturaservicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `facturaservicio` (
  `fecha` date NOT NULL,
  `numFactura` int(13) NOT NULL,
  `tipoServicio` char(13) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `valorFactura` decimal(10,0) NOT NULL,
  `formaPago` char(15) NOT NULL,
  `numSR` int(20) NOT NULL,
  `RUCIng` int(13) NOT NULL,
  `numOrden` int(13) NOT NULL,
  `cedulaRUC` int(13) NOT NULL,
  PRIMARY KEY (`numFactura`),
  UNIQUE KEY `numFactura` (`numFactura`),
  UNIQUE KEY `numSR` (`numSR`),
  UNIQUE KEY `RUCIng` (`RUCIng`),
  UNIQUE KEY `numOrden` (`numOrden`),
  UNIQUE KEY `cedulaRUC` (`cedulaRUC`),
  CONSTRAINT `facturaservicio_ibfk_1` FOREIGN KEY (`numOrden`) REFERENCES `ordentrabajo` (`numOrden`),
  CONSTRAINT `facturaservicio_ibfk_2` FOREIGN KEY (`cedulaRUC`) REFERENCES `cliente` (`cedulaRUC`),
  CONSTRAINT `facturaservicio_ibfk_3` FOREIGN KEY (`RUCIng`) REFERENCES `ingeniero` (`RUCIng`),
  CONSTRAINT `facturaservicio_ibfk_4` FOREIGN KEY (`numSR`) REFERENCES `repuesto` (`numSR`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facturaservicio`
--

LOCK TABLES `facturaservicio` WRITE;
/*!40000 ALTER TABLE `facturaservicio` DISABLE KEYS */;
/*!40000 ALTER TABLE `facturaservicio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gasto`
--

DROP TABLE IF EXISTS `gasto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gasto` (
  `idGasto` int(30) NOT NULL,
  `tipoGasto` varchar(30) NOT NULL,
  `valorGasto` decimal(10,0) NOT NULL,
  `fechaGasto` date NOT NULL,
  `RUCIng` int(13) NOT NULL,
  PRIMARY KEY (`idGasto`),
  UNIQUE KEY `RUCIng` (`RUCIng`),
  CONSTRAINT `gasto_ibfk_1` FOREIGN KEY (`RUCIng`) REFERENCES `ingeniero` (`RUCIng`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gasto`
--

LOCK TABLES `gasto` WRITE;
/*!40000 ALTER TABLE `gasto` DISABLE KEYS */;
/*!40000 ALTER TABLE `gasto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingeniero`
--

DROP TABLE IF EXISTS `ingeniero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ingeniero` (
  `RUCIng` int(13) NOT NULL,
  `nombreIng` varchar(50) NOT NULL,
  `direccionIng` varchar(100) NOT NULL,
  `telefono` int(10) NOT NULL,
  PRIMARY KEY (`RUCIng`),
  UNIQUE KEY `RUCIng` (`RUCIng`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingeniero`
--

LOCK TABLES `ingeniero` WRITE;
/*!40000 ALTER TABLE `ingeniero` DISABLE KEYS */;
/*!40000 ALTER TABLE `ingeniero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `motor`
--

DROP TABLE IF EXISTS `motor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `motor` (
  `numSM` int(30) NOT NULL,
  `marcaMotor` char(20) NOT NULL,
  `modeloMotor` varchar(50) NOT NULL,
  `horasOperacion` int(11) DEFAULT NULL,
  `tipoPropulsion` char(20) NOT NULL,
  `numSB` int(30) NOT NULL,
  PRIMARY KEY (`numSM`),
  UNIQUE KEY `numSM` (`numSM`),
  UNIQUE KEY `numSB` (`numSB`),
  CONSTRAINT `motor_ibfk_1` FOREIGN KEY (`numSB`) REFERENCES `bote` (`numSB`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `motor`
--

LOCK TABLES `motor` WRITE;
/*!40000 ALTER TABLE `motor` DISABLE KEYS */;
/*!40000 ALTER TABLE `motor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordentrabajo`
--

DROP TABLE IF EXISTS `ordentrabajo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ordentrabajo` (
  `numOrden` int(13) NOT NULL,
  `fechaOrden` date NOT NULL,
  PRIMARY KEY (`numOrden`),
  UNIQUE KEY `numOrden` (`numOrden`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordentrabajo`
--

LOCK TABLES `ordentrabajo` WRITE;
/*!40000 ALTER TABLE `ordentrabajo` DISABLE KEYS */;
/*!40000 ALTER TABLE `ordentrabajo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `partesutilizadas`
--

DROP TABLE IF EXISTS `partesutilizadas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `partesutilizadas` (
  `numOrden` int(13) NOT NULL,
  `numSR` int(20) NOT NULL,
  PRIMARY KEY (`numOrden`,`numSR`),
  UNIQUE KEY `numOrden` (`numOrden`),
  UNIQUE KEY `numSR` (`numSR`),
  CONSTRAINT `partesutilizadas_ibfk_1` FOREIGN KEY (`numOrden`) REFERENCES `ordentrabajo` (`numOrden`),
  CONSTRAINT `partesutilizadas_ibfk_2` FOREIGN KEY (`numSR`) REFERENCES `repuesto` (`numSR`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partesutilizadas`
--

LOCK TABLES `partesutilizadas` WRITE;
/*!40000 ALTER TABLE `partesutilizadas` DISABLE KEYS */;
/*!40000 ALTER TABLE `partesutilizadas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recibe`
--

DROP TABLE IF EXISTS `recibe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recibe` (
  `numFactura` int(13) NOT NULL,
  `numSB` int(30) NOT NULL,
  PRIMARY KEY (`numFactura`,`numSB`),
  UNIQUE KEY `numFactura` (`numFactura`),
  UNIQUE KEY `numSB` (`numSB`),
  CONSTRAINT `recibe_ibfk_1` FOREIGN KEY (`numFactura`) REFERENCES `facturaservicio` (`numFactura`),
  CONSTRAINT `recibe_ibfk_2` FOREIGN KEY (`numSB`) REFERENCES `bote` (`numSB`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recibe`
--

LOCK TABLES `recibe` WRITE;
/*!40000 ALTER TABLE `recibe` DISABLE KEYS */;
/*!40000 ALTER TABLE `recibe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `repuesto`
--

DROP TABLE IF EXISTS `repuesto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `repuesto` (
  `numSR` int(20) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `descripcion` varchar(60) DEFAULT NULL,
  `valorRep` decimal(10,0) NOT NULL,
  `frecuenciaUso` char(20) NOT NULL,
  `numFactura` int(13) NOT NULL,
  PRIMARY KEY (`numSR`),
  UNIQUE KEY `numSR` (`numSR`),
  UNIQUE KEY `numFactura` (`numFactura`),
  CONSTRAINT `repuesto_ibfk_1` FOREIGN KEY (`numFactura`) REFERENCES `facturaservicio` (`numFactura`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `repuesto`
--

LOCK TABLES `repuesto` WRITE;
/*!40000 ALTER TABLE `repuesto` DISABLE KEYS */;
/*!40000 ALTER TABLE `repuesto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'taller_re'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-23 17:05:29
