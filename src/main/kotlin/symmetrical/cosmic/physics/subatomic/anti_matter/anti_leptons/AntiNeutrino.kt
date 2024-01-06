package symmetrical.cosmic.physics.subatomic.anti_matter.anti_leptons

import symmetrical.cosmic.physics.subatomic.luminescent.IAntiMatter
import symmetrical.cosmic.physics.subatomic.luminescent.AntiMatter
import symmetrical.cosmic.physics.subatomic.matter.leptons.Neutrino
/*
https://en.wikipedia.org/wiki/Neutrino
 */
class AntiNeutrino (
    private val antiMatter: IAntiMatter = AntiMatter(AntiNeutrino::class, Neutrino::class),
) : AntiLepton(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(AntiNeutrino::class, Neutrino::class),
    )

    override fun i() : AntiNeutrino {
        super.i()
        return this
    }
    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
}