package game

import components.{Build, Move, State}
import utils.{EndGameConditions, MoveUtils}

object Play {
  def playGame(state: State): Int = {
    takeTurn(addWorkers(state))
  }

  def generateInitialState(): State =
    State(List.fill(5)(List.fill(5)(0)), List.fill(2)(List()), 0)

  def addWorkers(state: State): State = ???
}
