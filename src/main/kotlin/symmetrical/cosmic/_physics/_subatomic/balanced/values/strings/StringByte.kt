package symmetrical.cosmic._physics._subatomic.balanced.values.strings

import symmetrical.cosmic.__transpectors.transpectors.Bytes

class StringByte {
    val value : String?
    constructor(value:String?) {
        this.value = value
    }
    fun asByte() : Byte? {
        return Bytes.toByte(value)
    }
    fun toByte(): Byte {
        return asByte() ?: return 0
    }
}