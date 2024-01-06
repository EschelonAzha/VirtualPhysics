package symmetrical.cosmic.physics.subatomic.balanced.values.doubles

class DoubleInt {
    val value : Double?
    constructor(value:Double?) {
        this.value = value
    }

    fun asInt(): Int? {
        if (value == null)
            return null

        return value.toInt()
    }
    fun toInt(): Int {
        return asInt() ?: return 0
    }
}