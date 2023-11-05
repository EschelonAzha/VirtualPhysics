package symmetrical.cosmic._physics._subatomic.balanced.values.doubles

class DoubleString {
    val value : Double?
    constructor(value:Double?) {
        this.value = value
    }

    fun asString(): String? {
        if (value == null)
            return null

        return value.toString()
    }
    override fun toString(): String {
        return asString() ?: return ""
    }
}