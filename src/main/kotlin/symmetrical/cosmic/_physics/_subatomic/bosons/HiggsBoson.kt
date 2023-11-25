package symmetrical.cosmic._physics._subatomic.bosons

import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

class HiggsBoson(
    private val fermion: IFermion = Fermion(HiggsBoson::class),
) : Particle(),
    IFermion by fermion,
    Emitter
{
    constructor() : this(
        Fermion(HiggsBoson::class),
    )


    override fun absorb(photon: Photon) : Photon {
        fermion.check(photon);

        return photon.propagate()
    }
    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return fermion.getClassId()
    }
    override fun getClassId() : String {
        return fermion.getClassId()
    }
    fun i() : HiggsBoson {
        return this
    }
}