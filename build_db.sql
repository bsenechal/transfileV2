#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


#------------------------------------------------------------
# Table: EMPLOYEE
#------------------------------------------------------------

CREATE TABLE EMPLOYEE(
        EMPLOYEE_ID   int (11) Auto_increment  NOT NULL ,
        EMPLOYEE_NAME Varchar (50) ,
        TEAMS_ID      Int ,
        PRIMARY KEY (EMPLOYEE_ID )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: CLIENT
#------------------------------------------------------------

CREATE TABLE CLIENT(
        CLIENT_ID   int (11) Auto_increment  NOT NULL ,
        MERCHANT_ID Int NOT NULL ,
        SIPS_ALIAS  Varchar (100) ,
        ENVIRONMENT Varchar (15) ,
        PROTOCOL    Varchar (10) ,
        BANK_NAME   Varchar (10) NOT NULL ,
        FTP_GW      Varchar (25) ,
        PRIMARY KEY (CLIENT_ID )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: PROJECT
#------------------------------------------------------------

CREATE TABLE PROJECT(
        PROJECT_ID     int (11) Auto_increment  NOT NULL ,
        LABEL          Varchar (50) ,
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
        NAME_FILE        Varchar (25) ,
        PROFILE          Varchar (25) ,
        NAME_DEST        Varchar (50) ,
        NAME_ZIP         Varchar (50) ,
        DELETE           Bool ,
        MULTIPLE         Int ,
        OCCURENCE        Int ,
        COMMENT          Varchar (200) ,
        LIST_SERV        Varchar (200) ,
        RELEASE          Varchar (25) ,
        PROJECT_ID       Int NOT NULL ,
        CLIENT_ID        Int NOT NULL ,
        PRIMARY KEY (CONFIGURATION_ID )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: TEAMS
#------------------------------------------------------------

CREATE TABLE TEAMS(
        TEAMS_ID   int (11) Auto_increment  NOT NULL ,
        TEAMS_NAME Varchar (50) ,
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
        LABEL          Varchar (50) ,
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
        NAME_FILE        Varchar (25) ,
        PROFILE          Varchar (25) ,
        NAME_DEST        Varchar (50) ,
        NAME_ZIP         Varchar (50) ,
        DELETE           Bool ,
        MULTIPLE         Int ,
        OCCURENCE        Int ,
        COMMENT          Varchar (200) ,
        LIST_SERV        Varchar (200) ,
        RELEASE          Varchar (25) ,
        PRIMARY KEY (CONFIGURATION_ID )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: HISTORY_CLIENT
#------------------------------------------------------------

CREATE TABLE HISTORY_CLIENT(
        CLIENT_ID   int (11) Auto_increment  NOT NULL ,
        UPDATE_DATE TimeStamp NOT NULL ,
        MERCHANT_ID Int NOT NULL ,
        SIPS_ALIAS  Varchar (100) ,
        ENVIRONMENT Varchar (15) ,
        PROTOCOL    Varchar (10) ,
        BANK_NAME   Varchar (10) NOT NULL ,
        FTP_GW      Varchar (25) ,
        PRIMARY KEY (CLIENT_ID )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: work_on
#------------------------------------------------------------

CREATE TABLE work_on(
        JOBS        Varchar (50) ,
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
