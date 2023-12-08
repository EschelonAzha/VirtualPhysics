package symmetrical.cosmic._physics._subatomic.anti_matter.anti_quarks

import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.matter.quarks.Up

class AntiUp(
    private val antiMatter: IAntiMatter = AntiMatter(AntiUp::class, Up::class, true),
) : AntiQuark(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(AntiUp::class, Up::class, true),
    )


    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
}