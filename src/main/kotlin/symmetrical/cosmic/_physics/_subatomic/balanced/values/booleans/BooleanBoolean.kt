package symmetrical.cosmic._physics._subatomic.balanced.values.booleans

class BooleanBoolean {
    val value : Boolean?
    constructor(value:Boolean?) {
        this.value = value
    }
    fun asBoolean() : Boolean? {
        return value;
    }
    fun toBoolean() : Boolean {
        val result = asBoolean() ?: return false
        return value as Boolean
    }
}