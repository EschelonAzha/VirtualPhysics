package symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons

import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

class AntiMuonNeutrino(
    private val antiMatter: IAntiMatter = AntiMatter(AntiMuonNeutrino::class),
) : AntiLepton(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(AntiMuonNeutrino::class),
    )

    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
    override fun i() : AntiMuonNeutrino {
        super.i()
        return this
    }
}