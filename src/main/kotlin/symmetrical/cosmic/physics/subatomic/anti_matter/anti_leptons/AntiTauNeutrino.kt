package symmetrical.cosmic.physics.subatomic.anti_matter.anti_leptons

import symmetrical.cosmic.physics.subatomic.luminescent.IAntiMatter
import symmetrical.cosmic.physics.subatomic.luminescent.AntiMatter
import symmetrical.cosmic.physics.subatomic.matter.leptons.TauNeutrino
/*
https://en.wikipedia.org/wiki/TauNeutrino
 */
class AntiTauNeutrino  (
    private val antiMatter: IAntiMatter = AntiMatter(AntiTauNeutrino::class, TauNeutrino::class),
) : AntiLepton(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(AntiTauNeutrino::class, TauNeutrino::class),
    )



    override fun i() : AntiTauNeutrino {
        super.i()
        return this
    }
    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
}