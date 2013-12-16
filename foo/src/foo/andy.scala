
import scala.io.Source

val lines = Source.fromFile("/home/andy/foo.txt").getLines().toList.map( _.split(",").toList)

println(lines)

val m = {
  val q = lines.head
  for {
    vs <- lines.tail
  }  yield {
    Map(q.zip(vs) : _*)
  }
}

val triples = for { 
  x <- 1 to 20
  y <- 1 to 20
  z <- 1 to 20 
  if ( x * x + y * y == z * z )
} yield (x,y,z)

triples foreach println
