package symmetrical.cosmic._physics._subatomic.matter.leptons

import symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons.AntiTau
import symmetrical.cosmic._physics._subatomic.balanced.values.Field
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter


class Tau(
    private val matter: IMatter = Matter(Tau::class, AntiTau::class, true),
) : Lepton(),
    IMatter by matter
{
    constructor() : this(
        Matter(Tau::class, AntiTau::class, true),
    )
    init {

    }
    constructor(newValue : Field) : this() {
        fundamentals.getWavelength().setField(newValue)
    }
    override fun getClassId() : String {
        return matter.getClassId()
    }
    override fun i() : Tau {
        super.i()
        return this
    }
}