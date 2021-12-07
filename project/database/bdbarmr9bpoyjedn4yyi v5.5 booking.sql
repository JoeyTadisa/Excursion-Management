-- MySQL dump 10.13  Distrib 8.0.19, for macos10.15 (x86_64)
--
-- Host: 127.0.0.1    Database: thu_excursion_v5_usertbl_booking
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
  PRIMARY KEY (`id_booking`),
  KEY `numberUser_fk_idx` (`booked_by`),
  CONSTRAINT `userNumber_fk` FOREIGN KEY (`booked_by`) REFERENCES `user` (`user_number`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES (1,'2021-01-15',313001,12),(2,'2021-08-15',313001,13),(3,'2021-01-15',313002,12),(4,'2021-08-15',313002,13),(5,'2021-08-15',313002,14),(6,'2021-01-15',313002,15);
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
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
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `student_booking_excursion` AS select `user_excursion`.`id_booking` AS `id_booking`,`user_excursion`.`date_booked` AS `date_booked`,`user_excursion`.`booked_by` AS `booked_by`,`user_excursion`.`id_excursion` AS `id_excursion`,`user_excursion`.`user_id` AS `user_id`,`user_excursion`.`user_number` AS `user_number`,`user_excursion`.`user_type` AS `user_type`,`user_excursion`.`username` AS `username`,`user_excursion`.`firstname` AS `firstname`,`user_excursion`.`lastname` AS `lastname`,`user_excursion`.`email` AS `email`,`e`.`Description` AS `Description`,`e`.`dateadded` AS `dateadded`,`e`.`MaxParticipants` AS `max_participants`,`e`.`RegDeadline` AS `RegDeadline`,`e`.`DeregDeadline` AS `DeregDeadline`,`e`.`MeetingDetails` AS `MeetingDetails`,`e`.`Title` AS `Title`,`e`.`date_of_excursion` AS `date_of_excursion`,`e`.`destination` AS `destination`,`e`.`excursion_fee` AS `excursion_fee` from ((select `b`.`id_booking` AS `id_booking`,`b`.`date_booked` AS `date_booked`,`b`.`booked_by` AS `booked_by`,`b`.`id_excursion` AS `id_excursion`,`u`.`user_id` AS `user_id`,`u`.`user_number` AS `user_number`,`u`.`user_type` AS `user_type`,`u`.`username` AS `username`,`u`.`firstname` AS `firstname`,`u`.`lastname` AS `lastname`,`u`.`email` AS `email` from (`booking` `b` join `user` `u` on((`b`.`booked_by` = `u`.`user_number`)))) `user_excursion` join `excursion` `e` on((`e`.`idExcursion` = `user_excursion`.`id_excursion`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-01  1:26:11
