package symmetrical.cosmic._physics._subatomic.anti_matter.anti_quarks

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

class AntiDown(
    private val fermion: IFermion = Fermion(),
) : AntiQuark(fermion),
    IFermion by fermion
{
    constructor() : this(
        Fermion()
    )

    private fun getLocalClassId() : String {
        return Absorber.getClassId(AntiDown::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
}