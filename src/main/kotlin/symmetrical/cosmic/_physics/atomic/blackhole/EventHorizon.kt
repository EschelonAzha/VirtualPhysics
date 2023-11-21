package symmetrical.cosmic._physics.atomic.blackhole

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

class EventHorizon (
    private val fermion: IFermion = Fermion(EventHorizon::class),
) :
    IFermion by fermion
{
    constructor() : this(
        Fermion(EventHorizon::class),
    )

    override fun getClassId() : String {
        return fermion.getClassId()
    }
    // Event horizon is the API to external libraries and frameworks
}