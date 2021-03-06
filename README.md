# SonarQube
[![Build Status](https://travis-ci.org/Nifori/SonarQube.svg?branch=master)](https://travis-ci.org/Nifori/SonarQube)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=SonarQube-Test&metric=alert_status)](https://sonarcloud.io/dashboard?id=SonarQube-Test)

This Project is about showing how to use SonarQube to permanently get feedback about your code.

## Requirements
- Clone the repository
- Or fork the repository to get access to travis 
- Have MySQL installed ([MySQL-Download](https://dev.mysql.com/downloads/))
- The database must contain a schema 'zahlenraten' with a table 'gewinner'
    - Commands: 
    ```SQL
    CREATE SCHEMA zahlenraten;
    CREATE TABLE zahlenraten.gewinner (id INT NOT NULL, name VARCHAR(45) NULL, passwort VARCHAR(45) NULL, punkte INT NULL);
    SET GLOBAL time_zone = '+2:00';
    ```
- The database must know a user 'zahlenUser' with the password 'zahlenPasswort'
    - He must have access to the schema 'zahlenraten'
- Have Java 11 installed ([Java 11-Download](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html))
- Java 11 must be set in your environment variable JAVA_HOME
- Have SonarQube Scanner installed to run the analysis local ([SonarQube Scanner](https://docs.sonarqube.org/display/SCAN/Analyzing+with+SonarQube+Scanner))
- For Plugin-Usage you need the SonarQube Server installed locally ([SonarQube Server](https://www.sonarqube.org/downloads/))
- To show issues in your IDE you need to install a SonarLint-Plugin
