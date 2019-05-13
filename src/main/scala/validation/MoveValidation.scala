package validation

import utils.MoveUtils.applyMoveToState
import components.{Move, State}

object MoveValidation {
  def isMoveValid(state: State, move: Move): Boolean =
    StateValidation.isStateValid(applyMoveToState(state, move)) &&
      state.board(move.end.row)(move.end.col) - state.board(move.start.row)(
        move.start.col) < 1
}
