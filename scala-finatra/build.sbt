name := "scala-benchmark"

version := "0.1"

scalaVersion := "2.12.6"

resolvers ++= Seq(
  Resolver.sonatypeRepo("releases"),
  "Twitter Maven" at "https://maven.twttr.com"
)

logLevel := Level.Info

lazy val versions = new {
  val finatra = "2.13.0"
  val guice = "4.0"
  val logback = "1.1.7"
  val mockito = "1.9.5"
  val scalatest = "3.0.0"
  val scalacheck = "1.13.4"
  val specs2 = "2.4.17"
  val junit = "4.12"
}

libraryDependencies ++= Seq(
  "com.twitter" %% "finatra-http" % versions.finatra,
  "com.softwaremill.sttp" %% "core" % "1.3.0-RC5",
  "ch.qos.logback" % "logback-classic" % versions.logback,
  "ch.qos.logback" % "logback-classic" % versions.logback % "test",
  "org.json4s" %% "json4s-jackson" % "3.5.1",
  "org.mozilla" % "rhino" % "1.7R4",

  "com.typesafe.slick" %% "slick" % "3.2.3",
  "com.typesafe.slick" %% "slick-hikaricp" % "3.2.1",
  "com.h2database" % "h2" % "1.4.197",

  "com.twitter" %% "bijection-util" % "0.9.6",
  "com.twitter" %% "finatra-http" % versions.finatra % "test",
  "com.twitter" %% "finatra-jackson" % versions.finatra % "test",
  "com.twitter" %% "inject-server" % versions.finatra % "test",
  "com.twitter" %% "inject-app" % versions.finatra % "test",
  "com.twitter" %% "inject-core" % versions.finatra % "test",
  "com.twitter" %% "inject-modules" % versions.finatra % "test",
  "com.google.inject.extensions" % "guice-testlib" % versions.guice % "test",

  "com.twitter" %% "finatra-http" % versions.finatra % "test" classifier "tests",
  "com.twitter" %% "inject-server" % versions.finatra % "test" classifier "tests",
  "com.twitter" %% "inject-app" % versions.finatra % "test" classifier "tests",
  "com.twitter" %% "inject-core" % versions.finatra % "test" classifier "tests",
  "com.twitter" %% "inject-modules" % versions.finatra % "test" classifier "tests",

  "junit" % "junit" % versions.junit % "test",

  "com.github.tomakehurst" % "wiremock" % "2.18.0" % "test",
  "org.mockito" % "mockito-core" % versions.mockito % "test",
  "org.scalacheck" %% "scalacheck" % versions.scalacheck % "test",
  "org.scalatest" %% "scalatest" % versions.scalatest % "test",
  "org.specs2" %% "specs2-mock" % versions.specs2 % "test")
