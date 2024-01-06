package symmetrical.cosmic.physics.subatomic.balanced.values.ints

class IntDouble {
    val value : Int?
    constructor(value:Int?) {
        this.value = value
    }
    fun asDouble() : Double? {
        if (value == null)
            return null
        return value.toDouble()
    }
    fun toDouble(): Double {
        return asDouble() ?: return 0.0
    }
}