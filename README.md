# hospital-using-db
This is a very basic application
I have created a java project for hospitals
To run this project you need 

>> h2 database jar
>> eclipse

Create tables by using below queries
// doctor table
CREATE TABLE DOCTOR(
    ID INT NOT NULL,
    NAME VARCHAR(50),
    PSSWD VARCHAR(50),
		PRIMARY KEY (ID)
)

// PATIENT TABLE
CREATE TABLE PATIENT(
    SERIAL INT NOT NULL,
    NAME VARCHAR(50),
    ID INT,
    AGE INT,
    GENDER VARCHAR(6),
    PHONENUMBER VARCHAR(50),
    DISEASE VARCHAR(50),
    DOCTORID VARCHAR(10),
		PRIMARY KEY (SERIAL)
)

// receptionist table
CREATE TABLE RECEPTIONIST(
    ID INT NOT NULL,
    NAME VARCHAR(50),
    PSSWD VARCHAR(50),
		PRIMARY KEY (ID)
)

Now you can run your project as java application.

I have hotcoded the admin
Admin name: John
Password: 123
