name := "slickTest"

version := "1.0"

scalaVersion := "2.11.7"

val jdbc = "jdbc" % "jdbc" % "2.0"
val anorm = "com.typesafe.play" % "anorm_2.10" % "2.5.0"
val cache = "javax.cache" % "cache-api" % "1.0.0"


libraryDependencies ++= Seq(
  "com.typesafe.slick" % "slick_2.11" % "2.1.0",
  "com.typesafe.slick" % "slick-codegen_2.11" % "2.1.0",
  "org.scala-lang" % "scala-reflect" % scalaVersion.value,
  "com.h2database" % "h2" % "1.4.189",
  "mysql" % "mysql-connector-java" % "5.1.12",
  "com.zaxxer" % "HikariCP-java6" % "2.3.3",
  "org.slf4j" % "slf4j-nop" % "1.6.4"
)

resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"
