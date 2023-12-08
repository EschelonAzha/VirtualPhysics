package symmetrical.cosmic._physics._subatomic.matter.leptons

import symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons.AntiTauNeutrino
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter

class TauNeutrino(
    private val matter: IMatter = Matter(TauNeutrino::class, AntiTauNeutrino::class, true),
) : Lepton(),
    IMatter by matter
{
    constructor() : this(
        Matter(TauNeutrino::class, AntiTauNeutrino::class, true),
    )
    init {
    }

    override fun getClassId() : String {
        return matter.getClassId()
    }
    override fun i() : TauNeutrino {
        super.i()
        return this
    }
}