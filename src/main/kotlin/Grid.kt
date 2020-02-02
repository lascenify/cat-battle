package main

class Grid (width:Int, height:Int) {
    val width:Int
    val height:Int
    init {
        this.width = width
        this.height = height
    }
}


data class Position (var col: Int, var row: Int)

fun Position.getString() :String = "("+col+","+row+")"