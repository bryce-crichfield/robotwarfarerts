package game

import game.action.Action
import game.action.InputAction.KeyDown
import game.component.Renderable
import scalafx.scene.Node

import scala.collection.mutable.ListBuffer

case class World(entities: List[Entity]) {

  def update(actions: List[Action], delta: Double): List[Action] = {
    entities.foldLeft(List[Action]()) { (list, entity) =>
      list ::: entity.update(actions, delta)
    }
  }

  def serialize: String = {
    entities.map(_.serialize).mkString("\n")
  }
}

object World {
  def initial: World = {
    val serial = "Player(100, 100)\nPlayer(200, 200)"
    val entities = serial.split("\n").flatMap { serialized =>
      Player.deserialize(serialized)
    }.toList

    World(entities)
  }
}