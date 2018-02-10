#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------
DROP DATABASE IF EXISTS `test`;
CREATE DATABASE IF NOT EXISTS `test` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `test`;
-- Create de l'user de connexion pour les test
DROP USER IF EXISTS 'test';
CREATE USER 'test'@'%' IDENTIFIED BY 'test';
GRANT ALL PRIVILEGES ON test.* TO 'test'@'%';

#------------------------------------------------------------
# Table: EMPLOYEE
#------------------------------------------------------------

CREATE TABLE EMPLOYEE(
        EMPLOYEE_ID   int (11) Auto_increment  NOT NULL ,
        EMPLOYEE_NAME Varchar (200) ,
        TEAMS_ID      Int ,
        PRIMARY KEY (EMPLOYEE_ID )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: CLIENT
#------------------------------------------------------------

CREATE TABLE CLIENT(
        CLIENT_ID       int (11) Auto_increment  NOT NULL ,
        MERCHANT_ID     Varchar (15) ,
        SIPS_ALIAS      Varchar (100) ,
        ENVIRONMENT     Varchar (15) ,
        PROTOCOL        Varchar (10) ,
        BANK_NAME       Varchar (10) NOT NULL ,
        MERCHANT_FTP    Varchar (200) ,
        PRIMARY KEY (CLIENT_ID )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: PROJECT
#------------------------------------------------------------

CREATE TABLE PROJECT(
        PROJECT_ID     int (11) Auto_increment  NOT NULL ,
        LABEL          Varchar (200) ,
        START_DATE     Date ,
        TARGET_DATE    Date ,
        END_DATE       Date ,
        PROJECT_STATUS Int ,
        PRIMARY KEY (PROJECT_ID )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: CONFIGURATION
#------------------------------------------------------------

CREATE TABLE CONFIGURATION(
        CONFIGURATION_ID int (11) Auto_increment  NOT NULL ,
        PROFILE          Varchar (200) ,
        NAME_FILE        Varchar (200) ,
        NAME_ZIP         Varchar (200) ,
        DELETE_FLAG      Bool ,
        MULTIPLE         Int ,
        OCCURENCE        Int ,
        FORCED_NAME_ZIP  Varchar (200) ,
        FORCED_NAME_FILE Varchar (200) ,
        COMMENT          Varchar (200) ,
        LIST_SERV        Varchar (200) ,
        RELEASES         Varchar (200) ,
        EXTENTION_FILE   Varchar (50)  ,
        EXTENTION_ZIP    Varchar (50)  ,
        DATE_FORMAT      Varchar (50) ,
        PROJECT_ID       Int NOT NULL ,
        CLIENT_ID        Int NOT NULL ,
        PRIMARY KEY (CONFIGURATION_ID )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: TEAMS
#------------------------------------------------------------

CREATE TABLE TEAMS(
        TEAMS_ID   int (11) Auto_increment  NOT NULL ,
        TEAMS_NAME Varchar (200) ,
        PRIMARY KEY (TEAMS_ID )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: LOG
#------------------------------------------------------------

CREATE TABLE LOG(
        LOG_ID      int (11) Auto_increment  NOT NULL ,
        DATE_EVENT  TimeStamp ,
        COMMENTS    Varchar (255) ,
        EMPLOYEE_ID Int NOT NULL ,
        PRIMARY KEY (LOG_ID )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: HISTORY_PROJECT
#------------------------------------------------------------

CREATE TABLE HISTORY_PROJECT(
        PROJECT_ID     int (11) Auto_increment  NOT NULL ,
        UPDATE_DATE    TimeStamp ,
        LABEL          Varchar (200) ,
        START_DATE     Date ,
        TARGET_DATE    Date ,
        END_DATE       Date ,
        PROJECT_STATUS Int ,
        PRIMARY KEY (PROJECT_ID )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: HISTORY_CONFIGURATION
#------------------------------------------------------------

CREATE TABLE HISTORY_CONFIGURATION(
        CONFIGURATION_ID int (11) Auto_increment  NOT NULL ,
        UPDATE_DATE      TimeStamp NOT NULL ,
        PROFILE          Varchar (200) ,
        NAME_FILE        Varchar (200) ,
        NAME_ZIP         Varchar (200) ,
        FORCED_NAME_ZIP  Varchar (200) ,
        FORCED_NAME_FILE Varchar (200) ,
        DELETE_FLAG      Bool ,
        MULTIPLE         Int ,
        OCCURENCE        Int ,
        COMMENT          Varchar (200) ,
        EXTENTION_FILE   Varchar (50)  ,
        EXTENTION_ZIP    Varchar (50)  ,
        DATE_FORMAT      Varchar (50) ,
        LIST_SERV        Varchar (200) ,
        RELEASES         Varchar (200) ,
        PRIMARY KEY (CONFIGURATION_ID )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: HISTORY_CLIENT
#------------------------------------------------------------

CREATE TABLE HISTORY_CLIENT(
        CLIENT_ID       int (11) Auto_increment  NOT NULL ,
        UPDATE_DATE     TimeStamp NOT NULL ,
        MERCHANT_ID     Int NOT NULL ,
        SIPS_ALIAS      Varchar (100) ,
        ENVIRONMENT     Varchar (15) ,
        PROTOCOL        Varchar (10) ,
        BANK_NAME       Varchar (10) NOT NULL ,
        MERCHANT_FTP    Varchar (200) ,
        PRIMARY KEY (CLIENT_ID )
)ENGINE=InnoDB;

#------------------------------------------------------------
# Table: TRANSCODE
#------------------------------------------------------------

CREATE TABLE TRANSCODE(
        TRANSCODE_ID    int (11) Auto_increment  NOT NULL ,
        LOG_TYPE        Varchar (100) ,
        DB_VALUE        Varchar (100) ,
        CONF_VALUE      Varchar (100) ,
        PRIMARY KEY (TRANSCODE_ID )
)ENGINE=InnoDB;

#------------------------------------------------------------
# Table: work_on
#------------------------------------------------------------

CREATE TABLE work_on(
        JOBS        Varchar (200) ,
        EMPLOYEE_ID Int NOT NULL ,
        PROJECT_ID  Int NOT NULL ,
        PRIMARY KEY (EMPLOYEE_ID ,PROJECT_ID )
)ENGINE=InnoDB;

ALTER TABLE EMPLOYEE ADD CONSTRAINT FK_EMPLOYEE_TEAMS_ID FOREIGN KEY (TEAMS_ID) REFERENCES TEAMS(TEAMS_ID);
ALTER TABLE CONFIGURATION ADD CONSTRAINT FK_CONFIGURATION_PROJECT_ID FOREIGN KEY (PROJECT_ID) REFERENCES PROJECT(PROJECT_ID);
ALTER TABLE CONFIGURATION ADD CONSTRAINT FK_CONFIGURATION_CLIENT_ID FOREIGN KEY (CLIENT_ID) REFERENCES CLIENT(CLIENT_ID);
ALTER TABLE LOG ADD CONSTRAINT FK_LOG_EMPLOYEE_ID FOREIGN KEY (EMPLOYEE_ID) REFERENCES EMPLOYEE(EMPLOYEE_ID);
ALTER TABLE work_on ADD CONSTRAINT FK_work_on_EMPLOYEE_ID FOREIGN KEY (EMPLOYEE_ID) REFERENCES EMPLOYEE(EMPLOYEE_ID);
ALTER TABLE work_on ADD CONSTRAINT FK_work_on_PROJECT_ID FOREIGN KEY (PROJECT_ID) REFERENCES PROJECT(PROJECT_ID);
