package com.game.keezenspel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TurnBasedWebSocketController {

    private Map<String, String> playerMap = new HashMap<>();

    @Autowired
    public TurnBasedWebSocketController(SimpMessagingTemplate simpMessagingTemplate) {
        this.messagingTemplate = simpMessagingTemplate;
    }

    private int currentPlayerIndex = 0;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/join")
    @SendTo("/topic/welcome")
    public String handleJoin(String username) {
        // Assign a userId to the player and add to the playerMap
        String userId = "User" + (playerMap.size() + 1);
        playerMap.put(userId, username);
        return "Welcome, " + username + "!";
    }

    // @MessageMapping("/move")
    // @SendTo("/topic/moves")
    // public String handleMove(String move, String userId) {
    //     // Check if it's the current player's turn
    //     if (isCurrentPlayer(userId)) {
    //         // Process the client's move
    //         String response = processMove(move);

    //         // Switch to the next player
    //         switchPlayer();

    //         // Send the response back to the client
    //         messagingTemplate.convertAndSend("/topic/moves", response);

    //         return response;
    //     } else {
    //         // Inform the client that it's not their turn
    //         return "It's not your turn. Waiting for the other player.";
    //     }
    // }

    // private boolean isCurrentPlayer(String userId) {
    //     // Determine if it's the turn of the client based on the userId
    //     String currentPlayer = getCurrentPlayer();
    //     return currentPlayer.equals(userId);
    // }

    // private String getCurrentPlayer() {
    //     // Get the userId of the current player based on currentPlayerIndex
    //     String[] players = playerMap.keySet().toArray(new String[0]);
    //     return players[currentPlayerIndex];
    // }

    // private String processMove(String move) {
    //     // Implement your game logic here based on the client's move
    //     // For simplicity, just echoing the move back to the client in this example
    //     return "You made a move: " + move;
    // }

    // private void switchPlayer() {
    //     // Switch to the next player
    //     currentPlayerIndex = (currentPlayerIndex + 1) % playerMap.size();
    // }
}
