package symmetrical.cosmic.physics.subatomic.balanced.values.nil

class NilDouble {
    val value : Any?
    constructor(value:Any?) {
        this.value = value
    }
    fun asDouble() : Double? {
        return null
    }
    fun toDouble(): Double {
        return 0.0
    }
}