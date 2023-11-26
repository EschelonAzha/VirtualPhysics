package symmetrical.cosmic._physics.atomic.bonds.mixtures

import symmetrical.cosmic._physics.atomic.matter.Matter
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

class Mixture(
    private val luminescent: ILuminescent = Luminescent(Mixture::class),
) : Matter(),
    ILuminescent by luminescent
{
    constructor() : this(
        Luminescent(Mixture::class),
    )
    // mixtures may be regular classes with all kinds of things
    // mixed together that are other classes but not Atoms or Molecules

    override fun getClassId() : String {
        return luminescent.getClassId()
    }
}