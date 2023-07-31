package game.component

import game.component
import scalafx.scene.shape.Circle
import component.Position
import scalafx.scene.paint.Color.Red

trait Renderable {
  this: Position =>
  def render(): scalafx.scene.Node = {
    val self = this
    new Circle {
      centerX = self.x
      centerY = self.y
      radius = 25
      fill = Red
    }
  }
}
