import domain.Direction
import domain.Planet
import domain.Rover

class Navigator(private val planet: Planet) {

    var rover = Rover(1, 1, Direction.N)


    fun navigate(commands: Array<Char>) {

        commands.forEach {
            when (it) {
                'f' -> rover.moveForward(planet.maxX, planet.maxY)
                'b' -> rover.moveBackward(planet.maxX, planet.maxY)
                'l' -> rover.turnLeft()
                'r' -> rover.turnRight()
                else -> {
                    throw IllegalArgumentException("Bad instruction")
                }
            }
        }
    }
}

fun main() {

    val commands = arrayOf('l', 'f', 'f', 'r', 'b')

    val navigator = Navigator(Planet(4, 4))
    val rover = Rover(2, 2, Direction.E)
    navigator.rover = rover

    try {
        navigator.navigate(commands)
        println("Done without obstacles ! $rover")
    } catch (e: IllegalStateException) {
        println(e.message)
    }
}
