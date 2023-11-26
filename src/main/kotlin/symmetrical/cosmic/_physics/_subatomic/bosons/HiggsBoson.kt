package symmetrical.cosmic._physics._subatomic.bosons

import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

class HiggsBoson(
    private val luminescent: ILuminescent = Luminescent(HiggsBoson::class),
) : Particle(),
    ILuminescent by luminescent,
    Emitter
{
    constructor() : this(
        Luminescent(HiggsBoson::class),
    )


    override fun absorb(photon: Photon) : Photon {
        luminescent.check(photon);

        return photon.propagate()
    }
    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return luminescent.getClassId()
    }
    override fun getClassId() : String {
        return luminescent.getClassId()
    }
    fun i() : HiggsBoson {
        return this
    }
}