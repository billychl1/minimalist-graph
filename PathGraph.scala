import java.nio.file.{Files, Path}
import scala.jdk.StreamConverters.*

/**
 * Graph implementation for file system paths
 * Edges are the children of a directory
 */
object PathGraph extends Graph[Path]:
  override def edges(v: Path): List[Path] =
    if Files.isDirectory(v) then
      Files.list(v)
        .toScala(List)
        .sortWith { (p1, p2) =>
          // Directories first (deeper nodes), then alphabetical
          if Files.isDirectory(p1) && !Files.isDirectory(p2) then true
          else if !Files.isDirectory(p1) && Files.isDirectory(p2) then false
          else p1.toString.compareTo(p2.toString) < 0
        }
    else
      List.empty