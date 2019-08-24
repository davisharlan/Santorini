package server

import cats.effect._
import cats.implicits._
import org.http4s.HttpRoutes
import org.http4s.syntax._
import org.http4s.dsl.io._
import org.http4s.implicits._
import org.http4s.server.blaze._

object HTTPServer extends IOApp {

  val httpService = HttpRoutes
    .of[IO] {
      case GET -> Root / "api" / "board" / boardId =>
        //val boardState = getBoardState(boardId)
        //val jsonBoardState = boardState.toJson
        Ok() //<--- put the json board state here
      case POST -> Root / "api" / "board" / boardId / "player" / playerId / "piece" / pieceId / "move" / location =>
        //val isValid = validateMode(....)
        //val newState = applyMove(boardId, playerId, pieceId, location).toJson
        Ok() //<--- put the new board state here
      case GET -> Root / "ping" =>
        Ok("Pong!")
    }
    .orNotFound

  def run(args: List[String]): IO[ExitCode] =
    BlazeServerBuilder[IO]
      .bindHttp(8081, "localhost")
      .withHttpApp(httpService)
      .serve
      .compile
      .drain
      .as(ExitCode.Success)
}
