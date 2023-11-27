package symmetrical.cosmic._physics._subatomic.anti_matter.anti_quarks

import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

class AntiCharm (
    private val antiMatter: IAntiMatter = AntiMatter(AntiCharm::class),
) : AntiQuark(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(AntiCharm::class),
    )


    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
}