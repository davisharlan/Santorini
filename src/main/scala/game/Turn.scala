package game

import scala.io.StdIn.readLine
import components.State
import server.CLI
import utils.{BuildUtils, EndGameConditions, MoveUtils}
import validation.{BuildValidation, MoveValidation}

import scala.annotation.tailrec

object Turn {
  @tailrec def takeTurn(preMoveState: State): Int = {
    val postMoveState = Turn.takeMove(preMoveState)
    if (EndGameConditions.noAvailableMoves(preMoveState)) {
      preMoveState.turn + 1 % 2
    } else if (EndGameConditions.isWinningState(postMoveState))
      postMoveState.turn
    else takeTurn(Turn.takeBuild(postMoveState))
  }

  @tailrec def takeMove(preMoveState: State): State = {
    val move = CLI.requestMove()
    if (MoveValidation.isMoveValid(preMoveState, move)) {
      MoveUtils.applyMoveToState(preMoveState, move)
    } else {
      takeMove(preMoveState)
    }
  }

  @tailrec def takeBuild(preBuildState: State): State = {
    val build = CLI.requestBuild()
    if (BuildValidation.isBuildValid(preBuildState, build)) {
      BuildUtils.applyBuildToState(preBuildState, build)
    } else {
      takeBuild(preBuildState)
    }
  }

  def parseInput(): Array[Int] = readLine().split("D+").map(_.toInt).take(4)
}
