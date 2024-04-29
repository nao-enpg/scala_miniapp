name := """scala-miniapp"""
organization := "scala-miniapp"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)
.enablePlugins(DockerPlugin)
  .settings(
    Universal / javaOptions ++= Seq("-Dpidfile.path=/dev/null"),
    dockerBaseImage := "eclipse-temurin:21.0.3_9-jre-jammy",
    dockerExposedPorts ++= Seq(9000),
    dockerEnvVars := Map("TZ" -> "Asia/Tokyo"),
    // dockerEntrypoint := Seq("bin/entrypoint.sh"),
    // dockerRepository := Some(s"${sys.env.getOrElse("AWS_ACCOUNT", "")}.dkr.ecr.${sys.env.getOrElse("AWS_REGION", "ap-northeast-1")}.amazonaws.com")
  )

scalaVersion := "3.3.1"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "7.0.0" % Test

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "scala-miniapp.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "scala-miniapp.binders._"
