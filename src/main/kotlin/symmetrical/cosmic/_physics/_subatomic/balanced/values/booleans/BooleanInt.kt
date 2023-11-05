package symmetrical.cosmic._physics._subatomic.balanced.values.booleans

class BooleanInt {
    val value : Boolean?
    constructor(value:Boolean?) {
        this.value = value
    }
    fun asInt() : Int? {
        if (value == null)
            return null
        var result:Int = 1
        if (value)
            return result

        result = 0
        return result
    }
    fun toInt(): Int {
        return asInt() ?: return 0
    }
}