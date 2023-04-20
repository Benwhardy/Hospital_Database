# Hospital Database Command Line Program

This command line program allows users to input specified numbers to run predetermined "SELECT" statements on a hospital database. The program is written in Java and uses MySQL.

## How to Run the Program

1. Navigate to the "src" folder within the "checkpoint_4" folder in the Terminal.
2. Configure the path to the JDBC driver. For example: `export CLASSPATH=$CLASSPATH:/Users/benhardy/Desktop/DB2/mysql-connector-j-8.0.32.jar`
3. Compile the Java file using the command `javac HospitalQuery.java`.
4. Run the program using the command `java HospitalQuery`.
5. Input the specified numbers from the project description to get the output from the database.

## Technologies Used

- Java
- MySQL

## Prerequisites

Before running the program, make sure you have the following:

- A MySQL database with the necessary tables and data
- The JDBC driver for your MySQL version
- A working installation of Java on your machine
