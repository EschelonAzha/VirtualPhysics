package symmetrical.cosmic._physics._subatomic.matter.leptons

import symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons.AntiTau
import symmetrical.cosmic._physics._subatomic.balanced.values.Field
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter


class Tau(
    private val antiMatter: IAntiMatter = AntiMatter(Tau::class),
) : Lepton(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(Tau::class),
    )
    init {
        setAntiMatter(AntiTau::class)
    }
    constructor(newValue : Field) : this() {
        fundamentals.getWavelength().setField(newValue)
    }
    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
    override fun i() : Tau {
        super.i()
        return this
    }
}