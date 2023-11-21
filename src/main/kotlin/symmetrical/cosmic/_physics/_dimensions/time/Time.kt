package symmetrical.cosmic._physics._dimensions.time

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

class Time (
    private val fermion: IFermion = Fermion(Time::class),
) :
    IFermion by fermion
{
    constructor() : this(
        Fermion(Time::class),
    )

    override fun getClassId() : String {
        return fermion.getClassId()
    }
    fun i() : symmetrical.cosmic._physics._dimensions.time.Time {
        return this
    }
}