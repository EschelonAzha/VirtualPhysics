package symmetrical.cosmic._physics._subatomic.matter.quarks

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

class Top(
    private val fermion: IFermion = Fermion(Top::class),
) : Quark(),
    IFermion by fermion
{
    constructor() : this(
        Fermion(Top::class),
    )

    override fun absorb(photon: Photon) : Photon {
        return super.absorb(photon.propagate())
    }
    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return fermion.getClassId()+super.emit().radiate()
    }
    override fun getClassId() : String {
        return fermion.getClassId()
    }
    override fun i() : Top {
        super.i()
        return this
    }
}