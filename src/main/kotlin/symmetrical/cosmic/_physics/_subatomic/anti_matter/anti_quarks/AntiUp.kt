package symmetrical.cosmic._physics._subatomic.anti_matter.anti_quarks

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

class AntiUp(
    private val fermion: IFermion = Fermion(AntiUp::class),
) : AntiQuark(),
    IFermion by fermion
{
    constructor() : this(
        Fermion(AntiUp::class),
    )


    override fun getClassId() : String {
        return fermion.getClassId()
    }
}