package scenes

import scalafx.geometry.Pos
import scalafx.scene.Scene
import scalafx.scene.layout.VBox

class OptionsMenu() extends Scene {
  root = new VBox {
    alignment = Pos.Center

    children = Seq(
      new MenuButton("Back", () => {
        SceneManager.changeScene("main")
      }),
      new MenuButton("Fullscreen", () => {
        SceneManager.changeScene("main")
      }),
      new MenuButton("Resolution", () => {
        SceneManager.changeScene("main")
      }),
      new MenuButton("Volume", () => {
        SceneManager.changeScene("main")
      })
    )
  }
}