package symmetrical.cosmic._physics._subatomic.balanced.values.strings

class StringString {
    val value : String?
    constructor(value:String?) {
        this.value = value
    }
    fun asString() : String? {
        return value;
    }
    override fun toString(): String {
        return asString() ?: return ""
    }
}