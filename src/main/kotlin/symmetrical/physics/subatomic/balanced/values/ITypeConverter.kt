package symmetrical.physics.subatomic.balanced.values

import symmetrical.physics.atomic.atoms.Atom

interface ITypeConverter {
    fun setAtom(atom: Atom) : ITypeConverter
    fun asBoolean() : Boolean?
    fun asByte() : Byte?
    fun asDouble() : Double?
    fun asInt() : Int?
    fun asString() : String?
    fun toBoolean() : Boolean
    fun toByte() : Byte
    fun toDouble() : Double
    fun toInt() : Int
    override fun toString() : String
}