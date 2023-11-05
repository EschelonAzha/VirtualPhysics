package symmetrical.cosmic._physics._subatomic.balanced.values.booleans

class BooleanString {
    val value : Boolean?
    constructor(value:Boolean?) {
        this.value = value
    }
    fun asString() : String? {
        if (value == null)
            return null
        var result:String = "true"
        if (value)
            return result

        result = "false"
        return result
    }
    override fun toString(): String {

        return asString() ?: return ""
    }
}