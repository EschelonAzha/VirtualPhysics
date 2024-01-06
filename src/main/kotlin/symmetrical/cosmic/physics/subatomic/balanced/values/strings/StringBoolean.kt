package symmetrical.cosmic.physics.subatomic.balanced.values.strings

class StringBoolean {
    val value : String?
    constructor(value:String?) {
        this.value = value
    }
    fun asBoolean() : Boolean {
        return value != null
    }
    fun toBoolean(): Boolean {
        return asBoolean() ?: return false
    }
}