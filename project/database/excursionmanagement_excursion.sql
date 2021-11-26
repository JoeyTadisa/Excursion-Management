-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: excursionmanagement
-- ------------------------------------------------------
-- Server version	8.0.27

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
  `DateAdded` datetime DEFAULT NULL,
  `MaxParticipants` int DEFAULT NULL,
  `RegDeadline` datetime DEFAULT NULL,
  `DeregDeadline` datetime DEFAULT NULL,
  `MeetingDetails` varchar(255) DEFAULT NULL,
  `Title` varchar(45) DEFAULT NULL,
  `RequestedBy` int DEFAULT NULL,
  `destination` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idExcursion`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `excursion`
--

LOCK TABLES `excursion` WRITE;
/*!40000 ALTER TABLE `excursion` DISABLE KEYS */;
INSERT INTO `excursion` VALUES (1,'Day Trip to Neuschwanstein and Linderhof Castles from Munich','9999-12-31 23:59:59',25,'9999-12-31 23:59:59','9999-12-31 23:59:59','Ulm HBF','Neuschwanstein and Linderhof Castles',1,NULL),(2,'2 Hour Sightseeing Tour in classic VW Bus','9999-12-31 23:59:59',25,'9999-12-31 23:59:59','9999-12-31 23:59:59','Ulm HBF','Berlin',1,NULL),(3,'An Evening of Bavarian Beer and Food Culture','9999-12-31 23:59:59',25,'9999-12-31 23:59:59','9999-12-31 23:59:59','Ulm HBF','Munich',1,NULL),(4,'2-Hour Segway Tour of Dusseldorf, or VIP Segway Tour','9999-12-31 23:59:59',25,'9999-12-31 23:59:59','9999-12-31 23:59:59','Ulm HBF','Dusseldorf',1,NULL),(5,'6-Hour Tour from Frankfurt','9999-12-31 23:59:59',25,'9999-12-31 23:59:59','9999-12-31 23:59:59','Ulm HBF','Heidelberg',1,NULL),(6,'6-Hour Tour from Frankfurt','9999-12-31 23:59:59',25,'9999-12-31 23:59:59','9999-12-31 23:59:59','Ulm HBF','Heidelberg',1,NULL),(7,'6-Hour Tour from Frankfurt','9999-12-31 23:59:59',25,'9999-12-31 23:59:59','9999-12-31 23:59:59','Ulm HBF','Heidelberg',1,NULL),(8,'6-Hour Tour from Frankfurt','9999-12-31 23:59:59',25,'9999-12-31 23:59:59','9999-12-31 23:59:59','Ulm HBF','Heidelberg',1,NULL),(9,'6-Hour Tour from Frankfurt','9999-12-31 23:59:59',25,'9999-12-31 23:59:59','9999-12-31 23:59:59','Ulm HBF','Heidelberg',1,NULL),(10,'This is the hometown of world famous German physicist Albert Einstein.Although he moved out very early on in his life, today you can see his presence in the museums and university.The old streets line the River Danube and it’s a beautiful city. You can visit the world’s tallest church, marvel at the rickety, lopsided beerhaus that was built centuries ago, and wonder how the city’s very own leaning tower has still not fallen over.','2021-11-28 08:00:00',12,'2021-11-23 03:59:59','2021-11-26 23:59:59','Ulm Hbf','City tour Ulm',1,'Ulm'),(11,'We will spend our day in Munich and explore the BMW Museum ','2022-01-25 08:30:00',10,'2022-01-22 23:59:59','2022-01-24 23:59:59','Frauenstr Bushaltstelle','BMW Museum',2,'Am Olympiapark 2, 80809 München'),(12,'We will visit Friedrichshafen Museum and take a boat trip on the river Konstanz','2021-03-15 09:30:00',20,'2021-03-10 23:59:59','2021-01-12 23:59:59','Eselsberg Bushaltstelle','City tour Friedricshafen ',3,'Friedrichshafen'),(13,'We will be hiking on the norther border of Alps','2022-05-02 07:30:00',25,'2022-04-25 23:59:59','2022-04-28 23:59:59','ZUP, Neu Ulm','Apls Adventure Climbing',2,'Höllschult Forest, Pfronten'),(14,'We will explore the beautiful south of Stuttgart and The Neo-Gothic architecture dates back to the early 19th century when the Prussian King began construction of the high walls and magnificent turrets that you see today. ','2022-02-04 06:30:00',35,'2022-01-30 23:59:59','2022-02-01 23:59:59','Eselsberg Bushaltstelle','Hohenzollern Castle',1,'72379 Burg Hohenzollern, Bisingen'),(15,'Another iconic university town that’s perhaps much more well-known is Heidelberg.This is one of the most beautiful towns in Germany and it’s just a day trip from Stuttgart.Here, you will find an elegant bridge spanning the Neckar River and rolling hills covered in green trees surrounding the historic town.','2022-10-08 11:30:00',32,'2022-10-05 23:59:59','2022-10-07 23:59:59','Ulm Hbf','Trip to Heidelberg',1,'Heidelberg'),(16,'Neuschwanstein Castle quite literally looks like it has been transplanted into the real world from a fairy tale.\n\nIt’s a bit of a long day trip from Stuttgart – the castle is found to the south, on the border with Austria – but it’s well worth the trip to see this iconic landmark in all its glory.\n\nNeuschwanstein Castle is found on a high cliff top and its spires and turrets are the stuff of legend.','2022-06-22 08:00:00',30,'2022-06-15 23:59:59','2022-06-20 23:59:59','ZUP, Neu Ulm','Neuschwanstein Castle',3,' Neuschwansteinstraße 20, 87645 Schwangau'),(17,'Nuremberg is one of the Danube River’s most famous cities. Although much of it was destroyed in World War II and the name of the city became synonymous with the trials that were held here after the conflict, today the city has recovered and regained its position as a tourist destination that it has long held historically.','2022-08-14 10:00:00',15,'2022-08-10 23:59:59','2022-08-12 23:59:59','Frauenstr Bushaltstelle',' City tour Nuremberg',1,' Nuremberg'),(18,' At the northern border of the Alps and close to Lake Constance we are going to have a nice morning walk exploring the beautiful surroundings. Back at the Centre, professional guides are going to introduce us to different challenges and we will have a go at the team circuit of the Aktivzentrum. It\'s going to be a bit more competitive during the so called \"Allgäu Eventchallenge\"\" where we participate in traditional southgerman games. \"','2021-12-12 08:30:00',46,'2021-12-05 23:59:59','2021-12-10 23:59:59','ZUP, Neu Ulm','Highlight Excursion Oberstaufen',3,'Oberstaufen'),(19,'The Black Forest is an extensive area of natural beauty that’s easily accessible from Stuttgart.\nThere are many small towns to discover and a wonderful array of landscapes and hiking trails that will leave you speechless.\nA great place to begin your journey into the Black Forest and to get a great feel for nature here, explore the recently created Black Forest National Park, found in the northern part of the region.','2021-07-23 07:30:00',34,'2022-07-15 23:59:59','2022-07-20 23:59:59','Ulm Hbf','Hiking at The Black Forest',2,'Schwarzwaldhochstraße 2, 77889 Seebach');
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

-- Dump completed on 2021-11-26 18:13:37
