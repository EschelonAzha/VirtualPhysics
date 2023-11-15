package symmetrical.cosmic._physics._subatomic.matter.leptons

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic.wormholes.messaging.entanglement.IQuantumEntanglement
import symmetrical.cosmic.wormholes.messaging.entanglement.QuantumEntanglement

class TauNeutrino(private val entanglement: QuantumEntanglement = QuantumEntanglement()) : Lepton(), IQuantumEntanglement by entanglement {

    constructor() : this(QuantumEntanglement()) {
    }

    private fun getLocalClassId() : String {
        return Absorber.getClassId(TauNeutrino::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    override fun i() : TauNeutrino {
        super.i()
        return this
    }
}