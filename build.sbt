lazy val root = (project in file(".")).
  settings(
    name := "scalacd",
    version := "1.0",
    scalaVersion := "2.11.7"
  )

libraryDependencies +=  "org.json4s" %% "json4s-native" % "3.3.0.RC2"

// Add this if we want to do pandoc handling in-line,
// rather than assuming we're being fed json:
//libraryDependencies += "de.vorb" % "pandoc" % "0.0.+"


mainClass in assembly := Some("PandocJsonFilter")
