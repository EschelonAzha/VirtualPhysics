package symmetrical.cosmic._physics.atomic.substance.ions

import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

class Anion(
    val fermion: ILuminescent = Luminescent(Anion::class),
) : Ion(),
    ILuminescent by fermion
{
    constructor() : this(
        Luminescent(Anion::class),
    )
    override fun getClassId() : String {
        return fermion.getClassId()
    }
    // Negative charge
}