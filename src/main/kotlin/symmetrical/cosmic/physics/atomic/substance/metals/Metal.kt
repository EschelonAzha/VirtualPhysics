package symmetrical.cosmic.physics.atomic.substance.metals

import symmetrical.cosmic.physics.subatomic.luminescent.IMatter
import symmetrical.cosmic.physics.subatomic.luminescent.Matter
/*
https://en.wikipedia.org/wiki/Metal
 */
class Metal(
    private val matter: IMatter = Matter(Metal::class, Metal::class),
) :
    IMatter by matter
{

    constructor() : this(
        Matter(Metal::class, Metal::class),
    )
    override fun getClassId() : String {
        return matter.getClassId()
    }
}