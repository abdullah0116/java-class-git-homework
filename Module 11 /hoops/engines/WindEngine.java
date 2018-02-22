package engines;

import models.GameModel;
import models.BallModel;

public class WindEngine {
    public void updateState(GameModel state) {
        double xPosition = state.getBall().getxVelocity();
         state.getBall().setxVelocity(xPosition -.01);
    }
}
