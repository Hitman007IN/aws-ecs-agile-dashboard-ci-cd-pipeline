-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: agile_dashboard
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `sprint_item`
--

DROP TABLE IF EXISTS `sprint_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sprint_item` (
  `ID` int(11) NOT NULL,
  `PROJECT_NAME` varchar(150) DEFAULT NULL,
  `SPRINT_NAME` varchar(45) DEFAULT NULL,
  `ITEM_TYPE` varchar(45) DEFAULT NULL,
  `PRIORITY` varchar(45) DEFAULT NULL,
  `COUNT` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sprint_item`
--

LOCK TABLES `sprint_item` WRITE;
/*!40000 ALTER TABLE `sprint_item` DISABLE KEYS */;
INSERT INTO `sprint_item` VALUES (1,'MatrixPlatform','MAT Sprint 1','Bug','Lowest',1),(2,'MatrixPlatform','MAT Sprint 1','Story','High',1),(3,'MatrixPlatform','MAT Sprint 1','Story','Low',1),(4,'MatrixPlatform','MAT Sprint 1','Story','Medium',9),(5,'MatrixPlatform','MAT Sprint 1','Story','Highest',2),(6,'MatrixPlatform','MAT Sprint 2','Bug','High',1),(7,'MatrixPlatform','MAT Sprint 2','Bug','Medium',1),(8,'MatrixPlatform','MAT Sprint 2','Story','Medium',2),(9,'MatrixPlatform','MAT Sprint 2','Story','Highest',1),(10,'MatrixPlatform','MAT Sprint 3','Story','High',2),(11,'MatrixPlatform','MAT Sprint 3','Story','Low',1),(12,'MatrixPlatform','MAT Sprint 3','Story','Medium',1),(13,'MatrixPlatform','MAT Sprint 3','Story','Highest',1),(14,'MatrixPlatform','MAT Sprint 4','Story','Medium',5);
/*!40000 ALTER TABLE `sprint_item` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-10 14:51:43
