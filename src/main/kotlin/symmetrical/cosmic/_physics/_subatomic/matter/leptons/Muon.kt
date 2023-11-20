package symmetrical.cosmic._physics._subatomic.matter.leptons

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

class Muon(
    private val fermion: IFermion = Fermion(),
) : Lepton(),
    IFermion by fermion
{
    constructor() : this(
        Fermion()
    )

    private fun getLocalClassId() : String {
        return Absorber.getClassId(Muon::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    override fun i() : Muon {
        super.i()
        return this
    }
}