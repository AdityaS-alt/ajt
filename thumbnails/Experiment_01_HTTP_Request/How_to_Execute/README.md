# Experiment 1 How to Execute

## Aim

Implement a Java Servlet that handles HTTP GET and POST requests.

## Import into Eclipse

1. Install JDK 17, Eclipse IDE for Enterprise Java and Web Developers, and Apache Tomcat 10.1.
2. In Eclipse, select **File > Import > Maven > Existing Maven Projects**.
3. Browse to `Experiment_01_HTTP_Request\Code\AJT_Exp01_HTTP_Servlet`.
4. Select the detected `pom.xml` and click **Finish**.
5. Wait for Maven dependency download to finish.
6. Right-click the project and select **Maven > Update Project** if any dependency error remains.

## Configure Tomcat

1. Open **Window > Show View > Servers**.
2. Click the link to create a server, or right-click and select **New > Server**.
3. Choose **Apache > Tomcat v10.1 Server**.
4. Browse to the Tomcat 10.1 installation and select JDK 17.
5. Finish the wizard.
6. Open **Project > Properties > Targeted Runtimes** and select Tomcat 10.1.

## Run and test

1. Right-click `AJT_Exp01_HTTP_Servlet`.
2. Select **Run As > Run on Server**.
3. Choose Tomcat 10.1 and click **Finish**.
4. Open `http://localhost:8080/AJT_Exp01_HTTP_Servlet/` if Eclipse does not open it automatically.
5. Enter a name and click **Send POST Request**.
6. Return to the form and click the sample GET link.

Expected result: the servlet displays the submitted name, the HTTP method, and the request URI.

## Command-line build option

If Apache Maven is installed, open a terminal in the project folder and run:

```text
mvn clean package
```

The WAR will be created as `target\AJT_Exp01_HTTP_Servlet.war` and can be copied to Tomcat's `webapps` folder.

## Common errors

- `The import jakarta.servlet cannot be resolved`: select Tomcat 10.1 as the targeted runtime, then run **Maven > Update Project**.
- HTTP 404: confirm that the URL contains the exact context name `AJT_Exp01_HTTP_Servlet` and that the server shows the project as started.
- Server port already in use: double-click the Tomcat server in Eclipse and change its HTTP port, then use that port in the URL.

