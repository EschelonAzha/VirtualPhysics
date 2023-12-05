package symmetrical.cosmic._physics._subatomic.balanced.fundamentals.wavelength

import symmetrical.cosmic.__transpectors.transpectors.Photons
import symmetrical.cosmic.__transpectors.transpectors.Strings
import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.balanced.values.Field
import symmetrical.cosmic._physics._subatomic.bosons.Emitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.QuantumPhotonicField

class Wavelength(
    private val antiMatter: IAntiMatter = AntiMatter(Wavelength::class, Wavelength::class),
) : Particle(),
    IAntiMatter by antiMatter,
    Emitter
{
    constructor() : this(
        AntiMatter(Wavelength::class, Wavelength::class),
    )


    private var field      : QuantumPhotonicField = QuantumPhotonicField()

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
        return antiMatter.getClassId()
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