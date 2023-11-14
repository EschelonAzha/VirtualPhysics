package symmetrical.cosmic.wormholes.messaging.entanglement

import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam

class QuantumEntanglement : IQuantumEntanglement {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }
    public override fun getIlluminations() : ParticleBeam {
        return Illuminations.beam
    }
}