package service

import api.IntensiveDataFilter
import javax.inject.Inject
import repository.{Data, IntensiveDataRepository}

import scala.concurrent.Future

class IntesiveProcessingService @Inject()(repository: IntensiveDataRepository) {

  case class IntensiveData(id: Option[Long], description: String)

  def fetchAll(filter: IntensiveDataFilter): Future[Seq[Data]] = {
    repository.allByDescription(filter.description)
  }
}
