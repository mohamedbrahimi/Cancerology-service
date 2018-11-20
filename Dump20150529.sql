CREATE DATABASE  IF NOT EXISTS `hopital9` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `hopital1`;

-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: hopital1
-- ------------------------------------------------------
-- Server version	5.6.23-log

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
-- Table structure for table `alcoolisation`
--

DROP TABLE IF EXISTS `alcoolisation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alcoolisation` (
  `NumAlcoolisation` int(11) NOT NULL AUTO_INCREMENT,
  `Alcoolisation` varchar(50) DEFAULT NULL,
  `DateAlcool` date DEFAULT NULL,
  `DateDebAlcoolTrt` date DEFAULT NULL,
  `AlcoolIncidents` varchar(500) DEFAULT NULL,
  `NumDossier` varchar(50) DEFAULT NULL,
  `DateTrait` date DEFAULT NULL,
  PRIMARY KEY (`NumAlcoolisation`),
  UNIQUE KEY `uniqueAcoolDate` (`DateTrait`,`NumDossier`),
  KEY `fk_alcool` (`NumDossier`),
  CONSTRAINT `fk_alcool` FOREIGN KEY (`NumDossier`) REFERENCES `dossiermedicale` (`NumDossier`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alcoolisation`
--

LOCK TABLES `alcoolisation` WRITE;
/*!40000 ALTER TABLE `alcoolisation` DISABLE KEYS */;
INSERT INTO `alcoolisation` VALUES (1,'Oui','2015-04-23','2015-04-23','Incident','001/15','2015-04-23'),(2,'Oui','2015-04-23','2015-04-23','Presice','001/15','2015-04-17');
/*!40000 ALTER TABLE `alcoolisation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `atcdsfamiliale`
--

DROP TABLE IF EXISTS `atcdsfamiliale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `atcdsfamiliale` (
  `NumATCDFamiliale` int(11) NOT NULL AUTO_INCREMENT,
  `Hepatovirale` varchar(20) DEFAULT NULL,
  `TypeHepato` varchar(500) DEFAULT NULL,
  `Neoplasme` varchar(500) DEFAULT NULL,
  `AutreAtcd` varchar(500) DEFAULT NULL,
  `NumDossier` varchar(50) DEFAULT NULL,
  `Nplsm` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`NumATCDFamiliale`),
  UNIQUE KEY `unique_atcdsF` (`NumDossier`),
  CONSTRAINT `fk_atcdf` FOREIGN KEY (`NumDossier`) REFERENCES `dossiermedicale` (`NumDossier`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atcdsfamiliale`
--

LOCK TABLES `atcdsfamiliale` WRITE;
/*!40000 ALTER TABLE `atcdsfamiliale` DISABLE KEYS */;
INSERT INTO `atcdsfamiliale` VALUES (1,'Oui','PRECISE','Neoplasme','Autre','006/15',NULL),(2,'Oui','T','N','A','002/15','Oui'),(3,'Oui','P','n','','001/15','Oui'),(4,'Oui','T','N','A','004/15','Oui');
/*!40000 ALTER TABLE `atcdsfamiliale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `atcdspersonnel`
--

DROP TABLE IF EXISTS `atcdspersonnel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `atcdspersonnel` (
  `NumATCDPersonnel` int(11) NOT NULL AUTO_INCREMENT,
  `HepSouJac` varchar(50) DEFAULT NULL,
  `Depui` date DEFAULT NULL,
  `Precise` varchar(500) DEFAULT NULL,
  `TransSang` varchar(50) DEFAULT NULL,
  `ExtrDenTrad` varchar(50) DEFAULT NULL,
  `Sacrification` varchar(50) DEFAULT NULL,
  `Tatouage` varchar(50) DEFAULT NULL,
  `Chirurgie` varchar(50) DEFAULT NULL,
  `Autre` varchar(500) DEFAULT NULL,
  `AlcoolDuree` varchar(50) DEFAULT NULL,
  `AlcoolQuntite` varchar(50) DEFAULT NULL,
  `AlcoolNature` varchar(50) DEFAULT NULL,
  `AlcoolSevrage` varchar(50) DEFAULT NULL,
  `Cafe` varchar(20) DEFAULT NULL,
  `CafeNbrDeTasse` varchar(50) DEFAULT NULL,
  `Cannabis` varchar(50) DEFAULT NULL,
  `MaladieAutoImmune` varchar(50) DEFAULT NULL,
  `ContreOrale` varchar(50) DEFAULT NULL,
  `Molecule` varchar(50) DEFAULT NULL,
  `Duree` varchar(50) DEFAULT NULL,
  `NeoplasmeConnu` varchar(50) DEFAULT NULL,
  `NeoplasmePrecise` varchar(100) DEFAULT NULL,
  `Dyslipidemie` varchar(50) DEFAULT NULL,
  `Diabete` varchar(50) DEFAULT NULL,
  `TypeDiabete` varchar(20) DEFAULT NULL,
  `DepuiD` date DEFAULT NULL,
  `HTA` varchar(20) DEFAULT NULL,
  `TRT` varchar(100) DEFAULT NULL,
  `AutresTares` varchar(500) DEFAULT NULL,
  `NumDossier` varchar(50) DEFAULT NULL,
  `Cause` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`NumATCDPersonnel`),
  UNIQUE KEY `unique_atcdsP` (`NumDossier`),
  CONSTRAINT `fk_atcdp` FOREIGN KEY (`NumDossier`) REFERENCES `dossiermedicale` (`NumDossier`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atcdspersonnel`
--

LOCK TABLES `atcdspersonnel` WRITE;
/*!40000 ALTER TABLE `atcdspersonnel` DISABLE KEYS */;
INSERT INTO `atcdspersonnel` VALUES (1,'Oui','2015-04-23','PRECISE','Non','Non','Non','Non','Non','Autre','dURee','qUNTITE','Nature','Sevrage','Oui','5J','Oui','MLA','Oui','MOLECULE','dUREE','Oui','Neoplasme','Dyslipidemie','Oui','type1','2015-04-23','Oui','trt','aUTRE','001/15','CAUSE'),(2,'Oui','2015-04-25','hépathie chronique','Oui','Non','Non','Non','Oui','','5j','5','NATURE','SEVRAGE','Oui','5j','Oui','MALADIE','Oui','molecul','Duree','Oui','Precis','Dyslipdemie','Oui','type1','2015-04-25','Oui','TRT','Autre TAREs','006/15','viral C'),(3,'Oui','2015-05-17','cirrhose','Oui','Oui','Non','Oui','Non','Autre','D','F','N','S','Oui','5','Oui','','Oui','m','6','Oui','','d','Oui','type2','2015-05-17','Oui','TrT','Tares','002/15','viral B'),(5,'Oui','2015-05-17','hépathie chronique','Oui','Non','Non','Non','Oui','A','D','Q','N','S','Oui','5','Non','ù','Oui','M','D','Oui','P','D','Oui','type1','2015-05-17','Oui','TRT','Tares','004/15','viral B');
/*!40000 ALTER TABLE `atcdspersonnel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `autreexamens`
--

DROP TABLE IF EXISTS `autreexamens`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `autreexamens` (
  `NumExamen` int(11) NOT NULL AUTO_INCREMENT,
  `Thracique` varchar(50) DEFAULT NULL,
  `Metastase` varchar(50) DEFAULT NULL,
  `ScintOss` varchar(50) DEFAULT NULL,
  `ScintMetastase` varchar(50) DEFAULT NULL,
  `ExpAutre` varchar(50) DEFAULT NULL,
  `ExpPrecise` varchar(500) DEFAULT NULL,
  `NumDossier` varchar(50) DEFAULT NULL,
  `dateexamen` date DEFAULT NULL,
  PRIMARY KEY (`NumExamen`),
  UNIQUE KEY `uniqueExamenDate` (`dateexamen`,`NumDossier`),
  KEY `fk_exam` (`NumDossier`),
  CONSTRAINT `fk_exam` FOREIGN KEY (`NumDossier`) REFERENCES `dossiermedicale` (`NumDossier`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autreexamens`
--

LOCK TABLES `autreexamens` WRITE;
/*!40000 ALTER TABLE `autreexamens` DISABLE KEYS */;
/*!40000 ALTER TABLE `autreexamens` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bilananapath`
--

DROP TABLE IF EXISTS `bilananapath`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bilananapath` (
  `NumAnapath` int(11) NOT NULL AUTO_INCREMENT,
  `Anapath` varchar(50) DEFAULT NULL,
  `PEchoGuid` varchar(50) DEFAULT NULL,
  `PBiopsieTumeur` varchar(50) DEFAULT NULL,
  `PBiopsieAdjacent` varchar(50) DEFAULT NULL,
  `PieceOperatoire` varchar(50) DEFAULT NULL,
  `Resultat` varchar(500) DEFAULT NULL,
  `Lame` varchar(100) DEFAULT NULL,
  `Service` varchar(50) DEFAULT NULL,
  `AutreService` varchar(500) DEFAULT NULL,
  `Immunom` varchar(50) DEFAULT NULL,
  `ClassifGrade` varchar(50) DEFAULT NULL,
  `Difference` varchar(50) DEFAULT NULL,
  `EFoieNTumoral` varchar(50) DEFAULT NULL,
  `Activite` varchar(50) DEFAULT NULL,
  `Fibrose` varchar(50) DEFAULT NULL,
  `NumDossier` varchar(50) DEFAULT NULL,
  `DateAnapath` date DEFAULT NULL,
  PRIMARY KEY (`NumAnapath`),
  UNIQUE KEY `uniqueAnapaDate` (`DateAnapath`,`NumDossier`),
  KEY `fk_anap` (`NumDossier`),
  CONSTRAINT `fk_anap` FOREIGN KEY (`NumDossier`) REFERENCES `dossiermedicale` (`NumDossier`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bilananapath`
--

LOCK TABLES `bilananapath` WRITE;
/*!40000 ALTER TABLE `bilananapath` DISABLE KEYS */;
INSERT INTO `bilananapath` VALUES (1,'Oui','Non','Non','Non','Non','rESULTAT','lame','CPMC','','IMMUNO CK 19 ','4','BIEN DIFFERENCIE','SAIN','A1','F1','001/15','2015-04-23');
/*!40000 ALTER TABLE `bilananapath` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bilanandoschopique`
--

DROP TABLE IF EXISTS `bilanandoschopique`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bilanandoschopique` (
  `NumBilanAndoschopiue` int(11) NOT NULL AUTO_INCREMENT,
  `FOGD` varchar(50) DEFAULT NULL,
  `VARICES` varchar(50) DEFAULT NULL,
  `FOGDSignesRouge` varchar(50) DEFAULT NULL,
  `AndoscopAutres` varchar(500) DEFAULT NULL,
  `NumDossier` varchar(50) DEFAULT NULL,
  `DateBilanFOGD` date DEFAULT NULL,
  PRIMARY KEY (`NumBilanAndoschopiue`),
  UNIQUE KEY `uniqueAndoschopD` (`DateBilanFOGD`,`NumDossier`),
  KEY `fk_ando` (`NumDossier`),
  CONSTRAINT `fk_ando` FOREIGN KEY (`NumDossier`) REFERENCES `dossiermedicale` (`NumDossier`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bilanandoschopique`
--

LOCK TABLES `bilanandoschopique` WRITE;
/*!40000 ALTER TABLE `bilanandoschopique` DISABLE KEYS */;
/*!40000 ALTER TABLE `bilanandoschopique` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bilanbiologique`
--

DROP TABLE IF EXISTS `bilanbiologique`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bilanbiologique` (
  `NumBilanBiologique` int(11) NOT NULL AUTO_INCREMENT,
  `GroupSang` varchar(50) DEFAULT NULL,
  `TypeH` varchar(50) DEFAULT NULL,
  `Hb` varchar(50) DEFAULT NULL,
  `GB` varchar(50) DEFAULT NULL,
  `Plaq` varchar(50) DEFAULT NULL,
  `TP` varchar(50) DEFAULT NULL,
  `FacteurV` varchar(50) DEFAULT NULL,
  `SGOT` varchar(50) DEFAULT NULL,
  `SGPT` varchar(50) DEFAULT NULL,
  `BT` varchar(50) DEFAULT NULL,
  `BD` varchar(50) DEFAULT NULL,
  `GGT` varchar(50) DEFAULT NULL,
  `PAL` varchar(50) DEFAULT NULL,
  `VS` varchar(50) DEFAULT NULL,
  `Uree` varchar(50) DEFAULT NULL,
  `Creatinine` varchar(50) DEFAULT NULL,
  `Albunemie` varchar(50) DEFAULT NULL,
  `Calcemie` varchar(50) DEFAULT NULL,
  `Cholesterol` varchar(50) DEFAULT NULL,
  `Tryglycerides` varchar(50) DEFAULT NULL,
  `HVC` varchar(50) DEFAULT NULL,
  `HVCChargeViyale` varchar(50) DEFAULT NULL,
  `HVCGenotype` varchar(50) DEFAULT NULL,
  `AgHBs` varchar(50) DEFAULT NULL,
  `Aghbe` varchar(50) DEFAULT NULL,
  `Achbe` varchar(50) DEFAULT NULL,
  `Achbs` varchar(50) DEFAULT NULL,
  `Achbc` varchar(50) DEFAULT NULL,
  `HBChargeVirale` varchar(50) DEFAULT NULL,
  `HBGenotype` varchar(50) DEFAULT NULL,
  `HVD` varchar(50) DEFAULT NULL,
  `HIV` varchar(50) DEFAULT NULL,
  `AFP` varchar(50) DEFAULT NULL,
  `ACE` varchar(50) DEFAULT NULL,
  `CA` varchar(50) DEFAULT NULL,
  `NumDossier` varchar(50) DEFAULT NULL,
  `DateBilanBiologique` date DEFAULT NULL,
  PRIMARY KEY (`NumBilanBiologique`),
  UNIQUE KEY `uniqueBilanB` (`DateBilanBiologique`,`NumDossier`),
  KEY `fk_bio` (`NumDossier`),
  CONSTRAINT `fk_bio` FOREIGN KEY (`NumDossier`) REFERENCES `dossiermedicale` (`NumDossier`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bilanbiologique`
--

LOCK TABLES `bilanbiologique` WRITE;
/*!40000 ALTER TABLE `bilanbiologique` DISABLE KEYS */;
/*!40000 ALTER TABLE `bilanbiologique` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bilanimmunologique`
--

DROP TABLE IF EXISTS `bilanimmunologique`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bilanimmunologique` (
  `NumBilanImmunologique` int(11) NOT NULL AUTO_INCREMENT,
  `AcAntiNucleaires` varchar(50) DEFAULT NULL,
  `AcAntimuscles` varchar(50) DEFAULT NULL,
  `AcAntimitochondries` varchar(50) DEFAULT NULL,
  `AcAntiLMK1` varchar(50) DEFAULT NULL,
  `Autres` varchar(500) DEFAULT NULL,
  `NumDossier` varchar(50) DEFAULT NULL,
  `DateBilanImmunologique` date DEFAULT NULL,
  PRIMARY KEY (`NumBilanImmunologique`),
  UNIQUE KEY `uniqueImmunolD` (`DateBilanImmunologique`,`NumDossier`),
  KEY `fk_imm` (`NumDossier`),
  CONSTRAINT `fk_imm` FOREIGN KEY (`NumDossier`) REFERENCES `dossiermedicale` (`NumDossier`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bilanimmunologique`
--

LOCK TABLES `bilanimmunologique` WRITE;
/*!40000 ALTER TABLE `bilanimmunologique` DISABLE KEYS */;
/*!40000 ALTER TABLE `bilanimmunologique` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chimioembolisation`
--

DROP TABLE IF EXISTS `chimioembolisation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chimioembolisation` (
  `NumChimioEmbolisation` int(11) NOT NULL AUTO_INCREMENT,
  `ChimioEmbolisation` varchar(50) DEFAULT NULL,
  `DateChimio` date DEFAULT NULL,
  `ChimiDrogue` varchar(50) DEFAULT NULL,
  `ChimioPosologie` varchar(50) DEFAULT NULL,
  `ChimioDateDeTrt` date DEFAULT NULL,
  `ChimioDouleurHepa` varchar(50) DEFAULT NULL,
  `ChimioNausee` varchar(50) DEFAULT NULL,
  `ChimioVomiss` varchar(50) DEFAULT NULL,
  `ChimioFievre` varchar(50) DEFAULT NULL,
  `PreciseAutreChimio` varchar(500) DEFAULT NULL,
  `SyndromePostEmbo` varchar(50) DEFAULT NULL,
  `DouleurHeptique` varchar(50) DEFAULT NULL,
  `SPENausee` varchar(50) DEFAULT NULL,
  `SPEVomissement` varchar(50) DEFAULT NULL,
  `SPEfievre` varchar(50) DEFAULT NULL,
  `EffetSecondAntimiotique` varchar(50) DEFAULT NULL,
  `ESAAlopecie` varchar(50) DEFAULT NULL,
  `ESATroubleHematologique` varchar(50) DEFAULT NULL,
  `ESATHAnemie` varchar(50) DEFAULT NULL,
  `ESATHLeucopenie` varchar(50) DEFAULT NULL,
  `ESATHThrombopenie` varchar(50) DEFAULT NULL,
  `ReactAllergRelInkectprodContraste` varchar(50) DEFAULT NULL,
  `RisqueAtteintRenale` varchar(50) DEFAULT NULL,
  `ComplicationGrave` varchar(50) DEFAULT NULL,
  `CGCholangite` varchar(50) DEFAULT NULL,
  `CGCholesistite` varchar(50) DEFAULT NULL,
  `CGAbces` varchar(50) DEFAULT NULL,
  `CGAutres` varchar(500) DEFAULT NULL,
  `ChimioEmboNbrCure` varchar(50) DEFAULT NULL,
  `NumDossier` varchar(50) DEFAULT NULL,
  `datedetrait` date DEFAULT NULL,
  PRIMARY KEY (`NumChimioEmbolisation`),
  UNIQUE KEY `uniqueChimiDate` (`datedetrait`,`NumDossier`),
  KEY `fk_chimio` (`NumDossier`),
  CONSTRAINT `fk_chimio` FOREIGN KEY (`NumDossier`) REFERENCES `dossiermedicale` (`NumDossier`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chimioembolisation`
--

LOCK TABLES `chimioembolisation` WRITE;
/*!40000 ALTER TABLE `chimioembolisation` DISABLE KEYS */;
INSERT INTO `chimioembolisation` VALUES (1,'Oui','2015-04-23','','','2015-04-23','Oui','Oui','Oui','Oui','','Oui','Oui','Oui','Oui','Oui','Oui','Oui','Oui','Oui','Oui','Oui','Oui','Oui','Oui','Oui','Oui','Oui','','1','001/15','2015-04-23');
/*!40000 ALTER TABLE `chimioembolisation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chirurgie`
--

DROP TABLE IF EXISTS `chirurgie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chirurgie` (
  `NumChirurgie` int(11) NOT NULL AUTO_INCREMENT,
  `Chirurgie` varchar(50) DEFAULT NULL,
  `Resection` varchar(50) DEFAULT NULL,
  `Segmetectomie` varchar(50) DEFAULT NULL,
  `Hepatectomie` varchar(50) DEFAULT NULL,
  `Tumorectomie` varchar(50) DEFAULT NULL,
  `AutresRes` varchar(500) DEFAULT NULL,
  `DateRes` date DEFAULT NULL,
  `Hopital` varchar(50) DEFAULT NULL,
  `PreciseAutreHopital` varchar(100) DEFAULT NULL,
  `Transplantation` varchar(50) DEFAULT NULL,
  `VieDonneur` varchar(50) DEFAULT NULL,
  `DateTransplantation` date DEFAULT NULL,
  `HopitalTransplantation` varchar(50) DEFAULT NULL,
  `AutreHopitalTransp` varchar(100) DEFAULT NULL,
  `NumDossier` varchar(50) DEFAULT NULL,
  `dateTrait` date DEFAULT NULL,
  PRIMARY KEY (`NumChirurgie`),
  UNIQUE KEY `uniqueChururgieDate` (`dateTrait`,`NumDossier`),
  KEY `fk_Chir` (`NumDossier`),
  CONSTRAINT `fk_Chir` FOREIGN KEY (`NumDossier`) REFERENCES `dossiermedicale` (`NumDossier`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chirurgie`
--

LOCK TABLES `chirurgie` WRITE;
/*!40000 ALTER TABLE `chirurgie` DISABLE KEYS */;
INSERT INTO `chirurgie` VALUES (1,'Oui','Oui','Oui','Oui','Non','','2015-04-24','CPMC','','Oui','Oui','2015-04-24','bologhine','','001/15','2015-04-24');
/*!40000 ALTER TABLE `chirurgie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `circonstancedec`
--

DROP TABLE IF EXISTS `circonstancedec`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `circonstancedec` (
  `NumCirconstanceDec` int(11) NOT NULL AUTO_INCREMENT,
  `EMTHepato` varchar(30) DEFAULT NULL,
  `DDedSympto` date DEFAULT NULL,
  `Fortuit` varchar(30) DEFAULT NULL,
  `DECSyrrhose` varchar(30) DEFAULT NULL,
  `Echographie` varchar(30) DEFAULT NULL,
  `DosAFP` varchar(30) DEFAULT NULL,
  `Amaigre` varchar(30) DEFAULT NULL,
  `Fievre` varchar(30) DEFAULT NULL,
  `Ictere` varchar(30) DEFAULT NULL,
  `DouleurHD` varchar(30) DEFAULT NULL,
  `HemoragieDes` varchar(30) DEFAULT NULL,
  `Ascite` varchar(30) DEFAULT NULL,
  `Splenomegalie` varchar(30) DEFAULT NULL,
  `TypeSpleno` varchar(30) DEFAULT NULL,
  `Autre` varchar(500) DEFAULT NULL,
  `ETGSOms` varchar(30) DEFAULT NULL,
  `BMI` varchar(30) DEFAULT NULL,
  `CVC` varchar(30) DEFAULT NULL,
  `HPM` varchar(30) DEFAULT NULL,
  `OMI` varchar(30) DEFAULT NULL,
  `AutreS` varchar(500) DEFAULT NULL,
  `SyndrParaneo` varchar(30) DEFAULT NULL,
  `SynderPrecise` varchar(500) DEFAULT NULL,
  `NumDossier` varchar(50) DEFAULT NULL,
  `hpmFH` varchar(30) DEFAULT NULL,
  `hpmConsistance` varchar(30) DEFAULT NULL,
  `hpmSurface` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`NumCirconstanceDec`),
  UNIQUE KEY `unique_circonstance` (`NumDossier`),
  CONSTRAINT `fk_cir` FOREIGN KEY (`NumDossier`) REFERENCES `dossiermedicale` (`NumDossier`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `circonstancedec`
--

LOCK TABLES `circonstancedec` WRITE;
/*!40000 ALTER TABLE `circonstancedec` DISABLE KEYS */;
INSERT INTO `circonstancedec` VALUES (1,'Oui','2015-04-23','Oui','Oui','Oui','Oui','Oui','Non','Oui','Non','Non','Non','Non','','Autre','1','30<','Oui','Non','Oui','','Oui','','001/15','Non','',''),(2,'Oui','2015-04-25','Oui','Oui','Oui','Oui','Oui','Non','Oui','Non','Non','Non','Non','','','1','30<','Oui','Non','Oui','Autre','Oui','Precise','006/15','Non','',''),(3,'Oui','2015-05-17','Oui','Oui','Non','Non','Oui','Non','Oui','Non','Non','Non','Non','','','3','30<','Oui','Oui','Oui','','Oui','	ppp','001/14','Oui','dure','irreguliere'),(4,'Oui','2015-05-17','Non','Oui','Non','Oui','Non','Oui','Non','Oui','Oui','Oui','Oui','2','Autre','3','18-25','Non','Oui','Oui','Autre','Oui','Precis','002/15','Oui','dure','irreguliere'),(6,'Oui','2015-05-17','Oui','Oui','Non','Oui','Non','Oui','Non','Oui','Oui','Oui','Oui','4','Auter','4','25-30','Non','Oui','Oui','','Oui','','004/15','Non','ferme','irreguliere'),(8,'Oui','2015-05-20','Non','Oui','Non','Non','Non','Oui','Non','Oui','Oui','Non','Oui','3','Autre','3','25-30','Oui','Oui','Oui','Autre','Oui','p','007/15','Oui','dure','reguliere');
/*!40000 ALTER TABLE `circonstancedec` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classification`
--

DROP TABLE IF EXISTS `classification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `classification` (
  `NumClassification` int(11) NOT NULL AUTO_INCREMENT,
  `ClassifChildPugh` varchar(50) DEFAULT NULL,
  `ClassifBCLC` varchar(50) DEFAULT NULL,
  `ClassifOkuda` varchar(50) DEFAULT NULL,
  `ClassifClip` varchar(50) DEFAULT NULL,
  `ClassifcationTnm` varchar(50) DEFAULT NULL,
  `NumDossier` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`NumClassification`),
  UNIQUE KEY `uniqueClassif` (`NumDossier`),
  CONSTRAINT `fk_class` FOREIGN KEY (`NumDossier`) REFERENCES `dossiermedicale` (`NumDossier`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classification`
--

LOCK TABLES `classification` WRITE;
/*!40000 ALTER TABLE `classification` DISABLE KEYS */;
INSERT INTO `classification` VALUES (1,'A','A2','1','0','I','006/15');
/*!40000 ALTER TABLE `classification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `connect`
--

DROP TABLE IF EXISTS `connect`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `connect` (
  `User` varchar(50) DEFAULT NULL,
  `PassWord` varchar(50) DEFAULT NULL,
  UNIQUE KEY `User` (`User`),
  UNIQUE KEY `PassWord` (`PassWord`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `connect`
--

LOCK TABLES `connect` WRITE;
/*!40000 ALTER TABLE `connect` DISABLE KEYS */;
INSERT INTO `connect` VALUES ('brahimi','brahimi');
/*!40000 ALTER TABLE `connect` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deces`
--

DROP TABLE IF EXISTS `deces`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `deces` (
  `DateDeces` date DEFAULT NULL,
  `Rvo` varchar(50) DEFAULT NULL,
  `Encephalopathie` varchar(50) DEFAULT NULL,
  `ProgressionT` varchar(50) DEFAULT NULL,
  `Autre` varchar(500) DEFAULT NULL,
  `NumDossier` varchar(50) DEFAULT NULL,
  UNIQUE KEY `uniqueDeces` (`NumDossier`),
  CONSTRAINT `fkDeces` FOREIGN KEY (`NumDossier`) REFERENCES `dossiermedicale` (`NumDossier`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deces`
--

LOCK TABLES `deces` WRITE;
/*!40000 ALTER TABLE `deces` DISABLE KEYS */;
INSERT INTO `deces` VALUES ('2015-05-17','Oui','Oui','Oui','Autre','001/15'),('2015-05-17','Oui','Oui','Oui','A','001/14'),('2015-05-17','Oui','Non','Oui','','001/13');
/*!40000 ALTER TABLE `deces` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dossiermedicale`
--

DROP TABLE IF EXISTS `dossiermedicale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dossiermedicale` (
  `NumDossier` varchar(10) NOT NULL DEFAULT '',
  `DateHospitalisation` date DEFAULT NULL,
  PRIMARY KEY (`NumDossier`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dossiermedicale`
--

LOCK TABLES `dossiermedicale` WRITE;
/*!40000 ALTER TABLE `dossiermedicale` DISABLE KEYS */;
INSERT INTO `dossiermedicale` VALUES ('001/13','2013-04-01'),('001/14','2014-04-29'),('001/15','2015-04-23'),('002/15','2015-04-23'),('003/15','2015-04-25'),('004/13','2013-04-29'),('004/15','2015-04-25'),('005/15','2015-04-25'),('006/15','2015-04-25'),('007/15','2015-05-17');
/*!40000 ALTER TABLE `dossiermedicale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dossiertrait`
--

DROP TABLE IF EXISTS `dossiertrait`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dossiertrait` (
  `NumDossier` varchar(50) DEFAULT NULL,
  `Nom` varchar(50) DEFAULT NULL,
  `Action` varchar(50) DEFAULT NULL,
  `now` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dossiertrait`
--

LOCK TABLES `dossiertrait` WRITE;
/*!40000 ALTER TABLE `dossiertrait` DISABLE KEYS */;
INSERT INTO `dossiertrait` VALUES ('001/15','BOUHOUNE','Consultation','2015-05-17 18:09:50'),('002/15','MERKANI','Consultation','2015-05-17 18:10:37'),('001/15','BOUHOUNE','Traitement','2015-05-17 18:16:20'),('005/15','BADISSE','Traitement','2015-05-17 19:19:17'),('001/15','BOUHOUNE','Consultation','2015-05-17 21:11:52'),('001/15','BOUHOUNE','Consultation','2015-05-17 21:13:49'),('001/15','BOUHOUNE','Traitement','2015-05-17 21:18:21'),('002/15','MERKANI','Traitement','2015-05-17 21:22:10'),('001/15','BOUHOUNE','Traitement','2015-05-17 21:24:26'),('004/15','BEN ABBDELLAH','Traitement','2015-05-17 21:26:18'),('001/15','BOUHOUNE','Consultation','2015-05-17 22:43:35'),('006/15','BOFADINA','Traitement','2015-05-20 14:01:10'),('007/15','MOURADE','Traitement','2015-05-20 14:02:24'),('001/15','BOUHOUNE','Consultation','2015-05-22 08:18:35'),('001/15','BOUHOUNE','Traitement','2015-05-22 08:32:32'),('001/14','BOUSALEM','Consultation','2015-05-22 08:33:46'),('001/15','BOUHOUNE','Traitement','2015-05-24 14:53:31'),('001/15','BOUHOUNE','Traitement','2015-05-24 14:53:41'),('001/15','BOUHOUNE','Traitement','2015-05-24 14:53:49'),('001/15','BOUHOUNE','Traitement','2015-05-24 14:53:54'),('001/14','BOUSALEM','Traitement','2015-05-24 14:55:07'),('003/15','MARTINEZ','Traitement','2015-05-24 14:55:23'),('004/15','BEN ABBDELLAH','Traitement','2015-05-24 14:56:52'),('007/15','MOURADE','Traitement','2015-05-24 14:57:05'),('007/15','MOURADE','Consultation','2015-05-24 14:57:37'),('001/15','BOUHOUNE','Traitement','2015-05-25 08:26:48'),('001/15','BOUHOUNE','Traitement','2015-05-25 14:51:29'),('001/15','BOUHOUNE','Consultation','2015-05-25 14:52:57'),('004/13','MORABET','Consultation','2015-05-27 10:14:22'),('001/13','NAILLY','Traitement','2015-05-27 10:15:13'),('007/15','MOURADE','Consultation','2015-05-27 14:54:46'),('007/15','MOURADE','Consultation','2015-05-27 14:54:53'),('005/15','BADISSE','Consultation','2015-05-28 12:13:48'),('001/14','BOUSALEM','Traitement','2015-05-28 12:15:36'),('003/15','MARTINEZ','Consultation','2015-05-28 22:48:55'),('007/15','MOURADE','Traitement','2015-05-29 10:01:48'),('004/15','BEN ABBDELLAH','Consultation','2015-05-29 18:09:31'),('004/15','BEN ABBDELLAH','Consultation','2015-05-29 18:09:32'),('004/15','BEN ABBDELLAH','Traitement','2015-05-29 18:32:21'),('004/15','BEN ABBDELLAH','Consultation','2015-05-29 18:32:38'),('004/15','BEN ABBDELLAH','Consultation','2015-05-29 18:32:45'),('001/15','BOUHOUNE','Consultation','2015-05-29 19:02:17'),('001/15','BOUHOUNE','Traitement','2015-05-29 19:02:45');
/*!40000 ALTER TABLE `dossiertrait` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `echographie`
--

DROP TABLE IF EXISTS `echographie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `echographie` (
  `NumEcho` int(11) NOT NULL AUTO_INCREMENT,
  `Echo` varchar(50) DEFAULT NULL,
  `EchoFoieReg` varchar(50) DEFAULT NULL,
  `EchoFoieHom` varchar(50) DEFAULT NULL,
  `EchoTaille` varchar(50) DEFAULT NULL,
  `EchoNbr` varchar(50) DEFAULT NULL,
  `EchoSiege` varchar(100) DEFAULT NULL,
  `EchoVasc` varchar(50) DEFAULT NULL,
  `SiOuiTypeEnvah` varchar(50) DEFAULT NULL,
  `AutreTypeEnvah` varchar(500) DEFAULT NULL,
  `EchoGanglionnaire` varchar(50) DEFAULT NULL,
  `EchoLv` varchar(50) DEFAULT NULL,
  `EchoAscite` varchar(50) DEFAULT NULL,
  `EchoAutre` varchar(500) DEFAULT NULL,
  `NumDossier` varchar(50) DEFAULT NULL,
  `DateEchographie` date DEFAULT NULL,
  PRIMARY KEY (`NumEcho`),
  UNIQUE KEY `EchographDate` (`DateEchographie`,`NumDossier`),
  KEY `fk_echo` (`NumDossier`),
  CONSTRAINT `fk_echo` FOREIGN KEY (`NumDossier`) REFERENCES `dossiermedicale` (`NumDossier`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `echographie`
--

LOCK TABLES `echographie` WRITE;
/*!40000 ALTER TABLE `echographie` DISABLE KEYS */;
INSERT INTO `echographie` VALUES (1,'Oui','régulier','homgène','<2 cm','>4','   IV    VIII','Oui','autre','pRECISE','Oui','Oui','Oui','aUTRE','001/15','2015-04-23'),(2,'Oui','régulier','homgène','>6-8','>4','   IV    VIII','Oui','autre','precise','Oui','Oui','Oui','Autre','001/15','2015-04-26'),(3,'Oui','régulier','homgène','<2 cm','>4','       VIII','Oui','branche portable','','Oui','Oui','Oui','','002/15','2015-04-26');
/*!40000 ALTER TABLE `echographie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `echographiedoppler`
--

DROP TABLE IF EXISTS `echographiedoppler`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `echographiedoppler` (
  `NumDoppler` int(11) NOT NULL AUTO_INCREMENT,
  `Doppler` varchar(50) DEFAULT NULL,
  `DopFoieReg` varchar(50) DEFAULT NULL,
  `DopFoieHom` varchar(50) DEFAULT NULL,
  `DopNodTaille` varchar(50) DEFAULT NULL,
  `DopNbr` varchar(50) DEFAULT NULL,
  `DopSiege` varchar(100) DEFAULT NULL,
  `DopVasc` varchar(50) DEFAULT NULL,
  `SiOuiTypeEnvah` varchar(50) DEFAULT NULL,
  `AutreTypeEnvah` varchar(500) DEFAULT NULL,
  `NumDossier` varchar(50) DEFAULT NULL,
  `DateDoppler` date DEFAULT NULL,
  PRIMARY KEY (`NumDoppler`),
  UNIQUE KEY `uniqueEchoDoppDate` (`DateDoppler`,`NumDossier`),
  KEY `fk_echodop` (`NumDossier`),
  CONSTRAINT `fk_echodop` FOREIGN KEY (`NumDossier`) REFERENCES `dossiermedicale` (`NumDossier`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `echographiedoppler`
--

LOCK TABLES `echographiedoppler` WRITE;
/*!40000 ALTER TABLE `echographiedoppler` DISABLE KEYS */;
/*!40000 ALTER TABLE `echographiedoppler` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evolution`
--

DROP TABLE IF EXISTS `evolution`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evolution` (
  `Mois` varchar(50) DEFAULT NULL,
  `EtatEvol` varchar(50) DEFAULT NULL,
  `Clinique` varchar(500) DEFAULT NULL,
  `Radiologique` varchar(500) DEFAULT NULL,
  `Afp` varchar(500) DEFAULT NULL,
  `NumDossier` varchar(50) DEFAULT NULL,
  UNIQUE KEY `uniqueMoisDossEvol` (`Mois`,`NumDossier`),
  KEY `Evolfk` (`NumDossier`),
  CONSTRAINT `Evolfk` FOREIGN KEY (`NumDossier`) REFERENCES `dossiermedicale` (`NumDossier`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evolution`
--

LOCK TABLES `evolution` WRITE;
/*!40000 ALTER TABLE `evolution` DISABLE KEYS */;
INSERT INTO `evolution` VALUES ('3 mois ','Oui','Cilnique','Radiologique','AFP','001/15'),('6 mois ','Oui','Clinique 2','Radiologique','AFp','001/15'),('9 mois ','Non','Clinique','RRR','AAAAF','001/15'),('12 mois ','Oui','Mom','mOM','mOM','001/15'),('15 mois ','Oui','','','','001/15'),('18 mois ','Oui','','','','001/15'),('21 mois ','Oui','','','','001/15'),('3 mois ','Oui','Clinique','R','AFP','001/14'),('6 mois ','Oui','Clinique','Radiologue','AFP','001/14');
/*!40000 ALTER TABLE `evolution` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `irm`
--

DROP TABLE IF EXISTS `irm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `irm` (
  `NumIRM` int(11) NOT NULL AUTO_INCREMENT,
  `IRM` varchar(50) DEFAULT NULL,
  `IRMFoieReg` varchar(50) DEFAULT NULL,
  `IRMFoieHom` varchar(50) DEFAULT NULL,
  `IRMNodTaille` varchar(50) DEFAULT NULL,
  `IRMNbr` varchar(50) DEFAULT NULL,
  `IRMSiege` varchar(100) DEFAULT NULL,
  `IRMVasc` varchar(50) DEFAULT NULL,
  `SiOuiTypeEnvah` varchar(50) DEFAULT NULL,
  `AutreTypeEnvah` varchar(500) DEFAULT NULL,
  `IRMGanglionnaire` varchar(50) DEFAULT NULL,
  `IRMGanglType` varchar(50) DEFAULT NULL,
  `IRMAutre` varchar(500) DEFAULT NULL,
  `NumDossier` varchar(50) DEFAULT NULL,
  `DateIRM` date DEFAULT NULL,
  PRIMARY KEY (`NumIRM`),
  UNIQUE KEY `uniqueDateIrm` (`DateIRM`,`NumDossier`),
  KEY `fk_irm` (`NumDossier`),
  CONSTRAINT `fk_irm` FOREIGN KEY (`NumDossier`) REFERENCES `dossiermedicale` (`NumDossier`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `irm`
--

LOCK TABLES `irm` WRITE;
/*!40000 ALTER TABLE `irm` DISABLE KEYS */;
/*!40000 ALTER TABLE `irm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient` (
  `NumPatient` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(50) DEFAULT NULL,
  `Prenom` varchar(50) DEFAULT NULL,
  `NomJeuneFille` varchar(50) DEFAULT NULL,
  `Sexe` varchar(50) DEFAULT NULL,
  `Wilaya` varchar(50) DEFAULT NULL,
  `Profession` varchar(50) DEFAULT NULL,
  `Adresse` varchar(50) DEFAULT NULL,
  `Telephone1` varchar(50) DEFAULT NULL,
  `Telephone2` varchar(50) DEFAULT NULL,
  `SituationFamiliale` varchar(50) DEFAULT NULL,
  `CondSocioEco` varchar(50) DEFAULT NULL,
  `NumDossier` varchar(10) DEFAULT NULL,
  `Age` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`NumPatient`),
  KEY `fk_pat` (`NumDossier`),
  CONSTRAINT `fk_pat` FOREIGN KEY (`NumDossier`) REFERENCES `dossiermedicale` (`NumDossier`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES (24,'BOUHOUNE','Malek','','Masculin','Alger','AGENT','SPAIN 222-55','0555485698','0555485698','Marie','bonne','001/15','50'),(27,'MERKANI','Molay','','Masculin','Alger','Commerçant ','BabEzzouare','0984864514','0984864514','Marie','bonne','002/15','50'),(28,'MOUKRANI','Redoine ','','Masculin','Alger','Professeur','Paris -255','0512479845','0512479845','Marie','bonne','003/15','50'),(29,'BEN ABBDELLAH','Said','','Masculin','Alger','Agent','Dar Elbida','0552364789','0552364789','Marie',' moyenne','004/15','40'),(30,'BADISSE','Mostapha','','Masculin','Ouargla','Rien','Ouargla','0578498465','0578498465','Marie','bonne ','005/15','16'),(31,'BOFADINA','Mohamed','','Masculin','Batna','POLICIER','205-20','0785462135','0785642318','Marie',' mauvaise','006/15','20'),(32,'BOUSALEM','Nacira','','Féminin','Chlef','Rien','Ome Edroue','0554865235','0559986442','Marie','bonne','001/14','65'),(33,'NAILLY','Nabila','','Masculin','Alger','Rien','Alger','0784598231','0556289745','Célibataire','bonne','001/13','13'),(35,'MOURADE','Merzek','','Masculin','Bayadh','PLOICIER','255','0778974659','0578794651','Célibataire','bonne','007/15','16'),(36,'MORABET','Karim','','Masculin','Tiaret','enseignant ','Frenda','0778546998','0557894456','Marie','bonne','004/13','30');
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `radiofrequence`
--

DROP TABLE IF EXISTS `radiofrequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `radiofrequence` (
  `NumRadioFreq` int(11) NOT NULL AUTO_INCREMENT,
  `RadoiFrequence` varchar(50) DEFAULT NULL,
  `RadioFreqPercutannee` varchar(50) DEFAULT NULL,
  `DateRadioFreq` date DEFAULT NULL,
  `FreqDateDebTrt` date DEFAULT NULL,
  `FreqDoulHepat` varchar(50) DEFAULT NULL,
  `FreqNausee` varchar(50) DEFAULT NULL,
  `FreqVomissement` varchar(50) DEFAULT NULL,
  `FreqFievre` varchar(50) DEFAULT NULL,
  `FreqAutre` varchar(500) DEFAULT NULL,
  `FreqNbrCure` varchar(50) DEFAULT NULL,
  `NumDossier` varchar(50) DEFAULT NULL,
  `DateTraitement` date DEFAULT NULL,
  PRIMARY KEY (`NumRadioFreq`),
  UNIQUE KEY `uniqueRadioFDate` (`DateTraitement`,`NumDossier`),
  KEY `fk_radiof` (`NumDossier`),
  CONSTRAINT `fk_radiof` FOREIGN KEY (`NumDossier`) REFERENCES `dossiermedicale` (`NumDossier`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `radiofrequence`
--

LOCK TABLES `radiofrequence` WRITE;
/*!40000 ALTER TABLE `radiofrequence` DISABLE KEYS */;
INSERT INTO `radiofrequence` VALUES (1,'Oui','Percutanée','2015-04-24','2015-04-24','Oui','Oui','Oui','Oui','','1','001/15','2015-04-24');
/*!40000 ALTER TABLE `radiofrequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rendezvous`
--

DROP TABLE IF EXISTS `rendezvous`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rendezvous` (
  `NumRendezVous` int(11) NOT NULL AUTO_INCREMENT,
  `DateRendezVous` date DEFAULT NULL,
  `HeureRendezVous` varchar(50) DEFAULT NULL,
  `Avec` varchar(50) DEFAULT NULL,
  `sujet` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`NumRendezVous`),
  UNIQUE KEY `uniqueRdvDH` (`DateRendezVous`,`HeureRendezVous`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rendezvous`
--

LOCK TABLES `rendezvous` WRITE;
/*!40000 ALTER TABLE `rendezvous` DISABLE KEYS */;
INSERT INTO `rendezvous` VALUES (27,'2015-04-30','09:00','Avec','Sujet Sujet'),(28,'2015-05-17','09:00','Mohamed','Mohamed'),(29,'2015-05-25','09:00','Mr Zahfoune','Correction de PFE '),(30,'2015-05-28','09:00','Khettar','sur la date de soutenance'),(31,'2015-05-29','09:00','MERZAKI Mohamed','IRM ');
/*!40000 ALTER TABLE `rendezvous` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tdm`
--

DROP TABLE IF EXISTS `tdm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tdm` (
  `NumTDM` int(11) NOT NULL AUTO_INCREMENT,
  `TDM` varchar(50) DEFAULT NULL,
  `TDMFoieReg` varchar(50) DEFAULT NULL,
  `TDMFoieHom` varchar(50) DEFAULT NULL,
  `TDMNodTaille` varchar(50) DEFAULT NULL,
  `TDMNbr` varchar(50) DEFAULT NULL,
  `TDMSiege` varchar(100) DEFAULT NULL,
  `TDMVasc` varchar(50) DEFAULT NULL,
  `SiOuiTypeEnvah` varchar(50) DEFAULT NULL,
  `AutreTypeEnvah` varchar(500) DEFAULT NULL,
  `TDMGanglionnaire` varchar(50) DEFAULT NULL,
  `TDMGanglType` varchar(50) DEFAULT NULL,
  `TDMAutre` varchar(500) DEFAULT NULL,
  `NumDossier` varchar(50) DEFAULT NULL,
  `datetdm` date DEFAULT NULL,
  PRIMARY KEY (`NumTDM`),
  UNIQUE KEY `uniqueTdmDate` (`datetdm`,`NumDossier`),
  KEY `fk_tdm` (`NumDossier`),
  CONSTRAINT `fk_tdm` FOREIGN KEY (`NumDossier`) REFERENCES `dossiermedicale` (`NumDossier`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tdm`
--

LOCK TABLES `tdm` WRITE;
/*!40000 ALTER TABLE `tdm` DISABLE KEYS */;
/*!40000 ALTER TABLE `tdm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `therapiescibles`
--

DROP TABLE IF EXISTS `therapiescibles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `therapiescibles` (
  `NumTherapie` int(11) NOT NULL AUTO_INCREMENT,
  `TherapieCible` varchar(50) DEFAULT NULL,
  `TCDate` date DEFAULT NULL,
  `TCDrogue` varchar(50) DEFAULT NULL,
  `TCPosologie` varchar(50) DEFAULT NULL,
  `TCDateDebTRT` date DEFAULT NULL,
  `TcSMP` varchar(50) DEFAULT NULL,
  `TCDiarree` varchar(50) DEFAULT NULL,
  `GlobuleBlanche` varchar(50) DEFAULT NULL,
  `Graulocytes` varchar(50) DEFAULT NULL,
  `Lymphocytes` varchar(50) DEFAULT NULL,
  `Plaquette` varchar(50) DEFAULT NULL,
  `Hemoglobines` varchar(50) DEFAULT NULL,
  `Hemorragies` varchar(50) DEFAULT NULL,
  `TCCutanees` varchar(50) DEFAULT NULL,
  `NumDossier` varchar(50) DEFAULT NULL,
  `DateTrait` date DEFAULT NULL,
  PRIMARY KEY (`NumTherapie`),
  UNIQUE KEY `uniqueTherapieDate` (`DateTrait`,`NumDossier`),
  KEY `fk_therap` (`NumDossier`),
  CONSTRAINT `fk_therap` FOREIGN KEY (`NumDossier`) REFERENCES `dossiermedicale` (`NumDossier`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `therapiescibles`
--

LOCK TABLES `therapiescibles` WRITE;
/*!40000 ALTER TABLE `therapiescibles` DISABLE KEYS */;
INSERT INTO `therapiescibles` VALUES (1,'Oui','2015-04-24','','','2015-04-24','0','0','0','0','0','0','0','0','0','001/15','2015-04-24'),(2,'Oui','2015-05-22','','','2015-05-22','3','0','0','0','0','2','2','0','2','001/15','2015-05-22'),(3,'Oui','2015-05-25','Drogue','Posologie','2015-05-25','2','3','0','0','3','0','2','3','3','001/15','2015-05-25');
/*!40000 ALTER TABLE `therapiescibles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `traitementantivirale`
--

DROP TABLE IF EXISTS `traitementantivirale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `traitementantivirale` (
  `NumTraitAntiVirale` int(11) NOT NULL AUTO_INCREMENT,
  `TraitementAntiViral` varchar(50) DEFAULT NULL,
  `TADateDeb` date DEFAULT NULL,
  `ChargeViraleInitial` varchar(100) DEFAULT NULL,
  `TADrogue` varchar(50) DEFAULT NULL,
  `TAEntecavir` varchar(50) DEFAULT NULL,
  `TABitherapie` varchar(50) DEFAULT NULL,
  `TATritherapie` varchar(50) DEFAULT NULL,
  `TALamvidine` varchar(50) DEFAULT NULL,
  `TAAutre` varchar(500) DEFAULT NULL,
  `NumDossier` varchar(50) DEFAULT NULL,
  `DateTrait` date DEFAULT NULL,
  PRIMARY KEY (`NumTraitAntiVirale`),
  UNIQUE KEY `uniqueTraitV` (`DateTrait`,`NumDossier`),
  KEY `fk_ant` (`NumDossier`),
  CONSTRAINT `fk_ant` FOREIGN KEY (`NumDossier`) REFERENCES `dossiermedicale` (`NumDossier`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `traitementantivirale`
--

LOCK TABLES `traitementantivirale` WRITE;
/*!40000 ALTER TABLE `traitementantivirale` DISABLE KEYS */;
/*!40000 ALTER TABLE `traitementantivirale` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-05-29 19:05:41
