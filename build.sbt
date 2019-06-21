name := "infix-to-postfix"

version := "0.1"

scalaVersion := "2.13.0"

lazy val root = (project in file("."))
  .settings(
    name := "root",
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.1.0-SNAP13" % Test
    )
  )