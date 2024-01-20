package com.game.keezenspel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class BoardTest {

    @Test
    public void TestNumberOfPawns() {

        for (int numberOfPlayers = 2; numberOfPlayers < 9; numberOfPlayers++) {
            // [GIVEN]
            // Board board = new Board(numberOfPlayers);
            
            // // [WHEN]
            // int nrPawns = board.getPawns().size();
            
            // [THEN]
            // assertEquals(numberOfPlayers*4, nrPawns);
        }
    }
}
