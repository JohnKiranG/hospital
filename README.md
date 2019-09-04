# hospital-using-db
This is a very basic application. <br>
I have created a java project for hospitals. <br>
To run this project you need . <br>

### h2 database jar
### eclipse

### To Run h2 db and create tables
Got the the path of your local h2 database <br>
ex: cd h2/h2/bin <br>
To run this type in terminal <br>
ex: ./h2.sh <br>

Then it opens in browser, where you can configure.. <br>

My db username: john <br>
password: 12345 <br>

### You have to change the username and password before running the project of your db

Create tables by using below queries <br>
// doctor table <br>
CREATE TABLE DOCTOR( <br>
    ID INT NOT NULL AUTO_INCREMENT, <br>
    NAME VARCHAR(50), <br>
    PSSWD VARCHAR(50), <br>
    PRIMARY KEY (ID) <br>
) <br>

// PATIENT TABLE <br>
CREATE TABLE PATIENT( <br>
    SERIAL INT NOT NULL AUTO_INCREMENT, <br>
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
    ID INT NOT NULL AUTO_INCREMENT, <br>
    NAME VARCHAR(50), <br>
    PSSWD VARCHAR(50), <br>
    PRIMARY KEY (ID) <br>
) <br>

Now you can run your project as java application.

I have hotcoded the admin. <br>
Admin name: John <br>
Password: 123 <br>
