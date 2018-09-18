package template.restapi

import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.testkit.ScalatestRouteTest
import org.scalatest.{Matchers, WordSpec}

class ApiTest extends WordSpec with Matchers with ScalatestRouteTest {

  val routes: Route = (new Api).routes

  "API" should {
    val routes = (new Api).routes
    "GET /status resp OK" in {
      Get("/status") ~> routes ~> check {
        status shouldBe StatusCodes.OK
      }
    }

    "POST /status resp OK" in {
      Post("/status") ~> Route.seal(routes) ~> check {
        status.isFailure() shouldBe true
      }
    }
  }
}
