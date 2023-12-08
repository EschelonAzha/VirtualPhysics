package symmetrical.cosmic._physics._subatomic.anti_matter.anti_quarks

import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.matter.quarks.Strange

class AntiStrange(
    private val antiMatter: IAntiMatter = AntiMatter(AntiStrange::class, Strange::class, true),
) : AntiQuark(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(AntiStrange::class, Strange::class, true),
    )

    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
}