package symmetrical.cosmic._physics._subatomic.matter.leptons

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic.wormholes.messaging.entanglement.IQuantumEntanglement
import symmetrical.cosmic.wormholes.messaging.entanglement.QuantumEntanglement

class MuonNeutrino(private val entanglement: QuantumEntanglement = QuantumEntanglement()) : Lepton(), IQuantumEntanglement by entanglement {

    constructor() : this(QuantumEntanglement()) {
    }

    private fun getLocalClassId() : String {
        return Absorber.getClassId(MuonNeutrino::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    override fun i() : MuonNeutrino {
        super.i()
        return this
    }
}