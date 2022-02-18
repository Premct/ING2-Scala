ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

lazy val root = (project in file("."))
  .settings(
    name := "td2"
  )

organization  := ""
name          := ""
version       := "1.0"
scalaVersion  := "2.13.8"

//Options de compilation
scalacOptions ++= Seq("-deprecation", "-feature")

//Ajoute le support de la parallélisation pour les collections
libraryDependencies += "org.scala-lang.modules" %% "scala-parallel-collections" % "1.0.4"
