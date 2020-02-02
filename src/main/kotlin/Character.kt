package main


const val NORTH = 1
const val EAST = 2
const val SOUTH = 3
const val WEST = 4
val orientations:HashMap<Int,String> = hashMapOf(Pair(NORTH,"north"), Pair(EAST,"east"), Pair(SOUTH,"south"),Pair(WEST,"west"))

open class Character (position: Position, facingDirection:String) {
    var position:Position
    var facingDirection : Int

    init{
        this.position = position
        this.facingDirection = when (facingDirection){
            "w","W" -> WEST
            "s","S" -> SOUTH
            "e","E" -> EAST
            "n","N" -> NORTH
            else -> NORTH
        }
    }

    fun isVisibleFromPosition (observer:Position, observerLookingAt:Int): Boolean {
        val reachable = position.row == observer.row || position.col == observer.col
        val reachableAndVisible = if (reachable){
            when (observerLookingAt){
                NORTH-> { position.row < observer.row }
                SOUTH-> { position.row > observer.row }
                EAST -> { position.col > observer.col }
                WEST -> { position.col < observer.col }
                else -> false
            }
        } else false
        return reachableAndVisible
    }
}