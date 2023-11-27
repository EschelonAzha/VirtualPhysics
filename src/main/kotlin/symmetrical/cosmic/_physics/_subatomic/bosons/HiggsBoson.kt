package symmetrical.cosmic._physics._subatomic.bosons

import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

class HiggsBoson(
    private val antiMatter: IAntiMatter = AntiMatter(HiggsBoson::class),
) : Particle(),
    IAntiMatter by antiMatter,
    Emitter
{
    constructor() : this(
        AntiMatter(HiggsBoson::class),
    )


    override fun absorb(photon: Photon) : Photon {
        antiMatter.check(photon);

        return photon.propagate()
    }
    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return antiMatter.getClassId()
    }
    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
    fun i() : HiggsBoson {
        return this
    }
}