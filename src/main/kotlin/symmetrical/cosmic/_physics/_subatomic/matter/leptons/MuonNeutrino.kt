package symmetrical.cosmic._physics._subatomic.matter.leptons

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

class MuonNeutrino(
    private val fermion: IFermion = Fermion(MuonNeutrino::class),
) : Lepton(),
    IFermion by fermion
{
    constructor() : this(
        Fermion(MuonNeutrino::class),
    )

    override fun getClassId() : String {
        return fermion.getClassId()
    }
    override fun i() : MuonNeutrino {
        super.i()
        return this
    }
}