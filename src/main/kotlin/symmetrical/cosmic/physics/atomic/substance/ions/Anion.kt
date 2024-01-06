package symmetrical.cosmic.physics.atomic.substance.ions

import symmetrical.cosmic.physics.subatomic.luminescent.IMatter
import symmetrical.cosmic.physics.subatomic.luminescent.Matter
/*
https://en.wikipedia.org/wiki/Ion#Anions_and_cations
 */
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