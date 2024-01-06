package symmetrical.cosmic.physics.subatomic.balanced.values.strings

class StringInt {
    val value : String?
    constructor(value:String?) {
        this.value = value
    }
    fun asInt() : Int? {
        if (value == null)
            return null
        try {
            return value.toInt()
        } catch (e:Exception) {
            return null
        }
    }
    fun toInt(): Int {
        return asInt() ?: return 0
    }
}