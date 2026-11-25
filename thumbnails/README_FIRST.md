# AJT Lab Experiments 1 to 6

This folder contains six separate Maven web projects based on the first six experiments in the supplied Advanced Java Technologies lab manual.

## Standard software used by every project

- JDK 17
- Eclipse IDE for Enterprise Java and Web Developers
- Apache Tomcat 10.1
- Maven support included with Eclipse

All Java web APIs use the `jakarta.*` namespace. Use Tomcat 10.1 for every experiment. Do not attach these projects to Tomcat 9, because Tomcat 9 uses the older `javax.*` namespace and Eclipse will report missing packages or deployment errors.

Tomcat 10.1 requires Java 11 or later and implements Jakarta Servlet 6.0, JSP 3.1, and WebSocket 2.1. Java 17 is selected here because it is a widely available long-term-support JDK.

Official references:

- Tomcat versions: https://tomcat.apache.org/whichversion
- Tomcat 10.1 setup: https://tomcat.apache.org/tomcat-10.1-doc/setup.html
- Jakarta Servlet 6.0: https://jakarta.ee/specifications/servlet/6.0/
- Jakarta WebSocket 2.1: https://jakarta.ee/specifications/websocket/2.1/
- MySQL Connector/J with Maven: https://dev.mysql.com/doc/connector-j/en/connector-j-installing-maven.html
- Eclipse Angus Mail: https://eclipse-ee4j.github.io/angus-mail/

## Safest way to move this folder to another PC

1. Copy the ZIP file to the pen drive.
2. On the second PC, copy the ZIP from the pen drive to a normal local folder such as `Documents\AJT_Lab`.
3. Extract the ZIP completely. Do not import or run projects directly from inside the ZIP or from the pen drive.
4. Keep the folder names unchanged.
5. Install JDK 17, Eclipse Enterprise, and Tomcat 10.1 on that PC.
6. Start Eclipse and choose a new workspace.
7. Select **File > Import > Maven > Existing Maven Projects**.
8. Browse to this main folder. Eclipse should find six `pom.xml` files. Select all six and click **Finish**.
9. Allow Maven to download dependencies. The first import therefore needs internet access unless the required Maven cache is already present.
10. In Eclipse, open the **Servers** view and add an Apache Tomcat 10.1 server that uses JDK 17.
11. Read the `How_to_Execute` folder inside the experiment before running it.

If Apache Maven is installed, all six projects can also be packaged from this main folder with `mvn clean package`.

The `Prebuilt_WARs` folder contains WAR files produced during validation. They can be copied directly into Tomcat 10.1's `webapps` folder for a quick deployment. The Eclipse source projects remain the recommended way to study and modify the experiments.

## Projects and URLs

| Experiment | Eclipse project | Main URL after Run on Server |
| --- | --- | --- |
| 1 | `AJT_Exp01_HTTP_Servlet` | `http://localhost:8080/AJT_Exp01_HTTP_Servlet/` |
| 2 | `AJT_Exp02_HttpSession` | `http://localhost:8080/AJT_Exp02_HttpSession/` |
| 3 | `AJT_Exp03_JSP_Form` | `http://localhost:8080/AJT_Exp03_JSP_Form/` |
| 4 | `AJT_Exp04_JDBC_MySQL` | `http://localhost:8080/AJT_Exp04_JDBC_MySQL/` |
| 5 | `AJT_Exp05_SMTP_Mail` | `http://localhost:8080/AJT_Exp05_SMTP_Mail/` |
| 6 | `AJT_Exp06_WebSocket_Chat` | `http://localhost:8080/AJT_Exp06_WebSocket_Chat/` |

If port 8080 is already in use, Eclipse may configure Tomcat with another port. Use the port displayed in the Servers view.

## Extra software and external services

- Experiment 4 requires a running MySQL Server. Execute its supplied `setup.sql` once and configure the database credentials as described in its instructions.
- Experiment 5 requires working SMTP credentials and network access to the SMTP server. No password is stored in this folder. Configure credentials in the Tomcat launch environment.
- Experiments 1, 2, 3, and 6 need only JDK, Eclipse, Tomcat, and the first Maven dependency download.

## Common Eclipse fixes

If Eclipse shows red errors immediately after import:

1. Wait until the Maven progress tasks finish.
2. Right-click the project and select **Maven > Update Project**.
3. Select **Force Update of Snapshots/Releases** and click **OK**.
4. Select **Project > Clean**, clean the affected project, and rebuild.
5. Open **Project > Properties > Project Facets** and confirm Java 17 and Dynamic Web Module 6.0.
6. Open **Project > Properties > Targeted Runtimes** and select only Apache Tomcat 10.1.
7. Remove any old Tomcat 9 server associated with the project.

## Important limitations

The source code and project configuration are portable, but a web application cannot run on a completely unprepared PC. The second PC still needs compatible software, Maven dependencies, free ports, and any external service required by the experiment. Database and email credentials are intentionally excluded for safety.

