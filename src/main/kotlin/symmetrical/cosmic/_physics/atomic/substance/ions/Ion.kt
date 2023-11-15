package symmetrical.cosmic._physics.atomic.substance.ions

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.forces.magnetism.Magnetism
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic.wormholes.messaging.entanglement.IQuantumEntanglement
import symmetrical.cosmic.wormholes.messaging.entanglement.QuantumEntanglement

open class Ion(private val entanglement:QuantumEntanglement= QuantumEntanglement()) : IQuantumEntanglement by entanglement {


    private fun getLocalClassId() : String {
        return Absorber.getClassId(Ion::class)
    }
    open fun getClassId() : String {
        return getLocalClassId()
    }
}