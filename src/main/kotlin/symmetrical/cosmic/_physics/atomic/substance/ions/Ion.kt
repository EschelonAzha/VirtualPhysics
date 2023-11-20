package symmetrical.cosmic._physics.atomic.substance.ions

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

open class Ion(
    private val fermion: IFermion = Fermion()
) :
    IFermion by fermion
{

    constructor() : this(
        Fermion()
    )
    private fun getLocalClassId() : String {
        return Absorber.getClassId(Ion::class)
    }
    open fun getClassId() : String {
        return getLocalClassId()
    }
}