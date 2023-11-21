package symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

class AntiNeutrino (
    private val fermion: IFermion = Fermion(AntiNeutrino::class),
) : AntiLepton(),
    IFermion by fermion
{
    constructor() : this(
        Fermion(AntiNeutrino::class),
    )
    override fun getClassId() : String {
        return fermion.getClassId()
    }
    override fun i() : AntiNeutrino {
        super.i()
        return this
    }
}