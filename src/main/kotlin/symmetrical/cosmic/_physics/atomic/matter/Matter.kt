package symmetrical.cosmic._physics.atomic.matter

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

open class Matter(
    private val fermion: IFermion = Fermion()
) :
    IFermion by fermion
{

    constructor() : this(
        Fermion()
    )
    private fun getLocalClassId() : String {
        return Absorber.getClassId(Matter::class)
    }
    open fun getClassId() : String {
        return getLocalClassId()
    }
}