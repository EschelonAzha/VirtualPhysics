package symmetrical.cosmic.physics.atomic.substance.ions

import symmetrical.cosmic.physics.subatomic.luminescent.IMatter
import symmetrical.cosmic.physics.subatomic.luminescent.Matter
/*
https://en.wikipedia.org/wiki/Ion#Anions_and_cations
 */
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