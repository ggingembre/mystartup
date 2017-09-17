-- MySQL dump 10.13  Distrib 5.7.19, for Linux (x86_64)
--
-- Host: localhost    Database: startuptest
-- ------------------------------------------------------
-- Server version	5.7.19-0ubuntu0.16.04.1

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
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `address_id` bigint(20) NOT NULL,
  `country` int(11) DEFAULT NULL,
  `region` int(11) DEFAULT NULL,
  `town` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `businessplans`
--

DROP TABLE IF EXISTS `businessplans`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `businessplans` (
  `businessplan_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `business_model` varchar(255) DEFAULT NULL,
  `businessplan_amount_raised` decimal(19,2) DEFAULT NULL,
  `businessplan_expected_raise` decimal(19,2) DEFAULT NULL,
  `businessplan_last_change` date DEFAULT NULL,
  `businessplan_min_inv` decimal(19,2) DEFAULT NULL,
  `businessplan_return` double DEFAULT NULL,
  `collateral` varchar(255) DEFAULT NULL,
  `competition` varchar(255) DEFAULT NULL,
  `current_state` varchar(255) DEFAULT NULL,
  `docurl` varchar(255) DEFAULT NULL,
  `finances` varchar(255) DEFAULT NULL,
  `funds_uses` varchar(255) DEFAULT NULL,
  `idea` varchar(255) DEFAULT NULL,
  `isActive` bit(1) DEFAULT NULL,
  `market` varchar(255) DEFAULT NULL,
  `mentors` varchar(255) DEFAULT NULL,
  `opportunity` varchar(255) DEFAULT NULL,
  `previous_rounds` decimal(19,2) DEFAULT NULL,
  `project_id` bigint(20) DEFAULT NULL,
  `risks` varchar(255) DEFAULT NULL,
  `solution` varchar(255) DEFAULT NULL,
  `usp` varchar(255) DEFAULT NULL,
  `weburl` varchar(255) DEFAULT NULL,
  `address_address_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`businessplan_id`),
  KEY `FKi3481kg7m6mu72r6hj01m4opl` (`address_address_id`),
  CONSTRAINT `FKi3481kg7m6mu72r6hj01m4opl` FOREIGN KEY (`address_address_id`) REFERENCES `address` (`address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `projects`
--

DROP TABLE IF EXISTS `projects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `projects` (
  `project_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `isActive` bit(1) DEFAULT NULL,
  `project_logo_link` varchar(255) DEFAULT NULL,
  `project_amount_raised` decimal(19,2) DEFAULT NULL,
  `project_description` varchar(255) DEFAULT NULL,
  `project_doc_link` varchar(255) DEFAULT NULL,
  `project_expected_raise` decimal(19,2) DEFAULT NULL,
  `project_industry` int(11) DEFAULT NULL,
  `project_last_change` date DEFAULT NULL,
  `project_min_inv` decimal(19,2) DEFAULT NULL,
  `project_name` varchar(255) DEFAULT NULL,
  `previous_rounds` decimal(19,2) DEFAULT NULL,
  `project_return` double DEFAULT NULL,
  `project_site_link` varchar(255) DEFAULT NULL,
  `projectAddress_address_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`project_id`),
  KEY `FKdo5476d0t5w2s39o5unscokee` (`projectAddress_address_id`),
  CONSTRAINT `FKdo5476d0t5w2s39o5unscokee` FOREIGN KEY (`projectAddress_address_id`) REFERENCES `address` (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `projects_businessplans`
--

DROP TABLE IF EXISTS `projects_businessplans`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `projects_businessplans` (
  `projects_project_id` bigint(20) NOT NULL,
  `businessPlans_businessplan_id` bigint(20) NOT NULL,
  PRIMARY KEY (`projects_project_id`,`businessPlans_businessplan_id`),
  KEY `FKsnpkrdpb7f1hsp72jquujftrh` (`businessPlans_businessplan_id`),
  CONSTRAINT `FK6e5uenprs2uj33ca2j73l4jwm` FOREIGN KEY (`projects_project_id`) REFERENCES `projects` (`project_id`),
  CONSTRAINT `FKsnpkrdpb7f1hsp72jquujftrh` FOREIGN KEY (`businessPlans_businessplan_id`) REFERENCES `businessplans` (`businessplan_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-09-17  0:31:47
