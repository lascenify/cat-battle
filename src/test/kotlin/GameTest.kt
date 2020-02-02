import main.*
import org.junit.*

internal class GameTest {

    @Test
    fun test() {
        player = Player(Position(5,5),"n", 2)
        enemies = mutableListOf(Enemy(Position(5,4),"n",2L),
            Enemy(Position(5,6), "n", 2L),
            Enemy(Position(3,3), "e", 4L))
        battleField = Grid(10,10)
        val game = Game (player, enemies, battleField)
        game.start(listOf("shoot","advance", "left","right"))
        Assert.assertEquals("Bad final result", "DEAD at (5,4)", game.result)
    }

    @Test
    fun test2() {
        player = Player(Position(5,5),"n", 3)
        enemies = mutableListOf(Enemy(Position(4,1),"s",2L),
            Enemy(Position(8,2), "w", 5L),
            Enemy(Position(9,5), "w", 2L),
            Enemy(Position(2,6), "e", 3L))
        battleField = Grid(10,10)
        val game = Game (player, enemies, battleField)
        game.start(listOf("right", "shoot", "left", "advance", "advance", "advance", "left", "advance", "left", "advance", "advance", "right", "right", "shoot", "left", "left", "advance", "advance"))

        Assert.assertEquals("Bad final result", "DEAD at (4,4)", game.result)
    }

    @Test
    fun test3() {
        player = Player(Position(5,5),"n", 3)
        enemies = mutableListOf(Enemy(Position(5,4),"s",2L),
            Enemy(Position(5,3), "s", 5L))
        battleField = Grid(10,10)
        val game = Game (player, enemies, battleField)
        game.start(listOf("right","right","right", "right","right","right", "right", "right" ,"right"))

        Assert.assertEquals("Bad final result", "DEAD at (5,5)", game.result)
    }

    @Test
    fun test4(){
        player = Player(Position(0,0),"e", 3)
        enemies = mutableListOf(Enemy(Position(0,1),"n",2L),
            Enemy(Position(1,0), "w", 5L),
            Enemy(Position(0,5), "n", 4L))
        battleField = Grid(10,10)
        val game = Game (player, enemies, battleField)
        game.start(listOf("shoot","right","shoot", "advance","right","advance", "left", "advance" ,"right"))

        Assert.assertEquals("Bad final result", "DEAD at (0,2)", game.result)
    }

    @Test
    fun test5(){
        player = Player(Position(0,0),"e", 3)
        enemies = mutableListOf(Enemy(Position(0,1),"n",1L))
        battleField = Grid(10,10)
        val game = Game (player, enemies, battleField)
        game.start(listOf("shoot","right","left", "advance","right","advance", "left", "advance" ,"right"))

        Assert.assertEquals("Bad final result", "DEAD at (0,0)", game.result)
    }

}