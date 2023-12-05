package symmetrical.cosmic._physics._subatomic.matter.leptons

import symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons.AntiTauNeutrino
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

class TauNeutrino(
    private val antiMatter: IAntiMatter = AntiMatter(TauNeutrino::class, AntiTauNeutrino::class),
) : Lepton(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(TauNeutrino::class, AntiTauNeutrino::class),
    )
    init {
    }

    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
    override fun i() : TauNeutrino {
        super.i()
        return this
    }
}