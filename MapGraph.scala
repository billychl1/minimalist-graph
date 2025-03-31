/**
 * Generic graph implementation backed by an adjacency map
 */
class MapGraph[T](adjacencyMap: Map[T, List[T]]) extends Graph[T]:
  override def edges(v: T): List[T] = 
    adjacencyMap.getOrElse(v, List.empty[T])

object MapGraph:
  def apply[T](adjacencyMap: Map[T, List[T]]): MapGraph[T] = 
    new MapGraph(adjacencyMap)