package symmetrical.cosmic.physics.subatomic.balanced.values.vector

class VectorInt {
    val value : Array<Any>
    constructor(value:Array<Any>) {
        this.value = value
    }
    fun asInt() : Int? {
        if (value.isEmpty())
            return null
        return value!![0] as Int
    }
    fun toInt(): Int {
        return asInt() ?: return 0
    }
}