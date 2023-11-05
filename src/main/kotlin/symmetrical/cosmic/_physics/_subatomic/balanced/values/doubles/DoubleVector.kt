package symmetrical.cosmic._physics._subatomic.balanced.values.doubles

class DoubleVector {
    val value : Double?
    constructor(value:Double?) {
        this.value = value
    }
    fun asArray() : Array<Double>? {
        if (value == null)
            return Array<Double>(0){0.0}

        return arrayOf(value)
    }
    fun toArray(): Array<Double> {
        return asArray() as Array<Double>
    }

}