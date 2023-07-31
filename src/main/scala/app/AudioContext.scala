package app

import scala.collection.mutable.ListBuffer
import scalafx.scene.media.MediaPlayer

object AudioContext {
    private val players = new ListBuffer[MediaPlayer]()

    def start(name: String): Unit = {
        AudioResource(name).foreach { media =>
            val player = new MediaPlayer(media)
            // player.setCycleCount(MediaPlayer.)
            player.play()
            players.addOne(player)
        }
    }

    def stop(): Unit = {
        players.foreach(_.stop())
    }
}
