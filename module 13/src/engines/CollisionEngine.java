package engines;

import misc.GameState;

public class CollisionEngine {
    public void updateState(GameState state) {
        if (state.getBall().getY() < 0) {
            state.getBall().setY(0);
            double oldYVelocity = state.getBall().getyVelocity();
            state.getBall().setyVelocity(oldYVelocity * -.7);
        }
    }
}
