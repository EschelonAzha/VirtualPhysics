package symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons

import symmetrical.cosmic._physics._subatomic.balanced.values.Field
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.matter.leptons.Tau


class AntiTau(
    private val antiMatter: IAntiMatter = AntiMatter(AntiTau::class, Tau::class, true),
) : AntiLepton(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(AntiTau::class, Tau::class, true),
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