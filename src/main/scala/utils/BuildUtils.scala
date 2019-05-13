package utils

import components.{Build, Coordinates, Move, State}
import validation.BuildValidation

object BuildUtils {
  // TODO refactor
  def getAllPotentialBuilds(state: State, move: Move): List[Build] =
    List(
      Build(move.end, Coordinates(move.end.row - 1, move.end.col - 1)),
      Build(move.end, Coordinates(move.end.row - 1, move.end.col)),
      Build(move.end, Coordinates(move.end.row - 1, move.end.col + 1)),
      Build(move.end, Coordinates(move.end.row, move.end.col - 1)),
      Build(move.end, Coordinates(move.end.row, move.end.col + 1)),
      Build(move.end, Coordinates(move.end.row + 1, move.end.col - 1)),
      Build(move.end, Coordinates(move.end.row + 1, move.end.col)),
      Build(move.end, Coordinates(move.end.row + 1, move.end.col + 1))
    ).filter(BuildValidation.isBuildValid(state, _))

  def applyBuildToState(state: State, build: Build): State =
    State(
      state.board.updated(
        build.placement.row,
        state
          .board(build.placement.row)
          .updated(build.placement.col,
                   state.board(build.placement.row)(build.placement.col) + 1)),
      state.positions,
      state.turn
    )
}
