package symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons

import symmetrical.cosmic._physics._subatomic.balanced.values.Field
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent


class AntiTau(
    private val luminescent: ILuminescent = Luminescent(AntiTau::class),
) : AntiLepton(),
    ILuminescent by luminescent
{
    constructor() : this(
        Luminescent(AntiTau::class),
    )
    constructor(oldValue : Field) : this() {
        fundamentals.getWavelength().setField(oldValue)
    }

    override fun getClassId() : String {
        return luminescent.getClassId()
    }
    override fun i() : AntiTau {
        super.i()
        return this
    }
}