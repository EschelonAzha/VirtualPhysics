package symmetrical.cosmic._physics._subatomic.balanced.values.nil

class NilBoolean {
    val value : Any?
    constructor(value:Any?) {
        this.value = value
    }
    fun asBoolean() : Boolean? {
        return null
    }
    fun toBoolean() : Boolean {
        return false
    }
}