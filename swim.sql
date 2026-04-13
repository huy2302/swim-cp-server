-- MySQL dump 10.13  Distrib 8.0.45, for Linux (x86_64)
--
-- Host: localhost    Database: swim
-- ------------------------------------------------------
-- Server version	8.0.45-0ubuntu0.22.04.1

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
-- Table structure for table `accounts`
--

DROP TABLE IF EXISTS `accounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `accounts` (
  `uuid` binary(16) NOT NULL,
  `account_name` varchar(50) DEFAULT NULL,
  `bind_status` varchar(20) DEFAULT NULL,
  `config_json` text,
  `host` varchar(255) DEFAULT NULL,
  `port` int DEFAULT NULL,
  `protocol` varchar(20) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`uuid`),
  UNIQUE KEY `UK_ef8srjaet88qrf7w1mvtop0pp` (`account_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accounts`
--

LOCK TABLES `accounts` WRITE;
/*!40000 ALTER TABLE `accounts` DISABLE KEYS */;
INSERT INTO `accounts` VALUES (_binary 'zyõ]3/\Òó0Ö©DÜ\›','SWIM_GATEWAY_01','CONNECTED','{\"vpn\":\"aviation-vpn\", \"client-username\":\"cp-user\"}','10.28.1.50',55555,'SOLACE','ACTIVE');
/*!40000 ALTER TABLE `accounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gateway_log`
--

DROP TABLE IF EXISTS `gateway_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gateway_log` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `direction` varchar(255) DEFAULT NULL,
  `error_message` text,
  `message_id` varchar(255) DEFAULT NULL,
  `payload` text,
  `status` varchar(255) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gateway_log`
--

LOCK TABLES `gateway_log` WRITE;
/*!40000 ALTER TABLE `gateway_log` DISABLE KEYS */;
INSERT INTO `gateway_log` VALUES (1,NULL,'AMHS_TO_SWIM',NULL,'MSG123456','N·ªôi dung ƒëi·ªán vƒÉn m·∫´u...','SENT',NULL),(2,NULL,'SWIM_TO_AMHS','Connection timeout to AMHS server','MSG789012','N·ªôi dung l·ªói...','ERROR',NULL),(3,NULL,'AMHS_TO_SWIM',NULL,'VATM.20260410.091500.001','PRIORITY: FF\nFILING_TIME: 100915\nORIGIN: VVTSZPZX\nCONTENT: (FPL-HVN123-IS-A321/M-SDE3RWY/C-VVTS0930-N0450F350 DCT...)','SENT',NULL),(4,NULL,'SWIM_TO_AMHS','Routing failure: No AFTN recipient found for queue: AMQP.SWIM.PRIORITY.HIGH','SWIM-MSG-UUID-998877','{\"type\": \"FlightPlan\", \"acid\": \"BAM246\", \"dep\": \"VVNB\", \"dest\": \"VVDN\", \"eet\": \"0100\"}','ERROR',NULL),(5,NULL,'AMHS_TO_SWIM',NULL,'VATM.20260410.092015.042','PRIORITY: GG\nFILING_TIME: 100920\nORIGIN: VVVVZPZX\nCONTENT: (ARR-VJC622-VVDN0850-VVTS-0945)','PROCESSING',NULL),(6,NULL,'AMHS_TO_SWIM','ParserException: Missing open parenthesis at start of message content.','VATM.20260410.092530.105','PRIORITY: SS\nFILING_TIME: 100925\nORIGIN: VVNBZPZX\nCONTENT: INVALID_FORMAT_NOT_ATS_MESSAGE','ERROR',NULL),(7,NULL,'SWIM_TO_AMHS',NULL,'SWIM-MSG-UUID-112233','{\"type\": \"METAR\", \"station\": \"VVTS\", \"observationTime\": \"2026-04-10T09:00:00Z\", \"raw\": \"METAR VVTS 100900Z 24005KT 9999 FEW020 32/24 Q1010 NOSIG\"}','SENT',NULL);
/*!40000 ALTER TABLE `gateway_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message_archive`
--

DROP TABLE IF EXISTS `message_archive`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `message_archive` (
  `uuid` binary(16) NOT NULL,
  `direction` varchar(20) DEFAULT NULL,
  `ipm_id` varchar(100) DEFAULT NULL,
  `msg_id` varchar(100) DEFAULT NULL,
  `mts_id` varchar(100) DEFAULT NULL,
  `priority` varchar(2) DEFAULT NULL,
  `processing_status` varchar(20) DEFAULT NULL,
  `raw_content` text,
  `recipients` text,
  `timestamp` datetime(6) DEFAULT NULL,
  `aftn_address` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message_archive`
--

LOCK TABLES `message_archive` WRITE;
/*!40000 ALTER TABLE `message_archive` DISABLE KEYS */;
INSERT INTO `message_archive` VALUES (_binary '¡\n\Òô2W\Òó0Ö©DÜ\›','INBOUND','IPM-201','MSG-001','MTS-101','SS','PROCESSED','FPL-HVN123-IS-A321/M-S/C-VVTS0700...','VVTSZPZX','2026-04-07 14:59:50.000000',NULL),(_binary '¡ Cê2W\Òó0Ö©DÜ\›','OUTBOUND','IPM-202','MSG-002','MTS-102','DD','PROCESSED','ARR-HVN123-VVDN0830-VVTS-0','VVDNZPZX','2026-04-07 14:59:50.000000',NULL),(_binary '¡ \\∫2W\Òó0Ö©DÜ\›','INBOUND','IPM-203','MSG-003','MTS-103','FF','PENDING','CHG-AIC456-DOF/260407-REG/VTANW...','VVNBZPZX','2026-04-07 14:59:50.000000',NULL),(_binary '¡ _à2W\Òó0Ö©DÜ\›','INBOUND','IPM-204','MSG-004','MTS-104','GG','ERROR','DLA-VJ789-VVTS1000-VVPQ-0','VVPQZPZX','2026-04-07 14:59:50.000000',NULL),(_binary '¡ a©2W\Òó0Ö©DÜ\›','OUTBOUND','IPM-205','MSG-005','MTS-105','SS','PROCESSED','CNL-VJC112-VVTS-VVDN-DOF/260407','VVTSZPZX','2026-04-07 14:59:50.000000',NULL),(_binary '¡ c92W\Òó0Ö©DÜ\›','INBOUND','IPM-206','MSG-006','MTS-106','DD','PROCESSED','DEP-HVN123-VVTS0715-VVDN','VVDNZPZX','2026-04-07 14:59:50.000000',NULL),(_binary '¡ d∏2W\Òó0Ö©DÜ\›','OUTBOUND','IPM-207','MSG-007','MTS-107','FF','PENDING','EST-BAW99-VVDN-VVNB-DOF/260407','VVNBZPZX','2026-04-07 14:59:50.000000',NULL),(_binary '¡ f(2W\Òó0Ö©DÜ\›','INBOUND','IPM-208','MSG-008','MTS-108','SS','PROCESSED','NOTAMN A1234/26-VVTS-RWY 25L CLSD','VVPQZPZX','2026-04-07 14:59:50.000000',NULL),(_binary '¡ g•2W\Òó0Ö©DÜ\›','OUTBOUND','IPM-209','MSG-009','MTS-109','GG','ERROR','REJ-MSG-004-INVALID-FIELD-8','VVTSZPZX','2026-04-07 14:59:50.000000',NULL),(_binary '¡ i\"2W\Òó0Ö©DÜ\›','INBOUND','IPM-210','MSG-010','MTS-110','SS','PROCESSED','ACK-MSG-001-SUCCESS','VVDNZPZX','2026-04-07 14:59:50.000000',NULL),(_binary '⁄Å\»n4µ\Òó0Ö©DÜ\›','sent','ID-88990/OU=VVDNAMHS/O=AFTN/PRMD=VN/ADMD=ICAO/C=VN/','SWIM-MET-20260410-095','[/PRMD=VIETNAM/ADMD=ICAO/C=VN;/Nova.MET.095]','GG','SENT','METAR VVTS 101500Z 24005KT 9999 FEW020 32/24 Q1010 NOSIG','ALL_STATIONS','2026-04-10 15:10:00.000000',NULL);
/*!40000 ALTER TABLE `message_archive` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message_conversion_log`
--

DROP TABLE IF EXISTS `message_conversion_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `message_conversion_log` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `category` varchar(255) DEFAULT NULL,
  `content` text,
  `converted_time` datetime(6) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `filing_time` varchar(255) DEFAULT NULL,
  `ipm_id` varchar(255) DEFAULT NULL,
  `message_id` varchar(255) DEFAULT NULL,
  `origin` varchar(255) DEFAULT NULL,
  `reference_id` bigint DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message_conversion_log`
--

LOCK TABLES `message_conversion_log` WRITE;
/*!40000 ALTER TABLE `message_conversion_log` DISABLE KEYS */;
INSERT INTO `message_conversion_log` VALUES (1,'IPM','(FPL-HVN123-IS-A321/M-SDE3RWY/C-VVTS1030-N0450F350 DCT PANTO DCT VVNB0130)','2026-04-10 15:30:00.000000','20260410','100900','ID-55667/OU=VVTSAMHS/O=AFTN/PRMD=VN/ADMD=ICAO/C=VN/','VATM.FPL.HVN123.100900','VVTSZPZX',NULL,'Converted to SWIM JSON format successfully','SUCCESS','IA5'),(2,'IPM','METAR VVDN 101530Z 24005KT 9999 FEW020 32/24 Q1010 NOSIG','2026-04-10 15:35:10.000000','20260410','101530','ID-99881/OU=VVDNAMHS/O=AFTN/PRMD=VN/ADMD=ICAO/C=VN/','VATM.MET.VVDN.101530','VVDNZPZX',NULL,'Weather data broadcasted to SWIM bus','SUCCESS','IA5'),(3,'REPORT','QU VVTSZPZX\n.WSSSZPZX 101545\nACK RECEIVED FOR MSG VATM.20260410.FPL01','2026-04-10 15:40:05.000000','20260410','101545','ID-11223/OU=WSSSZPZX/O=AFTN/PRMD=SG/ADMD=ICAO/C=SG/','WSSS.ACK.20260410.001','WSSSZPZX',NULL,'Acknowledgement routed to local terminal','SUCCESS','IA5'),(4,'IPM','FPL-VJC456-IS-A320-VVNB... (Missing opening bracket)','2026-04-10 15:42:00.000000','20260410','101600','ID-88776/OU=VVNBAMHS/O=AFTN/PRMD=VN/ADMD=ICAO/C=VN/','VVNB.ERR.998','VVNBZPZX',NULL,'Parser Error: Missing \"(\" at index 0','ERROR','IA5'),(5,'IPM','(CNL-HVN123-VVTS1030-VVNB-18/CANCELLED DUE TO WEATHER)','2026-04-10 15:45:12.000000','20260410','101615','ID-44332/OU=VVTSAMHS/O=AFTN/PRMD=VN/ADMD=ICAO/C=VN/','VVTS.CNL.HVN123.101615','VVTSZPZX',NULL,'Cancellation processed','SUCCESS','IA5');
/*!40000 ALTER TABLE `message_conversion_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `performance_metrics`
--

DROP TABLE IF EXISTS `performance_metrics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `performance_metrics` (
  `uuid` binary(16) NOT NULL,
  `active_threads` int DEFAULT NULL,
  `cpu_usage` double DEFAULT NULL,
  `heap_memory` double DEFAULT NULL,
  `msg_in_count` int DEFAULT NULL,
  `msg_out_count` int DEFAULT NULL,
  `timestamp` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `performance_metrics`
--

LOCK TABLES `performance_metrics` WRITE;
/*!40000 ALTER TABLE `performance_metrics` DISABLE KEYS */;
INSERT INTO `performance_metrics` VALUES (_binary 'nà|µ3/\Òó0Ö©DÜ\›',24,15.5,512,120,115,'2026-04-08 16:43:43.000000'),(_binary 'nØz^3/\Òó0Ö©DÜ\›',26,18.2,530.5,150,140,'2026-04-08 16:38:43.000000'),(_binary 'n∞m3/\Òó0Ö©DÜ\›',22,12.1,490.2,90,85,'2026-04-08 16:33:43.000000');
/*!40000 ALTER TABLE `performance_metrics` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `routing`
--

DROP TABLE IF EXISTS `routing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `routing` (
  `uuid` binary(16) NOT NULL,
  `aftn_recipients` varchar(100) DEFAULT NULL,
  `amqp_account` varchar(50) DEFAULT NULL,
  `direction` varchar(50) DEFAULT NULL,
  `message_type` varchar(20) DEFAULT NULL,
  `receive_queue` varchar(100) DEFAULT NULL,
  `send_queue` varchar(50) DEFAULT NULL,
  `sender_aftn_address` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `routing`
--

LOCK TABLES `routing` WRITE;
/*!40000 ALTER TABLE `routing` DISABLE KEYS */;
INSERT INTO `routing` VALUES (_binary 'g bÖ3∑\Òó0Ö©DÜ\›','VVDNZPZX, VVNBZPZX','SOLACE_MAIN_HUB','AFTN_TO_AMQP','FPL','AFTN.INBOUND.Q','SWIM.FPL.QUEUE','VVTSZPZX');
/*!40000 ALTER TABLE `routing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `system_log`
--

DROP TABLE IF EXISTS `system_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `system_log` (
  `uuid` binary(16) NOT NULL,
  `content` text,
  `level` varchar(10) DEFAULT NULL,
  `module` varchar(50) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `timestamp` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `system_log`
--

LOCK TABLES `system_log` WRITE;
/*!40000 ALTER TABLE `system_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `system_log` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-04-13 10:28:43
