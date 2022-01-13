-- MySQL dump 10.13  Distrib 8.0.19, for macos10.15 (x86_64)
--
-- Host: 127.0.0.1    Database: thu_excursion_v5
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `excursion`
--

DROP TABLE IF EXISTS `excursion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `excursion` (
  `idExcursion` int NOT NULL AUTO_INCREMENT,
  `Description` varchar(500) DEFAULT NULL,
  `MaxParticipants` int DEFAULT NULL,
  `RegDeadline` date DEFAULT NULL,
  `DeregDeadline` date DEFAULT NULL,
  `MeetingDetails` varchar(255) DEFAULT NULL,
  `Title` varchar(45) DEFAULT NULL,
  `RequestedBy` int DEFAULT NULL,
  `date_of_excursion` date DEFAULT NULL,
  `destination` varchar(45) DEFAULT NULL,
  `excursion_fee` double DEFAULT '0',
  `dateadded` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idExcursion`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `excursion`
--

LOCK TABLES `excursion` WRITE;
/*!40000 ALTER TABLE `excursion` DISABLE KEYS */;
INSERT INTO `excursion` VALUES (12,'Neuschwanstein Castle and Linderhof Palace Day Tour from Munich',25,'2021-01-15','2021-01-30','Ulm HBF','Neuschwanstein Castle and Linderhof Palace',1,'2021-02-02','Munich',25,'2020-12-31 23:00:00'),(13,'Exclusive and Unique Romantic Road Tour from Munich to Rothenberg',25,'2021-08-15','2021-08-30','Ulm HBF','Romantic Road in Rothenberg',1,'2021-09-04','Rothenberg',40,'2021-07-31 22:00:00'),(14,'Private Scenic Transfer from Frankfurt to Munich with 4h of Sightseeing',25,'2021-11-15','2021-11-27','Ulm HBF','Sightseeing in Munich',1,'2021-12-06','Munich',20,'2021-10-31 23:00:00'),(18,'Dachau Concentration Camp Memorial Site Tour from Munich by Train',25,'2022-01-15','2022-01-31','Ulm HBF','Concentration Camp',1,'2022-02-08','Munich',25,'2021-12-31 23:00:00'),(19,'Heidelberg Half-Day Trip from Frankfurt',25,'2022-02-01','2022-02-15','Ulm HBF','Heidelberg Half-day Trip',1,'2022-02-18','Heidelberg',25,'2022-01-31 23:00:00'),(20,'Private Rhine Valley Day Trip from Frankfurt With Wine Tasting',25,'2022-03-15','2022-03-25','Ulm HBF','Rhine Valley Day Trip',1,'2022-03-28','Frankfurt',40,'2022-03-02 23:00:00'),(21,'Berlin Complete History All Day Tour',25,'2023-06-17','2023-06-27','Ulm HBF','Berlin History Tour',1,'2023-06-29','Berlin',50,'2023-06-01 22:00:00'),(22,'Sachsenhausen Concentration Camp Memorial Tour from Berlin',25,'2023-08-15','2023-08-29','Ulm HBF','Sachsenhausen Camp',1,'2023-09-02','Berlin',50,'2023-07-31 22:00:00'),(23,'City Tour Cologne',25,'2023-09-15','2023-09-25','Ulm HBF','City Tour in Cologne',1,'2023-09-26','Cologne',60,'2023-08-31 22:00:00'),(24,'Day Trip from Munich to Salzburg',25,'2023-10-15','2023-10-21','Ulm Hbf','Day Trip Salzburg',1,'2023-10-25','Salzburg',32,'2023-09-30 22:00:00'),(25,'6-Hour Tour from Frankfurt',25,'2021-08-15','2021-08-30','Ulm HBF','Frankfurt Day-Trip',1,'2021-09-04','Rothenberg',60,'2021-07-31 22:00:00'),(26,'Pompeu University Spain',25,'2021-08-15','2021-08-30','Ulm HBF','Spain Day-Trip',1,'2021-09-04','Spain Barcelona',60,'2021-12-01 16:22:05');
/*!40000 ALTER TABLE `excursion` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-01 17:26:34
