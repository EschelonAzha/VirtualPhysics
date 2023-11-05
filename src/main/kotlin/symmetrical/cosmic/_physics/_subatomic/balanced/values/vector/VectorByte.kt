package symmetrical.cosmic._physics._subatomic.balanced.values.vector

import symmetrical.cosmic.__transpectors.transpectors.Bytes

class VectorByte {
    val value : Array<Any>
    constructor(value:Array<Any>) {
        this.value = value
    }
    fun asByte() : Byte? {
        if (value.isEmpty())
            return null
        return value!![0] as Byte
    }
    fun toByte(): Byte {
        return asByte() ?: return 0
    }
}