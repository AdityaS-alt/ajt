# Experiment 5 How to Execute

## Aim

Configure Jakarta Mail and send an email from a web application through an SMTP server.

## Dependencies

Maven downloads these libraries during the first import:

- Jakarta Mail API 2.1.3
- Eclipse Angus Mail 2.0.5, including the SMTP provider
- Jakarta Activation API 2.1.3
- Eclipse Angus Activation 2.0.3

No email account or password is included in the project.

## Import into Eclipse

1. Use JDK 17, Eclipse Enterprise, and Tomcat 10.1.
2. Select **File > Import > Maven > Existing Maven Projects**.
3. Browse to `Experiment_05_SMTP_Mail\Code\AJT_Exp05_SMTP_Mail` and import the project.
4. Wait for Maven downloads to finish.
5. Select Tomcat 10.1 in **Project > Properties > Targeted Runtimes**.

## Configure SMTP settings in Eclipse

1. Open the **Servers** view.
2. Double-click Tomcat 10.1.
3. Click **Open launch configuration**.
4. Open the **Environment** tab.
5. Add the variables required for your mail provider.
6. Apply the changes and restart Tomcat.

### Gmail using TLS on port 587

```text
AJT_SMTP_HOST=smtp.gmail.com
AJT_SMTP_PORT=587
AJT_SMTP_STARTTLS=true
AJT_SMTP_SSL=false
AJT_SMTP_USER=your_account@gmail.com
AJT_SMTP_PASSWORD=your_app_password_or_provider_credential
AJT_SMTP_FROM=your_account@gmail.com
```

Gmail supports TLS on port 587 and SSL on port 465. Google recommends OAuth 2.0 for general application access. For a small classroom demonstration, an app password may work only when the account is eligible and configured for it. Never use the normal account password if the provider blocks basic password authentication.

### Gmail using SSL on port 465

```text
AJT_SMTP_HOST=smtp.gmail.com
AJT_SMTP_PORT=465
AJT_SMTP_STARTTLS=false
AJT_SMTP_SSL=true
```

Keep the same user, password, and from variables.

### Other providers

Use the SMTP host, port, encryption mode, and authentication method documented by the provider. Some Microsoft 365, school, and company accounts disable password-based SMTP authentication. In that case, this simple lab example cannot send until an administrator enables an allowed method or the code is extended for OAuth 2.0.

## Run and test

1. Right-click `AJT_Exp05_SMTP_Mail` and select **Run As > Run on Server**.
2. Open `http://localhost:8080/AJT_Exp05_SMTP_Mail/`.
3. Enter a recipient address, subject, and short message.
4. Click **Send Email** once and wait for the result page.
5. Check the recipient inbox and spam folder.

## Troubleshooting

- `SMTP credentials are not configured`: add the environment variables to the Tomcat launch configuration and restart the server.
- Authentication failed: verify the account name and app password or provider credential. Do not use an expired or revoked credential.
- Connection timeout: check internet access, firewall restrictions, SMTP host, and port.
- STARTTLS error: verify whether the provider expects STARTTLS on port 587 or SSL on port 465, and set the two Boolean variables accordingly.
- Maven dependency errors: run **Maven > Update Project** with internet access.
- Do not paste real SMTP secrets into Java, JSP, `pom.xml`, screenshots, or the ZIP. Environment variables keep the portable project free of personal credentials.

