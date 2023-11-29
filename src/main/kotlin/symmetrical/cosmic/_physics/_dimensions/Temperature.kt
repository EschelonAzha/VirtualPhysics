package symmetrical.cosmic._physics._dimensions

import symmetrical.cosmic.__transpectors.transpectors.Photons
import symmetrical.cosmic.__transpectors.transpectors.Strings
import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.wavelength.Wavelength
import symmetrical.cosmic._physics._subatomic.balanced.values.Field
import symmetrical.cosmic._physics._subatomic.bosons.Emitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

class Temperature (
    private val antiMatter: IAntiMatter = AntiMatter(Temperature::class),
) :
    IAntiMatter by antiMatter,
    Emitter
{
    constructor() : this(
        AntiMatter(Temperature::class),
    )
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

        const val NUMBERS_LTH = 1
        const val STRING1_LTH = 1
        const val STRING2_LTH = 2
        const val STRING3_LTH = 3
        const val VECTOR_LTH  = 3

    }

    private var field      : Field = Field()

    fun isNull() : Boolean {
        return field.isNull()
    }

    override fun absorb(photon: Photon) : Photon {
        antiMatter.check(photon);

        var (type, lthValue) = Strings.remainder(Static.NUMBERS_LTH, photon.propagate().radiate())
        if (type == Static.NULL) {
            field.setValue(null)
            return Photon(lthValue)
        }
        if (type == Static.BOOLEAN) {
            var (value, remainder) = Photons.parse(Static.NUMBERS_LTH, lthValue)
            field.setValue(value == "true")
            return Photon(remainder)
        }
        if (type == Static.BYTE) {
            var (value, remainder) = Photons.parse(Static.NUMBERS_LTH, lthValue)
            field.setValue(value)
            return Photon(remainder)
        }
        if (type == Static.INT) {
            var (value, remainder) = Photons.parse(Static.NUMBERS_LTH, lthValue)
            field.setValue(value.toInt())
            return Photon(remainder)
        }
        if (type == Static.DOUBLE) {
            var (value, remainder) = Photons.parse(Static.NUMBERS_LTH, lthValue)
            field.setValue(value.toDouble())
            return Photon(remainder)
        }
        if (type == Static.STRING1) {
            var (value, remainder) = Photons.parse(Static.STRING1_LTH, lthValue)
            field.setValue(value)
            return Photon(remainder)
        }
        if (type == Static.STRING2) {
            var (value, remainder) = Photons.parse(Static.STRING2_LTH, lthValue)
            field.setValue(value)
            return Photon(remainder)
        }
        if (type == Static.STRING3) {
            var (value, remainder) = Photons.parse(Static.STRING3_LTH, lthValue)
            field.setValue(value)
            return Photon(remainder)
        }
        if (type == Static.VECTOR) {
            var (value, remainder) = Photons.parse(Static.VECTOR_LTH, lthValue)
            field.setValue(value)
            return Photon(remainder)
        }
        println("!!!!!!!!!!!!!!!!!!!!!ERROR OCCURED IN WAVELENGTH:ABSORB!!!!!!!!!!!!!!!!!!!!!")
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
    private fun radiate() : String {
        val prefix = antiMatter.getClassId()+field.getType()
        if (field.getType() == Static.NULL)
            return prefix
        if (field.getType() == Static.BOOLEAN)
            return prefix+ Photon.toPhoton1(field.getValue())
        if (field.getType() == Static.BYTE)
            return prefix+ Photon.toPhoton1(field.getValue())
        if (field.getType() == Static.INT)
            return prefix+ Photon.toPhoton1(field.getValue())
        if (field.getType() == Static.DOUBLE)
            return prefix+ Photon.toPhoton1(field.getValue())
        if (field.getType() == Static.STRING1)
            return prefix+ Photon.toPhoton1(field.getValue())
        if (field.getType() == Static.STRING2)
            return prefix+ Photon.toPhoton2(field.getValue())
        if (field.getType() == Static.STRING3)
            return prefix+ Photon.toPhoton3(field.getValue())

        return prefix+ Photon.toPhoton3(field.getValue())
    }

    override fun getClassId() : String {
        return antiMatter.getClassId()
    }

    fun temperature() : Any? {
        return field.getValue()
    }

    fun setField(field: Field) : Temperature {
        this.field = field
        return this
    }

    fun setTemperature(value:Any?) : Any? {
        return field.setValue(value)
    }

    override fun toString() : String {
        return field.toString()
    }
    fun isChange(value:Any?) : Boolean {
        return field.isChange(value)
    }

}