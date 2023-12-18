package symmetrical.cosmic._physics._subatomic.balanced.values


interface IField {
    fun asArray()               : Array<Any>
    fun asBoolean()             : Boolean?
    fun asByte()                : Byte?
    fun asDouble()              : Double?
    fun asInt()                 : Int?
    fun asString()              : Boolean?

    fun getType()               : String
    fun getValue()              : Any?
    fun isChange(value:Any?)    : Boolean
    fun isNull()                : Boolean
    fun setField(field:Field)   : Field
    fun setValue(value:Any?)    : Any?

    fun toArray()               : Array<Any>
    fun toBoolean()             : Boolean
    fun toByte()                : Byte
    fun toDouble()              : Double
    fun toInt()                 : Int

    override fun toString()     : String
}