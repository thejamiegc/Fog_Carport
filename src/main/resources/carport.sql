CREATE DATABASE  IF NOT EXISTS `carport` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `carport`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 164.90.177.110    Database: carport
-- ------------------------------------------------------
-- Server version	8.0.31-0ubuntu0.20.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Bom`
--

DROP TABLE IF EXISTS `Bom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Bom` (
  `bomID` int NOT NULL AUTO_INCREMENT,
  `orderID` int NOT NULL,
  `materialID` int NOT NULL,
  PRIMARY KEY (`bomID`),
  KEY `fk_Bom_Order1_idx` (`orderID`),
  KEY `fk_Bom_Material1_idx` (`materialID`),
  CONSTRAINT `fk_Bom_Material1` FOREIGN KEY (`materialID`) REFERENCES `Material` (`materialID`),
  CONSTRAINT `fk_Bom_Order1` FOREIGN KEY (`orderID`) REFERENCES `Order` (`orderID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Bom`
--

LOCK TABLES `Bom` WRITE;
/*!40000 ALTER TABLE `Bom` DISABLE KEYS */;
/*!40000 ALTER TABLE `Bom` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Carport`
--

DROP TABLE IF EXISTS `Carport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Carport` (
  `carportID` int NOT NULL AUTO_INCREMENT,
  `length` int NOT NULL,
  `width` int NOT NULL,
  `rooftype` varchar(45) NOT NULL,
  `shed` int NOT NULL,
  PRIMARY KEY (`carportID`),
  KEY `fk_Carport_Shed1_idx` (`shed`),
  CONSTRAINT `fk_Carport_Shed1` FOREIGN KEY (`shed`) REFERENCES `Shed` (`shed`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Carport`
--

LOCK TABLES `Carport` WRITE;
/*!40000 ALTER TABLE `Carport` DISABLE KEYS */;
/*!40000 ALTER TABLE `Carport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Customer`
--

DROP TABLE IF EXISTS `Customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Customer` (
  `customerID` int NOT NULL AUTO_INCREMENT,
  `firstname` varchar(46) NOT NULL,
  `lastname` varchar(46) NOT NULL,
  `email` varchar(320) NOT NULL,
  `password` varchar(120) NOT NULL,
  `address` varchar(95) NOT NULL,
  `postalcode` int NOT NULL,
  `phonenumber` int NOT NULL,
  `role` varchar(5) NOT NULL,
  PRIMARY KEY (`customerID`),
  KEY `fk_Customer_Postalcode_idx` (`postalcode`),
  CONSTRAINT `fk_Customer_Postalcode` FOREIGN KEY (`postalcode`) REFERENCES `Postalcode` (`postalcode`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Customer`
--

LOCK TABLES `Customer` WRITE;
/*!40000 ALTER TABLE `Customer` DISABLE KEYS */;
INSERT INTO `Customer` VALUES (11,'Peter','Hans-Pedersen','phans@sol.dk','123','Kanalvej 7',2800,69696969,'user'),(12,'Hjalmer','Træben','piratHT@hotmail.dk','321','kaas allé 29',2900,69696968,'user'),(13,'Lise','Sørensøn','lavmenkærlig@gmail.dk','1233','Søvej 10b, th',3000,11211222,'user'),(14,'Kirsten','Damgård','grønnefingre@sol.dk','1232','Stengade 12b',3000,12222222,'user'),(15,'Kaj','frömann','popkorn@haps.dk','1233','Århusjyllandsvej 32A',8210,77272727,'user');
/*!40000 ALTER TABLE `Customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Employee`
--

DROP TABLE IF EXISTS `Employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Employee` (
  `employeeID` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(120) NOT NULL,
  `role` varchar(5) NOT NULL,
  PRIMARY KEY (`employeeID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Employee`
--

LOCK TABLES `Employee` WRITE;
/*!40000 ALTER TABLE `Employee` DISABLE KEYS */;
INSERT INTO `Employee` VALUES (1,'JohnHackermann','kode','admin'),(2,'Uella','password','CEO');
/*!40000 ALTER TABLE `Employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Material`
--

DROP TABLE IF EXISTS `Material`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Material` (
  `materialID` int NOT NULL AUTO_INCREMENT,
  `description` varchar(95) NOT NULL,
  `length` int NOT NULL,
  `quantity` int NOT NULL,
  `unit` varchar(45) NOT NULL,
  `itemdescription` varchar(95) NOT NULL,
  `quantityprice` double NOT NULL,
  `totalprice` double NOT NULL,
  PRIMARY KEY (`materialID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Material`
--

LOCK TABLES `Material` WRITE;
/*!40000 ALTER TABLE `Material` DISABLE KEYS */;
/*!40000 ALTER TABLE `Material` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Order`
--

DROP TABLE IF EXISTS `Order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Order` (
  `orderID` int NOT NULL AUTO_INCREMENT,
  `employeeID` int NOT NULL,
  `customerID` int NOT NULL,
  `created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `carportID` int NOT NULL,
  `price` double NOT NULL,
  `statusID` int NOT NULL,
  `bom` varchar(45) NOT NULL,
  PRIMARY KEY (`orderID`),
  KEY `fk_Order_Carport1_idx` (`carportID`),
  KEY `fk_Order_Customer1_idx` (`customerID`),
  KEY `fk_Order_Status1_idx` (`statusID`),
  KEY `fk_Order_Employee1_idx` (`employeeID`),
  CONSTRAINT `fk_Order_Carport1` FOREIGN KEY (`carportID`) REFERENCES `Carport` (`carportID`),
  CONSTRAINT `fk_Order_Customer1` FOREIGN KEY (`customerID`) REFERENCES `Customer` (`customerID`),
  CONSTRAINT `fk_Order_Employee1` FOREIGN KEY (`employeeID`) REFERENCES `Employee` (`employeeID`),
  CONSTRAINT `fk_Order_Status1` FOREIGN KEY (`statusID`) REFERENCES `Status` (`statusID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Order`
--

LOCK TABLES `Order` WRITE;
/*!40000 ALTER TABLE `Order` DISABLE KEYS */;
/*!40000 ALTER TABLE `Order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Postalcode`
--

DROP TABLE IF EXISTS `Postalcode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Postalcode` (
  `postalcode` int NOT NULL,
  `city` varchar(95) NOT NULL,
  PRIMARY KEY (`postalcode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Postalcode`
--

LOCK TABLES `Postalcode` WRITE;
/*!40000 ALTER TABLE `Postalcode` DISABLE KEYS */;
INSERT INTO `Postalcode` VALUES (2800,'Kongens Lyngby'),(2900,'Hellerup'),(3000,'Helsingør'),(8210,'Aarhus v');
/*!40000 ALTER TABLE `Postalcode` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Shed`
--

DROP TABLE IF EXISTS `Shed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Shed` (
  `shed` int NOT NULL AUTO_INCREMENT,
  `length` int NOT NULL,
  `width` int NOT NULL,
  PRIMARY KEY (`shed`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Shed`
--

LOCK TABLES `Shed` WRITE;
/*!40000 ALTER TABLE `Shed` DISABLE KEYS */;
/*!40000 ALTER TABLE `Shed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Status`
--

DROP TABLE IF EXISTS `Status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Status` (
  `statusID` int NOT NULL,
  `statusname` varchar(45) NOT NULL,
  PRIMARY KEY (`statusID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Status`
--

LOCK TABLES `Status` WRITE;
/*!40000 ALTER TABLE `Status` DISABLE KEYS */;
/*!40000 ALTER TABLE `Status` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-01 14:26:46
