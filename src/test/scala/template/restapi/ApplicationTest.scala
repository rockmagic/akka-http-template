package template.restapi

import com.softwaremill.sttp._
import org.scalatest.{Matchers, WordSpec}

class ApplicationTest extends WordSpec with Matchers {
  "Service" should {
    "response on target port" in {
      implicit val backend: SttpBackend[Id, Nothing] = HttpURLConnectionBackend()
      Application.start()
      sttp.get(uri"http://localhost:8000/").send().code shouldBe 200
    }
  }
}
