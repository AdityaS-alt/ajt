# Experiment 3 How to Execute

## Aim

Create a JSP page that receives form data through the JSP `request` implicit object and conditionally displays the result.

## Import and run

1. Use JDK 17, Eclipse Enterprise, and Tomcat 10.1.
2. Select **File > Import > Maven > Existing Maven Projects**.
3. Browse to `Experiment_03_JSP_Form\Code\AJT_Exp03_JSP_Form` and import the detected project.
4. Wait for Maven to finish.
5. In **Project > Properties > Targeted Runtimes**, select Tomcat 10.1.
6. Right-click the project and select **Run As > Run on Server**.
7. Open `http://localhost:8080/AJT_Exp03_JSP_Form/`.
8. Enter a degree and university, then click **Submit**.

Expected result: the same JSP page changes from the input form to a result page that displays the submitted degree and university.

## What to observe

- `<% ... %>` is a JSP scriptlet used for Java statements.
- `<%= ... %>` is a JSP expression used to display a value.
- `<%! ... %>` is a JSP declaration used here for a small HTML-escaping method.
- `request.getParameter(...)` obtains values from the submitted form.

Scriptlets are used because the lab experiment specifically demonstrates them. Modern production applications normally use servlets/controllers, expression language, and tag libraries instead of putting Java logic directly in JSP pages.

## Common errors

- JSP opens as plain text or downloads: run it through Tomcat; do not double-click the JSP file in Windows.
- HTTP 404: check that the project is added to Tomcat and use the exact context name.
- Red JSP errors in Eclipse but the Maven project is valid: select Tomcat 10.1 under **Targeted Runtimes**, then clean the project.

