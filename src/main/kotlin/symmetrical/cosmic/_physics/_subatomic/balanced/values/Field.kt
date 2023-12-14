package symmetrical.cosmic._physics._subatomic.balanced.values

import symmetrical.cosmic.__transpectors.transpectors.Doubles
class Field : IField {
    object Static {
        const val NULL      = "0"
        const val BOOLEAN   = "B"
        const val BYTE      = "1"
        const val INT       = "I"
        const val DOUBLE    = "D"
        const val STRING1   = "s"
        const val STRING2   = "S"
        const val STRING3   = "!"
        const val VECTOR    = "V"

        const val TYPE_LTH    = 1
        const val NUMBERS_LTH = 1
        const val STRING1_LTH = 1
        const val STRING2_LTH = 2
        const val STRING3_LTH = 3
        const val VECTOR_LTH  = 3

    }
    private var type:String = "0"
    private var value:Any?  = null
    constructor() {
    }
    constructor(value:Any?) {
        setValue(value)
    }
    override fun asArray() : Array<Any> {
        return Converter(this).asArray()
    }
    override fun asBoolean() : Boolean? {
        return Converter(this).asBoolean()
    }
    override fun asByte() : Byte? {
        return Converter(this).asByte()
    }
    override fun asDouble() : Double? {
        return Converter(this).asDouble()
    }
    override fun asInt() : Int? {
        return Converter(this).asInt()
    }
    override fun asString() : Boolean? {
        return Converter(this).asBoolean()
    }
    override fun getType() : String {
        return type
    }
    override fun getValue() : Any? {
        return value
    }
    override fun isChange(value:Any?)    : Boolean {
        return this.value != value
    }
    override fun isNull() : Boolean {
        return value == null
    }
    override fun setValue(value:Any?) : Any? {
        val previous = this.value
        this.value = value

        type = getTypeStr(value)
        return previous
    }
    override fun toArray() : Array<Any> {
        return Converter(this).toArray()
    }
    override fun toBoolean() : Boolean {
        return Converter(this).toBoolean()
    }

    override fun toByte() : Byte {
        return Converter(this).toByte()
    }

    override fun toDouble() : Double {
        return Converter(this).toDouble()
    }

    override fun toInt() : Int {
        return Converter(this).toInt()
    }

    override fun toString() : String {
        return Converter(this).toString()
    }


    private fun getTypeStr(value:Any?) : String {
        if (value == null)
            return Static.NULL

        if (value is String) {
            if (value.length <52)
                return Static.STRING1
            if (value.length < 2704)
                return Static.STRING2
            return Static.STRING3
        }

        if (Doubles.isDouble(value))  // This is needed for JS Bug
            return Static.DOUBLE

        if (value is Int)
            return Static.INT

        if (value is Double)
            return Static.DOUBLE

        if (value is Boolean)
            return Static.BOOLEAN

        if (value is Byte)
            return Static.BYTE

        return Static.VECTOR
    }
}