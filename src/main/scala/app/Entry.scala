package app

import scalafx.application.JFXApp3
import scalafx.application.JFXApp3.PrimaryStage
import scalafx.scene.Scene
import scenes.{GameScene, MainMenu, OptionsMenu, SceneManager}

object Entry extends JFXApp3 {
  SceneManager.addScene("main", new MainMenu())
  SceneManager.addScene("options", new OptionsMenu())
  SceneManager.addScene("game", new GameScene())

  override def start(): Unit = {
    stage = new PrimaryStage {
      title = "Game Graphics"
      width = 800
      height = 800
      scene = new MainMenu()
    }
  }

}