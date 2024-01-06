package symmetrical.cosmic.physics.subatomic.anti_matter.anti_quarks

import symmetrical.cosmic.physics.subatomic.luminescent.IAntiMatter
import symmetrical.cosmic.physics.subatomic.luminescent.AntiMatter
import symmetrical.cosmic.physics.subatomic.matter.quarks.Charm
/*
https://en.wikipedia.org/wiki/CharmQuark
 */
class AntiCharm (
    private val antiMatter: IAntiMatter = AntiMatter(AntiCharm::class, Charm::class),
) : AntiQuark(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(AntiCharm::class, Charm::class),
    )


    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
}