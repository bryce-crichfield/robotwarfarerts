package game

import scalafx.scene.Node

trait Entity {
  def update(actions: List[Action], delta_time: Double): (Option[Entity], List[Action])
  def render(): Node
}
