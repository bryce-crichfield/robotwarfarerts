package scenes

import scalafx.geometry.Pos
import scalafx.scene.Scene
import scalafx.scene.control.Label
import scalafx.scene.layout.VBox
import scenes.widget.{MenuButton, MenuSlider}
import app.Settings
import scalafx.scene.control.ChoiceBox
import scalafx.collections.ObservableBuffer
import scalafx.scene.control.CheckBox
import scalafx.scene.control.Slider

class OptionsScene(override val manager: SceneManager) extends ManagedScene(manager) {
  root = new VBox {
    alignment = Pos.Center

    children = Seq(
      new MenuButton("Back", () => {
        manager.transition("main")
      }),
      new MenuButton("Fullscreen", () => {
        manager.transition("main")
      }),
      new Slider {
        min = 0
        max = 1
        value = Settings.volume()
        value.onChange((_, _, new_value) => {
          Settings.volume() = new_value.doubleValue()
        })
      },
      new ChoiceBox[String] {
        items = ObservableBuffer("800x600", "1024x768", "1280x720", "1920x1080")
        value = "800x600"
        onAction = _ => {
          val resolution = value.value.split("x")
          Settings.resolution_width() = resolution(0).toDouble
          Settings.resolution_height() = resolution(1).toDouble
        }
      },
    )
  }
}