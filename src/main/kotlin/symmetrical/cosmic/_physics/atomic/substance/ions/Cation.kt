package symmetrical.cosmic._physics.atomic.substance.ions

import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

class Cation(
    private val fermion: ILuminescent = Luminescent(Cation::class),
) : Ion(),
    ILuminescent by fermion
{
    constructor() : this(
        Luminescent(Cation::class),
    )
    override fun getClassId() : String {
        return fermion.getClassId()
    }
    // plus
}