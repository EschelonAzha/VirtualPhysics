package symmetrical.cosmic._physics._subatomic.matter.leptons

import symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons.AntiMuonNeutrino
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

class MuonNeutrino(
    private val antiMatter: IAntiMatter = AntiMatter(MuonNeutrino::class, AntiMuonNeutrino::class),
) : Lepton(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(MuonNeutrino::class, AntiMuonNeutrino::class),
    )
    init {

    }

    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
    override fun i() : MuonNeutrino {
        super.i()
        return this
    }
}