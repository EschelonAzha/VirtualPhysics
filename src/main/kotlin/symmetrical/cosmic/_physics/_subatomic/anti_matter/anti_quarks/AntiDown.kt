package symmetrical.cosmic._physics._subatomic.anti_matter.anti_quarks

import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.matter.quarks.Down

class AntiDown(
    private val antiMatter: IAntiMatter = AntiMatter(AntiDown::class, Down::class, true),
) : AntiQuark(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(AntiDown::class, Down::class, true),
    )

    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
}