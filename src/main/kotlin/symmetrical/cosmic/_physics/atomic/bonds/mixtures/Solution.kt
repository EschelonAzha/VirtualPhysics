package symmetrical.cosmic._physics.atomic.bonds.mixtures

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.forces.magnetism.Magnetism
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic._physics.atomic.matter.Matter
import symmetrical.cosmic.wormholes.messaging.entanglement.IQuantumEntanglement
import symmetrical.cosmic.wormholes.messaging.entanglement.QuantumEntanglement

class Solution(private val entanglement:QuantumEntanglement= QuantumEntanglement()) : Matter(), IQuantumEntanglement by entanglement {


    private fun getLocalClassId() : String {
        return Absorber.getClassId(Solution::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
}