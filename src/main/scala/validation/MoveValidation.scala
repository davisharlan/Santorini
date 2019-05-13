package validation

import utils.MoveUtils.applyMoveToState
import components.{Move, State}
import utils.BuildUtils

object MoveValidation {
  def isMoveValid(state: State, move: Move): Boolean =
    StateValidation.isStateValid(applyMoveToState(state, move)) &&
      state.board(move.end._1)(move.end._2) - state.board(move.start._1)(
        move.start._2) < 1 &&
      BuildUtils
        .getAllPotentialBuilds(applyMoveToState(state, move), move)
        .length > 0
}
