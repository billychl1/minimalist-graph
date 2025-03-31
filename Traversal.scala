import scala.annotation.tailrec
import scala.collection.mutable
import java.nio.file.{Files, Path}

/**
 * Graph traversal utilities
 */
object Traversal:
  /**
   * Depth-first traversal of a graph starting from a given vertex
   * Returns a list of visited vertices in DFS order
   */
  def dfs[T](graph: Graph[T], start: T): List[T] =
    val result = mutable.ListBuffer.empty[T]

    def visit(vertex: T): Unit =
      result += vertex
      graph.edges(vertex).foreach(visit)

    visit(start)
    result.toList

  /**
   * Find all scala files in a directory and its subdirectories
   */
  def findScalaFiles(rootDir: Path): List[Path] =
    dfs(PathGraph, rootDir)
      .filter(p => p.toString.endsWith(".scala") && Files.isRegularFile(p))
      
  /**
   * Safe depth-first traversal that handles cycles correctly
   * Returns a list of visited vertices in DFS order without revisiting vertices
   */
  def safeDfs[T](graph: Graph[T], start: T): List[T] =
    val visited = mutable.Set.empty[T]
    val result = mutable.ListBuffer.empty[T]

    def visit(vertex: T): Unit =
      if !visited.contains(vertex) then
        visited += vertex
        result += vertex
        graph.edges(vertex).foreach(visit)

    visit(start)
    result.toList
