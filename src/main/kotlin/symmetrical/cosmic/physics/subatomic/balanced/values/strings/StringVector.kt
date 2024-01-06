package symmetrical.cosmic.physics.subatomic.balanced.values.strings

class StringVector {
    val value : String?
    constructor(value:String?) {
        this.value = value
    }
    fun asArray() : Array<String>? {
        if (value == null)
            return Array<String>(0){""}

        return arrayOf(value)
    }
    fun toArray(): Array<String> {
        return asArray() as Array<String>
    }
}