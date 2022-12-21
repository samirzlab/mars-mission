package domain

data class Planet(
    val maxX: Int,
    val maxY: Int
) {
    override fun toString(): String {
        return "Planet maxX: $maxX, maxY: $maxY)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Planet

        if (maxX != other.maxX) return false
        if (maxY != other.maxY) return false

        return true
    }

    override fun hashCode(): Int {
        var result = maxX
        result = 31 * result + maxY
        return result
    }


}