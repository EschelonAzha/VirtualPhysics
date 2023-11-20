package symmetrical.cosmic._physics.atomic.blackhole

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

class Blackhole(
    private val fermion: IFermion = Fermion()
) :
    IFermion by fermion
{

    constructor() : this(
        Fermion()
    )
    private fun getLocalClassId() : String {
        return Absorber.getClassId(Blackhole::class)
    }
    open fun getClassId() : String {
        return getLocalClassId()
    }
    // black holes encompass all external libraries and frameworks
}