package symmetrical.cosmic._physics._subatomic.forces.weak_force

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.forces.magnetism.Magnetism
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic.wormholes.messaging.entanglement.IQuantumEntanglement
import symmetrical.cosmic.wormholes.messaging.entanglement.QuantumEntanglement

class ChargedWeak(
    private val entanglement:IQuantumEntanglement
) : Particle(entanglement),
    IQuantumEntanglement by entanglement
{
    // can emit a charged W Boson that can alter the charge of a Proton by
    // altering the structure of its quarks
    constructor() : this(
        QuantumEntanglement()
    )

    private fun getLocalClassId() : String {
        return Absorber.getClassId(ChargedWeak::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    fun i() : ChargedWeak {
        return this
    }
}