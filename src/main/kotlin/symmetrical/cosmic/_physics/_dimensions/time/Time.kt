package symmetrical.cosmic._physics._dimensions.time

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

class Time (
    private val fermion: IFermion = Fermion(),
) :
    IFermion by fermion
{
    constructor() : this(
        Fermion()
    )

    private fun getLocalClassId() : String {
        return Absorber.getClassId(symmetrical.cosmic._physics._dimensions.time.Time::class)
    }
    open fun getClassId() : String {
        return getLocalClassId()
    }
    fun i() : symmetrical.cosmic._physics._dimensions.time.Time {
        return this
    }
}