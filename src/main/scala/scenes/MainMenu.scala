package scenes

import scalafx.Includes.when
import scalafx.application.Platform
import scalafx.geometry.Pos
import scalafx.scene.Scene
import scalafx.scene.control.Button
import scalafx.scene.effect.BlendMode.{Green, Red}
import scalafx.scene.layout.VBox
import scalafx.scene.text.Font

class MainMenu extends Scene {
  root = new VBox {
    fillWidth = true
    alignment = Pos.Center
    spacing = 20

    children = Seq(
      new MenuButton("Enter Game", () => {
        SceneManager.changeScene("game")
      }),

      new MenuButton("Options", () => {
        SceneManager.changeScene("options")
      }),

      new MenuButton("Exit", () => {
        Platform.exit()
      })
    )
  }
}


