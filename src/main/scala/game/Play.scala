package game

import components.State

object Play {
  def playGame(): Int = Turn.takeTurn(addWorkers(generateInitialState()))

  def generateInitialState(): State =
    State(List.fill(5)(List.fill(5)(0)), List.fill(2)(List()), 0)

  def addWorkers(state: State): State = ???
}
