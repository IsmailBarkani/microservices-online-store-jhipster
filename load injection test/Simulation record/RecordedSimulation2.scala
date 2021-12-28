
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class RecordedSimulation2 extends Simulation {

  private val httpProtocol = http
    .baseUrl("http://35.205.222.73:8080")
    .inferHtmlResources(AllowList(), DenyList())
    .acceptHeader("application/json, text/plain, */*")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("fr,fr-FR;q=0.8,en-US;q=0.5,en;q=0.3")
    .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:95.0) Gecko/20100101 Firefox/95.0")
  
  private val headers_0 = Map(
  		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8",
  		"Upgrade-Insecure-Requests" -> "1"
  )
  
  private val headers_1 = Map("Accept" -> "*/*")
  
  private val headers_2 = Map("Accept" -> "image/avif,image/webp,*/*")
  
  private val headers_4 = Map("Accept" -> "text/css,*/*;q=0.1")
  
  private val headers_18 = Map(
  		"Content-Type" -> "application/json",
  		"Origin" -> "http://35.205.222.73:8080"
  )
  
  private val headers_19 = Map("authorization" -> "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1dGgiOiJST0xFX0FETUlOLFJPTEVfVVNFUiIsImV4cCI6MTY0MDU0NjA0M30.0H91xTWBnfazvzyya-qpkSRzqjtmwZ3-QgTcaiq1tpSK2hooVHjcmcoU1KBhlY6SC3doaQpHyK2kuoN6naoDJw")


  private val scn = scenario("RecordedSimulation2")
    .exec(
      http("request_0")
        .get("/notification?page=1&size=20&sort=id,asc")
        .headers(headers_0)
        .resources(
          http("request_1")
            .get("/runtime.f8bb13dfabfeb2dbcea7.js")
            .headers(headers_1),
          http("request_2")
            .get("/images/logo-jhipster.png")
            .headers(headers_2)
            .check(status.is(401)),
          http("request_3")
            .get("/main.3d11d845e99af2df6e71.js")
            .headers(headers_1),
          http("request_4")
            .get("/content/css/loading.css")
            .headers(headers_4),
          http("request_5")
            .get("/polyfills.f8cf464ea56fc2d20b4c.js")
            .headers(headers_1),
          http("request_6")
            .get("/content/images/logo-jhipster.png")
            .headers(headers_2),
          http("request_7")
            .get("/styles.abfa85462d9a8faa304f.css")
            .headers(headers_4),
          http("request_8")
            .get("/38.64cac4edccfc0c283127.js")
            .headers(headers_1),
          http("request_9")
            .get("/favicon.ico")
            .headers(headers_2),
          http("request_10")
            .get("/i18n/en.json?_=28b3c139f550053f07272e09d6c2ef61"),
          http("request_11")
            .get("/api/account")
            .check(status.is(401)),
          http("request_12")
            .get("/management/info"),
          http("request_13")
            .get("/229.8a06b358a03019f0315d.js")
            .headers(headers_1),
          http("request_14")
            .get("/api/account")
            .check(status.is(401)),
          http("request_15")
            .get("/977.117b63a0cd1edbb48118.js")
            .headers(headers_1),
          http("request_16")
            .get("/api/account")
            .check(status.is(401)),
          http("request_17")
            .get("/logo-jhipster.cfd81fbabebba3d187b7.png")
            .headers(headers_2)
        )
    )
    .pause(6)
    .exec(
      http("request_18")
        .post("/api/authenticate")
        .headers(headers_18)
        .body(RawFileBody("recordedsimulation2/0018_request.json"))
        .resources(
          http("request_19")
            .get("/api/account")
            .headers(headers_19),
          http("request_20")
            .get("/services/notification/api/notifications?page=0&size=20&sort=id,asc")
            .headers(headers_19)
        )
    )
    .pause(1)
    .exec(
      http("request_21")
        .get("/services/notification/api/notifications?page=0&size=20&sort=id,asc")
        .headers(headers_19)
    )

	setUp(scn.inject(atOnceUsers(200))).protocols(httpProtocol)
}
