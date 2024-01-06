package symmetrical.cosmic.physics.subatomic.balanced.values.bytes

class ByteByte {
    val value : Byte?
    constructor(value:Byte?) {
        this.value = value
    }
    fun asByte() : Byte? {
        return value
    }
    fun toByte(): Byte {
        return asByte() ?: return 0
    }
}