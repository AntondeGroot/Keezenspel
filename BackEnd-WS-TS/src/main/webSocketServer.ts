import { WebSocketServer } from "ws";
import { WebSocket } from "ws";

const port = 8080;
const wss = new WebSocketServer({ port });

// TODO: DEFINE WEB SOCKET SERVER LOGIC
wss.on('connection', (ws) => {
    // Handles new connections
    wss.clients.add(ws);
    console.log(`Server connected to new client`);
    
    ws.onmessage = (event) => {
        handleClientData(event.data, ws);
    }
    
    ws.onclose = (event) => {
        wss.clients.delete(ws);
        ws.close();
        console.log(`Server: client has disconnected`);
    }

    ws.send(`Hello, this is WebSocketServer.ts`);
})

function handleClientData(data: any, ws: WebSocket) {
    console.log('Received client data:', data);
    // Your logic for handling client data

    // Send a response back to the client
    wss.clients.forEach(client => client.send(data));
    ws.send(JSON.stringify({ type: 'serverResponse', message: 'Data received successfully!' }));
}

console.log(`Listening at port: ${port}...`);