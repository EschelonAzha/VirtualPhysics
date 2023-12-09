package symmetrical.cosmic._physics.atomic.bonds.mixtures

import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter

class Mixture(
    private val matter: IMatter = Matter(Mixture::class, Mixture::class),
) :
    IMatter by matter
{
    constructor() : this(
        Matter(Mixture::class, Mixture::class),
    )
    // mixtures may be regular classes with all kinds of things
    // mixed together that are other classes but not Atoms or Molecules

    override fun getClassId() : String {
        return matter.getClassId()
    }
}