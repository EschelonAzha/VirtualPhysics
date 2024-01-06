package symmetrical.cosmic.physics.subatomic.balanced.values.strings

import symmetrical.cosmic.transpectors.transpectors.Bytes

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