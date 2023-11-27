package symmetrical.cosmic.cosmology

import symmetrical.cosmic._physics._subatomic.balanced.IParticle
import symmetrical.cosmic._physics._subatomic.spacial.ParticleBeam

class Wormhole {

    val nebula:INebula
    val beam  : ParticleBeam = ParticleBeam()
    constructor(nebula:INebula) {
        this.nebula = nebula
    }


    fun add(particle: IParticle) : IParticle {
        return beam.add(particle)
    }
    fun remove(particle: IParticle) : IParticle {
        return beam.remove(particle) as IParticle
    }
}