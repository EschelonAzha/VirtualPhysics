package symmetrical.cosmic.physics.subatomic.balanced.values.booleans

class BooleanDouble {
    val value : Boolean?
    constructor(value:Boolean?) {
        this.value = value
    }
    fun asDouble() : Double? {
        if (value == null)
            return null
        var result:Double = 1.0
        if (value)
            return result

        result = 0.0
        return result
    }
    fun toDouble(): Double {
        return asDouble() ?: return 0.0
    }
}