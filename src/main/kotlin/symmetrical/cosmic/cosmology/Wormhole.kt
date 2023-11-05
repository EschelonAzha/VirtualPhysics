package symmetrical.cosmic.cosmology

import symmetrical.cosmic._physics._subatomic.balanced.IParticle
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam

class Wormhole {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }
    val nebula:INebula
    val beam  :ParticleBeam = ParticleBeam()
    constructor(nebula:INebula) {
        this.nebula = nebula
    }
    public fun getIlluminations() : ParticleBeam {
        return Illuminations.beam
    }

    fun add(particle: IParticle) : IParticle {
        return beam.add(particle)
    }
    fun remove(particle: IParticle) : IParticle {
        return beam.remove(particle) as IParticle
    }
}