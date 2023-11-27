package symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons

import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

class Positron (
    private val antiMatter: IAntiMatter = AntiMatter(Positron::class),
) : AntiLepton(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(Positron::class),
    )
    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
    override fun i() : Positron {
        super.i()
        return this
    }

}