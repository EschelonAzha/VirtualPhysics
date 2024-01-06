package symmetrical.cosmic.physics.subatomic.balanced.values.bytes

class ByteString {
    val value : Byte?
    constructor(value:Byte?) {
        this.value = value
    }

    fun asString(): String? {
        if (value == null)
            return null
        val byteVal = value as Byte
        return byteVal.toString()
    }
    override fun toString(): String {
        return asString() ?: return ""
    }
}