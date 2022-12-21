import domain.Direction
import domain.Rover
import kotlin.random.Random

object MissionUtils {

    fun initRover(): Rover = Rover(0, 0, Direction.N)

    fun detectObstacle(): Boolean = Random.nextBoolean()
}