package symmetrical.cosmic._physics._subatomic.matter.leptons

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.values.Field
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic.wormholes.messaging.entanglement.IQuantumEntanglement
import symmetrical.cosmic.wormholes.messaging.entanglement.QuantumEntanglement


class Tau(
    private val entanglement:IQuantumEntanglement=QuantumEntanglement(),
) : Lepton(entanglement),
    IQuantumEntanglement by entanglement
{
    constructor() : this(
        QuantumEntanglement()
    )
    constructor(newValue : Field) : this() {
        fundamentals.getWavelength().setField(newValue)
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(Tau::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    override fun i() : Tau {
        super.i()
        return this
    }
}