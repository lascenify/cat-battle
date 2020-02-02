package main

import java.util.*
import java.util.concurrent.TimeUnit

const val RIGHT ="right"
const val LEFT = "left"
const val SHOOT = "shoot"
const val ADVANCE = "advance"

class Game(player:Player, enemies:MutableList<Enemy>, battleField:Grid){
    var result: String=""
    var player:Player
    var enemies:MutableList<Enemy>
    var battleField:Grid

    var startTime:Long = 0
    var actualTime:Long = 0
    var elapsedTimeInSeconds: Long  = 0
    init {
        this.player = player
        this.enemies = enemies
        this.battleField = battleField
    }

    fun start(commands:List<String> = listOf()){
        if (commands.isEmpty()) {
            getCommandInputs()
        }
        gameLoop(commands)
    }

    private fun gameLoop(commands:List<String>){
        startTime = System.currentTimeMillis()
        for (input in commands){
            Thread.sleep(1000)
            analiseInput(input)
            actualTime = System.currentTimeMillis()
            elapsedTimeInSeconds = TimeUnit.MILLISECONDS.toSeconds(actualTime-startTime)
            checkIfEnemiesShoot(elapsedTimeInSeconds)
            if (player.lives <= 0) {
                result = "DEAD at " + player.position.getString()
                return
            }
        }
        result = "ALIVE at " + player.position.getString()
    }

    private fun analiseInput(input:String){
        when (input){
            RIGHT-> player.turnRight()
            LEFT -> player.turnLeft()
            SHOOT -> player.shoot()
            ADVANCE -> player.move()
        }
    }

    private fun checkIfEnemiesShoot(timeElapsed:Long){
        enemies.forEach { enemy -> if (timeElapsed % enemy.frequency == 0L){ enemy.shoot()} }
    }

}



