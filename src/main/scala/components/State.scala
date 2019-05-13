package components

case class State(board: List[List[Int]],
                 positions: List[List[Coordinates]],
                 turn: Int)
