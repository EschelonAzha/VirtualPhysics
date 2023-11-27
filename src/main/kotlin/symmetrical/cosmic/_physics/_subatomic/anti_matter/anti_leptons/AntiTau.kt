package symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons

import symmetrical.cosmic._physics._subatomic.balanced.values.Field
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter


class AntiTau(
    private val antiMatter: IAntiMatter = AntiMatter(AntiTau::class),
) : AntiLepton(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(AntiTau::class),
    )
    constructor(oldValue : Field) : this() {
        fundamentals.getWavelength().setField(oldValue)
    }

    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
    override fun i() : AntiTau {
        super.i()
        return this
    }
}