package engines;
import models.GameModel;

public class CollisionEngine {
    public void updateState(GameModel state) {
        if (state.getBall().getY() < 0) {
          state.getBall().setY(0);
        }
    }
}
