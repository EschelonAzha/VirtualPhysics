package symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

class AntiNeutrino (
    private val fermion: IFermion = Fermion()
) : AntiLepton(),
    IFermion by fermion
{
    constructor() : this(
        Fermion()
    )
    private fun getLocalClassId() : String {
        return Absorber.getClassId(AntiNeutrino::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    override fun i() : AntiNeutrino {
        super.i()
        return this
    }
}