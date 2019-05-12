package validation

import components.State

object MoveValidity {
  def isMoveValid(state: State, move: State => State): Boolean = ???
  def isBuildValid(state: State, move: State => State, build: State => State): Boolean = ???
}
