package main


lateinit var player:Player
var enemies:MutableList<Enemy> = mutableListOf()
lateinit var battleField:Grid
lateinit var game:Game

fun main() {
    getInputs()
    startGame()
    println(game.result)
}

fun getInputs(){
    getFieldInputs()
    getPlayerInputs()
    getEnemiesInputs()
}

fun startGame() {
    game = Game (player, enemies, battleField)
    game.start()
}
