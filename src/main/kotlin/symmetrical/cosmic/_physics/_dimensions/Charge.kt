package symmetrical.cosmic._physics._dimensions

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.values.Field
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.IQuantumField
import symmetrical.cosmic._physics._subatomic.luminescent.QuantumField

class Charge (private val field:QuantumField=QuantumField()) : IQuantumField by field {

    object Static {
        const val PLUS:Byte  = +1
        const val ZERO:Byte  = 0
        const val MINUS:Byte = -1
    }
    constructor() : this(
        QuantumField()
    ) {
        setCharge(Static.ZERO)
    }
    fun i() : Charge {
        return this
    }

    override fun absorb(photon: Photon) : Photon {
        var remainder : Photon  = photon.propagate()
        remainder = field.absorb(remainder)
        return remainder
    }
    fun charge() : Any? {
        return field.getValue()
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
    fun setCharge(value:Any?) : Any? {
        return setValue(value)
    }

    private fun getLocalClassId() : String {
        return Absorber.getClassId(Charge::class)
    }
    private fun radiate() : String {
        return getLocalClassId()+field.emit().radiate()
    }
}