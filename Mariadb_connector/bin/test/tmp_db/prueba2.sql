-- MySQL dump 10.13  Distrib 8.0.32, for Linux (x86_64)
--
-- Host: localhost    Database: MariaDB_Ejer1
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.27-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `DEPARTAMENTO`
--

DROP TABLE IF EXISTS `DEPARTAMENTO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `DEPARTAMENTO` (
  `depto_no` int(11) NOT NULL,
  `nombre_depto` varchar(30) NOT NULL,
  `localizacion` varchar(20) NOT NULL,
  PRIMARY KEY (`depto_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DEPARTAMENTO`
--

LOCK TABLES `DEPARTAMENTO` WRITE;
/*!40000 ALTER TABLE `DEPARTAMENTO` DISABLE KEYS */;
INSERT INTO `DEPARTAMENTO` VALUES (0,'',''),(10,'Desarrollo Software','El Coyolar'),(20,'Analisis Sistema','Guadalupe'),(30,'Contabilidad','Subtiava'),(40,'Ventas','San Felipe');
/*!40000 ALTER TABLE `DEPARTAMENTO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `EMPLEADO`
--

DROP TABLE IF EXISTS `EMPLEADO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `EMPLEADO` (
  `codigo_c` varchar(16) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `edad` tinyint(4) NOT NULL,
  `oficio` varchar(20) NOT NULL,
  `dir` varchar(20) NOT NULL,
  `fecha_alt` date NOT NULL,
  `salario` int(11) NOT NULL,
  `comision` int(11) NOT NULL,
  `depto_no` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo_c`),
  KEY `depto_no` (`depto_no`),
  CONSTRAINT `EMPLEADO_ibfk_1` FOREIGN KEY (`depto_no`) REFERENCES `DEPARTAMENTO` (`depto_no`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `EMPLEADO`
--

LOCK TABLES `EMPLEADO` WRITE;
/*!40000 ALTER TABLE `EMPLEADO` DISABLE KEYS */;
INSERT INTO `EMPLEADO` VALUES ('081-130678-0004S','Esquivel José',31,'Director','Juigalpa','1981-06-05',16700,1200,30),('281-040483-0056P','López Hernandez Julio',27,'Analista','Chinandenga','1982-07-14',13000,1500,20),('281-160473-0009Q','Delgado Carmen',37,'Vendedor','Leon','1983-03-02',13400,0,40),('281-160483-0005F','Rocha Vargas Hector',27,'Vendedor','Leon','1983-05-12',12000,0,40),('281-160493-0005F','Castillo Montes Luis',17,'Vendedor','Masaya','1982-08-12',16309,1000,40),('281-161277-0008R','Perez Luis',32,'Empleado','Managua','1980-03-02',16890,0,10),('281-240784-0004Y','Esquivel Leonel Alfonso',26,'Presidente','Nagarote','1981-09-12',15000,0,30);
/*!40000 ALTER TABLE `EMPLEADO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `HISTORICO`
--

DROP TABLE IF EXISTS `HISTORICO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `HISTORICO` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `codigo_c` varchar(16) DEFAULT NULL,
  `depto_no` int(11) DEFAULT NULL,
  `oficio` varchar(20) NOT NULL,
  `fecha_alt` date NOT NULL,
  `fecha_fin` date NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `codigo_c` (`codigo_c`),
  KEY `depto_no` (`depto_no`),
  CONSTRAINT `HISTORICO_ibfk_1` FOREIGN KEY (`codigo_c`) REFERENCES `EMPLEADO` (`codigo_c`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `HISTORICO_ibfk_2` FOREIGN KEY (`depto_no`) REFERENCES `DEPARTAMENTO` (`depto_no`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `HISTORICO`
--

LOCK TABLES `HISTORICO` WRITE;
/*!40000 ALTER TABLE `HISTORICO` DISABLE KEYS */;
INSERT INTO `HISTORICO` VALUES (1,'081-130678-0004S',30,'Director','1981-06-05','1986-02-09'),(2,'281-040483-0056P',20,'Analista','1982-07-14','1984-12-01'),(3,'281-160473-0009Q',40,'Vendedor','1983-03-02','1985-10-15'),(4,'281-160483-0005F',40,'Vendedor','1983-05-12','1985-09-23'),(5,'281-160493-0005F',40,'Vendedor','1982-08-12','1983-03-19'),(6,'281-161277-0008R',10,'Empleado','1980-03-02','1989-08-17'),(7,'281-240784-0004Y',30,'Presidente','1981-09-12','1981-11-23'),(8,'281-160473-0009Q',10,'Empleado','1978-06-10','1983-03-01');
/*!40000 ALTER TABLE `HISTORICO` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-01 16:35:38
