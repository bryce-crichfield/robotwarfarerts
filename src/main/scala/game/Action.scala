package game

trait Action

trait InputAction extends Action
object InputAction {
  case class KeyDown(key: String) extends InputAction

  case class MouseMotion(x: Double, y: Double) extends InputAction

  case class MouseDown(button: String, x: Double, y: Double) extends InputAction
}