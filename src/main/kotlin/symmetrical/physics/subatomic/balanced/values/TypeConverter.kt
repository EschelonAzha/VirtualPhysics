package symmetrical.physics.subatomic.balanced.values

import symmetrical.physics.atomic.atoms.Atom

class TypeConverter : ITypeConverter {
    private lateinit var field:Field
    override fun setAtom(atom: Atom) : TypeConverter {
        this.field = atom.getField()
        return this
    }
    override fun asBoolean() : Boolean? {
        return field.asBoolean()
    }
    override fun asByte() : Byte? {
        return field.asByte()
    }
    override fun asDouble() : Double? {
        return field.asDouble()
    }
    override fun asInt() : Int? {
        return field.asInt()
    }
    override fun asString() : String? {
        return field.asString()
    }
    override fun toBoolean() : Boolean {
        return field.toBoolean()
    }
    override fun toByte() : Byte {
        return field.toByte()
    }
    override fun toDouble() : Double {
        return field.toDouble()
    }
    override fun toInt() : Int {
        return field.toInt()
    }
    override fun toString() : String {
        return field.toString()
    }
}