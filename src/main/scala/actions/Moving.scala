package actions

import components.{Move, State}

object Moving {
  def getAllPotentialMoves(state: State, player: Int): List[Move] = ??? //

  def getAllValidMoves(state: State, player: Int): List[Move] = ???

  def applyMoveToState(state: State, move: Move): State =
    State(state.board,
          state.positions.map(_.map(x => if (x == move.start) move.end else x)),
          state.turn)
}
