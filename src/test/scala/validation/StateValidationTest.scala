package validation

import components.Coordinates
import org.scalatest.FunSpec

class StateValidationTest extends FunSpec {

  describe("StateValidationTest") {

    val mockBoard = List(List(0, 1, 2, 3, 4),
                         List(0, 1, 2, 3, 4),
                         List(0, 1, 2, 3, 4),
                         List(0, 1, 2, 3, 4),
                         List(0, 1, 2, 3, 4))
    val mockPositions = List(List(Coordinates(0, 0), Coordinates(4, 4)),
                             List(Coordinates(0, 4), Coordinates(4, 0)))

    describe("isBoardValid") {
      it("should return true if the board is valid") {
        assert(StateValidation.isBoardValid(mockBoard))
      }
      it(
        "should return false if the board does not have correct number of rows") {
        assert(!StateValidation.isBoardValid(mockBoard.drop(1)))
      }
      it("should return false if a row does not have the correct number of columns") {
        assert(
          !StateValidation.isBoardValid(List(1, 2, 3, 4) :: mockBoard.drop(1)))
      }
      it("should return false if board contain an invalid value") {
        assert(
          !StateValidation.isBoardValid(
            List(1, 2, 3, 4, 5) :: mockBoard.drop(1)))
      }
    }

    describe("isPositionsValid") {
      it("should return true if the positions are valid") {
        assert(StateValidation.isPositionsValid(mockPositions))
      }
      it("should return false if the positions overlap") {
        assert(!StateValidation.isPositionsValid(
          List(Coordinates(0, 4), Coordinates(4, 4)) :: mockPositions.drop(1)))
      }
      it("should return false if a position is off the board") {
        assert(!StateValidation.isPositionsValid(
          List(Coordinates(0, -1), Coordinates(4, 4)) :: mockPositions.drop(1)))
      }
    }

    ignore("isStateValid") {}

  }
}
