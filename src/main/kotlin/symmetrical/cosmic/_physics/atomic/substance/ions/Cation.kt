package symmetrical.cosmic._physics.atomic.substance.ions

import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter

class Cation(
    private val matter: IMatter = Matter(Cation::class, Cation::class),
) : Ion(),
    IMatter by matter
{
    constructor() : this(
        Matter(Cation::class, Cation::class),
    )
    override fun getClassId() : String {
        return matter.getClassId()
    }
    // plus
}