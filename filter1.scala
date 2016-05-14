
import org.json4s._
import org.json4s.native.JsonMethods._

import scala.io.Source

/**
*/
object PandocJsonFilter {


  /** Gets a string of JSON data as a string.
  * If command-line args included, first arg is
  * considered to be a file name.  Otherwise,
  * uses stdin as source for JSON text.
  * @param args Command-line args.
  * @return String of JSON text.
  */
  def srcText(args: Array[String]): String = {
    if (args.size < 1) scala.io.Source.stdin.getLines mkString "\n"
    else Source.fromFile(args(0)).getLines mkString "\n"
  }


  /** Transforms Pandoc JSON with URN values to pandoc
  * Pandoc JSON with URNs resolved to URLs.
  * @param args Zero or one command-line args.  If
  * arg included, it is assumed to be the name of a
  * file with Pandoc JSON.
  */
  def main(args: Array[String]) = {

    val parsed = parse(srcText(args))

    println ("Peek at yaml metadata:")
    val yaml = parsed \\ "unMeta"
    println (pretty(render(yaml)))
  }


}
