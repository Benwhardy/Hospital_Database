# Hospital Database Command Line Program

This command line program allows users to input specified numbers to run predetermined "SELECT" statements on a hospital database. The program is written in Java and uses MySQL.

## How to Run the Program

1. Navigate to the "src" folder within the "checkpoint_4" folder in the Terminal.
2. Configure the path to the JDBC driver. (may not be necessary for all machines
      For example: `export CLASSPATH=$CLASSPATH:/YOUR/PATH/TO/mysql-connector-j-8.0.32.jar`
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


## Queries
1.1. List the rooms that are occupied, along with the associated patient names and the date the patient was
admitted.
1.2. List the rooms that are currently unoccupied.
1.3. List all rooms in the hospital along with patient names and admission dates for those that are
occupied.

2.1. List all patients in the database, with full personal information.
2.2. List all patients currently admitted to the hospital. List only patient identification number and name.
2.3. List all patients who were discharged in a given date range. List only patient identification number and
name.
2.4. List all patients who were admitted within a given date range. List only patient identification number
and name.
2.5. For a given patient (either patient identification number or name), list all admissions to the hospital
along with the diagnosis for each admission.
2.6. For a given patient (either patient identification number or name), list all treatments that were
administered. Group treatments by admissions. List admissions in descending chronological order,
and list treatments in ascending chronological order within each admission.

3.1. List the diagnoses given to patients, in descending order of occurrences. List diagnosis identification
number, name, and total occurrences of each diagnosis.
3.2. List the diagnoses given to hospital patients, in descending order of occurrences. List diagnosis
identification number, name, and total occurrences of each diagnosis.
3.3. List the treatments performed on admitted patients, in descending order of occurrences. List treatment
identification number, name, and total number of occurrences of each treatment.
3.4. List the diagnoses associated with patients who have the highest occurrences of admissions to the
hospital, in ascending order or correlation.
3.5. For a given treatment occurrence, list the patient name and the doctor who ordered the treatment.

4.1. List all workers at the hospital, in ascending last name, first name order. For each worker, list their,
name, and job category.
4.2. List the primary doctors of patients with a high admission rate (at least 4 admissions within a one-year
time frame).
4.3. For a given doctor, list all associated diagnoses in descending order of occurrence. For each
diagnosis, list the total number of occurrences for the given doctor.
4.4. For a given doctor, list all treatments that they ordered in descending order of occurrence. For each
treatment, list the total number of occurrences for the given doctor.
