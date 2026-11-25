# Validation Report

## Scope checked

The first six experiments were matched to the supplied AJT lab manual:

1. Java Servlet for HTTP requests
2. `HttpSession` user-session management
3. JSP form handling
4. JSP, Servlet, JDBC, and MySQL
5. Jakarta Mail through SMTP
6. Real-time WebSocket chat

## Results

- Folder structure: passed. All six experiment folders contain direct `Code` and `How_to_Execute` subfolders.
- Eclipse metadata: parsed successfully for all six projects.
- Maven POM files: parsed successfully; every experiment is a WAR project.
- Package paths: passed. Every Java `package` declaration matches its folder path.
- Namespace check: passed. Application source uses `jakarta.*`; no old `javax.*` imports are present.
- Servlet descriptor check: passed. Every `web.xml` uses the Jakarta Servlet 6.0 schema.
- Maven build: passed. A single reactor build ran `clean package` successfully for all six experiments.
- Java compatibility: compiled application classes have class-file major version 61, which is Java 17.
- JSP validation: Tomcat Jasper precompiled all five JSP files with zero errors.
- WAR inspection: passed. Six WAR files were produced. Servlet and WebSocket APIs are correctly excluded from the WARs because Tomcat supplies them. The MySQL and Jakarta Mail runtime dependencies are included where needed.
- Tomcat deployment scan: Tomcat 10.1.61 unpacked and deployed all six WAR files without application deployment exceptions.
- Credential scan and configuration: no real MySQL or SMTP password is stored in the source. External settings are read from environment variables.

## Runtime boundaries

The execution host prevented Tomcat's HTTP NIO connector from establishing its internal loopback selector, so browser HTTP requests and a live WebSocket exchange could not be completed in this environment. This was a host networking restriction, not an application deployment error.

The following checks require the student's own external setup and therefore were not performed here:

- Experiment 4 inserting and retrieving rows from a real MySQL Server
- Experiment 5 authenticating with a real SMTP account and sending an email
- Experiment 6 exchanging messages between live browser connections

Detailed setup and troubleshooting steps for those checks are included in each experiment's `How_to_Execute` folder.

