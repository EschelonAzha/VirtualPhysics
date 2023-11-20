package symmetrical.cosmic._physics._subatomic.forces.weak_force.neutral

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IQuantumEntanglement
import symmetrical.cosmic._physics._subatomic.fermions.QuantumEntanglement

class ChargedWeakForce(
    private val fermion: IQuantumEntanglement = QuantumEntanglement(),
) :
    IQuantumEntanglement by fermion
{
    constructor() : this(
        QuantumEntanglement()
    )

    private fun getLocalClassId() : String {
        return Absorber.getClassId(ChargedWeakForce::class)
    }
    open fun getClassId() : String {
        return getLocalClassId()
    }
    fun i() : ChargedWeakForce {
        return this
    }
}