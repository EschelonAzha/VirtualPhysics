package symmetrical.cosmic._physics.atomic.blackhole

import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

class Blackhole(
    private val fermion: ILuminescent = Luminescent(Blackhole::class),
) :
    ILuminescent by fermion
{

    constructor() : this(
        Luminescent(Blackhole::class),
    )
    override fun getClassId() : String {
        return fermion.getClassId()
    }
    // black holes encompass all external libraries and frameworks
}