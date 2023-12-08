package symmetrical.cosmic._physics.atomic.substance.metals

import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter

class Metal(
    private val matter: IMatter = Matter(Metal::class, Metal::class, true),
) :
    IMatter by matter
{

    constructor() : this(
        Matter(Metal::class, Metal::class, true),
    )
    override fun getClassId() : String {
        return matter.getClassId()
    }
}