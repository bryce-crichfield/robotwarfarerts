package scenes

import scalafx.scene.Scene

abstract class ManagedScene(val manager: SceneManager) extends Scene {
  def onEnter(): Unit = ()
  def onExit(): Unit = ()
}
