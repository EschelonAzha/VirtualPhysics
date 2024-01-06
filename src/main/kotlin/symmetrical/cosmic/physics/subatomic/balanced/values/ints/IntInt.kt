package symmetrical.cosmic.physics.subatomic.balanced.values.ints

class IntInt {
    val value : Int?
    constructor(value:Int?) {
        this.value = value
    }

    fun asInt(): Int? {
        return value
    }
    fun toInt(): Int {
        return asInt() ?: return 0
    }
}