package symmetrical.cosmic.physics.subatomic.balanced.values.strings


class StringDouble {
    val value : String?
    constructor(value:String?) {
        this.value = value
    }
    fun asDouble() : Double? {
        if (value == null)
            return null
        try {
            return value.toDouble()
        } catch (e:Exception) {
            return null
        }
    }
    fun toDouble(): Double {
        return asDouble() ?: return 0.0
    }
}