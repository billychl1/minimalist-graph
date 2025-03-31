import java.nio.file.{Path, Paths}

/**
 * Main application to demonstrate the graph implementations and traversals
 */
@main def run(): Unit =
  // Demonstrate RPS Graph
  println("=== Rock-Paper-Scissors Graph ===")
  println(s"Rock beats: ${RPSGraph.edges(RPSMove.Rock)}")
  println(s"Paper beats: ${RPSGraph.edges(RPSMove.Paper)}")
  println(s"Scissors beats: ${RPSGraph.edges(RPSMove.Scissors)}")
  println()

  // Demonstrate Map Graph
  println("=== Map Graph Example ===")
  val simpleGraph = MapGraph(Map(
    1 -> List(2, 3),
    2 -> List(1)
  ))
  println(s"Edges from 1: ${simpleGraph.edges(1)}")
  println(s"Edges from 2: ${simpleGraph.edges(2)}")
  println(s"Edges from 3 (not in map): ${simpleGraph.edges(3)}")
  println()

  // Demonstrate the example cyclic graph and safe traversal
  println("=== Cyclic Map Graph Example ===")
  val cyclicGraph = MapGraph(Map(
    1 -> List(2, 5, 8),
    2 -> List(3),
    3 -> List(4),
    4 -> List(2),
    5 -> List(6),
    6 -> List(3, 7, 8)
  ))
  println(s"Safe DFS from vertex 1: ${Traversal.safeDfs(cyclicGraph, 1).mkString(", ")}")
  println()

  // Demonstrate Path Graph and finding scala files (assuming the path exists)
  def demoPathGraph(path: String): Unit =
    try
      val rootDir = Paths.get(path)
      println("=== Path Graph Example ===")
      println(s"Exploring directory: $rootDir")

      println("=== Finding Scala Files ===")
      val scalaFiles = Traversal.findScalaFiles(rootDir)
      println(s"Found ${scalaFiles.size} scala files:")
      scalaFiles.foreach(println)
    catch
      case e: Exception => println(s"Error exploring path: ${e.getMessage}")

  // Demo PathGraph
  demoPathGraph("./foo")