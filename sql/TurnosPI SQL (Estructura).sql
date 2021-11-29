CREATE DATABASE  IF NOT EXISTS `turnospi` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `turnospi`;
-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: turnospi
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
-- Table structure for table `especialidad`
--

DROP TABLE IF EXISTS `especialidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `especialidad` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre_especialidad` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `historiaclinica`
--

DROP TABLE IF EXISTS `historiaclinica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `historiaclinica` (
  `id_historia_clinica` int NOT NULL AUTO_INCREMENT,
  `historia_clinica` longtext,
  PRIMARY KEY (`id_historia_clinica`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `medico`
--

DROP TABLE IF EXISTS `medico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medico` (
  `id_medico` int NOT NULL AUTO_INCREMENT,
  `nombres` varchar(120) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `documento` int NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `telefono_fijo` varchar(45) DEFAULT NULL,
  `telefono_celular` varchar(45) NOT NULL,
  `departamento` varchar(45) DEFAULT NULL,
  `codigo_postal` int DEFAULT NULL,
  `localidad` int NOT NULL,
  PRIMARY KEY (`id_medico`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `medico_especialidad`
--

DROP TABLE IF EXISTS `medico_especialidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medico_especialidad` (
  `id_medico_especialidad` int NOT NULL AUTO_INCREMENT,
  `id_medico` int NOT NULL,
  `id_especialidad` int NOT NULL,
  PRIMARY KEY (`id_medico_especialidad`),
  KEY `medico_especialidadEspecialidad_idx` (`id_especialidad`),
  KEY `medico_especialidadMedico_idx` (`id_medico`),
  CONSTRAINT `fk_especialidad_especialidad_nombre` FOREIGN KEY (`id_especialidad`) REFERENCES `especialidad` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_medico_especialidad` FOREIGN KEY (`id_medico`) REFERENCES `medico` (`id_medico`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `paciente`
--

DROP TABLE IF EXISTS `paciente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `paciente` (
  `id_paciente` int NOT NULL AUTO_INCREMENT,
  `nombres` varchar(120) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `documento` bigint NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `telefono_fijo` varchar(20) DEFAULT NULL,
  `telefono_celular` varchar(20) NOT NULL,
  `departamento` varchar(45) DEFAULT NULL,
  `codigo_postal` int DEFAULT NULL,
  `localidad` int NOT NULL,
  `id_historia_clinica` int DEFAULT NULL,
  PRIMARY KEY (`id_paciente`),
  KEY `pacienteHistoriaClinica_idx` (`id_historia_clinica`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `paciente_turnos`
--

DROP TABLE IF EXISTS `paciente_turnos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `paciente_turnos` (
  `id_paciente_turnos` int NOT NULL AUTO_INCREMENT,
  `id_paciente` int NOT NULL,
  `id_turnos` int NOT NULL,
  PRIMARY KEY (`id_paciente_turnos`),
  KEY `pacienteturnos_turnos_idx` (`id_turnos`),
  KEY `pacienteturnos_paciente_idx` (`id_paciente`),
  CONSTRAINT `pacienteturnos_paciente` FOREIGN KEY (`id_paciente`) REFERENCES `paciente` (`id_paciente`),
  CONSTRAINT `pacienteturnos_turnos` FOREIGN KEY (`id_turnos`) REFERENCES `turnos` (`idTurno`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_cs_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `turnos`
--

DROP TABLE IF EXISTS `turnos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `turnos` (
  `idTurno` int NOT NULL AUTO_INCREMENT,
  `idPaciente` int NOT NULL,
  `IdMedico` int NOT NULL,
  `Fecha` date NOT NULL,
  `Horario` time NOT NULL,
  PRIMARY KEY (`idTurno`),
  KEY `turnos_paciente_idx` (`idPaciente`),
  KEY `turnos_medico_idx` (`IdMedico`),
  CONSTRAINT `turnos_medico` FOREIGN KEY (`IdMedico`) REFERENCES `medico` (`id_medico`),
  CONSTRAINT `turnos_paciente` FOREIGN KEY (`idPaciente`) REFERENCES `paciente` (`id_paciente`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-29  2:57:23
