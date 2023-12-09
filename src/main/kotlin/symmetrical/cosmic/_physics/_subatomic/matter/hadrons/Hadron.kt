package symmetrical.cosmic._physics._subatomic.matter.hadrons

import symmetrical.cosmic._physics._subatomic.anti_matter.anti_hadrons.AntiHadron
import symmetrical.cosmic._physics._subatomic.bosons.Emitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.spacial.ParticleBeam
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter


open class Hadron(
    private val matter: IMatter = Matter(Hadron::class, AntiHadron::class),
) : ParticleBeam(),
    IMatter by matter,
    Emitter
{
    constructor() : this(
        Matter(Hadron::class, AntiHadron::class),
    )


    object Static {
        const val LAST : Int = ParticleBeam.Static.LAST

    }



    override fun absorb(photon: Photon) : Photon {
        matter.check(photon);

        clear()
        val remainder = super.absorb(photon.propagate())
        shrink()
        return remainder
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        val classId = matter.getClassId()
        return classId+super.emit().radiate()
    }
    override fun getClassId() : String {
        return matter.getClassId()
    }
    fun i(size:Int) : Hadron {
        return this
    }
}