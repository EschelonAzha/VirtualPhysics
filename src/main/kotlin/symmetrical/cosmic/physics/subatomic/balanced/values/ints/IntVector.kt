package symmetrical.cosmic.physics.subatomic.balanced.values.ints

class IntVector {
    val value : Int?
    constructor(value:Int?) {
        this.value = value
    }
    fun asArray() : Array<Int>? {
        if (value == null)
            return Array<Int>(0){0}

        return arrayOf(value)
    }
    fun toArray(): Array<Int> {
        return asArray() as Array<Int>
    }
}