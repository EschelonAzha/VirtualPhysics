package symmetrical.cosmic._physics._subatomic.anti_matter.anti_quarks

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.matter.quarks.Quark
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic.wormholes.messaging.entanglement.IQuantumEntanglement
import symmetrical.cosmic.wormholes.messaging.entanglement.QuantumEntanglement


class AntiBottom(private val entanglement: QuantumEntanglement = QuantumEntanglement()) : AntiQuark(), IQuantumEntanglement by entanglement {

    private fun getLocalClassId() : String {
        return Absorber.getClassId(AntiBottom::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
}