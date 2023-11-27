package symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons

import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

class AntiTauNeutrino  (
    private val antiMatter: IAntiMatter = AntiMatter(AntiTauNeutrino::class),
) : AntiLepton(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(AntiTauNeutrino::class),
    )


    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
    override fun i() : AntiTauNeutrino {
        super.i()
        return this
    }
}