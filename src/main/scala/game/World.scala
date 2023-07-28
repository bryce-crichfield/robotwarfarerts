package game

import game.InputAction.KeyDown
import scalafx.scene.Node

import scala.collection.mutable.ListBuffer

case class World(entities: List[Entity]) {
  def update(actions: List[Action], delta: Double): (World, List[Action]) = {
    val new_entities = ListBuffer[Entity]()
    val new_actions = ListBuffer[Action]()

    for (entity <- entities) {
      val (new_entity, returned_actions) = entity.update(actions, delta)
      new_entity match {
        case Some(e) => new_entities += e
        case None =>
      }
      new_actions ++= returned_actions
    }

    (World(new_entities.toList), new_actions.toList)
  }

  def render(): List[Node] = {
    entities.map(_.render())
  }
}
object World {
  def initial: World = {
    World(List(Player((100, 100))))
  }
}