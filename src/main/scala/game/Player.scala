package game
import game.InputAction.KeyDown
import scalafx.scene.Node
import scalafx.scene.paint.Color.Blue
import scalafx.scene.shape.Circle

case class Player(val position: (Double, Double)) extends Entity {
  override def update(actions: List[Action], delta_time: Double): (Option[Entity], List[Action]) = {
    val new_position = actions.foldLeft(position) {
      case ((x, y), KeyDown("w")) => (x, y - 1)
      case ((x, y), KeyDown("a")) => (x - 1, y)
      case ((x, y), KeyDown("s")) => (x, y + 1)
      case ((x, y), KeyDown("d")) => (x + 1, y)
      case ((x, y), _) => (x, y)
    }

    (Some(Player(new_position)), List())
  }

  override def render(): Node = {
    new Circle {
      centerX = position._1
      centerY = position._2
      radius = 10
      fill = Blue
    }
  }
}
