package symmetrical.cosmic._physics._subatomic.forces.weak_force.neutral

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.forces.magnetism.Magnetism
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic.wormholes.messaging.entanglement.IQuantumEntanglement
import symmetrical.cosmic.wormholes.messaging.entanglement.QuantumEntanglement

class ChargedWeakForce(
    private val entanglement:IQuantumEntanglement
) :
    IQuantumEntanglement by entanglement
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