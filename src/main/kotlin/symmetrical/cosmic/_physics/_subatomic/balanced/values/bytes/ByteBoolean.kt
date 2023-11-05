package symmetrical.cosmic._physics._subatomic.balanced.values.bytes

class ByteBoolean {
    val value : Byte?
    constructor(value:Byte?) {
        this.value = value
    }
    fun asBoolean() : Boolean? {
        if (value == null)
            return null
        val byteVal = value as Byte
        return byteVal.toInt() != 0
    }
    fun toBoolean() : Boolean {
        return asBoolean() ?: return false
    }
}