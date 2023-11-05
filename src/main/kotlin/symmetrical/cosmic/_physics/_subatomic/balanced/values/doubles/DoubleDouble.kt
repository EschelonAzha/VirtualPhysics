package symmetrical.cosmic._physics._subatomic.balanced.values.doubles

class DoubleDouble {
    val value : Double?
    constructor(value:Double?) {
        this.value = value
    }
    fun asDouble() : Double? {
        return value
    }
    fun toDouble(): Double {
        return asDouble() ?: return 0.0
    }
}