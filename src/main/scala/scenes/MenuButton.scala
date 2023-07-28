package scenes

import scalafx.scene.control.Button
import scalafx.scene.text.Font

class MenuButton(text: String, action: () => Unit) extends Button(text) {
  onAction = _ => {
    action()
  }

  font = new Font("Arial", 20)
  prefWidth = 200
  prefHeight = 50
}