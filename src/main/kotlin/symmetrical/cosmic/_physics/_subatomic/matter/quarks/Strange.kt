package symmetrical.cosmic._physics._subatomic.matter.quarks

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

class Strange(
    private val fermion: IFermion = Fermion()
) : Quark(),
    IFermion by fermion
{
    constructor() : this(
        Fermion()
    )

    override fun absorb(photon: Photon) : Photon {
        return super.absorb(photon.propagate())
    }
    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return getLocalClassId()+super.emit().radiate()
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(Strange::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    override fun i() : Strange {
        super.i()
        return this
    }
}