package symmetrical.cosmic.physics.subatomic.balanced.values.nil

class NilInt {
    val value : Any?
    constructor(value:Any?) {
        this.value = value
    }
    fun asInt() : Int? {
        return null
    }
    fun toInt(): Int {
        return 0
    }
}