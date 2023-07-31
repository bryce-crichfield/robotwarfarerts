package game
import game.action.Action
import game.action.InputAction.KeyDown
import game.component.{Physics, Position, Renderable}
import scalafx.scene.Node
import scalafx.scene.paint.Color.Blue
import scalafx.scene.shape.Circle

class Player() extends Entity
  with Position with Physics with Renderable {
  override def update(actions: List[Action], delta_time: Double): List[Action] = {
    val acceleration = 100
    actions.foreach {
      case KeyDown("w") => ay -= acceleration
      case KeyDown("a") => ax -= acceleration
      case KeyDown("s") => ay += acceleration
      case KeyDown("d") => ax += acceleration
    }

    // Do euler integration
    vx += ax * delta_time
    vy += ay * delta_time
    // clamp velocity
    vx = Math.max(-100, Math.min(100, vx))
    vy = Math.max(-100, Math.min(100, vy))
    x += vx * delta_time
    y += vy * delta_time

    // Apply friction
    ax = -vx * 0.5
    ay = -vy * 0.5

    List()
  }

  def serialize: String = {
    s"Player($x, $y)"
  }
}

object Player {
  def deserialize(serialized: String): Option[Player] = {
    val pattern = "Player\\((\\d+), (\\d+)\\)".r
    serialized match {
      case pattern(x, y) => 
        val player = new Player()
        player.x = x.toInt
        player.y = y.toInt
        Some(player)
      case _ => None
    }
  }
}