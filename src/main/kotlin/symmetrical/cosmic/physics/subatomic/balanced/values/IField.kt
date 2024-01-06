package symmetrical.cosmic.physics.subatomic.balanced.values


interface IField {
    fun asArray()               : Array<Any>
    fun asBoolean()             : Boolean?
    fun asByte()                : Byte?
    fun asDouble()              : Double?
    fun asInt()                 : Int?
    fun asString()              : String?
    fun getContent()            : Any?
    fun getType()               : String

    fun isChange(value:Any?)    : Boolean
    fun isNull()                : Boolean
    fun setContent(content:Any?): Any?
    fun setField(field:Field)   : Field

    fun toArray()               : Array<Any>
    fun toBoolean()             : Boolean
    fun toByte()                : Byte
    fun toDouble()              : Double
    fun toInt()                 : Int

    override fun toString()     : String
}