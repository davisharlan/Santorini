package utils

import components.{Coordinates, Move, State}
import validation.{MoveValidation}

object MoveUtils {
  // TODO refactor function in the flatMap call
  def getAllPotentialMoves(state: State): List[Move] =
    state
      .positions(state.turn)
      .flatMap(x =>
        List(
          Move(x, Coordinates(x.row - 1, x.col - 1)),
          Move(x, Coordinates(x.row - 1, x.col)),
          Move(x, Coordinates(x.row - 1, x.col + 1)),
          Move(x, Coordinates(x.row, x.col - 1)),
          Move(x, Coordinates(x.row, x.col + 1)),
          Move(x, Coordinates(x.row + 1, x.col - 1)),
          Move(x, Coordinates(x.row + 1, x.col)),
          Move(x, Coordinates(x.row + 1, x.col + 1))
      ))
      .filter(MoveValidation.isMoveValid(state, _))

  def applyMoveToState(state: State, move: Move): State =
    State(state.board,
          state.positions.map(_.map(x => if (x == move.start) move.end else x)),
          state.turn)

}
