package symmetrical.cosmic._physics._subatomic.anti_matter.anti_quarks

import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.matter.quarks.Top

class AntiTop(
    private val antiMatter: IAntiMatter = AntiMatter(AntiTop::class, Top::class, true),
) : AntiQuark(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(AntiTop::class, Top::class, true),
    )

    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
}