name := "restapi"
organization := "template"

version := "0.1"

scalaVersion := "2.12.6"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-stream" % "2.5.16",
  "com.typesafe.akka" %% "akka-http" % "10.1.5",
  "com.typesafe.akka" %% "akka-http-testkit" % "10.1.5" % Test,
  "org.scalatest" %% "scalatest" % "3.0.5" % Test,
  "com.softwaremill.sttp" %% "core" % "1.3.3" % Test
)

enablePlugins(JavaAppPackaging)

dockerBaseImage := "anapsix/alpine-java"
dockerExposedPorts ++= Seq(8000)