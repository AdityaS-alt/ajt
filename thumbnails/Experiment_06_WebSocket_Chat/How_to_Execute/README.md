# Experiment 6 How to Execute

## Aim

Develop a real-time chat application that uses a Jakarta WebSocket server endpoint and a browser WebSocket client.

## Why Tomcat 10.1 is required

This project uses the Jakarta WebSocket 2.1 `jakarta.websocket.*` packages. Tomcat 10.1 implements WebSocket 2.1. Tomcat 9 uses the older `javax.websocket.*` namespace and is not compatible with this source code.

## Import and run

1. Use JDK 17, Eclipse Enterprise, and Tomcat 10.1.
2. Select **File > Import > Maven > Existing Maven Projects**.
3. Browse to `Experiment_06_WebSocket_Chat\Code\AJT_Exp06_WebSocket_Chat` and import it.
4. Wait for Maven to download both WebSocket API artifacts.
5. Select Tomcat 10.1 in **Project > Properties > Targeted Runtimes**.
6. Right-click the project and select **Run As > Run on Server**.
7. Open `http://localhost:8080/AJT_Exp06_WebSocket_Chat/`.

## Test real-time communication

1. Open the application in two browser tabs or two different browsers.
2. Enter a different name in each tab.
3. Send a message from the first tab.
4. Confirm that both tabs receive it immediately.
5. Close one tab and confirm that the other tab receives the updated connected-user message.

The JavaScript calculates the WebSocket URL from the current browser host and application context. There is no hard-coded PC path, host name, or Tomcat port, so changing port 8080 does not require a code edit.

## Troubleshooting

- Status remains `Connecting`: confirm Tomcat is running and the project was published without errors.
- Browser console shows WebSocket 404: use the application home URL so that the calculated context path is correct, and confirm the endpoint path is `/chat`.
- Missing `jakarta.websocket` classes: run **Maven > Update Project**, then select Tomcat 10.1 as the targeted runtime.
- Messages work in one tab but not another PC: this lab URL uses `localhost`, which always means the current PC. For a LAN demonstration, use the Tomcat PC's IP address and allow the Tomcat port through the firewall. Do this only on a trusted network.
- A public internet deployment should use HTTPS and `wss://`, authentication, input controls, rate limits, and a production server configuration. This lab intentionally keeps the chat simple.

