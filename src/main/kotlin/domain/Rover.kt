package domain

import MissionUtils

class Rover(
    var positionX: Int,
    var positionY: Int,
    var direction: Direction
) {

    fun moveForward(maxX: Int, maxY: Int) {

        if (direction in Direction.N..Direction.S) {
            try {
                positionY = calculateNextMove(positionY, direction, Direction.N, Direction.S, maxY)
            } catch (e: IllegalStateException) {
                throw IllegalStateException("Obstacle spotted $positionX / ${e.message} \n${toString()}")
            }
        } else {
            try {
                positionX = calculateNextMove(positionX, direction, Direction.E, Direction.W, maxX)
            } catch (e: IllegalStateException) {
                throw IllegalStateException("Obstacle spotted ${e.message} / $positionY \n${toString()}")
            }
        }

        /*TODO : If a custom message is not needed :
        if (direction in Direction.N..Direction.S)
            positionY = calculateNextMove(positionY, direction, Direction.N, Direction.S, maxY)
        else
            positionX = calculateNextMove(positionX, direction, Direction.E, Direction.W, maxX)*/
    }

    fun moveBackward(maxX: Int, maxY: Int) {

        if (direction in Direction.N..Direction.S) {
            try {
                positionY = calculateNextMove(positionY, direction, Direction.S, Direction.N, maxY)
            } catch (e: IllegalStateException) {
                throw IllegalStateException("Obstacle spotted $positionX / ${e.message} \n${toString()}")
            }
        } else {
            try {
                positionX = calculateNextMove(positionX, direction, Direction.W, Direction.E, maxX)
            } catch (e: IllegalStateException) {
                throw IllegalStateException("Obstacle spotted ${e.message} / $positionY \n${toString()}")
            }
        }
    }

    private fun calculateNextMove(
        positionAxe: Int,
        actualDirection: Direction,
        directionInc: Direction,
        directionDec: Direction,
        maxValueAxe: Int
    ): Int {

        val nextMove = when (actualDirection) {
            directionInc -> increment(positionAxe, maxValueAxe)
            directionDec -> decrement(positionAxe, maxValueAxe)
            else -> throw IllegalStateException()
        }

        return if (MissionUtils.detectObstacle()) throw IllegalStateException("$nextMove") else nextMove
    }


    private fun increment(value: Int, maxValue: Int): Int {
        return if (value.inc() > maxValue)
            1
        else
            value.inc()
    }

    private fun decrement(value: Int, maxValue: Int): Int {
        return if (value.dec() < 1)
            maxValue
        else
            value.dec()
    }

    fun turnLeft() {
        direction = when (direction) {
            Direction.N -> Direction.W
            Direction.S -> Direction.E
            Direction.E -> Direction.N
            Direction.W -> Direction.S
        }
    }

    fun turnRight() {
        direction = when (direction) {
            Direction.N -> Direction.E
            Direction.S -> Direction.W
            Direction.E -> Direction.S
            Direction.W -> Direction.N
        }
    }

    override fun toString(): String {
        return "My position is : $positionX / $positionY and my direction : ${direction.label}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Rover

        if (positionX != other.positionX) return false
        if (positionY != other.positionY) return false
        if (direction != other.direction) return false

        return true
    }

    override fun hashCode(): Int {
        var result = positionX
        result = 31 * result + positionY
        result = 31 * result + direction.hashCode()
        return result
    }


}
