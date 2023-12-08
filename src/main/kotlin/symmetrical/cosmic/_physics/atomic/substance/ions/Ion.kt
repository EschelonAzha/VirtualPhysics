package symmetrical.cosmic._physics.atomic.substance.ions

import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter

open class Ion(
    private val matter: IMatter = Matter(Ion::class, Ion::class, true),
) :
    IMatter by matter
{

    constructor() : this(
        Matter(Ion::class, Ion::class, true),
    )
    override fun getClassId() : String {
        return matter.getClassId()
    }
}