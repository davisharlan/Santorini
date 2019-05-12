package actions

import components.{Move, State}

object Moving {
  // TODO refactor getAllPotentialMoves()
  def getAllPotentialMoves(state: State, player: Int): List[Move] =
    state
      .positions(player)
      .flatMap(
        x =>
          List(
            Move(x, (x._1 - 1, x._2 - 1)),
            Move(x, (x._1 - 1, x._2)),
            Move(x, (x._1 - 1, x._2 + 1)),
            Move(x, (x._1, x._2 - 1)),
            Move(x, (x._1, x._2 + 1)),
            Move(x, (x._1 + 1, x._2 - 1)),
            Move(x, (x._1 + 1, x._2)),
            Move(x, (x._1 + 1, x._2 + 1))
        ))

  def getAllValidMoves(state: State, player: Int): List[Move] = ???

  def applyMoveToState(state: State, move: Move): State =
    State(state.board,
          state.positions.map(_.map(x => if (x == move.start) move.end else x)),
          state.turn)
}
