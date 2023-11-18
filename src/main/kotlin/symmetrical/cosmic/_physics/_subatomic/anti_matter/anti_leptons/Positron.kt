package symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.matter.leptons.Lepton
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic.wormholes.messaging.entanglement.IQuantumEntanglement
import symmetrical.cosmic.wormholes.messaging.entanglement.QuantumEntanglement

class Positron (
    private val entanglement:IQuantumEntanglement=QuantumEntanglement(),
) : AntiLepton(entanglement),
    IQuantumEntanglement by entanglement
{
    constructor() : this(
        QuantumEntanglement()
    )
    private fun getLocalClassId() : String {
        return Absorber.getClassId(Positron::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    override fun i() : Positron {
        super.i()
        return this
    }

}