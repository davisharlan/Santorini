package actions

import components.{Move, State}
import org.scalatest.FunSpec

class MovingTest extends FunSpec {

  val mockState = State(
    List.fill(5)(List.fill(5)(0)),
    List(List((0, 0), (4, 4)), List((0, 4), (4, 0))),
    0
  )

  describe("getAllPotentialMoves") {
    it("should return all of the moves next to each position") {
      val expected = List(
        Move((0, 0), (-1, -1)),
        Move((0, 0), (-1, 0)),
        Move((0, 0), (-1, 1)),
        Move((0, 0), (0, -1)),
        Move((0, 0), (0, 1)),
        Move((0, 0), (1, -1)),
        Move((0, 0), (1, 0)),
        Move((0, 0), (1, 1)),
        Move((4, 4), (3, 3)),
        Move((4, 4), (3, 4)),
        Move((4, 4), (3, 5)),
        Move((4, 4), (4, 3)),
        Move((4, 4), (4, 5)),
        Move((4, 4), (5, 3)),
        Move((4, 4), (5, 4)),
        Move((4, 4), (5, 5))
      )
      assert(Moving.getAllPotentialMoves(mockState, 0) == expected)
    }
  }

  ignore("getAllValidMoves") {
    it("should only return valid moves") {}
  }

  describe("applyMoveToState") {
    it("should apply a move to the state") {
      val mockMove = Move((0, 0), (0, 1))
      val expected = State(
        List.fill(5)(List.fill(5)(0)),
        List(List((0, 1), (4, 4)), List((0, 4), (4, 0))),
        0
      )
      assert(Moving.applyMoveToState(mockState, mockMove) == expected)
    }
  }

}
