# hospital-using-db
This is a very basic application. <br>
I have created a java project for hospitals. <br>
To run this project you need . <br>

### h2 database jar
### eclipse

Create tables by using below queries <br>
// doctor table <br>
CREATE TABLE DOCTOR( <br>
    ID INT NOT NULL, <br>
    NAME VARCHAR(50), <br>
    PSSWD VARCHAR(50), <br>
    PRIMARY KEY (ID) <br>
) <br>

// PATIENT TABLE <br>
CREATE TABLE PATIENT( <br>
    SERIAL INT NOT NULL, <br>
    NAME VARCHAR(50), <br>
    ID INT, <br>
    AGE INT, <br>
    GENDER VARCHAR(6), <br>
    PHONENUMBER VARCHAR(50), <br>
    DISEASE VARCHAR(50), <br>
    DOCTORID VARCHAR(10), <br>
    PRIMARY KEY (SERIAL) <br>
)

// receptionist table <br>
CREATE TABLE RECEPTIONIST( <br>
    ID INT NOT NULL, <br>
    NAME VARCHAR(50), <br>
    PSSWD VARCHAR(50), <br>
    PRIMARY KEY (ID) <br>
) <br>

Now you can run your project as java application.

I have hotcoded the admin. <br>
Admin name: John <br>
Password: 123 <br>
