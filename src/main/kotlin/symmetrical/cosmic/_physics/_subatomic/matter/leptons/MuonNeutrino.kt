package symmetrical.cosmic._physics._subatomic.matter.leptons

import symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons.AntiMuonNeutrino
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter

class MuonNeutrino(
    private val matter: IMatter = Matter(MuonNeutrino::class, AntiMuonNeutrino::class),
) : Lepton(),
    IMatter by matter
{
    constructor() : this(
        Matter(MuonNeutrino::class, AntiMuonNeutrino::class),
    )
    init {

    }

    override fun getClassId() : String {
        return matter.getClassId()
    }
    override fun i() : MuonNeutrino {
        super.i()
        return this
    }
}