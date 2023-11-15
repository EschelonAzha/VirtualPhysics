package symmetrical.cosmic._physics.atomic.substance.ions

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.forces.magnetism.Magnetism
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic.wormholes.messaging.entanglement.IQuantumEntanglement
import symmetrical.cosmic.wormholes.messaging.entanglement.QuantumEntanglement

class Anion(private val entanglement: QuantumEntanglement = QuantumEntanglement()) : Ion(), IQuantumEntanglement by entanglement {


    private fun getLocalClassId() : String {
        return Absorber.getClassId(Anion::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    // Negative charge
}