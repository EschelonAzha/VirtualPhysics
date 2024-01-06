package symmetrical.cosmic.physics.subatomic.balanced.values.bytes

class ByteInt {
    val value : Byte?
    constructor(value:Byte?) {
        this.value = value
    }

    fun asInt(): Int? {
        if (value == null)
            return null
        val byteVal = value as Byte
        return byteVal.toInt()
    }
    fun toInt(): Int {
        return asInt() ?: return 0
    }
}