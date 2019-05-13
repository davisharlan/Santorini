package validation

import components.Coordinates

object CoordinatesValidation {
  def isCoordinatesValid(coordinates: Coordinates): Boolean =
    coordinates.row >= 0 && coordinates.row < 5 && coordinates.col >= 0 && coordinates.col < 5
}
