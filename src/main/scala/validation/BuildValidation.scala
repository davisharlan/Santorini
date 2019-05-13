package validation

import components.{Build, State}
import utils.BuildUtils

object BuildValidation {
  def isBuildValid(state: State, build: Build): Boolean =
    StateValidation.isPositionsValid(List(List(build.placement))) &&
      StateValidation.isStateValid(BuildUtils.applyBuildToState(state, build)) &&
      !state.positions.flatten.contains(build.placement)
}
