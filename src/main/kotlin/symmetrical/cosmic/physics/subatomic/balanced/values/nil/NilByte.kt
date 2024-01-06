package symmetrical.cosmic.physics.subatomic.balanced.values.nil

class NilByte {
    val value : Any?
    constructor(value:Any?) {
        this.value = value
    }
    fun asByte() : Byte? {
        return null
    }
    fun toByte(): Byte {
        return 0
    }
}