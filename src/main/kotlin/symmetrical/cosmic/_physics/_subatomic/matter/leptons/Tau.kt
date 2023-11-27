package symmetrical.cosmic._physics._subatomic.matter.leptons

import symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons.AntiTau
import symmetrical.cosmic._physics._subatomic.balanced.values.Field
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent


class Tau(
    private val luminescent: ILuminescent = Luminescent(Tau::class),
) : Lepton(),
    ILuminescent by luminescent
{
    constructor() : this(
        Luminescent(Tau::class),
    )
    init {
        setAntiMatter(AntiTau::class)
    }
    constructor(newValue : Field) : this() {
        fundamentals.getWavelength().setField(newValue)
    }
    override fun getClassId() : String {
        return luminescent.getClassId()
    }
    override fun i() : Tau {
        super.i()
        return this
    }
}