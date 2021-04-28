-- CREATE TABLE country (
--     id   INTEGER      NOT NULL AUTO_INCREMENT,
--     name VARCHAR(128) NOT NULL,
--     PRIMARY KEY (id)
-- );
DROP TABLE IF EXISTS STUDY_GROUP;

CREATE TABLE STUDY_GROUP (
   GROUP_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
   GROUP_NAME VARCHAR(250) NOT NULL,
   PEOPLE_COUNT INT,
   COURSE_NUMBER INT
);

DROP TABLE IF EXISTS PERSON;

CREATE TABLE PERSON (
   PERSON_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
   FIRST_NAME VARCHAR(250) NOT NULL,
   LAST_NAME VARCHAR(250) NOT NULL,
   BIRTHDATE DATE NOT NULL,
   STUDY_GROUP_ID INT,
   CONSTRAINT FK_PERSON_GROUP FOREIGN KEY (STUDY_GROUP_ID) REFERENCES STUDY_GROUP(GROUP_ID)
);

DROP TABLE IF EXISTS BASE_ID_ENTITY;

CREATE TABLE BASE_ID_ENTITY (
   CARD_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
   FIRST_NAME VARCHAR(250) NOT NULL,
   LAST_NAME VARCHAR(250) NOT NULL,
   DOC_NUMBER INT NOT NULL UNIQUE,
   ID_CARD_TYPE VARCHAR(15) NOT NULL,
   PERSON_ID INT,
   CONSTRAINT FK_ID_PERSON FOREIGN KEY (PERSON_ID) REFERENCES PERSON(PERSON_ID)
);




/*
DROP TABLE IF EXISTS MilitaryCard;

CREATE TABLE MilitaryCard (
   id INT AUTO_INCREMENT PRIMARY KEY,
   FirstName VARCHAR(250) NOT NULL,
   LastName VARCHAR(250) NOT NULL,
   DocumentNumber INT,
   Rank VARCHAR(250) NOT NULL,
   MilitaryBaseNumber INT
);

DROP TABLE IF EXISTS Passport;

CREATE TABLE Passport (
   id INT AUTO_INCREMENT PRIMARY KEY,
   FirstName VARCHAR(250) NOT NULL,
   LastName VARCHAR(250) NOT NULL,
   DocumentNumber INT,
   PlaceOfBirth VARCHAR(250) NOT NULL,
   BirthDate DATE NOT NULL
);

DROP TABLE IF EXISTS StudentCard;

CREATE TABLE StudentCard (
   id INT AUTO_INCREMENT PRIMARY KEY,
   FirstName VARCHAR(250) NOT NULL,
   LastName VARCHAR(250) NOT NULL,
   DocumentNumber INT,
   Course VARCHAR(250) NOT NULL,
   GroupNumber VARCHAR(250) NOT NULL
)
*/

