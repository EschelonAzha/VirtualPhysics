package symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons

import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.matter.leptons.MuonNeutrino

class AntiMuonNeutrino(
    private val antiMatter: IAntiMatter = AntiMatter(AntiMuonNeutrino::class, MuonNeutrino::class, true),
) : AntiLepton(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(AntiMuonNeutrino::class, MuonNeutrino::class, true),
    )

    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
    override fun i() : AntiMuonNeutrino {
        super.i()
        return this
    }
}