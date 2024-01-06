package com.game.keezenspel;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class PawnSwapTest {

    // @Test
    // public void PawnFromPlayerA_CannotSwapWith_PawnFromPlayerA() {
    //     // [GIVEN]
    //     Tile tile = new Tile();
    //     Pawn pawn1 = new Pawn(1, tile);
    //     Pawn pawn2 = new Pawn(1, tile);

    //     // [WHEN]
    //     Boolean canSwap = pawn1.CanSwapWith(pawn2);

    //     // [THEN]
    //     assertFalse(canSwap, "Player cannot switch with himself");
    // }

    // @Test
    // public void PawnFromPlayerA_CanSwapWith_PawnFromPlayerB() {
    //     // [GIVEN]
    //     Tile tile = new Tile();
    //     Pawn pawn1 = new Pawn(1, tile);
    //     Pawn pawn2 = new Pawn(2, tile);

    //     // [WHEN]
    //     Boolean canSwap = pawn1.CanSwapWith(pawn2);

    //     // [THEN]
    //     assertTrue(canSwap, "Player cannot switch with himself");
    // }

    // @Test
    // public void PawnFromPlayerA_CanSwapWith_PawnFromPlayerB_WhenAisOnStartTile() {
    //     // [GIVEN]
    //     Tile tile = new Tile();
    //     Tile startTile = new StartTile(1);

    //     Pawn pawn1 = new Pawn(1, startTile);
    //     Pawn pawn2 = new Pawn(2, tile);

    //     // [WHEN]
    //     Boolean canSwap = pawn1.CanSwapWith(pawn2);

    //     // [THEN]
    //     assertTrue(canSwap, "Player can switch when they are on start tile");
    // }

    // @Test
    // public void PawnFromPlayerA_CannotSwapWith_PawnFromPlayerB_WhenBisOnStartTile() {
    //     // [GIVEN]
    //     Tile tile = new Tile();
    //     Tile startTile = new StartTile(2);

    //     Pawn pawn1 = new Pawn(1, tile);
    //     Pawn pawn2 = new Pawn(2, startTile);

    //     // [WHEN]
    //     Boolean canSwap = pawn1.CanSwapWith(pawn2);

    //     // [THEN]
    //     assertFalse(canSwap, "Player cannot switch when opponent is on their start tile");
    // }

    // @Test
    // public void PawnFromPlayerA_CanSwapWith_PawnFromPlayerB_WhenBisOnWrongStartTile() {
    //     // [GIVEN]
    //     Tile tile = new Tile();
    //     Tile startTile = new StartTile(3);

    //     Pawn pawn1 = new Pawn(1, tile);
    //     Pawn pawn2 = new Pawn(2, startTile);

    //     // [WHEN]
    //     Boolean canSwap = pawn1.CanSwapWith(pawn2);

    //     // [THEN]
    //     assertTrue(canSwap, "Player can switch when the opponent is on a different start tile than their own");
    // }

    // @Test
    // public void PawnFromPlayerA_CannotSwapWith_PawnFromPlayerB_WhenAisOnFinishTile() {
    //     // [GIVEN]
    //     Tile tile = new Tile();
    //     Tile finishTile = new FinishTile(1);

    //     Pawn pawn1 = new Pawn(1, finishTile);
    //     Pawn pawn2 = new Pawn(2, tile);

    //     // [WHEN]
    //     Boolean canSwap = pawn1.CanSwapWith(pawn2);

    //     // [THEN]
    //     assertFalse(canSwap,"Player cannot switch when they are already finished");
    // }

    // @Test
    // public void PawnFromPlayerA_CannotSwapWith_PawnFromPlayerB_WhenBisOnFinishTile() {
    //     // [GIVEN]
    //     Tile tile = new Tile();
    //     Tile finishTile = new FinishTile(2);

    //     Pawn pawn1 = new Pawn(1, tile);
    //     Pawn pawn2 = new Pawn(2, finishTile);

    //     // [WHEN]
    //     Boolean canSwap = pawn1.CanSwapWith(pawn2);

    //     // [THEN]
    //     assertFalse(canSwap, "Player cannot switch when the opponent is already finished");
    // }

    // @Test
    // public void PawnFromPlayerA_CannotSwapWith_PawnFromPlayerB_WhenAisOnNestTile() {
    //     // [GIVEN]
    //     Tile tile = new Tile();
    //     Tile nestTile = new NestTile(1);

    //     Pawn pawn1 = new Pawn(1, nestTile);
    //     Pawn pawn2 = new Pawn(2, tile);

    //     // [WHEN]
    //     Boolean canSwap = pawn1.CanSwapWith(pawn2);

    //     // [THEN]
    //     assertFalse(canSwap, "Player cannot switch when they are not yet on the board");
    // }

    // @Test
    // public void PawnFromPlayerA_CannotSwapWith_PawnFromPlayerB_WhenBisOnNestTile() {
    //     // [GIVEN]
    //     Tile tile = new Tile();
    //     Tile nestTile = new NestTile(2);

    //     Pawn pawn1 = new Pawn(1, tile);
    //     Pawn pawn2 = new Pawn(2, nestTile);

    //     // [WHEN]
    //     Boolean canSwap = pawn1.CanSwapWith(pawn2);

    //     // [THEN]
    //     assertFalse(canSwap, "Player cannot switch when opponent is not yet on the board");
    // }

}
