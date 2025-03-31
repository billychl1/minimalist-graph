/**
 * Representation of Rock, Paper, Scissors moves
 */
enum RPSMove:
  case Rock, Paper, Scissors

/**
 * Graph implementation for the Rock, Paper, Scissors game
 * An edge from A to B means A beats B
 */
object RPSGraph extends Graph[RPSMove]:
  override def edges(v: RPSMove): List[RPSMove] = v match
    case RPSMove.Rock => List(RPSMove.Scissors)
    case RPSMove.Paper => List(RPSMove.Rock)
    case RPSMove.Scissors => List(RPSMove.Paper)