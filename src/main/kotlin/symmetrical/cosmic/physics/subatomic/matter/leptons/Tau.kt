package symmetrical.cosmic.physics.subatomic.matter.leptons

import symmetrical.cosmic.physics.subatomic.balanced.values.Field
import symmetrical.cosmic.physics.subatomic.anti_matter.anti_leptons.AntiTau
import symmetrical.cosmic.physics.subatomic.luminescent.IMatter
import symmetrical.cosmic.physics.subatomic.luminescent.Matter
/*
https://en.wikipedia.org/wiki/Tau
 */

class Tau(
    private val matter: IMatter = Matter(Tau::class, AntiTau::class),
) : Lepton(),
    IMatter by matter
{
    constructor() : this(
        Matter(Tau::class, AntiTau::class),
    )
    init {

    }

    constructor(newValue : Field) : this() {
        getWavelength().setField(newValue)
    }
    override fun i() : Tau {
        super.i()
        return this
    }
    override fun getClassId() : String {
        return matter.getClassId()
    }

}