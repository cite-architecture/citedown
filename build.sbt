lazy val root = (project in file(".")).
  settings(
    name := "scpd",
    version := "1.0",
    scalaVersion := "2.11.7"
  )

libraryDependencies +=  "org.json4s" %% "json4s-native" % "3.3.0.RC2"
//libraryDependencies += "de.vorb" % "pandoc" % "0.0.+"
