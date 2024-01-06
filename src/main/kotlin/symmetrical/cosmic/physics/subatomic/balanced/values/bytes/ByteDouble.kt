package symmetrical.cosmic.physics.subatomic.balanced.values.bytes

class ByteDouble {
    val value : Byte?
    constructor(value:Byte?) {
        this.value = value
    }

    fun asDouble(): Double? {
        if (value == null)
            return null
        val byteVal = value as Byte
        return byteVal.toInt().toDouble()
    }
    fun toDouble(): Double {
        return asDouble() ?: return 0.0
    }
}