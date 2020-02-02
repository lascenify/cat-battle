import main.*
import org.junit.*

internal class CharacterTest {

    @Test
    fun isVisibleFromPositionAbove() {
        val character = Character (Position(2,5), "n")
        val observerPoint = Position(2,4)
        val result = character.isVisibleFromPosition(observerPoint, SOUTH)
        Assert.assertEquals("", true, result)
    }

    @Test
    fun isVisibleFromPositionBelow() {
        val character = Character (Position(2,3), "n")
        val observerPoint = Position(2,4)
        val result = character.isVisibleFromPosition(observerPoint, NORTH)
        Assert.assertEquals("", true, result)
    }

    @Test
    fun isNotVisibleFromSameColumn() {
        val character = Character (Position(1,3), "n")
        val observerPoint = Position(1,2)
        val result = character.isVisibleFromPosition(observerPoint, NORTH)
        Assert.assertEquals("", false, result)
    }

    @Test
    fun isVisibleFromPositionRight() {
        val character = Character (Position(2,3), "n")
        val observerPoint = Position(3,3)
        val result = character.isVisibleFromPosition(observerPoint, WEST)
        Assert.assertEquals("", true, result)
    }

    @Test
    fun isVisibleFromPositionLeft() {
        val character = Character (Position(2,3), "n")
        val observerPoint = Position(1,3)
        val result = character.isVisibleFromPosition(observerPoint, EAST)
        Assert.assertEquals("", true, result)
    }

    @Test
    fun isNotVisibleFromSameRow() {
        val character = Character (Position(2,3), "n")
        val observerPoint = Position(1,3)
        val result = character.isVisibleFromPosition(observerPoint, WEST)
        Assert.assertEquals("", false, result)
    }

    @Test
    fun isVisibleFromSamePosition() {
        val character = Character (Position(2,3), "n")
        val observerPoint = Position(2,3)
        val result = character.isVisibleFromPosition(observerPoint, NORTH)
        Assert.assertEquals("", false, result)
    }
}