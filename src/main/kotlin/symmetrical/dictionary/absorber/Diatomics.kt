package symmetrical.dictionary.absorber
import symmetrical.physics.subatomic.balanced.IParticle
import symmetrical.physics.subatomic.spacial.ParticleBeam

object Diatomics {
    val beam : ParticleBeam = ParticleBeam()

    fun illuminate(particle: IParticle) : Unit {
        val debug = particle.getUniqueId()
        val pos = beam.findByUniqueId(particle.getUniqueId())
        if (pos == -1) {
            println("Illumination Id: $debug")
            beam.add(particle)
        }
    }

    fun dim(particle: IParticle) : Unit {
        beam.remove(particle)
    }
}