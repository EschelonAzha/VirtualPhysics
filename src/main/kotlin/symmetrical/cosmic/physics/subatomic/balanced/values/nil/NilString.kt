package symmetrical.cosmic.physics.subatomic.balanced.values.nil

class NilString {
    val value : Any?
    constructor(value:Any?) {
        this.value = value
    }
    fun asString() : String? {
        return null
    }
    override fun toString(): String {
        return ""
    }
}