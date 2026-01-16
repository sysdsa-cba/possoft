-- MySQL dump 10.13  Distrib 5.7.38, for Win64 (x86_64)
--
-- Host: localhost    Database: possoft
-- ------------------------------------------------------
-- Server version	5.7.38-log

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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `id` smallint(6) NOT NULL,
  `codcli` smallint(6) DEFAULT NULL,
  `sexo` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `domicilio` varchar(255) DEFAULT NULL,
  `te` varchar(255) DEFAULT NULL,
  `celular` varchar(255) DEFAULT NULL,
  `tealternativo` varchar(255) DEFAULT NULL,
  `barrio` varchar(255) DEFAULT NULL,
  `provincia` varchar(255) DEFAULT NULL,
  `tipodoc` varchar(255) DEFAULT NULL,
  `codiva` varchar(255) DEFAULT NULL,
  `cuit` varchar(11) DEFAULT NULL,
  `ingbru` varchar(255) DEFAULT NULL,
  `nacimiento` varchar(255) DEFAULT NULL,
  `categoria` varchar(255) DEFAULT NULL,
  `notas` varchar(255) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `codsuc` varchar(255) DEFAULT NULL,
  `vendedor` varchar(80) DEFAULT NULL,
  `saldo` varchar(255) DEFAULT NULL,
  `codpos` varchar(255) DEFAULT NULL,
  `descuento` decimal(10,2) DEFAULT NULL,
  `lista` decimal(10,2) DEFAULT NULL,
  `limcredito` varchar(255) DEFAULT NULL,
  `fechacon` varchar(255) DEFAULT NULL,
  `localidad` varchar(255) DEFAULT NULL,
  `cliente` varchar(255) DEFAULT NULL,
  `fecha_pago` varchar(255) DEFAULT NULL,
  `fecha_vto` varchar(255) DEFAULT NULL,
  `estcivil` varchar(255) DEFAULT NULL,
  `hijos` varchar(255) DEFAULT NULL,
  `fichamedica` varchar(255) DEFAULT NULL,
  `cobertmed` varchar(255) DEFAULT NULL,
  `ddjjmedica` varchar(255) DEFAULT NULL,
  `turno1` varchar(255) DEFAULT NULL,
  `turno2` varchar(255) DEFAULT NULL,
  `turno3` varchar(255) DEFAULT NULL,
  `actividad1` varchar(255) DEFAULT NULL,
  `actividad2` varchar(255) DEFAULT NULL,
  `actividad3` varchar(255) DEFAULT NULL,
  `fechacom` varchar(255) DEFAULT NULL,
  `foto` varchar(255) DEFAULT NULL,
  `ingresos` decimal(10,2) DEFAULT NULL,
  `profe` varchar(255) DEFAULT NULL,
  `fechaing` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,1,'NB','Generico','Av. San Martin',NULL,NULL,NULL,'Centro','Cordoba','1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `codificacion`
--

DROP TABLE IF EXISTS `codificacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `codificacion` (
  `id_codificacion` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_codificacion` varchar(100) DEFAULT NULL,
  `obs` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_codificacion`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `codificacion`
--

LOCK TABLES `codificacion` WRITE;
/*!40000 ALTER TABLE `codificacion` DISABLE KEYS */;
INSERT INTO `codificacion` VALUES (1,'EAN-13',NULL),(2,'EAN-8',NULL),(3,'CODE 128',NULL);
/*!40000 ALTER TABLE `codificacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `familia`
--

DROP TABLE IF EXISTS `familia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `familia` (
  `id_familia` int(11) NOT NULL AUTO_INCREMENT,
  `id_sub_tipo` int(11) NOT NULL,
  `id_tipo` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_familia`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `familia`
--

LOCK TABLES `familia` WRITE;
/*!40000 ALTER TABLE `familia` DISABLE KEYS */;
INSERT INTO `familia` VALUES (1,1,1,'Huevos',NULL);
/*!40000 ALTER TABLE `familia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_venta`
--

DROP TABLE IF EXISTS `item_venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item_venta` (
  `id_item_venta` int(11) NOT NULL AUTO_INCREMENT,
  `id_venta` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `cantidad` decimal(10,2) NOT NULL DEFAULT '0.00',
  `id_lista_precio` int(11) DEFAULT NULL,
  `precio_individual` decimal(10,2) NOT NULL DEFAULT '0.00',
  `importe` decimal(10,2) NOT NULL DEFAULT '0.00',
  PRIMARY KEY (`id_item_venta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_venta`
--

LOCK TABLES `item_venta` WRITE;
/*!40000 ALTER TABLE `item_venta` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_venta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itemventas`
--

DROP TABLE IF EXISTS `itemventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itemventas` (
  `entregado` tinyint(1) NOT NULL DEFAULT '0',
  `fechaentrega` date NOT NULL DEFAULT '2000-01-01',
  `CODSUC` decimal(2,0) NOT NULL,
  `REGISTRO` decimal(8,0) NOT NULL,
  `SOBRE` decimal(10,0) NOT NULL,
  `FECHA_ING` date NOT NULL,
  `FECHA_EGR` date NOT NULL,
  `FECHA_PRO` date NOT NULL,
  `ARTICULO` varchar(20) NOT NULL,
  `NOMBRE` varchar(90) NOT NULL,
  `CANT` decimal(9,2) NOT NULL,
  `PRECIO` decimal(10,3) NOT NULL,
  `LISTA` decimal(1,0) NOT NULL,
  `COSTO` decimal(10,2) NOT NULL,
  `TOTAL` decimal(10,2) NOT NULL,
  `CAJA` decimal(10,0) NOT NULL,
  `DCTO` decimal(7,2) NOT NULL,
  `IMPINT` decimal(11,4) NOT NULL,
  `IVA` decimal(5,2) NOT NULL,
  `REPONE` decimal(10,0) NOT NULL,
  `ITC` decimal(10,4) NOT NULL,
  `TGO` decimal(10,4) NOT NULL,
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PCAJA` decimal(2,0) NOT NULL,
  `RUBRO` varchar(50) NOT NULL,
  `MARCA` varchar(30) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itemventas`
--

LOCK TABLES `itemventas` WRITE;
/*!40000 ALTER TABLE `itemventas` DISABLE KEYS */;
INSERT INTO `itemventas` VALUES (0,'2022-12-14',0,6,0,'2022-12-14','2022-12-14','2022-12-14','4','Mpl.col.chico',1.00,750.000,0,0.00,0.00,0,0.00,0.0000,0.00,0,0.0000,0.0000,1,0,'',''),(0,'2022-12-14',0,7,0,'2022-12-14','2022-12-14','2022-12-14','4','Mpl.col.chico',2.00,800.000,0,0.00,0.00,0,0.00,0.0000,0.00,0,0.0000,0.0000,2,0,'',''),(0,'2022-12-14',0,8,0,'2022-12-14','2022-12-14','2022-12-14','4','Mpl.col.chico',2.00,800.000,0,0.00,0.00,0,0.00,0.0000,0.00,0,0.0000,0.0000,3,0,'',''),(0,'2022-12-14',0,9,0,'2022-12-14','2022-12-14','2022-12-14','4','Mpl.col.chico',2.00,800.000,0,0.00,0.00,0,0.00,0.0000,0.00,0,0.0000,0.0000,4,0,'',''),(0,'2022-12-14',0,10,0,'2022-12-14','2022-12-14','2022-12-14','4','Mpl.col.chico',1.00,750.000,0,0.00,0.00,0,0.00,0.0000,0.00,0,0.0000,0.0000,5,0,'',''),(0,'2022-12-14',0,10,0,'2022-12-14','2022-12-14','2022-12-14','5','Mpl.col.med',1.00,750.000,0,0.00,0.00,0,0.00,0.0000,0.00,0,0.0000,0.0000,6,0,'',''),(0,'2022-12-14',0,10,0,'2022-12-14','2022-12-14','2022-12-14','6','Mpl.col.gran',1.00,750.000,0,0.00,0.00,0,0.00,0.0000,0.00,0,0.0000,0.0000,7,0,'',''),(0,'2022-12-14',0,10,0,'2022-12-14','2022-12-14','2022-12-14','7','Mpl.blan.chico',1.00,750.000,0,0.00,0.00,0,0.00,0.0000,0.00,0,0.0000,0.0000,8,0,'',''),(0,'2022-12-14',0,11,0,'2022-12-14','2022-12-14','2022-12-14','4','Mpl.col.chico',1.00,750.000,0,0.00,0.00,0,0.00,0.0000,0.00,0,0.0000,0.0000,9,0,'',''),(0,'2022-12-14',0,11,0,'2022-12-14','2022-12-14','2022-12-14','7','Mpl.bl.chico',2.00,800.000,0,0.00,0.00,0,0.00,0.0000,0.00,0,0.0000,0.0000,10,0,'',''),(0,'2022-12-14',0,12,0,'2022-12-14','2022-12-14','2022-12-14','4','Mpl.col.chico',1.00,750.000,0,0.00,0.00,0,0.00,0.0000,0.00,0,0.0000,0.0000,11,0,'',''),(0,'2022-12-14',0,12,0,'2022-12-14','2022-12-14','2022-12-14','6','Mpl.col.gran',2.00,800.000,0,0.00,0.00,0,0.00,0.0000,0.00,0,0.0000,0.0000,12,0,'',''),(0,'2022-12-14',0,12,0,'2022-12-14','2022-12-14','2022-12-14','8','Mpl.bl.med',2.00,800.000,0,0.00,0.00,0,0.00,0.0000,0.00,0,0.0000,0.0000,13,0,'',''),(0,'2022-12-14',0,13,0,'2022-12-14','2022-12-14','2022-12-14','4','Mpl.col.chico',1.00,750.000,0,0.00,0.00,0,0.00,0.0000,0.00,0,0.0000,0.0000,14,0,'',''),(0,'2022-12-14',0,13,0,'2022-12-14','2022-12-14','2022-12-14','5','Mpl.col.med',1.00,750.000,0,0.00,0.00,0,0.00,0.0000,0.00,0,0.0000,0.0000,15,0,'',''),(0,'2022-12-14',0,13,0,'2022-12-14','2022-12-14','2022-12-14','6','Mpl.col.gran',2.00,750.000,0,0.00,0.00,0,0.00,0.0000,0.00,0,0.0000,0.0000,16,0,'',''),(0,'2022-12-14',0,13,0,'2022-12-14','2022-12-14','2022-12-14','7','Mpl.bl.chico',1.00,750.000,0,0.00,0.00,0,0.00,0.0000,0.00,0,0.0000,0.0000,17,0,'',''),(0,'2022-12-14',0,13,0,'2022-12-14','2022-12-14','2022-12-14','8','Mpl.bl.med',2.00,750.000,0,0.00,0.00,0,0.00,0.0000,0.00,0,0.0000,0.0000,18,0,'',''),(0,'2022-12-14',0,13,0,'2022-12-14','2022-12-14','2022-12-14','9','Mpl.bl.gran',1.00,750.000,0,0.00,0.00,0,0.00,0.0000,0.00,0,0.0000,0.0000,19,0,'',''),(0,'2022-12-14',0,14,0,'2022-12-14','2022-12-14','2022-12-14','4','Mpl.col.chico',1.00,750.000,0,0.00,0.00,0,0.00,0.0000,0.00,0,0.0000,0.0000,20,0,'',''),(0,'2022-12-14',0,14,0,'2022-12-14','2022-12-14','2022-12-14','6','Mpl.col.gran',1.00,750.000,0,0.00,0.00,0,0.00,0.0000,0.00,0,0.0000,0.0000,21,0,'',''),(0,'2022-12-14',0,14,0,'2022-12-14','2022-12-14','2022-12-14','8','Mpl.bl.med',1.00,750.000,0,0.00,0.00,0,0.00,0.0000,0.00,0,0.0000,0.0000,22,0,'',''),(0,'2022-12-14',0,15,0,'2022-12-14','2022-12-14','2022-12-14','6','Mpl.col.gran',2.00,750.000,0,0.00,0.00,0,0.00,0.0000,0.00,0,0.0000,0.0000,23,0,'',''),(0,'2022-12-14',0,15,0,'2022-12-14','2022-12-14','2022-12-14','8','Mpl.bl.med',2.00,750.000,0,0.00,0.00,0,0.00,0.0000,0.00,0,0.0000,0.0000,24,0,'',''),(0,'2022-12-14',0,16,0,'2022-12-14','2022-12-14','2022-12-14','4','Mpl.col.chico',1.00,750.000,0,0.00,0.00,0,0.00,0.0000,0.00,0,0.0000,0.0000,25,0,'',''),(0,'2022-12-14',0,16,0,'2022-12-14','2022-12-14','2022-12-14','6','Mpl.col.gran',1.00,750.000,0,0.00,0.00,0,0.00,0.0000,0.00,0,0.0000,0.0000,26,0,'',''),(0,'2022-12-14',0,16,0,'2022-12-14','2022-12-14','2022-12-14','8','Mpl.bl.med',1.00,750.000,0,0.00,0.00,0,0.00,0.0000,0.00,0,0.0000,0.0000,27,0,'',''),(0,'2022-12-14',0,17,0,'2022-12-14','2022-12-14','2022-12-14','4','Mpl.col.chico',1.00,750.000,0,0.00,0.00,0,0.00,0.0000,0.00,0,0.0000,0.0000,28,0,'',''),(0,'2022-12-14',0,17,0,'2022-12-14','2022-12-14','2022-12-14','5','Mpl.col.med',1.00,750.000,0,0.00,0.00,0,0.00,0.0000,0.00,0,0.0000,0.0000,29,0,'',''),(0,'2022-12-14',0,17,0,'2022-12-14','2022-12-14','2022-12-14','6','Mpl.col.gran',1.00,750.000,0,0.00,0.00,0,0.00,0.0000,0.00,0,0.0000,0.0000,30,0,'',''),(0,'2022-12-14',0,17,0,'2022-12-14','2022-12-14','2022-12-14','7','Mpl.bl.chico',1.00,750.000,0,0.00,0.00,0,0.00,0.0000,0.00,0,0.0000,0.0000,31,0,'',''),(0,'2022-12-14',0,17,0,'2022-12-14','2022-12-14','2022-12-14','8','Mpl.bl.med',1.00,750.000,0,0.00,0.00,0,0.00,0.0000,0.00,0,0.0000,0.0000,32,0,'',''),(0,'2022-12-14',0,17,0,'2022-12-14','2022-12-14','2022-12-14','9','Mpl.bl.gran',1.00,800.000,0,0.00,0.00,0,0.00,0.0000,0.00,0,0.0000,0.0000,33,0,'',''),(0,'2022-12-14',0,18,0,'2022-12-14','2022-12-14','2022-12-14','4','Mpl.col.chico',3.00,730.000,0,0.00,0.00,0,0.00,0.0000,0.00,0,0.0000,0.0000,34,0,'',''),(0,'2022-12-14',0,19,0,'2022-12-14','2022-12-14','2022-12-14','4','Mpl.col.chico',2.00,730.000,0,0.00,0.00,0,0.00,0.0000,0.00,0,0.0000,0.0000,35,0,'',''),(0,'2022-12-14',0,19,0,'2022-12-14','2022-12-14','2022-12-14','5','Mpl.col.med',1.00,750.000,0,0.00,0.00,0,0.00,0.0000,0.00,0,0.0000,0.0000,36,0,'',''),(0,'2022-12-14',0,20,0,'2022-12-14','2022-12-14','2022-12-14','4','Mpl.col.chico',1.00,750.000,0,0.00,0.00,0,0.00,0.0000,0.00,0,0.0000,0.0000,37,0,'',''),(0,'2022-12-14',0,20,0,'2022-12-14','2022-12-14','2022-12-14','5','Mpl.col.med',1.00,750.000,0,0.00,0.00,0,0.00,0.0000,0.00,0,0.0000,0.0000,38,0,'',''),(0,'2022-12-14',0,20,0,'2022-12-14','2022-12-14','2022-12-14','6','Mpl.col.gran',1.00,750.000,0,0.00,0.00,0,0.00,0.0000,0.00,0,0.0000,0.0000,39,0,'',''),(0,'2022-12-14',0,20,0,'2022-12-14','2022-12-14','2022-12-14','7','Mpl.bl.chico',1.00,750.000,0,0.00,0.00,0,0.00,0.0000,0.00,0,0.0000,0.0000,40,0,'',''),(0,'2022-12-14',0,20,0,'2022-12-14','2022-12-14','2022-12-14','8','Mpl.bl.med',1.00,750.000,0,0.00,0.00,0,0.00,0.0000,0.00,0,0.0000,0.0000,41,0,'',''),(0,'2022-12-14',0,20,0,'2022-12-14','2022-12-14','2022-12-14','9','Mpl.bl.gran',2.00,800.000,0,0.00,0.00,0,0.00,0.0000,0.00,0,0.0000,0.0000,42,0,'','');
/*!40000 ALTER TABLE `itemventas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `linea`
--

DROP TABLE IF EXISTS `linea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `linea` (
  `id_linea` int(11) NOT NULL AUTO_INCREMENT,
  `id_familia` int(11) NOT NULL,
  `id_sub_tipo` int(11) NOT NULL,
  `id_tipo` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_linea`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `linea`
--

LOCK TABLES `linea` WRITE;
/*!40000 ALTER TABLE `linea` DISABLE KEYS */;
INSERT INTO `linea` VALUES (1,1,1,1,'Blancos',NULL);
/*!40000 ALTER TABLE `linea` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lista_precios`
--

DROP TABLE IF EXISTS `lista_precios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lista_precios` (
  `id_lista_precios` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `fecha_inicio_vigencia` date NOT NULL,
  `fecha_fin_vigencia` varchar(100) NOT NULL,
  `activa` tinyint(1) NOT NULL DEFAULT '1',
  `fecha_ultima_actualizacion` date NOT NULL DEFAULT '2022-11-15',
  PRIMARY KEY (`id_lista_precios`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lista_precios`
--

LOCK TABLES `lista_precios` WRITE;
/*!40000 ALTER TABLE `lista_precios` DISABLE KEYS */;
INSERT INTO `lista_precios` VALUES (1,'Lista 1','2022-01-01','2025-12-31',1,'2022-11-15'),(2,'Lista 2','2022-01-01','2025-12-31',1,'2022-11-15'),(3,'Lista 3','2022-01-01','2025-12-31',1,'2022-11-15');
/*!40000 ALTER TABLE `lista_precios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `precios`
--

DROP TABLE IF EXISTS `precios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `precios` (
  `id_precio` int(11) NOT NULL AUTO_INCREMENT,
  `id_lista_precio` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `precio` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_precio`),
  KEY `precios_FK` (`id_lista_precio`),
  KEY `precios_FK_1` (`id_producto`),
  CONSTRAINT `precios_FK` FOREIGN KEY (`id_lista_precio`) REFERENCES `lista_precios` (`id_lista_precios`),
  CONSTRAINT `precios_FK_1` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id_producto`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `precios`
--

LOCK TABLES `precios` WRITE;
/*!40000 ALTER TABLE `precios` DISABLE KEYS */;
INSERT INTO `precios` VALUES (1,1,1,750),(2,1,2,150),(3,1,3,700),(4,2,1,800),(5,2,2,100),(6,2,3,730),(7,3,1,800),(8,3,2,200),(9,3,3,900),(10,1,4,730),(11,2,4,750),(12,3,4,800),(13,1,5,750),(14,2,5,700),(15,3,5,850),(16,1,6,750),(17,2,6,800),(18,3,6,850),(19,1,7,750),(20,2,7,800),(21,3,7,850),(22,1,8,750),(23,2,8,800),(24,3,8,850),(25,1,9,750),(26,2,9,800),(27,3,9,850);
/*!40000 ALTER TABLE `precios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producto` (
  `id_producto` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(20) DEFAULT NULL,
  `cod_barras` varchar(20) DEFAULT NULL,
  `nombre` varchar(150) DEFAULT NULL,
  `marca` varchar(20) DEFAULT NULL,
  `descripcion` varchar(250) DEFAULT NULL,
  `alicuota` decimal(8,2) DEFAULT NULL,
  `proveedor` varchar(40) DEFAULT NULL,
  `tipo` int(11) DEFAULT NULL,
  `subtipo` int(11) DEFAULT NULL,
  `familia` varchar(100) DEFAULT NULL,
  `linea` varchar(100) DEFAULT NULL,
  `unidad` int(11) NOT NULL DEFAULT '1',
  `cantidad` decimal(10,2) NOT NULL DEFAULT '1.00',
  `id_codificacion` int(11) NOT NULL DEFAULT '1',
  `activo` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id_producto`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,'M_BLANCO','7795','Maple de huevos blancos','Propio','',0.00,'1',1,1,'Huevos','Blancos',1,1.00,1,0),(2,'D_KEVIN_250','7791600037345','Desodorante Kevin 250lm','KEVIN','---',0.00,'1',3,1,'Desodorantes','Aerosol',2,250.00,1,0),(3,'ENCENDEDOR','7790129100158','Encendedor','FUEGOLANDIA','Encendedor',0.00,'1',9,9,'Encendedores','Rojo',1,1.00,1,0),(4,'CO_CHI','7795','Mpl.col.chico','Propio','Maple huevos color chico',0.00,'1',1,1,'Color','Chico',1,1.00,1,1),(5,'CO_MED','7795','Mpl.col.med','Propio','Maple huevos color mediano',0.00,'1',1,1,'Color','Mediano',1,1.00,1,1),(6,'CO_GRA','7795','Mpl.col.gran','Propio','Maple huevos color grande',0.00,'1',1,1,'Color','Grande',1,1.00,1,1),(7,'BL_CHI','7795','Mpl.bl.chico','Propio','Maple huevos blancos chico',0.00,'1',1,1,'Blancos','Chico',1,1.00,1,1),(8,'BL_MED','7795','Mpl.bl.med','Propio','Maple huevos blancos mediano',0.00,'1',1,1,'Blancos','Mediano',1,1.00,1,1),(9,'BL_GRA','7795','Mpl.bl.gran','Propio','Maple huevos blancos grande',0.00,'1',1,1,'Blancos','Grande',1,1.00,1,1);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registro_actual`
--

DROP TABLE IF EXISTS `registro_actual`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registro_actual` (
  `registro_actual` int(11) DEFAULT NULL,
  `operacion` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registro_actual`
--

LOCK TABLES `registro_actual` WRITE;
/*!40000 ALTER TABLE `registro_actual` DISABLE KEYS */;
INSERT INTO `registro_actual` VALUES (20,1);
/*!40000 ALTER TABLE `registro_actual` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock`
--

DROP TABLE IF EXISTS `stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stock` (
  `id_stock` int(11) NOT NULL AUTO_INCREMENT,
  `id_producto` int(11) NOT NULL,
  `stock_inicial` double NOT NULL DEFAULT '0',
  `stock_actual` double NOT NULL DEFAULT '0',
  `stock_minimo` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_stock`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock`
--

LOCK TABLES `stock` WRITE;
/*!40000 ALTER TABLE `stock` DISABLE KEYS */;
INSERT INTO `stock` VALUES (1,1,0,0,10),(2,2,0,0,10),(3,3,0,0,10),(4,4,0,8,10),(5,5,0,6,10),(6,6,0,7,10),(7,7,0,12,10),(8,8,0,5,10),(9,9,0,15,10);
/*!40000 ALTER TABLE `stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock_mov`
--

DROP TABLE IF EXISTS `stock_mov`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stock_mov` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_producto` int(11) NOT NULL,
  `cantidad` double NOT NULL DEFAULT '0',
  `fecha` date NOT NULL DEFAULT '2022-01-01',
  `hora` time NOT NULL DEFAULT '00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock_mov`
--

LOCK TABLES `stock_mov` WRITE;
/*!40000 ALTER TABLE `stock_mov` DISABLE KEYS */;
INSERT INTO `stock_mov` VALUES (1,1,2,'2022-01-01','00:00:00'),(2,7,2,'2022-12-14','18:56:00'),(3,9,2,'2022-12-14','18:56:00'),(4,8,2,'2022-12-14','18:56:00'),(5,4,2,'2022-12-14','18:56:00'),(6,6,2,'2022-12-14','18:56:00'),(7,5,2,'2022-12-14','18:56:00'),(8,7,10,'2022-12-14','19:09:00'),(9,7,-16,'2022-12-14','19:09:00'),(10,9,10,'2022-12-14','19:09:00'),(11,9,-38,'2022-12-14','19:09:00'),(12,8,10,'2022-12-14','19:09:00'),(13,8,-27,'2022-12-14','19:09:00'),(14,4,10,'2022-12-14','19:09:00'),(15,4,-24,'2022-12-14','19:09:00'),(16,6,10,'2022-12-14','19:09:00'),(17,6,-29,'2022-12-14','19:09:00'),(18,5,10,'2022-12-14','19:09:00'),(19,5,-21,'2022-12-14','19:09:00'),(20,7,12,'2022-12-14','19:10:00'),(21,7,-10,'2022-12-14','19:10:00'),(22,9,15,'2022-12-14','19:10:00'),(23,9,-10,'2022-12-14','19:10:00'),(24,8,5,'2022-12-14','19:10:00'),(25,8,-10,'2022-12-14','19:10:00'),(26,4,8,'2022-12-14','19:10:00'),(27,4,-10,'2022-12-14','19:10:00'),(28,6,7,'2022-12-14','19:10:00'),(29,6,-10,'2022-12-14','19:10:00'),(30,5,6,'2022-12-14','19:10:00'),(31,5,-10,'2022-12-14','19:10:00');
/*!40000 ALTER TABLE `stock_mov` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sub_tipo`
--

DROP TABLE IF EXISTS `sub_tipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sub_tipo` (
  `id_sub_tipo` int(11) NOT NULL AUTO_INCREMENT,
  `id_tipo` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_sub_tipo`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sub_tipo`
--

LOCK TABLES `sub_tipo` WRITE;
/*!40000 ALTER TABLE `sub_tipo` DISABLE KEYS */;
INSERT INTO `sub_tipo` VALUES (1,1,'Granja','Granja'),(2,3,'Cosmética y personal',NULL),(9,9,'Varios','Varios');
/*!40000 ALTER TABLE `sub_tipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo`
--

DROP TABLE IF EXISTS `tipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo` (
  `id_tipo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_tipo`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo`
--

LOCK TABLES `tipo` WRITE;
/*!40000 ALTER TABLE `tipo` DISABLE KEYS */;
INSERT INTO `tipo` VALUES (1,'ALIMENTOS',NULL),(2,'LIMPIEZA',NULL),(3,'HIGIENE',NULL),(4,'BEBIDAS',NULL),(5,'BEBIDAS ALCOHOLICAS',NULL),(6,'---',NULL),(7,'---',NULL),(8,'---',NULL),(9,'VARIOS',NULL);
/*!40000 ALTER TABLE `tipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_pago`
--

DROP TABLE IF EXISTS `tipo_pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_pago` (
  `id_tipo_pago` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `descripcion` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`id_tipo_pago`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_pago`
--

LOCK TABLES `tipo_pago` WRITE;
/*!40000 ALTER TABLE `tipo_pago` DISABLE KEYS */;
INSERT INTO `tipo_pago` VALUES (1,'Contado',''),(2,'Mercado Pago',''),(3,'Débito',''),(4,'Crédito',''),(5,'Transferencia',''),(6,'Otro','');
/*!40000 ALTER TABLE `tipo_pago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turno`
--

DROP TABLE IF EXISTS `turno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `turno` (
  `id_turno` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`id_turno`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turno`
--

LOCK TABLES `turno` WRITE;
/*!40000 ALTER TABLE `turno` DISABLE KEYS */;
INSERT INTO `turno` VALUES (1,'Mañana'),(2,'Tarde');
/*!40000 ALTER TABLE `turno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unidad`
--

DROP TABLE IF EXISTS `unidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `unidad` (
  `id_unidad` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_unidad` varchar(100) NOT NULL,
  `abbrev` varchar(100) DEFAULT NULL,
  `info` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_unidad`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unidad`
--

LOCK TABLES `unidad` WRITE;
/*!40000 ALTER TABLE `unidad` DISABLE KEYS */;
INSERT INTO `unidad` VALUES (1,'Unidades','unid',''),(2,'Mililitros','ml',NULL);
/*!40000 ALTER TABLE `unidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta`
--

DROP TABLE IF EXISTS `venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `venta` (
  `id_venta` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL DEFAULT '2022-01-01',
  `hora` time NOT NULL DEFAULT '12:00:00',
  `id_turno` int(11) NOT NULL DEFAULT '1',
  `cliente` int(11) NOT NULL DEFAULT '1',
  `importe` decimal(10,2) NOT NULL DEFAULT '0.00',
  `nro_venta` int(11) NOT NULL,
  `nro_factura` varchar(100) DEFAULT NULL,
  `id_vendedor` int(11) NOT NULL DEFAULT '1',
  `tipo_pago` int(11) NOT NULL DEFAULT '1',
  `descuento` decimal(10,2) NOT NULL DEFAULT '0.00',
  PRIMARY KEY (`id_venta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta`
--

LOCK TABLES `venta` WRITE;
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ventas`
--

DROP TABLE IF EXISTS `ventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ventas` (
  `CODSUC` decimal(4,0) DEFAULT NULL,
  `REGISTRO` int(11) NOT NULL AUTO_INCREMENT,
  `FACTURA` decimal(8,0) DEFAULT NULL,
  `FECHA` date DEFAULT NULL,
  `hora` time DEFAULT NULL,
  `TIPOCOMP` varchar(1) DEFAULT NULL,
  `TIPOCOMPF` decimal(2,0) DEFAULT NULL,
  `CLIENTE` int(11) DEFAULT NULL,
  `NOMBRE` varchar(50) DEFAULT NULL,
  `CODIVA` varchar(21) DEFAULT NULL,
  `cuit` varchar(11) DEFAULT NULL,
  `INGBRU` varchar(15) DEFAULT NULL,
  `NETO21` decimal(9,2) DEFAULT NULL,
  `NETO105` decimal(9,2) DEFAULT NULL,
  `IVA21` decimal(9,2) DEFAULT NULL,
  `IVA105` decimal(9,2) DEFAULT NULL,
  `EXENTO` decimal(9,2) DEFAULT NULL,
  `TOTAL` decimal(11,2) DEFAULT NULL,
  `VENDEDOR` varchar(40) DEFAULT NULL,
  `DCTOSEÑA` decimal(11,2) DEFAULT NULL,
  `CAJA` decimal(10,2) DEFAULT NULL,
  `CTACTE` decimal(9,2) DEFAULT NULL,
  `ITC` decimal(10,4) DEFAULT NULL,
  `TGO` decimal(10,4) DEFAULT NULL,
  `IMPINT` decimal(10,4) DEFAULT NULL,
  `PCAJA` decimal(2,0) DEFAULT NULL,
  `CAE` varchar(30) DEFAULT NULL,
  `FVCAE` varchar(30) DEFAULT NULL,
  `RECTARJETA` decimal(10,2) DEFAULT NULL,
  `DTOGRAL` decimal(10,2) DEFAULT NULL,
  `FECHAVTO` date DEFAULT NULL,
  `NOTAS` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`REGISTRO`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ventas`
--

LOCK TABLES `ventas` WRITE;
/*!40000 ALTER TABLE `ventas` DISABLE KEYS */;
INSERT INTO `ventas` VALUES (1,1,1,'2022-01-01','00:00:00',NULL,NULL,1,'Generico',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(0,2,0,'2022-12-14','12:39:00','',0,0,'','','','',0.00,0.00,0.00,0.00,0.00,750.00,'',0.00,0.00,0.00,0.0000,0.0000,0.0000,0,'','',0.00,0.00,'2022-12-14',''),(0,3,0,'2022-12-14','12:51:00','',0,1,'','','','',0.00,0.00,0.00,0.00,0.00,4650.00,'',0.00,0.00,0.00,0.0000,0.0000,0.0000,0,'','',0.00,0.00,'2022-12-14',''),(0,4,0,'2022-12-14','12:52:00','',0,1,'','','','',0.00,0.00,0.00,0.00,0.00,750.00,'',0.00,0.00,0.00,0.0000,0.0000,0.0000,0,'','',0.00,0.00,'2022-12-14',''),(0,5,0,'2022-12-14','12:52:00','',0,1,'','','','',0.00,0.00,0.00,0.00,0.00,750.00,'',0.00,0.00,0.00,0.0000,0.0000,0.0000,0,'','',0.00,0.00,'2022-12-14',''),(0,6,0,'2022-12-14','12:53:00','',0,1,'','','','',0.00,0.00,0.00,0.00,0.00,750.00,'',0.00,0.00,0.00,0.0000,0.0000,0.0000,0,'','',0.00,0.00,'2022-12-14',''),(0,7,0,'2022-12-14','13:09:00','',0,1,'','','','',0.00,0.00,0.00,0.00,0.00,1600.00,'',0.00,0.00,0.00,0.0000,0.0000,0.0000,0,'','',0.00,0.00,'2022-12-14',''),(0,8,0,'2022-12-14','13:10:00','',0,1,'','','','',0.00,0.00,0.00,0.00,0.00,1600.00,'',0.00,0.00,0.00,0.0000,0.0000,0.0000,0,'','',0.00,0.00,'2022-12-14',''),(0,9,0,'2022-12-14','13:10:00','',0,1,'','','','',0.00,0.00,0.00,0.00,0.00,1600.00,'',0.00,0.00,0.00,0.0000,0.0000,0.0000,0,'','',0.00,0.00,'2022-12-14',''),(0,10,0,'2022-12-14','13:27:00','',0,1,'','','','',0.00,0.00,0.00,0.00,0.00,3000.00,'',0.00,0.00,0.00,0.0000,0.0000,0.0000,0,'','',0.00,0.00,'2022-12-14',''),(0,11,0,'2022-12-14','13:35:00','',0,1,'','','','',0.00,0.00,0.00,0.00,0.00,2350.00,'',0.00,0.00,0.00,0.0000,0.0000,0.0000,0,'','',0.00,0.00,'2022-12-14',''),(0,12,0,'2022-12-14','18:04:00','',0,1,'','','','',0.00,0.00,0.00,0.00,0.00,3950.00,'',0.00,0.00,0.00,0.0000,0.0000,0.0000,0,'','',0.00,0.00,'2022-12-14',''),(0,13,0,'2022-12-14','18:07:00','',0,1,'','','','',0.00,0.00,0.00,0.00,0.00,6000.00,'',0.00,0.00,0.00,0.0000,0.0000,0.0000,0,'','',0.00,0.00,'2022-12-14',''),(0,14,0,'2022-12-14','18:10:00','',0,1,'','','','',0.00,0.00,0.00,0.00,0.00,2250.00,'',0.00,0.00,0.00,0.0000,0.0000,0.0000,0,'','',0.00,0.00,'2022-12-14',''),(0,15,0,'2022-12-14','18:20:00','',0,1,'','','','',0.00,0.00,0.00,0.00,0.00,3000.00,'',0.00,0.00,0.00,0.0000,0.0000,0.0000,0,'','',0.00,0.00,'2022-12-14',''),(0,16,0,'2022-12-14','18:22:00','',0,1,'','','','',0.00,0.00,0.00,0.00,0.00,2250.00,'',0.00,0.00,0.00,0.0000,0.0000,0.0000,0,'','',0.00,0.00,'2022-12-14',''),(0,17,0,'2022-12-14','18:28:00','',0,1,'','','','',0.00,0.00,0.00,0.00,0.00,4550.00,'',0.00,0.00,0.00,0.0000,0.0000,0.0000,0,'','',0.00,0.00,'2022-12-14',''),(0,18,0,'2022-12-14','20:58:00','',0,1,'','','','',0.00,0.00,0.00,0.00,0.00,2190.00,'',0.00,0.00,0.00,0.0000,0.0000,0.0000,0,'','',0.00,0.00,'2022-12-14',''),(0,19,0,'2022-12-14','20:58:00','',0,1,'','','','',0.00,0.00,0.00,0.00,0.00,2210.00,'',0.00,0.00,0.00,0.0000,0.0000,0.0000,0,'','',0.00,0.00,'2022-12-14',''),(0,20,0,'2022-12-14','21:11:00','',0,1,'','','','',0.00,0.00,0.00,0.00,0.00,5350.00,'',0.00,0.00,0.00,0.0000,0.0000,0.0000,0,'','',0.00,0.00,'2022-12-14','');
/*!40000 ALTER TABLE `ventas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'possoft'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-15  1:27:05
