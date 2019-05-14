package validation

import components.{Coordinates, State}

object StateValidation {
  def isBoardValid(board: List[List[Int]]): Boolean =
    if (board.length == 5 &&
        board.count(_.length == 5) == 5 &&
        board.flatten.count(x => x < 0 || x > 4) == 0) true
    else false

  def isPositionsValid(positions: List[List[Coordinates]]): Boolean =
    if (positions.flatten.distinct.size == positions.flatten.size &&
        positions.flatten.count(!CoordinatesValidation.isCoordinatesValid(_)) == 0) true
    else false

  def isStateValid(state: State): Boolean =
    if (isBoardValid(state.board) &&
        isPositionsValid(state.positions) &&
        state.positions.flatten.count(x => state.board(x.row)(x.col) == 4) == 0)
      true
    else false
}
