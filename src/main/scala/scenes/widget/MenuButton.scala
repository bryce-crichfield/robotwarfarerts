package scenes.widget

import scalafx.scene.control.Button
import scalafx.scene.text.Font
import java.applet.AudioClip
import app.AudioContext

class MenuButton(text: String, action: () => Unit) extends Button(text) {
  onAction = _ => {
    AudioContext.start("menu_23")
    action()
  }

  font = new Font("Arial", 20)
  prefWidth = 200
  prefHeight = 50
}