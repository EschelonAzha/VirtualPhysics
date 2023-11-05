package symmetrical.cosmic._physics._subatomic.balanced.values.booleans

class BooleanVector {
    val value : Boolean?
    constructor(value:Boolean?) {
        this.value = value
    }
    fun asArray() : Array<Boolean>? {
        if (value == null)
            return Array<Boolean>(0){false}

        return arrayOf(value)
    }
    fun toArray(): Array<Boolean> {
        return asArray() as Array<Boolean>
    }
}