
import org.json4s._
import org.json4s.native.JsonMethods._

import scala.io.Source

object PandocJsonFilter {


  def srcText(args: Array[String]): String = {
    if (args.size < 1) scala.io.Source.stdin.getLines mkString "\n"
    else Source.fromFile(args(0)).getLines mkString "\n"
  }

  // takes name of a source file in pandoc JSON,
  // does something with it
  def main(args: Array[String]) = {
    val text = srcText(args)
    val parsedVal = parse(text)

    println ("\npeek at yaml metadata:")
    val yaml = parsedVal \\ "unMeta"
    println (pretty(render(yaml)))
  }


}
