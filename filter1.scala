
import org.json4s._
import org.json4s.native.JsonMethods._

import scala.io.Source

object PandocJsonFilter {

  // takes name of a source file in pandoc JSON,
  // does something with it
  def main(args: Array[String]) = {
    if (args.size < 1) {
      val text = scala.io.Source.stdin.getLines mkString "\n"
      val parsedVal = parse(text)


      println ("\npeek at yaml metadata:")
      val yaml = parsedVal \\ "unMeta"
      println (pretty(render(yaml)))


    } else {
      val src = Source.fromFile(args(0))
      val srcStr = src.getLines mkString "\n"
      val parsedVal = parse(srcStr)
      //println (pretty(render(parsedVal)))


      println ("\npeek at yaml metadata:")
      val yaml = parsedVal \\ "unMeta"
      println (pretty(render(yaml)))
    }
  }


}
