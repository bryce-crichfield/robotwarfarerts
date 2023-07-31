package scenes

import app.Entry
import scalafx.animation.PauseTransition
import scalafx.application.Platform
import scalafx.scene.Scene
import scalafx.stage.Stage

import scala.concurrent.duration.Duration

class SceneManager(private val stage: Stage) {
  private var current: Option[ManagedScene] = None
  private var scenes: Map[String, SceneManager => ManagedScene] = Map()

  def += (name: String, constructor: SceneManager => ManagedScene): Unit = {
    scenes += (name -> constructor)
  }

  def transition(name: String): Unit = {
    scenes.get(name).foreach { constructor =>
      current.foreach(_.onExit())

      val scene = constructor(this)
      scene.onEnter()
      stage.scene = scene
      // this seems to force the scene to update
      val orginal_width = stage.width.value
      stage.width = orginal_width + 0.001
      stage.width = orginal_width

      current = Some(scene)
    }
  }
}
