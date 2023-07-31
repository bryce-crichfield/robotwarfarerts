package scenes

import scalafx.Includes.when
import scalafx.application.Platform
import scalafx.geometry.Pos
import scalafx.scene.Scene
import scalafx.scene.control.Button
import scalafx.scene.effect.BlendMode.{Green, Red}
import scalafx.scene.layout.VBox
import scalafx.scene.text.Font
import scenes.widget.MenuButton

class MainScene(override val manager: SceneManager) extends ManagedScene(manager) {
  root = new VBox {
    fillWidth = true
    alignment = Pos.Center
    spacing = 20

    children = Seq(
      new MenuButton("Enter Game", () => {
        manager.transition("game")
      }),

      new MenuButton("Options", () => {
        manager.transition("options")
      }),

      new MenuButton("Exit", () => {
        Platform.exit()
      })
    )
  }
}


