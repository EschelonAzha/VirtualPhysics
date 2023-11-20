package symmetrical.cosmic._physics._dimensions.charge

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

class Charge (
    private val fermion: IFermion = Fermion(),
) :
    IFermion by fermion
{
    constructor() : this(
        Fermion()
    )

    private fun getLocalClassId() : String {
        return Absorber.getClassId(Charge::class)
    }
    open fun getClassId() : String {
        return getLocalClassId()
    }
    fun i() : Charge {
        return this
    }
}