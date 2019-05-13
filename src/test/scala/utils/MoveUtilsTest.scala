package utils

import components.{Coordinates, Move, State}
import org.scalatest.FunSpec

class MoveUtilsTest extends FunSpec {

  describe("getAllPotentialMoves") {
    it("should return all of the moves next to each position") {
      val mockState = State(
        List(List(0, 0, 0, 0, 0),
             List(0, 0, 0, 3, 0),
             List(0, 0, 0, 0, 1),
             List(0, 0, 0, 0, 0),
             List(0, 0, 0, 4, 3)),
        List(List(Coordinates(2, 4), Coordinates(4, 4)),
             List(Coordinates(2, 3), Coordinates(4, 0))),
        0
      )

      val expected = List(
        Move(Coordinates(2, 4), Coordinates(1, 4)),
        Move(Coordinates(2, 4), Coordinates(3, 3)),
        Move(Coordinates(2, 4), Coordinates(3, 4)),
        Move(Coordinates(4, 4), Coordinates(3, 3)),
        Move(Coordinates(4, 4), Coordinates(3, 4))
      )
      assert(MoveUtils.getAllPotentialMoves(mockState, 0) == expected)
    }
  }

  describe("applyMoveToState") {
    it("should apply a move to the state") {
      val mockState = State(
        List.fill(5)(List.fill(5)(0)),
        List(List(Coordinates(0, 0), Coordinates(4, 4)),
             List(Coordinates(0, 4), Coordinates(4, 0))),
        0
      )
      val mockMove = Move(Coordinates(0, 0), Coordinates(0, 1))
      val expected = State(
        List.fill(5)(List.fill(5)(0)),
        List(List(Coordinates(0, 1), Coordinates(4, 4)),
             List(Coordinates(0, 4), Coordinates(4, 0))),
        0
      )
      assert(MoveUtils.applyMoveToState(mockState, mockMove) == expected)
    }
  }

}
