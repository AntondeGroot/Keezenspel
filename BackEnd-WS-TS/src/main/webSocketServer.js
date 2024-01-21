"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var ws_1 = require("ws");
var port = 8080;
var wss = new ws_1.WebSocketServer({ port: port });
// TODO: DEFINE WEB SOCKET SERVER LOGIC
wss.on('connection', function (ws) {
    // Handles new connections
    wss.clients.add(ws);
    console.log("Server connected to new client");
    ws.onmessage = function (event) {
        handleClientData(event.data, ws);
    };
    ws.onclose = function (event) {
        wss.clients.delete(ws);
        ws.close();
        console.log("Server: client has disconnected");
    };
    ws.send("Hello, this is WebSocketServer.ts");
});
function handleClientData(data, ws) {
    console.log('Received client data:', data);
    // Your logic for handling client data
    // Send a response back to the client
    wss.clients.forEach(function (client) { return client.send(data); });
    ws.send(JSON.stringify({ type: 'serverResponse', message: 'Data received successfully!' }));
}
console.log("Listening at port: ".concat(port, "..."));
