# Introduction
This is a URL shortening application that takes a long URL and converts it to a short URL with an embedded link.
This is a Spring MVC application using mySQL database.

# Prerequisites
1.	Must have a running mysql server locally
2.	Run database_setup.sql in src/main/resources to create the database and table

# Build and Test
1. Open project in your IDE of choice and run the project.
2. Once Project is built and running go to localhost:8080 on your browser.
3. Enter any URL and get a short URL returned which will redirect you to the original URL.

# TO-D0
1. Read database connection string from application properties.
2. Deploy the database with project.
3. Containerise application.
4. Write unit and integration tests.