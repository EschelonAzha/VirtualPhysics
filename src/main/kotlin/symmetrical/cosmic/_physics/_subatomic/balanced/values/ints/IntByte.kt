package symmetrical.cosmic._physics._subatomic.balanced.values.ints

class IntByte {
    val value : Int?
    constructor(value:Int?) {
        this.value = value
    }
    fun asByte() : Byte? {
        if (value == null)
            return null
        return value.toByte()
    }
    fun toByte(): Byte {
        return asByte() ?: return 0
    }
}