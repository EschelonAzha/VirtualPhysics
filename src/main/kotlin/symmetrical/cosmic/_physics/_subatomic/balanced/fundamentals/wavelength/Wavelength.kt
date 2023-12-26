package symmetrical.cosmic._physics._subatomic.balanced.fundamentals.wavelength

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._dimensions.Mass
import symmetrical.cosmic._physics._subatomic.balanced.values.Field
import symmetrical.cosmic._physics._subatomic.bosons.IEmitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.*

class Wavelength(private val field:QuantumField=QuantumField()) : IQuantumField by field {

    constructor() : this(
        QuantumField()
    )

    fun i() : Wavelength {
        return this
    }

    override fun absorb(photon: Photon) : Photon {
        var remainder = photon.propagate()
        remainder = field.absorb(remainder)
        return remainder
    }
    override fun emit() : Photon {
        return Photon(radiate())
    }
    public fun getClassId() : String {
        return getLocalClassId()
    }
    fun getField() : Field {
        return field.getField()
    }

    fun getQuantumField() : QuantumField {
        return field
    }

    private fun radiate() : String {
        return getLocalClassId()+field.emit().radiate()
    }

    private fun getLocalClassId() : String {
        return Absorber.getClassId(Wavelength::class)
    }
    fun setWavelength(value:Any?) : Any? {
        return setValue(value)
    }
    fun wavelength() : Any? {
        return field.getValue()
    }


}