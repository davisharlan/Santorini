package utils

import components.State

object EndGameConditions {
  def isWinningState(state: State, player: Int): Boolean =
    state.positions(player).map(x => state.board(x.row)(x.col)).contains(3)

  def isLosingState(state: State, player: Int): Boolean =
    MoveUtils.getAllPotentialMoves(state, player).length == 0
}
