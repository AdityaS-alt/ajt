# Experiment 4 How to Execute

## Aim

Build a database-driven web application with JSP, Servlet, JDBC, and MySQL. The application inserts a user and retrieves all registered users.

## Required software

- JDK 17
- Eclipse IDE for Enterprise Java and Web Developers
- Apache Tomcat 10.1
- MySQL Server 8.0 or later
- MySQL Workbench or the MySQL command-line client
- Internet access during the first Maven import so that MySQL Connector/J can download

The project uses the official Maven coordinates `com.mysql:mysql-connector-j:8.4.0`. Do not manually copy a differently named connector JAR into the project.

## Create the database

1. Start MySQL Server.
2. Open MySQL Workbench and connect to the local server.
3. Open `Code\AJT_Exp04_JDBC_MySQL\setup.sql`.
4. Execute the complete script.
5. Confirm that database `ajt_lab` and table `users` exist.

Command-line alternative:

```text
mysql -u root -p < setup.sql
```

Run the command from the project folder. Enter the MySQL password when prompted.

## Import into Eclipse

1. Select **File > Import > Maven > Existing Maven Projects**.
2. Browse to `Experiment_04_JDBC_MySQL\Code\AJT_Exp04_JDBC_MySQL`.
3. Import the detected project and wait for Maven to finish.
4. Select Tomcat 10.1 in **Project > Properties > Targeted Runtimes**.

## Configure MySQL credentials

The default values are:

- URL: `jdbc:mysql://localhost:3306/ajt_lab?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC`
- User: `root`
- Password: empty

If these do not match your MySQL installation, configure Tomcat in Eclipse:

1. In the **Servers** view, double-click Tomcat 10.1.
2. Click **Open launch configuration**.
3. Open the **Environment** tab.
4. Add these variables with values for that PC:
   - `AJT_DB_URL`
   - `AJT_DB_USER`
   - `AJT_DB_PASSWORD`
5. Apply the changes and restart Tomcat.

Example values:

```text
AJT_DB_URL=jdbc:mysql://localhost:3306/ajt_lab?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
AJT_DB_USER=root
AJT_DB_PASSWORD=your_mysql_password
```

Do not save a real database password in the source folder or ZIP.

## Run and test

1. Right-click `AJT_Exp04_JDBC_MySQL` and select **Run As > Run on Server**.
2. Open `http://localhost:8080/AJT_Exp04_JDBC_MySQL/`.
3. Enter name, email, and a sample password.
4. Click **Register**.
5. Confirm that the success message and user list appear.
6. In MySQL Workbench, run `SELECT id, name, email FROM ajt_lab.users;` to verify the inserted row.

## Caveats and troubleshooting

- `Access denied for user`: the username or password is wrong. Correct the Tomcat environment variables and restart Tomcat.
- `Unknown database 'ajt_lab'` or `Table 'ajt_lab.users' doesn't exist`: execute `setup.sql`.
- `Communications link failure`: start MySQL, confirm port 3306, and check the JDBC URL.
- `Public Key Retrieval is not allowed`: keep `allowPublicKeyRetrieval=true` in the local lab URL, or configure proper TLS for a production system.
- `ClassNotFoundException: com.mysql.cj.jdbc.Driver`: run **Maven > Update Project** and confirm internet access.
- This lab stores the sample password as plain text only to keep the JDBC example simple. A real system must hash passwords and must not display or log them.

