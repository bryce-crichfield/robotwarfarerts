package scenes

import scalafx.beans.property.StringProperty

class LoadingScene(override val manager: SceneManager) extends ManagedScene(manager) {
    val status = new StringProperty("")

}
