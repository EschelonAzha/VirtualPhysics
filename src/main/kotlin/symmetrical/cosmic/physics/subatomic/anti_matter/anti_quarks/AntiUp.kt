package symmetrical.cosmic.physics.subatomic.anti_matter.anti_quarks

import symmetrical.cosmic.physics.subatomic.luminescent.IAntiMatter
import symmetrical.cosmic.physics.subatomic.luminescent.AntiMatter
import symmetrical.cosmic.physics.subatomic.matter.quarks.Up
/*
https://en.wikipedia.org/wiki/UpQuark
 */
class AntiUp(
    private val antiMatter: IAntiMatter = AntiMatter(AntiUp::class, Up::class),
) : AntiQuark(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(AntiUp::class, Up::class),
    )


    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
}