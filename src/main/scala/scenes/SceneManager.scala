package scenes

import app.Entry
import scalafx.animation.PauseTransition
import scalafx.application.Platform
import scalafx.scene.Scene
import scalafx.stage.Stage

import scala.concurrent.duration.Duration

object SceneManager {
  private var scenes: Map[String, () => Scene] = Map()

  def addScene(name: String, scene: => Scene): Unit = {
    scenes += (name -> (() => scene))
  }

  def changeScene(name: String): Unit = {
    val stage = Entry.stage
    val scene = scenes(name)()
    stage.scene = scene
    // this seems to force the scene to update
    val orginal_width = stage.width.value
    stage.width = orginal_width + 0.001
    stage.width = orginal_width
  }
}
