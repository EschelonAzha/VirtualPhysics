package symmetrical.cosmic._physics._subatomic.balanced.fundamentals.angularMomentum

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.values.Field
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.IQuantumField
import symmetrical.cosmic._physics._subatomic.luminescent.QuantumField

open class AngularMomentum(private val field: QuantumField = QuantumField()) : IQuantumField by field {

    constructor() : this(
        QuantumField()
    )

    override fun absorb(photon: Photon) : Photon {
        var remainder = photon.propagate()
        remainder = field.absorb(remainder)
        return remainder
    }
    override fun emit() : Photon {
        return Photon(radiate())
    }

    private fun radiate() : String {
        return getLocalClassId()+
                field.emit().radiate()
    }

    private fun getLocalClassId() : String {
        return Absorber.getClassId(AngularMomentum::class)
    }

    public open fun getClassId() : String {
        return getLocalClassId()
    }
    fun getField() : Field {
        return field.getField()
    }

    fun momentum() : Any? {
        return field.getContent()
    }

    fun setAngularMomentum(content:Any?) : Any? {
        return setContent(content)
    }

    open fun format(wavelength: QuantumField) : String {
        return wavelength.toString()
    }

    fun i() : AngularMomentum {
        return this
    }
}