package template.restapi

import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import template.restapi.api.V1

class Api {

  def routes: Route = path("status") {
    get {
      complete(StatusCodes.OK)
    }
  } ~ (new V1).routes

}
