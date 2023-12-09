package symmetrical.cosmic._physics.atomic.substance.ions

import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter

class Anion(
    private val matter: IMatter = Matter(Anion::class, Anion::class),
) : Ion(),
    IMatter by matter
{
    constructor() : this(
        Matter(Anion::class, Anion::class),
    )
    override fun getClassId() : String {
        return matter.getClassId()
    }
    // Negative charge
}