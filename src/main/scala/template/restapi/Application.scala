package template.restapi

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer

import scala.concurrent.ExecutionContextExecutor

object Application extends App {
  def start(): Unit = {
    implicit val system: ActorSystem = ActorSystem()
    implicit val materializer: ActorMaterializer = ActorMaterializer()
    implicit val executionContext: ExecutionContextExecutor = system.dispatcher

    val routes = (new Api).routes

    val bindingFuture = Http().bindAndHandle(routes, "0.0.0.0", 8000).recoverWith {
      case _ => sys.exit(1)
    }

    sys.addShutdownHook {
      bindingFuture.map(_.unbind())
    }
  }

  start()
}
