-- --------------------------------------------------------
-- Hôte :                        127.0.0.1
-- Version du serveur:           5.7.21-log - MySQL Community Server (GPL)
-- SE du serveur:                Win64
-- HeidiSQL Version:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Export de la structure de la base pour test
DROP DATABASE IF EXISTS `test`;
CREATE DATABASE IF NOT EXISTS `test` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `test`;
-- Create de l'user de connexion pour les test
DROP USER IF EXISTS 'test';
CREATE USER 'test'@'%' IDENTIFIED BY 'test';
GRANT ALL PRIVILEGES ON test.* TO 'test'@'%';

-- Export de la structure de la table test. client
CREATE TABLE IF NOT EXISTS `client` (
  `CLIENT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `MERCHANT_ID` int(11) NOT NULL,
  `SIPS_ALIAS` varchar(100) DEFAULT NULL,
  `ENVIRONMENT` varchar(15) DEFAULT NULL,
  `PROTOCOL` varchar(10) DEFAULT NULL,
  `BANK_NAME` varchar(10) NOT NULL,
  `FTP_GW` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`CLIENT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Les données exportées n'étaient pas sélectionnées.
-- Export de la structure de la table test. configuration
CREATE TABLE IF NOT EXISTS `configuration` (
  `CONFIGURATION_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME_FILE` varchar(25) DEFAULT NULL,
  `PROFILE` varchar(25) DEFAULT NULL,
  `NAME_DEST` varchar(50) DEFAULT NULL,
  `NAME_ZIP` varchar(50) DEFAULT NULL,
  `DELETE_FLAG` tinyint(1) DEFAULT NULL,
  `MULTIPLE` int(11) DEFAULT NULL,
  `OCCURENCE` int(11) DEFAULT NULL,
  `COMMENT` varchar(200) DEFAULT NULL,
  `LIST_SERV` varchar(200) DEFAULT NULL,
  `RELEASES` varchar(25) DEFAULT NULL,
  `PROJECT_ID` int(11) NOT NULL,
  `CLIENT_ID` int(11) NOT NULL,
  PRIMARY KEY (`CONFIGURATION_ID`),
  KEY `FK_CONFIGURATION_PROJECT_ID` (`PROJECT_ID`),
  KEY `FK_CONFIGURATION_CLIENT_ID` (`CLIENT_ID`),
  CONSTRAINT `FK_CONFIGURATION_CLIENT_ID` FOREIGN KEY (`CLIENT_ID`) REFERENCES `client` (`CLIENT_ID`),
  CONSTRAINT `FK_CONFIGURATION_PROJECT_ID` FOREIGN KEY (`PROJECT_ID`) REFERENCES `project` (`PROJECT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Les données exportées n'étaient pas sélectionnées.
-- Export de la structure de la table test. employee
CREATE TABLE IF NOT EXISTS `employee` (
  `EMPLOYEE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `EMPLOYEE_NAME` varchar(50) DEFAULT NULL,
  `TEAMS_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`EMPLOYEE_ID`),
  KEY `FK_EMPLOYEE_TEAMS_ID` (`TEAMS_ID`),
  CONSTRAINT `FK_EMPLOYEE_TEAMS_ID` FOREIGN KEY (`TEAMS_ID`) REFERENCES `teams` (`TEAMS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Les données exportées n'étaient pas sélectionnées.
-- Export de la structure de la table test. history_client
CREATE TABLE IF NOT EXISTS `history_client` (
  `CLIENT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `UPDATE_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `MERCHANT_ID` int(11) NOT NULL,
  `SIPS_ALIAS` varchar(100) DEFAULT NULL,
  `ENVIRONMENT` varchar(15) DEFAULT NULL,
  `PROTOCOL` varchar(10) DEFAULT NULL,
  `BANK_NAME` varchar(10) NOT NULL,
  `FTP_GW` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`CLIENT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Les données exportées n'étaient pas sélectionnées.
-- Export de la structure de la table test. history_configuration
CREATE TABLE IF NOT EXISTS `history_configuration` (
  `CONFIGURATION_ID` int(11) NOT NULL AUTO_INCREMENT,
  `UPDATE_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `NAME_FILE` varchar(25) DEFAULT NULL,
  `PROFILE` varchar(25) DEFAULT NULL,
  `NAME_DEST` varchar(50) DEFAULT NULL,
  `NAME_ZIP` varchar(50) DEFAULT NULL,
  `DELETE_FLAG` tinyint(1) DEFAULT NULL,
  `MULTIPLE` int(11) DEFAULT NULL,
  `OCCURENCE` int(11) DEFAULT NULL,
  `COMMENT` varchar(200) DEFAULT NULL,
  `LIST_SERV` varchar(200) DEFAULT NULL,
  `RELEASES` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`CONFIGURATION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Les données exportées n'étaient pas sélectionnées.
-- Export de la structure de la table test. history_project
CREATE TABLE IF NOT EXISTS `history_project` (
  `PROJECT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `UPDATE_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `LABEL` varchar(50) DEFAULT NULL,
  `START_DATE` date DEFAULT NULL,
  `TARGET_DATE` date DEFAULT NULL,
  `END_DATE` date DEFAULT NULL,
  `PROJECT_STATUS` int(11) DEFAULT NULL,
  PRIMARY KEY (`PROJECT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Les données exportées n'étaient pas sélectionnées.
-- Export de la structure de la table test. log
CREATE TABLE IF NOT EXISTS `log` (
  `LOG_ID` int(11) NOT NULL AUTO_INCREMENT,
  `DATE_EVENT` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `COMMENTS` varchar(255) DEFAULT NULL,
  `EMPLOYEE_ID` int(11) NOT NULL,
  PRIMARY KEY (`LOG_ID`),
  KEY `FK_LOG_EMPLOYEE_ID` (`EMPLOYEE_ID`),
  CONSTRAINT `FK_LOG_EMPLOYEE_ID` FOREIGN KEY (`EMPLOYEE_ID`) REFERENCES `employee` (`EMPLOYEE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Les données exportées n'étaient pas sélectionnées.
-- Export de la structure de la table test. project
CREATE TABLE IF NOT EXISTS `project` (
  `PROJECT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `LABEL` varchar(50) DEFAULT NULL,
  `START_DATE` date DEFAULT NULL,
  `TARGET_DATE` date DEFAULT NULL,
  `END_DATE` date DEFAULT NULL,
  `PROJECT_STATUS` int(11) DEFAULT NULL,
  PRIMARY KEY (`PROJECT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Les données exportées n'étaient pas sélectionnées.
-- Export de la structure de la table test. teams
CREATE TABLE IF NOT EXISTS `teams` (
  `TEAMS_ID` int(11) NOT NULL AUTO_INCREMENT,
  `TEAMS_NAME` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`TEAMS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Les données exportées n'étaient pas sélectionnées.
-- Export de la structure de la table test. work_on
CREATE TABLE IF NOT EXISTS `work_on` (
  `JOBS` varchar(50) DEFAULT NULL,
  `EMPLOYEE_ID` int(11) NOT NULL,
  `PROJECT_ID` int(11) NOT NULL,
  PRIMARY KEY (`EMPLOYEE_ID`,`PROJECT_ID`),
  KEY `FK_work_on_PROJECT_ID` (`PROJECT_ID`),
  CONSTRAINT `FK_work_on_EMPLOYEE_ID` FOREIGN KEY (`EMPLOYEE_ID`) REFERENCES `employee` (`EMPLOYEE_ID`),
  CONSTRAINT `FK_work_on_PROJECT_ID` FOREIGN KEY (`PROJECT_ID`) REFERENCES `project` (`PROJECT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Les données exportées n'étaient pas sélectionnées.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
