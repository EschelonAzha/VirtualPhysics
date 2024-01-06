package symmetrical.cosmic.physics.subatomic.balanced.values.vector

class VectorString {
    val value : Array<Any>
    constructor(value:Array<Any>) {
        this.value = value
    }
    fun asString() : String? {
        if (value.isEmpty())
            return null
        return value!![0] as String
    }
    override fun toString(): String {
        return asString() ?: return ""
    }
}