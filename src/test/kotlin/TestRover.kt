import domain.Direction
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class TestRover {

    @Test
    fun testRoverUp() {
        var rover = MissionUtils.initRover()
        try {
            rover.moveForward(4, 4)
            assertEquals(1, rover.positionY)
        } catch (e: IllegalStateException) {
            assertNotEquals(1, rover.positionY)
            println(e.message)
        }
    }

    @Test
    fun testRoverDown() {
        var rover = MissionUtils.initRover()
        try {
            rover.moveBackward(4, 4)
            assertEquals(4, rover.positionY)
        } catch (e: IllegalStateException) {
            assertNotEquals(4, rover.positionY)
            println(e.message)
        }

    }

    @Test
    fun testRoverRight() {
        var rover = MissionUtils.initRover()
        rover.turnRight()
        assertEquals(Direction.E, rover.direction)
    }

    @Test
    fun testRoverLeft() {
        var rover = MissionUtils.initRover()
        rover.turnLeft()
        assertEquals(Direction.W, rover.direction)
    }


}