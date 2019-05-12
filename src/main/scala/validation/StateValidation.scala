package validation

import components.State

object StateValidation {
  def isBoardValid(board: List[List[Int]]): Boolean =
    if (board.length == 5 &&
        board.count(_.length == 5) == 5 &&
        board.flatten.count(x => x < 0 || x > 4) == 0) true
    else false

  def isPositionsValid(positions: List[List[(Int, Int)]]): Boolean =
    if ((positions.flatten.distinct.size == positions.flatten.size) &&
        positions.flatten.count(
          x => x._1 < 0 || x._1 > 4 || x._2 < 0 || x._2 > 4) == 0) true
    else false

  def isStateValid(state: State): Boolean =
    if (isBoardValid(state.board) &&
        isPositionsValid(state.positions) &&
        state.positions.flatten.count(x => state.board(x._1)(x._2) == 4) == 0)
      true
    else false
}
