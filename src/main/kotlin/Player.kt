package main

class Player (startingPosition:Position, facingDirection:String, lives:Int) : Character(startingPosition, facingDirection) {

    var lives:Int
    var reachableEnemies:MutableList<Enemy>? = null
    init{
        this.lives = lives
    }

    fun shoot(){
        reachableEnemies = enemies.filter { enemy -> enemy.isVisibleFromPosition(position, facingDirection) }.toMutableList()
        if (reachableEnemies != null) {
            if (!reachableEnemies?.isEmpty()!!) {
                println(" Player has shoot and has killed enemy on "+ reachableEnemies?.first()?.position?.getString())
                enemies.remove(reachableEnemies?.first())
            }
            else{
                println("Player has shoot but nothing happens")
            }
        }
        else{
            println("Player has shoot but nothing happens")
        }
    }

    fun move(){
        val wantedPosition = getWantedPosition()
        if (!isItInTheLimit()) {
            if (!isThePositionOccupied(wantedPosition)) {
                player.position = wantedPosition
                println("Player has moved. Now it is in position " + position.getString())
            }
            else println("Player has tried to move but there is an enemy on that position. ")
        }
        else println("Player has tried to move but it is at the end of the field. ")
    }

    private fun getWantedPosition(): Position {
        return when (facingDirection) {
            NORTH -> Position(position.col, position.row - 1)
            SOUTH -> Position(position.col, position.row + 1)
            EAST -> Position(position.col + 1, position.row)
            WEST -> Position(position.col - 1, position.row)
            else -> Position(0, 0)
        }
    }

    private fun isItInTheLimit(): Boolean = when (facingDirection) {
            NORTH -> { position.row == 0 }
            SOUTH -> { position.row == battleField.height - 1 }
            EAST -> { position.col == battleField.width - 1 }
            WEST -> { position.col == 0 }
            else -> false
        }

    private fun isThePositionOccupied(wantedPosition:Position):Boolean {
        for (enemy in enemies){
            if (enemy.position.col == wantedPosition.col && enemy.position.row == wantedPosition.row)
                return true
        }
        return false
    }

    fun hurt(){
        lives --
        println("The player has been hurt! Remaining lives: " + lives)
    }
}


fun Player.turnLeft(){
    if (facingDirection == NORTH)
        facingDirection = WEST
    else
        facingDirection --

    println("Player is now facing " + orientations[facingDirection])
}

fun Player.turnRight(){
    if (facingDirection == WEST)
        facingDirection = NORTH
    else
        facingDirection ++
    println("Player is now facing " + orientations[facingDirection])
}
