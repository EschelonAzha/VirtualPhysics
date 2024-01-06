package symmetrical.cosmic.physics.subatomic.anti_matter.anti_quarks

import symmetrical.cosmic.physics.subatomic.luminescent.IAntiMatter
import symmetrical.cosmic.physics.subatomic.luminescent.AntiMatter
import symmetrical.cosmic.physics.subatomic.matter.quarks.Bottom
/*
https://en.wikipedia.org/wiki/BottomQuark
 */

class AntiBottom(
    private val antiMatter: IAntiMatter = AntiMatter(AntiBottom::class, Bottom::class),
) : AntiQuark(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(AntiBottom::class, Bottom::class),
    )

    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
}