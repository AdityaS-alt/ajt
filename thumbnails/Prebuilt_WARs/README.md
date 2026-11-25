# Prebuilt WAR Files

These WAR files were created by a successful Maven reactor build using Java release 17 settings.

To deploy one without Eclipse:

1. Install JDK 17 and Apache Tomcat 10.1.
2. Stop Tomcat.
3. Copy the required `.war` file into Tomcat's `webapps` folder.
4. Start Tomcat.
5. Open `http://localhost:8080/WAR_FILE_NAME_WITHOUT_DOT_WAR/`.

Experiment 4 still requires MySQL and its configured environment variables. Experiment 5 still requires SMTP environment variables and network access. The WAR files do not contain personal database or email credentials.
