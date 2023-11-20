package symmetrical.cosmic._physics.atomic.blackhole

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

class EventHorizon (
    private val fermion: IFermion = Fermion()
) :
    IFermion by fermion
{
    constructor() : this(
        Fermion()
    )

    private fun getLocalClassId() : String {
        return Absorber.getClassId(EventHorizon::class)
    }
    open fun getClassId() : String {
        return getLocalClassId()
    }
    // Event horizon is the API to external libraries and frameworks
}