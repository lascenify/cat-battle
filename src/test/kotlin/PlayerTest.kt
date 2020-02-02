import main.*
import org.junit.Test
import org.junit.*

internal class PlayerTest {

    @Test
    fun correctShoot() {
        player = Player(Position(3,3),"e", 3)
        enemies = mutableListOf(Enemy(Position(4,3), "e",5))
        player.shoot()
        Assert.assertEquals("", true, enemies.isEmpty())
    }

    @Test
    fun incorrectShoot() {
        player = Player(Position(3,3),"w", 3)
        enemies = mutableListOf(Enemy(Position(4,3), "e",5))
        player.shoot()
        Assert.assertEquals("", false, enemies.isEmpty())
    }

    @Test
    fun move() {
        battleField = Grid(10, 10)
        player =  Player(Position(3,3),"w", 3)
        player.move()
        Assert.assertEquals("", true, player.position.col == 2)
    }

    @Test
    fun cantMoveLimit() {
        battleField = Grid(10, 10)
        player =  Player(Position(0,0),"w", 3)
        player.move()
        Assert.assertEquals("", false, player.position.col == -1)
    }

    @Test
    fun cantMoveEnemy() {
        enemies.add(Enemy(Position(2,3),"e", 3))
        battleField = Grid(10, 10)
        player =  Player(Position(3,3),"w", 3)
        player.move()
        Assert.assertEquals("", false, player.position.col == 2)
    }

    @Test
    fun hurt() {
        player =  Player(Position(0,0),"w", 3)
        player.hurt()
        Assert.assertEquals("", true, player.lives == 2)
    }
}