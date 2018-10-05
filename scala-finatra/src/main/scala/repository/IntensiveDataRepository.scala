package repository

import slick.driver.H2Driver.api._
import com.google.inject.{Inject, Singleton}
import slick.jdbc.JdbcProfile

import scala.concurrent.Future

case class Data(id: Long, description:String)

@Singleton
class IntensiveDataRepository {

  class IntensiveData(tag: Tag) extends Table[Data](tag, "INTENSIVE_DATA") {
    def id = column[Long]("ID", O.AutoInc, O.PrimaryKey)
    def description = column[String]("DESCRIPTION")

    def * = (id, description) <> (Data.tupled, Data.unapply)
  }

  val setup = DBIO.seq(
    intensiveData.schema.create,
    intensiveData ++= Seq(
      Data(1, "If you care about what other people think, you're never gonna do anything"),
      Data(2, "If you care about what other people think, you're never gonna do anything"),
      Data(3, "I need to go take a shower so I can't tell if I'm crying or not"),
      Data(4, "It gets easier. But you have to do it every day, that's the hard part. But it does get easier"),
      Data(5, "If you care about what other people think, you're never gonna do anything"),
      Data(6, "You know what the problem is with everybody? They all just want to hear what they already believe. No one ever wants to hear the truth"),
      Data(7, "The universe is a cruel, uncaring void. The key to being happy isn't a search for meaning. It's to just keep yourself busy with unimportant nonsense, and eventually, you'll be dead"),
      Data(8, "It gets easier. But you have to do it every day, that's the hard part. But it does get easier"),
      Data(9, "Spaghetti or not, here I come"),
      Data(10, "It gets easier. But you have to do it every day, that's the hard part. But it does get easier"),
      Data(11, "Yes, I ate all the muffins, because I have no self-control and I hate myself"),
      Data(12, "Spaghetti or not, here I come"),
      Data(13, "I don't understand how people live. It's amazing to me that people wake up every morning and say: 'Yeah, another day, let's do it.' How do people do it? I don't know how"),
      Data(14, "Dead on the inside, dead on the outside"),
      Data(15, "I need to go take a shower so I can't tell if I'm crying or not"),
      Data(16, "I don't understand how people live. It's amazing to me that people wake up every morning and say: 'Yeah, another day, let's do it.' How do people do it? I don't know how"),
      Data(17, "Spaghetti or not, here I come"),
      Data(18, "Yes, I ate all the muffins, because I have no self-control and I hate myself"),
      Data(19, "I don't understand how people live. It's amazing to me that people wake up every morning and say: 'Yeah, another day, let's do it.' How do people do it? I don't know how"),
      Data(20, "For a lot of people, life is just one long, hard kick in the urethra"),
      Data(21, "Spaghetti or not, here I come"),
      Data(22, "I do love you, by the way. I mean as much as I'm capable of loving anyone"),
      Data(23, "I don't understand how people live. It's amazing to me that people wake up every morning and say: 'Yeah, another day, let's do it.' How do people do it? I don't know how"),
      Data(24, "If you care about what other people think, you're never gonna do anything"),
      Data(25, "I need to go take a shower so I can't tell if I'm crying or not"),
      Data(26, "Ow, crap. I hate this. Running is terrible. Everything is the worst"),
      Data(27, "If you care about what other people think, you're never gonna do anything"),
      Data(28, "For a lot of people, life is just one long, hard kick in the urethra"),
      Data(29, "Spaghetti or not, here I come"),
      Data(30, "I do love you, by the way. I mean as much as I'm capable of loving anyone"),
      Data(31, "Not understanding that you're a horrible person doesn't make you less of a horrible person"),
      Data(32, "Not understanding that you're a horrible person doesn't make you less of a horrible person"),
      Data(33, "Yes, I ate all the muffins, because I have no self-control and I hate myself"),
      Data(34, "Dead on the inside, dead on the outside"),
      Data(35, "Dead on the inside, dead on the outside"),
      Data(36, "I don't understand how people live. It's amazing to me that people wake up every morning and say: 'Yeah, another day, let's do it.' How do people do it? I don't know how"),
      Data(37, "Beer before liquor, never sicker, liquor before beer, never fear, don't do heroin"),
      Data(38, "You know what the problem is with everybody? They all just want to hear what they already believe. No one ever wants to hear the truth"),
      Data(39, "That's the problem with life, either you know what you want and you don't get what you want, or you get what you want and then you don't know what you want"),
      Data(40, "Spaghetti or not, here I come"),
      Data(41, "The universe is a cruel, uncaring void. The key to being happy isn't a search for meaning. It's to just keep yourself busy with unimportant nonsense, and eventually, you'll be dead"),
      Data(42, "I need to go take a shower so I can't tell if I'm crying or not"),
      Data(43, "Ow, crap. I hate this. Running is terrible. Everything is the worst"),
      Data(44, "It gets easier. But you have to do it every day, that's the hard part. But it does get easier"),
      Data(45, "Dead on the inside, dead on the outside"),
      Data(46, "Yes, I ate all the muffins, because I have no self-control and I hate myself"),
      Data(47, "It gets easier. But you have to do it every day, that's the hard part. But it does get easier"),
      Data(48, "Yes, I ate all the muffins, because I have no self-control and I hate myself"),
      Data(49, "If you care about what other people think, you're never gonna do anything"),
      Data(50, "That's the problem with life, either you know what you want and you don't get what you want, or you get what you want and then you don't know what you want"),
      Data(51, "I need to go take a shower so I can't tell if I'm crying or not"),
      Data(52, "You know what the problem is with everybody? They all just want to hear what they already believe. No one ever wants to hear the truth"),
      Data(53, "For a lot of people, life is just one long, hard kick in the urethra"),
      Data(54, "Beer before liquor, never sicker, liquor before beer, never fear, don't do heroin"),
      Data(55, "Beer before liquor, never sicker, liquor before beer, never fear, don't do heroin"),
      Data(56, "I don't understand how people live. It's amazing to me that people wake up every morning and say: 'Yeah, another day, let's do it.' How do people do it? I don't know how"),
      Data(57, "I need to go take a shower so I can't tell if I'm crying or not"),
      Data(58, "Not understanding that you're a horrible person doesn't make you less of a horrible person"),
      Data(59, "I do love you, by the way. I mean as much as I'm capable of loving anyone"),
      Data(60, "Beer before liquor, never sicker, liquor before beer, never fear, don't do heroin"),
      Data(61, "Yes, I ate all the muffins, because I have no self-control and I hate myself"),
      Data(62, "Dead on the inside, dead on the outside"),
      Data(63, "For a lot of people, life is just one long, hard kick in the urethra"),
      Data(64, "The universe is a cruel, uncaring void. The key to being happy isn't a search for meaning. It's to just keep yourself busy with unimportant nonsense, and eventually, you'll be dead"),
      Data(65, "That's the problem with life, either you know what you want and you don't get what you want, or you get what you want and then you don't know what you want"),
      Data(66, "If you care about what other people think, you're never gonna do anything"),
      Data(67, "It gets easier. But you have to do it every day, that's the hard part. But it does get easier"),
      Data(68, "I do love you, by the way. I mean as much as I'm capable of loving anyone"),
      Data(69, "It gets easier. But you have to do it every day, that's the hard part. But it does get easier"),
      Data(70, "If you care about what other people think, you're never gonna do anything"),
      Data(71, "It gets easier. But you have to do it every day, that's the hard part. But it does get easier"),
      Data(72, "It gets easier. But you have to do it every day, that's the hard part. But it does get easier"),
      Data(73, "That's the problem with life, either you know what you want and you don't get what you want, or you get what you want and then you don't know what you want"),
      Data(74, "I do love you, by the way. I mean as much as I'm capable of loving anyone"),
      Data(75, "If you care about what other people think, you're never gonna do anything"),
      Data(76, "Dead on the inside, dead on the outside"),
      Data(77, "Spaghetti or not, here I come"),
      Data(78, "Yes, I ate all the muffins, because I have no self-control and I hate myself"),
      Data(79, "It gets easier. But you have to do it every day, that's the hard part. But it does get easier"),
      Data(80, "Dead on the inside, dead on the outside"),
      Data(81, "Ow, crap. I hate this. Running is terrible. Everything is the worst"),
      Data(82, "Ow, crap. I hate this. Running is terrible. Everything is the worst"),
      Data(83, "That's the problem with life, either you know what you want and you don't get what you want, or you get what you want and then you don't know what you want"),
      Data(84, "If you care about what other people think, you're never gonna do anything"),
      Data(85, "The universe is a cruel, uncaring void. The key to being happy isn't a search for meaning. It's to just keep yourself busy with unimportant nonsense, and eventually, you'll be dead"),
      Data(86, "It gets easier. But you have to do it every day, that's the hard part. But it does get easier"),
      Data(87, "You know what the problem is with everybody? They all just want to hear what they already believe. No one ever wants to hear the truth"),
      Data(88, "I do love you, by the way. I mean as much as I'm capable of loving anyone"),
      Data(89, "If you care about what other people think, you're never gonna do anything"),
      Data(90, "Yes, I ate all the muffins, because I have no self-control and I hate myself"),
      Data(91, "It gets easier. But you have to do it every day, that's the hard part. But it does get easier"),
      Data(92, "Not understanding that you're a horrible person doesn't make you less of a horrible person"),
      Data(93, "Not understanding that you're a horrible person doesn't make you less of a horrible person"),
      Data(94, "That's the problem with life, either you know what you want and you don't get what you want, or you get what you want and then you don't know what you want"),
      Data(95, "Yes, I ate all the muffins, because I have no self-control and I hate myself"),
      Data(96, "It gets easier. But you have to do it every day, that's the hard part. But it does get easier"),
      Data(97, "You know what the problem is with everybody? They all just want to hear what they already believe. No one ever wants to hear the truth"),
      Data(98, "Yes, I ate all the muffins, because I have no self-control and I hate myself"),
      Data(99, "If you care about what other people think, you're never gonna do anything"),
      Data(100, "Dead on the inside, dead on the outside")
    )
  )

  lazy val intensiveData = TableQuery[IntensiveData]
  val db = Database.forConfig("h2mem1")
  db.run(setup)

  def filterByDescription(description: String) = intensiveData
    .filter(_.description.like(s"%$description%"))
    .to[List]

  def allByDescription(description: String): Future[List[Data]] = {
    val query = filterByDescription(description).result
    db.run(query)
  }
}
