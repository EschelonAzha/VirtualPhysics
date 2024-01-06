package symmetrical.cosmic.physics.subatomic.balanced.values.vector

class VectorDouble {
    val value : Array<Any>
    constructor(value:Array<Any>) {
        this.value = value
    }
    fun asDouble() : Double? {
        if (value.isEmpty())
            return null
        return value!![0] as Double
    }
    fun toDouble(): Double {
        return asDouble() ?: return 0.0
    }
}