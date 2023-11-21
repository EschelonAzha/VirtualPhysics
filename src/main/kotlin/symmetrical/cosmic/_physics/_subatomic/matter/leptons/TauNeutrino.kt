package symmetrical.cosmic._physics._subatomic.matter.leptons

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

class TauNeutrino(
    private val fermion: IFermion = Fermion(TauNeutrino::class),
) : Lepton(),
    IFermion by fermion
{
    constructor() : this(
        Fermion(TauNeutrino::class),
    )

    override fun getClassId() : String {
        return fermion.getClassId()
    }
    override fun i() : TauNeutrino {
        super.i()
        return this
    }
}