package symmetrical.cosmic.physics.subatomic.anti_matter.anti_leptons

import symmetrical.cosmic.physics.subatomic.balanced.values.Field
import symmetrical.cosmic.physics.subatomic.luminescent.IAntiMatter
import symmetrical.cosmic.physics.subatomic.luminescent.AntiMatter
import symmetrical.cosmic.physics.subatomic.matter.leptons.Tau
/*
https://en.wikipedia.org/wiki/Tau
 */

class AntiTau(
    private val antiMatter: IAntiMatter = AntiMatter(AntiTau::class, Tau::class),
) : AntiLepton(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(AntiTau::class, Tau::class),
    )
    constructor(oldValue : Field) : this() {
        getWavelength().setField(oldValue)
    }


    override fun i() : AntiTau {
        super.i()
        return this
    }
    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
}