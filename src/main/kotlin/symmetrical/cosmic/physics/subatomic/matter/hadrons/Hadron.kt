package symmetrical.cosmic.physics.subatomic.matter.hadrons

import symmetrical.cosmic.physics.subatomic.bosons.IEmitter
import symmetrical.cosmic.physics.subatomic.bosons.Photon
import symmetrical.cosmic.physics.subatomic.spacial.ParticleBeam
import symmetrical.cosmic.physics.subatomic.anti_matter.anti_hadrons.AntiHadron
import symmetrical.cosmic.physics.subatomic.balanced.Particle
import symmetrical.cosmic.physics.subatomic.luminescent.IMatter
import symmetrical.cosmic.physics.subatomic.luminescent.Matter

/*
https://en.wikipedia.org/wiki/Hadron
 */
open class Hadron(
    private val matter: IMatter = Matter(Hadron::class, AntiHadron::class),
) : ParticleBeam(),
    IMatter by matter,
    IEmitter
{
    constructor() : this(
        Matter(Hadron::class, AntiHadron::class),
    )


    object Static {
        const val LAST : Int = ParticleBeam.Static.LAST

    }
    fun i(size:Int) : Hadron {
        return this
    }

    override fun absorb(photon: Photon) : Photon {
        matter.check(photon);

        var remainder = photon.propagate()
        remainder = super.absorb(remainder)

        return remainder
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }

    override fun getClassId() : String {
        return matter.getClassId()
    }

    private fun radiate() : String {
        if (Particle.Static.debuggingOn) {
            println("Hadron")
        }
        val classId      : String = matter.getClassId()
        val particleBeam : String = super.emit().radiate()
        return classId+particleBeam
    }
}