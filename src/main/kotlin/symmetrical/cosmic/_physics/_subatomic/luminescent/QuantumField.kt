package symmetrical.cosmic._physics._subatomic.luminescent

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic.__transpectors.transpectors.Photons
import symmetrical.cosmic.__transpectors.transpectors.Strings
import symmetrical.cosmic._physics._subatomic.balanced.values.Field
import symmetrical.cosmic._physics._subatomic.bosons.IEmitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon

class QuantumField : IEmitter {


    private var field      : Field = Field()

    constructor() {

    }
    constructor(value:Any?) {
        field.setValue(value)
    }

    fun isNull() : Boolean {
        return field.isNull()
    }

    override fun absorb(photon: Photon) : Photon {

        var (type, leftover) = Strings.remainder(Field.Static.TYPE_LTH, photon.propagate().radiate())
        if (type == Field.Static.NULL) {
            field.setValue(null)
            return Photon(leftover)
        }
        if (type == Field.Static.BOOLEAN) {
            var (value, remainder) = Photons.parse(Field.Static.NUMBERS_LTH, leftover)
            field.setValue(value == "true")
            return Photon(remainder)
        }
        if (type == Field.Static.BYTE) {
            var (value, remainder) = Photons.parse(Field.Static.NUMBERS_LTH, leftover)
            field.setValue(value)
            return Photon(remainder)
        }
        if (type == Field.Static.INT) {
            var (value, remainder) = Photons.parse(Field.Static.NUMBERS_LTH, leftover)
            field.setValue(value.toInt())
            return Photon(remainder)
        }
        if (type == Field.Static.DOUBLE) {
            var (value, remainder) = Photons.parse(Field.Static.NUMBERS_LTH, leftover)
            field.setValue(value.toDouble())
            return Photon(remainder)
        }
        if (type == Field.Static.STRING1) {
            var (value, remainder) = Photons.parse(Field.Static.STRING1_LTH, leftover)
            field.setValue(value)
            return Photon(remainder)
        }
        if (type == Field.Static.STRING2) {
            var (value, remainder) = Photons.parse(Field.Static.STRING2_LTH, leftover)
            field.setValue(value)
            return Photon(remainder)
        }
        if (type == Field.Static.STRING3) {
            var (value, remainder) = Photons.parse(Field.Static.STRING3_LTH, leftover)
            field.setValue(value)
            return Photon(remainder)
        }
        if (type == Field.Static.VECTOR) {
            var (value, remainder) = Photons.parse(Field.Static.VECTOR_LTH, leftover)
            field.setValue(value)
            return Photon(remainder)
        }
        println("!!!!!!!!!!!!!!!!!!!!!ERROR OCCURED IN QuantumPhotonicField:ABSORB!!!!!!!!!!!!!!!!!!!!!")
        return Photon("")
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }

    fun getField() : Field {
        return field
    }
    fun getValue() : Any? {
        return getField().getValue()
    }
    fun radiate() : String {
        val prefix = getClassId()+field.getType()
        if (field.getType() == Field.Static.NULL)
            return prefix
        if (field.getType() == Field.Static.BOOLEAN)
            return prefix+ Photon.toPhoton1(field.getValue())
        if (field.getType() == Field.Static.BYTE)
            return prefix+ Photon.toPhoton1(field.getValue())
        if (field.getType() == Field.Static.INT)
            return prefix+ Photon.toPhoton1(field.getValue())
        if (field.getType() == Field.Static.DOUBLE)
            return prefix+ Photon.toPhoton1(field.getValue())
        if (field.getType() == Field.Static.STRING1)
            return prefix+ Photon.toPhoton1(field.getValue())
        if (field.getType() == Field.Static.STRING2)
            return prefix+ Photon.toPhoton2(field.getValue())
        if (field.getType() == Field.Static.STRING3)
            return prefix+ Photon.toPhoton3(field.getValue())

        return prefix+ Photon.toPhoton3(field.getValue())
    }

    private fun getLocalClassId() : String {
        return Absorber.getClassId(QuantumField::class)
    }

    public fun getClassId() : String {
        return getLocalClassId()
    }


    fun setField(field: Field) : QuantumField {
        this.field = field
        return this
    }

    fun setValue(value:Any?) : Any? {
        return field.setValue(value)
    }

    override fun toString() : String {
        return field.toString()
    }
    fun isChange(value:Any?) : Boolean {
        return field.isChange(value)
    }

}