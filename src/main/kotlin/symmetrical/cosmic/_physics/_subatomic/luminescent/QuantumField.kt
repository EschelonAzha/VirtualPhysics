package symmetrical.cosmic._physics._subatomic.luminescent

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic.__transpectors.transpectors.Photons
import symmetrical.cosmic.__transpectors.transpectors.Strings
import symmetrical.cosmic._physics._subatomic.balanced.values.Field
import symmetrical.cosmic._physics._subatomic.balanced.values.IField
import symmetrical.cosmic._physics._subatomic.bosons.IEmitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon

class QuantumField(
    private val field:Field=Field()
) : IField by field,
    IQuantumField
{
    constructor() : this(
        Field()
    )
    constructor(value:Any?) : this(
        Field()
    ){
        field.setContent(value)
    }

    override fun absorb(photon: Photon) : Photon {

        var (type, leftover) = Strings.remainder(Field.Static.TYPE_LTH, photon.propagate().radiate())
        if (type == Field.Static.NULL) {
            field.setContent(null)
            return Photon(leftover)
        }
        if (type == Field.Static.BOOLEAN) {
            var (content, remainder) = Photons.parse(Field.Static.NUMBERS_LTH, leftover)
            field.setContent(content == "true")
            return Photon(remainder)
        }
        if (type == Field.Static.BYTE) {
            var (content, remainder) = Photons.parse(Field.Static.NUMBERS_LTH, leftover)
            field.setContent(content)
            return Photon(remainder)
        }
        if (type == Field.Static.INT) {
            var (content, remainder) = Photons.parse(Field.Static.NUMBERS_LTH, leftover)
            field.setContent(content.toInt())
            return Photon(remainder)
        }
        if (type == Field.Static.DOUBLE) {
            var (content, remainder) = Photons.parse(Field.Static.NUMBERS_LTH, leftover)
            field.setContent(content.toDouble())
            return Photon(remainder)
        }
        if (type == Field.Static.STRING1) {
            var (content, remainder) = Photons.parse(Field.Static.STRING1_LTH, leftover)
            field.setContent(content)
            return Photon(remainder)
        }
        if (type == Field.Static.STRING2) {
            var (content, remainder) = Photons.parse(Field.Static.STRING2_LTH, leftover)
            field.setContent(content)
            return Photon(remainder)
        }
        if (type == Field.Static.STRING3) {
            var (content, remainder) = Photons.parse(Field.Static.STRING3_LTH, leftover)
            field.setContent(content)
            return Photon(remainder)
        }
        if (type == Field.Static.VECTOR) {
            var (content, remainder) = Photons.parse(Field.Static.VECTOR_LTH, leftover)
            field.setContent(content)
            return Photon(remainder)
        }
        println("!!!!!!!!!!!!!!!!!!!!!ERROR OCCURED IN QuantumPhotonicField:ABSORB!!!!!!!!!!!!!!!!!!!!!")
        return Photon("")
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }

    public fun getClassId() : String {
        return getLocalClassId()
    }

    fun getField() : Field {
        return field
    }

    fun radiate() : String {
        val prefix = getLocalClassId()+field.getType()
        if (field.getType() == Field.Static.NULL)
            return prefix
        if (field.getType() == Field.Static.BOOLEAN)
            return prefix+ Photon.toPhoton1(field.getContent())
        if (field.getType() == Field.Static.BYTE)
            return prefix+ Photon.toPhoton1(field.getContent())
        if (field.getType() == Field.Static.INT)
            return prefix+ Photon.toPhoton1(field.getContent())
        if (field.getType() == Field.Static.DOUBLE)
            return prefix+ Photon.toPhoton1(field.getContent())
        if (field.getType() == Field.Static.STRING1)
            return prefix+ Photon.toPhoton1(field.getContent())
        if (field.getType() == Field.Static.STRING2)
            return prefix+ Photon.toPhoton2(field.getContent())
        if (field.getType() == Field.Static.STRING3)
            return prefix+ Photon.toPhoton3(field.getContent())

        return prefix+ Photon.toPhoton3(field.getContent())
    }

    override fun toString() : String {
        return field.toString()
    }

    private fun getLocalClassId() : String {
        return Absorber.getClassId(QuantumField::class)
    }
}