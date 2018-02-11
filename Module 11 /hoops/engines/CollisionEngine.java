package engines;
import models.GameModel;

public class CollisionEngine {
  public void updateState(GameModel gameModel) {
    if (gameModel.getBall().getY() < 0) {
      gameModel.getBall().setY(0);
      //double oldYVeolocity = gameModel.getBall().getyvelocity();
      //gameModel.getBall().setyVelocity;
    }
  }
}
