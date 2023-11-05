package symmetrical.cosmic._physics._subatomic.balanced.values.booleans

class BooleanByte {
    val value : Boolean?
    constructor(value:Boolean?) {
        this.value = value
    }
    fun asByte() : Byte? {
        if (value == null)
            return null
        var result:Byte = 1
        if (value)
            return result

        result = 0
        return result
    }
    fun toByte(): Byte {
        return asByte() ?: return 0
    }
}