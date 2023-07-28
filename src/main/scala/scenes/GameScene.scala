package scenes

import game.InputAction.KeyDown
import game.{Action, InputAction, World}
import javafx.beans.value.ObservableBooleanValue
import scalafx.Includes.when
import scalafx.application.Platform
import scalafx.beans.property.{BooleanProperty, DoubleProperty, IntegerProperty, ObjectProperty}
import scalafx.scene.{Node, Scene}
import scalafx.scene.layout.Pane
import scalafx.scene.paint.Color.Blue

import scala.collection.mutable.ListBuffer
import scala.concurrent.Future

class GameScene extends Scene {
  private var delta_time = 0.0d
  private var last_time = System.nanoTime()
  private var actions = List[Action]()
  private val frame_prop = IntegerProperty(0)
  private val world_prop = ObjectProperty(World.initial)

  frame_prop.onChange {
    val now = System.nanoTime()
    val delta = (now - last_time) / 1000000000.0d
    last_time = now
    val (new_world, new_actions) = world_prop().update(actions, delta)
    actions = new_actions
    world_prop() = new_world
    Platform.runLater(() => GameScene.this.content = world_prop().render())
  }

  val animation = new javafx.animation.AnimationTimer {
    override def handle(now: Long): Unit = {
      frame_prop() = frame_prop() + 1
    }
  }

  animation.start()

  onKeyPressed  = (event) => {
    if (event.getCode == javafx.scene.input.KeyCode.ESCAPE) {
      SceneManager.changeScene("main")
    }
    actions ::= KeyDown(event.getText)
  }
}
