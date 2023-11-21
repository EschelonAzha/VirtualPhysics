package symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

class AntiTauNeutrino  (
    private val fermion: IFermion = Fermion(AntiTauNeutrino::class),
) : AntiLepton(),
    IFermion by fermion
{
    constructor() : this(
        Fermion(AntiTauNeutrino::class),
    ) {
        fermion.setKClass(AntiTauNeutrino::class)
    }


    override fun getClassId() : String {
        return fermion.getClassId()
    }
    override fun i() : AntiTauNeutrino {
        super.i()
        return this
    }
}