package symmetrical.cosmic._physics._subatomic.anti_matter.anti_quarks

import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter


class AntiBottom(
    private val antiMatter: IAntiMatter = AntiMatter(AntiBottom::class),
) : AntiQuark(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(AntiBottom::class),
    )

    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
}