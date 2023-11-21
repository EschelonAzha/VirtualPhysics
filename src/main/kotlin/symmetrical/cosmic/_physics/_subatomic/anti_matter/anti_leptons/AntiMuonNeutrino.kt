package symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

class AntiMuonNeutrino(
    private val fermion: IFermion = Fermion(AntiMuonNeutrino::class),
) : AntiLepton(),
    IFermion by fermion
{
    constructor() : this(
        Fermion(AntiMuonNeutrino::class),
    )

    override fun getClassId() : String {
        return fermion.getClassId()
    }
    override fun i() : AntiMuonNeutrino {
        super.i()
        return this
    }
}