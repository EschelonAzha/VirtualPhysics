package symmetrical.cosmic._physics._subatomic.anti_matter.anti_quarks

import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.matter.quarks.Strange
/*
https://en.wikipedia.org/wiki/StrangeQuark
 */
class AntiStrange(
    private val antiMatter: IAntiMatter = AntiMatter(AntiStrange::class, Strange::class),
) : AntiQuark(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(AntiStrange::class, Strange::class),
    )

    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
}