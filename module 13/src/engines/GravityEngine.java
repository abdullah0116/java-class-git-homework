package engines;

import misc.GameState;

/**
 * Engine which applies the force of gravity to items within the game.
 */
public class GravityEngine implements Engines{
    public void updateState(GameState state) {
        double oldYVelocity = state.getBall().getyVelocity();
        state.getBall().setyVelocity(oldYVelocity - .1);
    }
}
