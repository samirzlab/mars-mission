import domain.Direction
import domain.Planet
import domain.Rover
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class TestNavigator {

    @Test
    fun testWrappingEdgeFallDecX() {
        val navigator = Navigator(Planet(4, 4))
        val rover = Rover(3, 1, Direction.N)
        navigator.rover = rover

        try {
            navigator.navigate(arrayOf('r', 'b', 'b', 'b'))
            assertEquals(4, navigator.rover.positionX)
        } catch (e: IllegalStateException) {
            assertNotEquals(4, navigator.rover.positionX)
            println(e.message)
        }
    }

    @Test()
    fun testWrappingEdgeFallIncY() {
        val navigator = Navigator(Planet(4, 4))
        val rover = Rover(2, 2, Direction.E)
        navigator.rover = rover

        try {
            navigator.navigate(arrayOf('l', 'f', 'f', 'f'))
            assertEquals(1, navigator.rover.positionY)
        } catch (e: IllegalStateException) {
            assertNotEquals(4, navigator.rover.positionY)
            println(e.message)
        }


    }
}