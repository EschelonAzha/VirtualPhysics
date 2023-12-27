package symmetrical.cosmic._physics._subatomic.matter.hadrons

import symmetrical.cosmic._physics._subatomic.anti_matter.anti_hadrons.AntiHadron
import symmetrical.cosmic._physics._subatomic.bosons.IEmitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.spacial.ParticleBeam
import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter


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

        clear()
        var remainder = photon.propagate()
        remainder = super.absorb(remainder)

        shrink()
        return remainder
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }

    override fun getClassId() : String {
        return matter.getClassId()
    }

    private fun radiate() : String {
        return matter.getClassId()+
                super.emit().radiate()
    }
}