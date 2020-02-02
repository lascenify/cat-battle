package main

class Enemy (position:Position, facingDirection: String, frequency:Long) :Character(position, facingDirection){
    var frequency:Long
    init{ this.frequency = frequency }
}

fun Enemy.shoot(){
    if (player.isVisibleFromPosition(position, facingDirection)){
        println("enemy on " + position.getString() + " has shoot")
        player.hurt()
    }
}




