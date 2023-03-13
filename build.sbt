ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .settings(
    name := "sbt_assignment"
  )
//scala test dependency.
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.7" % Test
//jdbc
libraryDependencies += "io.snappydata" % "snappydata-jdbc_2.11" % "1.2.0"
//Adding joda-date/time
libraryDependencies += "joda-time" % "joda-time" % "2.12.2"
// Added Cached Resolution  feature.
updateOptions := updateOptions.value.withCachedResolution(true)

lazy val core = (project in file("core"))
  .settings(
    name := "core",
    version := "1.0.0",
    scalaVersion := "2.13.8",
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.2.9" % Test,
      "joda-time" % "joda-time" % "2.10.13"
    )
  )
  .dependsOn(utils)
  .aggregate(utils)

lazy val utils = (project in file("utils"))
  .settings(
    name := "utils",
    version := "1.0.0",
    scalaVersion := "2.13.8"
  )



