package symmetrical.cosmic.physics.atomic.substance.ions

import symmetrical.cosmic.physics.subatomic.luminescent.IMatter
import symmetrical.cosmic.physics.subatomic.luminescent.Matter
/*
https://en.wikipedia.org/wiki/Ion
 */
open class Ion(
    private val matter: IMatter = Matter(Ion::class, Ion::class),
) :
    IMatter by matter
{

    constructor() : this(
        Matter(Ion::class, Ion::class),
    )
    override fun getClassId() : String {
        return matter.getClassId()
    }
}