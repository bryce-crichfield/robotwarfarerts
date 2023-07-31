package scenes

import game.action.Action
import game.action.InputAction.KeyDown
import game.component.Renderable
import game.{Entity, World}
import scalafx.application.Platform
import app.AudioResource
import app.AudioContext

class GameScene(override val manager: SceneManager) extends ManagedScene(manager) {
  private var delta_time = 0.0d
  private var last_update_time = System.nanoTime()
  private var last_render_time = System.nanoTime()
  private var actions = List[Action]()
  private val world = World.initial

  private val game_loop = new javafx.animation.AnimationTimer {
    override def handle(now: Long): Unit = {
      val update_delta = (now - last_update_time) / 1e9d
      val render_delta = (now - last_render_time) / 1e9d

      actions = world.update(actions, update_delta)
      last_update_time = now

      if (render_delta >= (1d / 60)) {
        Platform.runLater {
          content = world.entities.collect {
            case entity: Entity with Renderable =>
              entity.render()
          }
        }

        last_render_time = now
      }
    }
  }

  override def onEnter(): Unit = {
    game_loop.start()
  }

  override def onExit(): Unit = {
    game_loop.stop()
  }


  onKeyPressed  = (event) => {
    if (event.getCode == javafx.scene.input.KeyCode.ESCAPE) {
      manager.transition("main")
    }
    actions ::= KeyDown(event.getText)
  }
}
