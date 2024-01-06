package symmetrical.cosmic.physics.subatomic.anti_matter.anti_quarks

import symmetrical.cosmic.physics.subatomic.luminescent.IAntiMatter
import symmetrical.cosmic.physics.subatomic.luminescent.AntiMatter
import symmetrical.cosmic.physics.subatomic.matter.quarks.Down
/*
https://en.wikipedia.org/wiki/DownQuark
 */
class AntiDown(
    private val antiMatter: IAntiMatter = AntiMatter(AntiDown::class, Down::class),
) : AntiQuark(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(AntiDown::class, Down::class),
    )

    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
}