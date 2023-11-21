package symmetrical.cosmic._physics._subatomic.matter.leptons

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

class Muon(
    private val fermion: IFermion = Fermion(Muon::class),
) : Lepton(),
    IFermion by fermion
{
    constructor() : this(
        Fermion(Muon::class),
    )

    override fun getClassId() : String {
        return fermion.getClassId()
    }
    override fun i() : Muon {
        super.i()
        return this
    }
}