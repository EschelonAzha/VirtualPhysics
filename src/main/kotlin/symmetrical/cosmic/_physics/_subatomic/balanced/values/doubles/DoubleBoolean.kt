package symmetrical.cosmic._physics._subatomic.balanced.values.doubles

class DoubleBoolean {
    val value : Double?
    constructor(value:Double?) {
        this.value = value
    }
    fun asBoolean() : Boolean? {
        if (value == null)
            return null
        return value != 0.0
    }
    fun toBoolean() : Boolean {
        return asBoolean() ?: return false
    }

}