package app

import scala.collection.mutable.HashMap
import scalafx.scene.media.Media
import scala.collection.mutable.ListBuffer
import scalafx.scene.media.MediaPlayer
import java.nio.file.FileStore
import java.nio.file.FileSystem
import java.nio.file.FileSystems
import java.io.File

object AudioResource {AudioResource
  private var media = new HashMap[String, Media]
  private var players = new ListBuffer[MediaPlayer]

  def load(): Unit = {
    // get all files in "/sounds" directory
    val isMp3 = (name: String) => name.endsWith(".mp3")
    val isWav = (name: String) => name.endsWith(".wav")
    val directory = "/home/bryce/IdeaProjects/robotwarfarerts/src/main/resources/sounds"

    // recursively get all files in directory
    val files = new ListBuffer[File]()
    val stack = new ListBuffer[File]()
    stack.addOne(new File(directory))
    while (stack.nonEmpty) {
      val file = stack.remove(0)
      if (file.isDirectory) {
        stack.addAll(file.listFiles())
      } else {
        files.addOne(file)
      }
    }

    // load all files into media map
    files.foreach { file =>
      val path = file.getAbsolutePath()
      val name = file.getName()
      if (isMp3(name) || isWav(name)) {
        val id = name.split("\\.")(0)
        media.addOne(id, new Media(new File(path).toURI().toString()))
      }
    }
  }

  def unload(): Unit = {
    media = new HashMap[String, Media]
  }

  def apply(name: String): Option[Media] = {
    media.get(name)
  }


}
