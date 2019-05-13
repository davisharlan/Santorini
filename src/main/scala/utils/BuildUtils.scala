package utils

import components.{Build, Move, State}

object BuildUtils {
  def getAllPotentialBuilds(state: State, move: Move): List[Build] =
    List(
      Build(move.end, (move.end._1 - 1, move.end._2 - 1)),
      Build(move.end, (move.end._1 - 1, move.end._2)),
      Build(move.end, (move.end._1 - 1, move.end._2 + 1)),
      Build(move.end, (move.end._1, move.end._2 - 1)),
      Build(move.end, (move.end._1, move.end._2 + 1)),
      Build(move.end, (move.end._1 + 1, move.end._2 - 1)),
      Build(move.end, (move.end._1 + 1, move.end._2)),
      Build(move.end, (move.end._1 + 1, move.end._2 + 1))
    )

  def applyBuildToState(state: State, build: Build): State =
    State(
      state.board.updated(
        build.placement._1,
        state
          .board(build.placement._1)
          .updated(build.placement._2,
                   state.board(build.placement._1)(build.placement._2) + 1)),
      state.positions,
      state.turn
    )
}
