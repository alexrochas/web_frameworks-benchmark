import api.IntensiveProcessingAPI
import com.twitter.finatra.http.HttpServer
import com.twitter.finatra.http.routing.HttpRouter

object AppServer extends App

class App extends HttpServer {

  override val disableAdminHttpServer: Boolean = true

  override def defaultFinatraHttpPort: String = ":8080"

  override def configureHttp(router: HttpRouter): Unit = {
    router.add[IntensiveProcessingAPI]
  }
}
