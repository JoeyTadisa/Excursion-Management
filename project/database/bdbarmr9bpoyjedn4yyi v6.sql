-- MySQL dump 10.13  Distrib 8.0.19, for macos10.15 (x86_64)
--
-- Host: bdbarmr9bpoyjedn4yyi-mysql.services.clever-cloud.com    Database: bdbarmr9bpoyjedn4yyi
-- ------------------------------------------------------
-- Server version	8.0.22-13

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
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;


--
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking` (
  `id_booking` int NOT NULL AUTO_INCREMENT,
  `date_booked` date DEFAULT NULL,
  `booked_by` int NOT NULL,
  `id_excursion` int NOT NULL,
  `is_deregistered` tinyint DEFAULT '0',
  `date_deregistered` date DEFAULT NULL,
  PRIMARY KEY (`id_booking`),
  KEY `numberUser_fk_idx` (`booked_by`),
  CONSTRAINT `userNumber_fk` FOREIGN KEY (`booked_by`) REFERENCES `user` (`user_number`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES (1,'2021-01-15',313001,12,1,NULL),(2,'2021-08-15',313001,13,1,NULL),(3,'2021-01-15',313002,12,1,NULL),(4,'2021-08-15',313002,13,1,NULL),(5,'2021-08-15',313002,14,1,NULL),(6,'2021-01-15',313002,15,1,NULL),(7,'2021-01-15',313002,16,1,NULL);
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `excursion`
--

DROP TABLE IF EXISTS `excursion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `excursion` (
  `idExcursion` int NOT NULL AUTO_INCREMENT,
  `Description` varchar(500) DEFAULT NULL,
  `dateadded` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `MaxParticipants` int DEFAULT NULL,
  `RegDeadline` date DEFAULT NULL,
  `DeregDeadline` date DEFAULT NULL,
  `MeetingDetails` varchar(255) DEFAULT NULL,
  `Title` varchar(45) DEFAULT NULL,
  `RequestedBy` int DEFAULT NULL,
  `date_of_excursion` date DEFAULT NULL,
  `destination` varchar(45) DEFAULT NULL,
  `excursion_fee` double DEFAULT '0',
  `is_approved` tinyint NOT NULL DEFAULT '0',
  `date_reviewed` date DEFAULT NULL,
  `reviewed_by` int NOT NULL DEFAULT '0',
  `approval_status` enum('0','1','2') NOT NULL DEFAULT '0',
  PRIMARY KEY (`idExcursion`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `excursion`
--

LOCK TABLES `excursion` WRITE;
/*!40000 ALTER TABLE `excursion` DISABLE KEYS */;
INSERT INTO `excursion` VALUES (12,'Neuschwanstein Castle and Linderhof Palace Day Tour from Munich','2020-12-31 23:00:00',25,'2021-01-15','2021-01-30','Ulm HBF','Neuschwanstein Castle and Linderhof Palace',1,'2021-02-02','Munich',60,1,NULL,0,'0'),(13,'Exclusive and Unique Romantic Road Tour from Munich to Rothenberg','2021-07-31 22:00:00',25,'2021-08-14','2021-08-29','Ulm HBF','Romantic Road in Rothenberg',1,'2021-09-03','Rothenberg',25,1,NULL,0,'0'),(14,'Private Scenic Transfer from Frankfurt to Munich with 4h of Sightseeing','2021-10-31 23:00:00',25,'2021-11-15','2021-11-27','Ulm HBF','Sightseeing in Munich',1,'2021-12-06','Munich',50,0,NULL,0,'0'),(18,'Dachau Concentration Camp Memorial Site Tour from Munich by Train','2021-12-31 23:00:00',25,'2022-01-15','2022-01-31','Ulm HBF','Concentration Camp',1,'2022-02-08','Munich',90,0,NULL,0,'0'),(19,'Heidelberg Half-Day Trip from Frankfurt','2022-01-31 23:00:00',25,'2022-02-01','2022-02-15','Ulm HBF','Heidelberg Half-day Trip',1,'2022-02-18','Heidelberg',35,0,NULL,0,'0'),(20,'Private Rhine Valley Day Trip from Frankfurt With Wine Tasting','2022-03-02 23:00:00',25,'2022-03-15','2022-03-25','Ulm HBF','Rhine Valley Day Trip',1,'2022-03-28','Frankfurt',32,0,NULL,0,'0'),(21,'Berlin Complete History All Day Tour','2023-06-01 22:00:00',25,'2023-06-17','2023-06-27','Ulm HBF','Berlin History Tour',1,'2023-06-29','Berlin',25,0,NULL,0,'0'),(22,'Sachsenhausen Concentration Camp Memorial Tour from Berlin','2023-07-31 22:00:00',25,'2023-08-15','2023-08-29','Ulm HBF','Sachsenhausen Camp',1,'2023-09-02','Berlin',36,0,NULL,0,'0'),(23,'City Tour Cologne','2023-08-31 22:00:00',25,'2023-09-15','2023-09-25','Ulm HBF','City Tour in Cologne',1,'2023-09-26','Cologne',65,0,NULL,0,'0'),(24,'Day Trip from Munich to Salzburg','2023-09-30 22:00:00',25,'2023-10-15','2023-10-21','Ulm Hbf','Day Trip Salzburg',1,'2023-10-25','Salzburg',20,0,NULL,0,'0'),(25,'Pompeu University Spain','2021-12-01 20:12:04',25,'2021-08-15','2021-08-30','Ulm HBF','Spain Day-Trip',1,'2021-09-04','Spain Barcelona',60,0,NULL,0,'0'),(26,'UP Manila','2021-12-01 22:18:22',25,'2021-08-15','2021-08-30','Ulm HBF','UP Manila',1,'2021-09-04','Spain Barcelona',60,0,NULL,0,'0'),(27,'Pompeu University Spain','2021-12-02 11:28:38',25,'2021-08-15','2021-08-30','Ulm HBF','Spain Day-Trip',1,'2021-09-04','Spain Barcelona',60,0,'2021-08-02',0,'0'),(28,'Giethoorn Netherlands','2021-12-03 16:00:04',25,'2021-08-14','2021-08-29','Ulm HBF','Village with no roads',1,'2021-09-03','Netherlands',60,0,'2021-08-01',0,'0'),(29,'Head along the enchanting road through bohemian Europe','2021-12-03 16:16:56',25,'2021-08-14','2021-08-29','Ulm HBF','Education Trip in Venice Italy',1,'2021-09-03','Italy',60,0,'2021-08-01',0,'0');
/*!40000 ALTER TABLE `excursion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `student_booking_excursion`
--

DROP TABLE IF EXISTS `student_booking_excursion`;
/*!50001 DROP VIEW IF EXISTS `student_booking_excursion`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `student_booking_excursion` AS SELECT 
 1 AS `id_booking`,
 1 AS `date_booked`,
 1 AS `booked_by`,
 1 AS `id_excursion`,
 1 AS `user_id`,
 1 AS `user_number`,
 1 AS `user_type`,
 1 AS `username`,
 1 AS `firstname`,
 1 AS `lastname`,
 1 AS `email`,
 1 AS `Description`,
 1 AS `dateadded`,
 1 AS `max_participants`,
 1 AS `RegDeadline`,
 1 AS `DeregDeadline`,
 1 AS `MeetingDetails`,
 1 AS `Title`,
 1 AS `date_of_excursion`,
 1 AS `destination`,
 1 AS `excursion_fee`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `user_number` int NOT NULL,
  `user_type` varchar(10) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `is_active` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_number_UNIQUE` (`user_number`),
  UNIQUE KEY `user_id_UNIQUE` (`user_id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `user_type_fk_id` (`user_type`),
  KEY `user_type_fk_idx` (`user_type`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,6,'a','billcrawford','confidential','Bill','Crawford','crawford@thu.de','Craw Str. 211',1),(2,55512,'o','chrislawrence','complex','Chris','Lawrence','lawrence@thu.de','Law Str. 211',1),(3,313001,'s','shilogonzaga','complex','Shilo','Gonzaga','gonzaga@thu.de','Gonza Str. 211',1),(4,313002,'s','lunafox','confidential','Luna','Fox','fox@thu.de','Fox Str. 211',0),(9,69696969,'s','arod69','rod696969','alex','rod','rod@thu.de','heiden. Str. 69',1),(10,3143029,'a','markrod','96markrod69','alex','mark','mark@thu.de','heiden. Str. 69',1),(12,3134729,'o','lisathompson','thompsonRules32','Lisa','Thompson','thompson@thu.de','Thompson Alle 52',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usertype`
--

DROP TABLE IF EXISTS `usertype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usertype` (
  `id` int NOT NULL,
  `user_type` char(2) DEFAULT NULL,
  `user_description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usertype`
--

LOCK TABLES `usertype` WRITE;
/*!40000 ALTER TABLE `usertype` DISABLE KEYS */;
INSERT INTO `usertype` VALUES (1,'a','admin'),(2,'o','organizer'),(3,'s','student');
/*!40000 ALTER TABLE `usertype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `student_booking_excursion`
--

/*!50001 DROP VIEW IF EXISTS `student_booking_excursion`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50001 VIEW `student_booking_excursion` AS select `user_excursion`.`id_booking` AS `id_booking`,`user_excursion`.`date_booked` AS `date_booked`,`user_excursion`.`booked_by` AS `booked_by`,`user_excursion`.`id_excursion` AS `id_excursion`,`user_excursion`.`user_id` AS `user_id`,`user_excursion`.`user_number` AS `user_number`,`user_excursion`.`user_type` AS `user_type`,`user_excursion`.`username` AS `username`,`user_excursion`.`firstname` AS `firstname`,`user_excursion`.`lastname` AS `lastname`,`user_excursion`.`email` AS `email`,`e`.`Description` AS `Description`,`e`.`dateadded` AS `dateadded`,`e`.`MaxParticipants` AS `max_participants`,`e`.`RegDeadline` AS `RegDeadline`,`e`.`DeregDeadline` AS `DeregDeadline`,`e`.`MeetingDetails` AS `MeetingDetails`,`e`.`Title` AS `Title`,`e`.`date_of_excursion` AS `date_of_excursion`,`e`.`destination` AS `destination`,`e`.`excursion_fee` AS `excursion_fee` from ((select `b`.`id_booking` AS `id_booking`,`b`.`date_booked` AS `date_booked`,`b`.`booked_by` AS `booked_by`,`b`.`id_excursion` AS `id_excursion`,`u`.`user_id` AS `user_id`,`u`.`user_number` AS `user_number`,`u`.`user_type` AS `user_type`,`u`.`username` AS `username`,`u`.`firstname` AS `firstname`,`u`.`lastname` AS `lastname`,`u`.`email` AS `email` from (`booking` `b` join `user` `u` on((`b`.`booked_by` = `u`.`user_number`)))) `user_excursion` join `excursion` `e` on((`e`.`idExcursion` = `user_excursion`.`id_excursion`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-03 19:12:35
