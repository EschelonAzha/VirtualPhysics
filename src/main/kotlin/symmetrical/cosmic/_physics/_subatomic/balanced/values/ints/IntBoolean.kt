package symmetrical.cosmic._physics._subatomic.balanced.values.ints

class IntBoolean {
    val value : Int?
    constructor(value:Int?) {
        this.value = value
    }
    fun asBoolean() : Boolean? {
        if (value == null)
            return null
        val byteVal = value as Int
        return value != 0
    }
    fun toBoolean() : Boolean {
        return asBoolean() ?: return false
    }
}