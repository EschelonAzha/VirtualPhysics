package symmetrical.cosmic.physics.subatomic.balanced.values.nil

class NilVector {
    val value : Any?
    constructor(value:Any?) {
        this.value = value
    }
    fun asArray() : Array<Any> {
        return emptyArray()
    }
    fun toArray(): Array<Any> {

        return asArray()
    }
}