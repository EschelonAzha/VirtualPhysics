package symmetrical.cosmic._physics.atomic.substance.metals

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.forces.magnetism.Magnetism
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic.wormholes.messaging.entanglement.IQuantumEntanglement
import symmetrical.cosmic.wormholes.messaging.entanglement.QuantumEntanglement

class Metal(
    private val entanglement:IQuantumEntanglement=QuantumEntanglement()
) :
    IQuantumEntanglement by entanglement
{

    constructor() : this(
        QuantumEntanglement()
    )
    private fun getLocalClassId() : String {
        return Absorber.getClassId(Metal::class)
    }
    open fun getClassId() : String {
        return getLocalClassId()
    }
}