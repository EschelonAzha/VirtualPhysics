package symmetrical.cosmic._physics.atomic.bonds.mixtures

import symmetrical.cosmic._physics.atomic.matter.Matter
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

class Mixture(
    private val antiMatter: IAntiMatter = AntiMatter(Mixture::class, Mixture::class),
) : Matter(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(Mixture::class, Mixture::class),
    )
    // mixtures may be regular classes with all kinds of things
    // mixed together that are other classes but not Atoms or Molecules

    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
}