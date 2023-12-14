package symmetrical.cosmic._physics._subatomic.balanced.fundamentals.wavelength

import symmetrical.cosmic._physics._subatomic.balanced.values.Field
import symmetrical.cosmic._physics._subatomic.bosons.Emitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.*

class Wavelength(
    private val matterAntiMatter: IMatterAntiMatter = MatterAntiMatter(Wavelength::class, Wavelength::class),
) :
    IMatterAntiMatter by matterAntiMatter,
    Emitter
{
    constructor() : this(
        MatterAntiMatter(Wavelength::class, Wavelength::class),
    )


    private var field      : QuantumField = QuantumField()

    fun isNull() : Boolean {
        return field.isNull()
    }

    override fun absorb(photon: Photon) : Photon {
        return field.absorb(photon)
    }

    override fun emit() : Photon {
        return field.emit()
    }

    fun getField() : Field {
        return field.getField()
    }
    fun getValue() : Any? {
        return field.getField().getValue()
    }
    private fun radiate() : String {
        return field.radiate()
    }

    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }

    fun wavelength() : Any? {
        return field.getValue()
    }

    fun setField(field:Field) : Wavelength {
        this.field.setField(field)
        return this
    }

    fun setWavelength(value:Any?) : Any? {
        return field.setValue(value)
    }

    override fun toString() : String {
        return field.toString()
    }
    fun isChange(value:Any?) : Boolean {
        return field.isChange(value)
    }

}