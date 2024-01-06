package symmetrical.cosmic.physics.subatomic.anti_matter.anti_leptons

import symmetrical.cosmic.physics.subatomic.luminescent.IAntiMatter
import symmetrical.cosmic.physics.subatomic.luminescent.AntiMatter
import symmetrical.cosmic.physics.subatomic.matter.leptons.MuonNeutrino
/*
https://en.wikipedia.org/wiki/MuonNeutrino
 */
class AntiMuonNeutrino(
    private val antiMatter: IAntiMatter = AntiMatter(AntiMuonNeutrino::class, MuonNeutrino::class),
) : AntiLepton(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(AntiMuonNeutrino::class, MuonNeutrino::class),
    )

    override fun i() : AntiMuonNeutrino {
        super.i()
        return this
    }
    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
}