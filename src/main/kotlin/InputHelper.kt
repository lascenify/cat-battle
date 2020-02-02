package main

import java.util.*

fun getEnemiesInputs() {
    println(
        """
        Now you can start introducing enemies. 
        Please introduce the parameters separated with an space
        
    """.trimIndent()
    )
    val scanner = Scanner(System.`in`)
    do {

        println(
            """
            Enter a new enemy.
            The pattern is "column row orientation frequencyOfShooting"
        """.trimIndent()
        )

        var input = readLine()!!.split(' ')
        val position = Position(input[0].toInt(), input[1].toInt())

        val enemy = Enemy(position, input[2], input[3].toLong())
        enemies.add(enemy)
        println("""Continue? (yes/no)""")
        var continueInput = scanner.nextLine()

    } while (!continueInput.equals("no"))
}
fun getPlayerInputs() {


    println(
        """
        What is the starting position of your player? 
        Example: 5 5
        
    """.trimIndent()
    )
    val (positionX, positionY) = readLine()!!.split(' ').map(String::toInt)
    val initialPosition = Position(positionX, positionY)

    println(
        """
        What is its initial orientation? (n/w/e/s)
        
    """.trimIndent()
    )
    val orientation = readLine()!!

    println(
        """
        How many lives does your player have?
        Example: 2
        
    """.trimIndent()
    )
    val lives = readLine()!!.trim().toInt()
    player = Player(initialPosition, orientation, lives)
}
fun getFieldInputs(){
    println(
        """
            
        Welcome to the cat battle!!! 
        To start, introduce the size of the battle field.
        Example: 10 10
        
    """.trimIndent()
    )
    val (columns, rows) = readLine()!!.split(' ').map(String::toInt)

    battleField = Grid(columns, rows)
}
fun getCommandInputs(){
    val arrayOfCommands:MutableList<String> = mutableListOf()
    val scanner = Scanner(System.`in`)

    println(
        """
       *****************START OF THE GAME***************
       You now have to introduce commands that you want your cat to do:
       right: turn into the right without changing its position
       shoot: shoot to kill an enemy (if exists)
       left: turn into the left without changing its position
       advance: go ahead in the facing direction
       
    """.trimIndent())
    do {
        println("""
                Enter a new command (right/shoot/left/advance).
        """.trimIndent()
        )
        arrayOfCommands.add(readLine()!!.trim())
        println("""
                |Continue? (yes/no)
                |
            """.trimMargin())
        var continueInput = scanner.nextLine()
    } while (!continueInput.equals("no"))

}
