package symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons

import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.matter.leptons.Electron
/*
https://en.wikipedia.org/wiki/Positron
 */
class Positron (
    private val antiMatter: IAntiMatter = AntiMatter(Positron::class, Electron::class),
) : AntiLepton(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(Positron::class, Electron::class),
    )

    override fun i() : Positron {
        super.i()
        return this
    }
    override fun getClassId() : String {
        return antiMatter.getClassId()
    }

}