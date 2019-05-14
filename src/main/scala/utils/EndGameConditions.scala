package utils

import components.State

object EndGameConditions {
  def isWinningState(state: State): Boolean =
    state.positions(state.turn).map(x => state.board(x.row)(x.col)).contains(3)

  def isLosingState(state: State): Boolean =
    MoveUtils.getAllPotentialMoves(state).length == 0
}
