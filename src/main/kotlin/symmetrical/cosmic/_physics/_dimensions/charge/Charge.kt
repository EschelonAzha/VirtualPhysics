package symmetrical.cosmic._physics._dimensions.charge

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

class Charge (
    private val fermion: IFermion = Fermion(Charge::class),
) :
    IFermion by fermion
{
    constructor() : this(
        Fermion(Charge::class),
    )

    override fun getClassId() : String {
        return fermion.getClassId()
    }
    fun i() : Charge {
        return this
    }
}