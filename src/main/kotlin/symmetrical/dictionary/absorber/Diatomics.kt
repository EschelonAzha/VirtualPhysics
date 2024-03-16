package symmetrical.dictionary.absorber
import symmetrical.physics.subatomic.balanced.IParticle
import symmetrical.physics.subatomic.spacial.ParticleBeam

object Diatomics {
    val beam : ParticleBeam = ParticleBeam()

    fun illuminate(particle: IParticle) : Unit {
        val pos = beam.findByUniqueId(particle.getUniqueId())
        if (pos == -1) {
            beam.add(particle)
        }
    }
}