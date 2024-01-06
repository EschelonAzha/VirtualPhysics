package symmetrical.cosmic.physics.subatomic.balanced.values.vector

class VectorVector {
    val value : Array<Any>
    constructor(value:Array<Any>) {
        this.value = value
    }
    fun asArray() : Array<Any> {
       return value
    }
    fun toArray(): Array<Any> {
        return asArray()
    }
}