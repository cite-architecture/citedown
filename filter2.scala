
import org.json4s._
import org.json4s.native.JsonMethods._

import scala.io.Source

//import de.vorb.text.pandoc._

object PandocMdFilter {

  // takes name of a source file in Markdown format,
  // converts it to markdown with URNs resolved.
  def main(args: Array[String]) = {
    if (args.size < 1) {
      System.err.println ("Usage: requires at least one file as parameter")
    } else {
      val src = Source.fromFile(args(0))
      val srcStr = src.getLines mkString "\n"
      val parsedVal = parse(srcStr)
      println (pretty(render(parsedVal)))


      println ("\npeek at yaml metadata:")
      println (parsedVal \\ "unMeta")
    }
  }


}
