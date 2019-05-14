package game

import components.{Build, Move, State}
import utils.MoveUtils

object Turn {
  def takeTurn(state: State): Either[State, Error] = ???

  def takeMove(state: State, move: Move): Either[Int, Error] = ???

  def takeBuild(state: State, build: Build): Either[Int, Error] = {
    
  }
}
