# Experiment 2 How to Execute

## Aim

Develop a user session management system with `HttpSession` and three form-processing servlets.

## Import and server setup

1. Use JDK 17, Eclipse Enterprise, and Tomcat 10.1.
2. Select **File > Import > Maven > Existing Maven Projects**.
3. Browse to `Experiment_02_HttpSession\Code\AJT_Exp02_HttpSession` and import the `pom.xml`.
4. Wait for Maven to finish, then use **Maven > Update Project** if Eclipse still shows errors.
5. In **Project > Properties > Targeted Runtimes**, select Tomcat 10.1.

## Run the experiment

1. Right-click `AJT_Exp02_HttpSession` and select **Run As > Run on Server**.
2. Open `http://localhost:8080/AJT_Exp02_HttpSession/`.
3. Enter name and age, then click **Next**.
4. Enter email and phone, then click **Next**.
5. Enter degree and university, then click **Finish**.

Expected result: the final page shows all values from the three forms. The first two servlets store values in the same `HttpSession`; the last servlet reads them and invalidates the completed session.

## Verify session behavior

- Complete the forms normally to see all values.
- Restart the experiment and remain idle for more than 30 minutes. The session expires and the later step redirects to the first form.
- Opening the contact or education page directly without a valid session also redirects after submission.

## Common errors

- Missing `jakarta.servlet` classes: use Tomcat 10.1 and run **Maven > Update Project**.
- Final page contains blank values: start again from the first page and do not block cookies; Tomcat uses the `JSESSIONID` cookie to identify the session.
- HTTP 404: confirm the exact context name and check that the project is added to the Tomcat server.

