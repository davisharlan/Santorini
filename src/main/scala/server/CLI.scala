package server

import components.{Build, Move}
import game.Play

object CLI {

  def main(args: Array[String]): Unit = {
    println(Play.playGame() + "won!")
  }

  def requestMove(): Move = ???

  def requestBuild(): Build = ???

}
