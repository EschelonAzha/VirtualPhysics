package symmetrical.cosmic._physics._subatomic.balanced.values.vector

class VectorBoolean {
    val value : Array<Any>
    constructor(value:Array<Any>) {
        this.value = value
    }
    fun asBoolean() : Boolean? {
        if (value.isEmpty())
            return null
        return value!![0] as Boolean
    }
    fun toBoolean(): Boolean {
        return asBoolean() ?: return false
    }
}