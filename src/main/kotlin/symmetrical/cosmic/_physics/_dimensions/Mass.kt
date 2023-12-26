package symmetrical.cosmic._physics._dimensions

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.values.Field
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.IQuantumField
import symmetrical.cosmic._physics._subatomic.luminescent.QuantumField

class Mass (private val field:QuantumField=QuantumField()) : IQuantumField by field {

    object Static {
            const val PHOTON        : Byte = 0
            const val NEUTRINO      : Byte = 1
            const val ELECTRON      : Byte = 2
            const val MUON          : Byte = 3
            const val TAU           : Byte = 4
            const val UP_QUARK      : Byte = 5
            const val DOWN_QUARK    : Byte = 6
            const val STRANGE_QUARK : Byte = 7
            const val CHARM_QUARK   : Byte = 8
            const val BOTTOM_QUARK  : Byte = 9
            const val TOP_QUARK     : Byte = 10
            const val PROTON        : Byte = 11
            const val NEUTRON       : Byte = 12
    }

    constructor() : this(
        QuantumField()
    ) {
        setMass(Static.PHOTON)
    }
    fun i() : Mass {
        return this
    }
    override fun absorb(photon: Photon) : Photon {
        var remainder : Photon  = photon.propagate()
        remainder = field.absorb(remainder)
        return remainder
    }
    override fun emit() : Photon {
        return Photon(radiate())
    }

    fun getClassId() : String {
        return getLocalClassId()
    }
    fun getField() : Field {
        return field.getField()
    }

    fun mass() : Any? {
        return field.getValue()
    }

    fun setMass(value:Any?) : Any? {
        return setValue(value)
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(Mass::class)
    }
    private fun radiate() : String {
        return getLocalClassId()+field.emit().radiate()
    }
}