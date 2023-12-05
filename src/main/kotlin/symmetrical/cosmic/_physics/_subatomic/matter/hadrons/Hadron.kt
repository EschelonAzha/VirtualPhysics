package symmetrical.cosmic._physics._subatomic.matter.hadrons

import symmetrical.cosmic._physics._subatomic.anti_matter.anti_hadrons.AntiHadron
import symmetrical.cosmic._physics._subatomic.bosons.Emitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.spacial.ParticleBeam
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter


open class Hadron(
    private val antiMatter: IAntiMatter = AntiMatter(Hadron::class, AntiHadron::class),
) : ParticleBeam(),
    IAntiMatter by antiMatter,
    Emitter
{
    constructor() : this(
        AntiMatter(Hadron::class, AntiHadron::class),
    )


    object Static {
        const val LAST : Int = ParticleBeam.Static.LAST

    }



    override fun absorb(photon: Photon) : Photon {
        antiMatter.check(photon);

        clear()
        val remainder = super.absorb(photon.propagate())
        shrink()
        return remainder
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        val classId = antiMatter.getClassId()
        return classId+super.emit().radiate()
    }
    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
    fun i(size:Int) : Hadron {
        return this
    }
}