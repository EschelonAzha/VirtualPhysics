package symmetrical.cosmic._physics._subatomic.balanced.values.bytes

class ByteVector {
    val value : Byte?
    constructor(value:Byte?) {
        this.value = value
    }
    fun asArray() : Array<Byte>? {
        if (value == null)
            return Array<Byte>(0){0}

        return arrayOf(value)
    }
    fun toArray(): Array<Byte> {
        return asArray() as Array<Byte>
    }
}