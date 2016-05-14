
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


  /**  Gets string value of a YAML
  * metadata configuration object parsed
  * as a JValue object.
  * @param metaObj The parsed YAML entry.
  * @returns The string value of the entry,
  * or a null string an appropriate string
  * value could not be found.
  */
  def metaString(metaObj: JValue) = {
    implicit val formats = DefaultFormats
    try {
      val obj = metaObj \ "c" \ "c"
      obj.extract[String]
    } catch {
      case _: Throwable => {
        val str = ""
        str
      }
    }
  }

  /** Transforms a parsed document to a
  * map configuring base URLs for each of
  * the fundamental CITE services.
  */
  def configServices(yml: JValue) = {
    // transform services -> map
    val ctsBase = metaString(yml \\ "cts")
    val citeBase = metaString(yml \\ "cite")
    val imgBase = metaString(yml \\ "citeimg")
    ("cts" -> ctsBase, "cite" -> citeBase, "citeimg" -> imgBase)
  }


  /** Transforms Pandoc JSON with URN values to pandoc
  * Pandoc JSON with URNs resolved to URLs.
  * @param args Zero or one command-line args.  If
  * arg included, it is assumed to be the name of a
  * file with Pandoc JSON.
  */
  def main(args: Array[String]) = {
    val parsed = parse(srcText(args))
    var meta = configServices(parsed \\ "unMeta" \\ "services")
    println("Meta: " + meta)
      //println (pretty(render(meta)))
  }


}
