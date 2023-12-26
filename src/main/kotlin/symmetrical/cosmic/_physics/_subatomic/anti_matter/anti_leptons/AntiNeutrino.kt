package symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons

import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.matter.leptons.Neutrino

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