package symmetrical.cosmic.physics.subatomic.balanced.values.ints

class IntString {
    val value : Int?
    constructor(value:Int?) {
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