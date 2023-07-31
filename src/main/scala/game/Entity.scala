package game

import game.action.Action
import scalafx.scene.Node

trait Entity {
  def update(actions: List[Action], delta_time: Double): List[Action]

  def serialize: String
}
