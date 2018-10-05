package api

import com.twitter.finatra.http.Controller
import com.twitter.finatra.request.QueryParam
import javax.inject.{Inject, Singleton}
import service.IntesiveProcessingService

case class IntensiveDataFilter(@QueryParam description: String)

@Singleton
class IntensiveProcessingAPI @Inject()(intensiveProcessingService: IntesiveProcessingService) extends Controller{

  get("/intensive-processing") { filter: IntensiveDataFilter =>
    intensiveProcessingService.fetchAll(filter)
  }
}

