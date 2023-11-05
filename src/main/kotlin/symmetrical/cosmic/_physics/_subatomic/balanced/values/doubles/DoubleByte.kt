package symmetrical.cosmic._physics._subatomic.balanced.values.doubles

class DoubleByte {
    val value : Double?
    constructor(value:Double?) {
        this.value = value
    }
    fun asByte() : Byte? {
        if (value == null)
            return null
        return value.toInt().toByte()
    }
    fun toByte(): Byte {
        return asByte() ?: return 0
    }
}