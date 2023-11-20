package symmetrical.cosmic._physics._subatomic.matter.leptons

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

class MuonNeutrino(
    private val fermion: IFermion = Fermion(),
) : Lepton(),
    IFermion by fermion
{
    constructor() : this(
        Fermion()
    )

    private fun getLocalClassId() : String {
        return Absorber.getClassId(MuonNeutrino::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    override fun i() : MuonNeutrino {
        super.i()
        return this
    }
}