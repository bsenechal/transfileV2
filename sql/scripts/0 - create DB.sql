#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------
CREATE DATABASE test;
USE test;

#------------------------------------------------------------
# Table: LOG_ID
#------------------------------------------------------------

CREATE TABLE LOG_ID(
        LOG_ID      int (11) Auto_increment  NOT NULL ,
        DATE_EVENT  TimeStamp ,
        COMMENTS    Varchar (255) ,
        EMPLOYEE_ID Int ,
        PRIMARY KEY (LOG_ID )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: EMPLOYEE
#------------------------------------------------------------

CREATE TABLE EMPLOYEE(
        EMPLOYEE_ID   int (11) Auto_increment  NOT NULL ,
        EMPLOYEE_NAME Varchar (255) ,
        TEAM_ID       Int ,
        PRIMARY KEY (EMPLOYEE_ID )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: TEAM
#------------------------------------------------------------

CREATE TABLE TEAM(
        TEAM_ID   int (11) Auto_increment  NOT NULL ,
        TEAM_NAME Varchar (255) ,
        PRIMARY KEY (TEAM_ID )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: PROJECT
#------------------------------------------------------------

CREATE TABLE PROJECT(
        PROJECT_ID     int (11) Auto_increment  NOT NULL ,
        LABEL          Varchar (255) ,
        CREATION_DATE  Date ,
        TARGET_DATE    Date ,
        PROJECT_STATUS Int ,
        PRIMARY KEY (PROJECT_ID )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: HISTORY_PROJECT
#------------------------------------------------------------

CREATE TABLE HISTORY_PROJECT(
        PROJECT_ID     int (11) Auto_increment  NOT NULL ,
        UPDATE_DATE    Date NOT NULL ,
        LABEL          Varchar (255) NOT NULL ,
        START_DATE     Date NOT NULL ,
        CREATION_DATE  Date NOT NULL ,
        TARGET_DATE    Date NOT NULL ,
        PROJECT_STATUS Int NOT NULL ,
        PRIMARY KEY (PROJECT_ID )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: CONFIGURATION
#------------------------------------------------------------

CREATE TABLE CONFIGURATION(
        CONFIG_ID        int (11) Auto_increment  NOT NULL ,
        LOG_TYPE         Varchar (255) ,
        PROFILE          Varchar (255) ,
        NAME_FILE        Varchar (255) ,
        NAME_ZIP         Varchar (255) ,
        DELETE_FLAG      Bool ,
        MULTIPLE         Int ,
        OCCURENCE        Int ,
        COMMENTS         Varchar (255) ,
        HOST_LIST        Varchar (255) ,
        RELEASE_NUMBER   Varchar (255) ,
        FORCED_ZIP_NAME  Varchar (255) ,
        FORCED_FILE_NAME Varchar (255) ,
        EXTENTION        Varchar (50) ,
        DATE_FORMAT      Varchar (250) ,
        PROJECT_ID       Int ,
        CLIENT_ID        Int NOT NULL ,
        PRIMARY KEY (CONFIG_ID )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: HISTORY_CONFIGURATION
#------------------------------------------------------------

CREATE TABLE HISTORY_CONFIGURATION(
        CONFIG_ID        int (11) Auto_increment  NOT NULL ,
        LOG_TYPE         Varchar (255) ,
        UPDATE_DATE      TimeStamp ,
        NAME_ZIP         Varchar (255) ,
        DELETE_FLAG      Bool ,
        MULTIPLE         Int ,
        OCCURENCE        Int ,
        FORCED_NAME      Varchar (255) ,
        HOST_LIST        Varchar (255) ,
        RELEASE_NUMBER   Varchar (255) ,
        FORCED_ZIP_NAME  Varchar (255) ,
        FORCED_FILE_NAME Varchar (255) ,
        EXTENTION        Varchar (50) ,
        DATE_FORMAT      Varchar (250) ,
        PRIMARY KEY (CONFIG_ID )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: TRANSCODE
#------------------------------------------------------------

CREATE TABLE TRANSCODE(
        TRANSCODE_ID int (11) Auto_increment  NOT NULL ,
        LOG_TYPE     Varchar (255) ,
        DB_VALUE     Varchar (255) ,
        CONF_VALUE   Varchar (255) ,
        PRIMARY KEY (TRANSCODE_ID )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: HISTORY_CLIENT
#------------------------------------------------------------

CREATE TABLE HISTORY_CLIENT(
        CLIENT_ID    int (11) Auto_increment  NOT NULL ,
        UPDATE_DATE  TimeStamp ,
        MERCHANT_ID  Varchar (20) ,
        SIPS_ALIAS   Varchar (255) ,
        ENVIRONMENT  Varchar (255) ,
        PROTOCOL     Varchar (250) ,
        BANK_NAME    Varchar (255) ,
        MERCHANT_FTP Varchar (255) ,
        PRIMARY KEY (CLIENT_ID )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: CLIENT
#------------------------------------------------------------

CREATE TABLE CLIENT(
        CLIENT_ID    int (11) Auto_increment  NOT NULL ,
        MERCHANT_ID  Varchar (20) ,
        SIPS_ALIAS   Varchar (255) ,
        ENVIRONMENT  Varchar (255) ,
        PROTOCOL     Varchar (250) ,
        BANK_NAME    Varchar (255) ,
        MERCHANT_FTP Varchar (255) ,
        PRIMARY KEY (CLIENT_ID )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: work_on
#------------------------------------------------------------

CREATE TABLE work_on(
        JOBS        int (11) ,
        EMPLOYEE_ID Int NOT NULL ,
        PROJECT_ID  Int NOT NULL ,
        PRIMARY KEY (EMPLOYEE_ID ,PROJECT_ID )
)ENGINE=InnoDB;

ALTER TABLE LOG_ID ADD CONSTRAINT FK_LOG_ID_EMPLOYEE_ID FOREIGN KEY (EMPLOYEE_ID) REFERENCES EMPLOYEE(EMPLOYEE_ID);
ALTER TABLE EMPLOYEE ADD CONSTRAINT FK_EMPLOYEE_TEAM_ID FOREIGN KEY (TEAM_ID) REFERENCES TEAM(TEAM_ID);
ALTER TABLE CONFIGURATION ADD CONSTRAINT FK_CONFIGURATION_PROJECT_ID FOREIGN KEY (PROJECT_ID) REFERENCES PROJECT(PROJECT_ID);
ALTER TABLE CONFIGURATION ADD CONSTRAINT FK_CONFIGURATION_CLIENT_ID FOREIGN KEY (CLIENT_ID) REFERENCES CLIENT(CLIENT_ID);
ALTER TABLE work_on ADD CONSTRAINT FK_work_on_EMPLOYEE_ID FOREIGN KEY (EMPLOYEE_ID) REFERENCES EMPLOYEE(EMPLOYEE_ID);
ALTER TABLE work_on ADD CONSTRAINT FK_work_on_PROJECT_ID FOREIGN KEY (PROJECT_ID) REFERENCES PROJECT(PROJECT_ID);
