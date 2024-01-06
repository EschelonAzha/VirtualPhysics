package symmetrical.cosmic.physics.subatomic.matter.leptons

import symmetrical.cosmic.physics.subatomic.anti_matter.anti_leptons.AntiTauNeutrino
import symmetrical.cosmic.physics.subatomic.luminescent.IMatter
import symmetrical.cosmic.physics.subatomic.luminescent.Matter
/*
https://en.wikipedia.org/wiki/TauNeutrino
 */
class TauNeutrino(
    private val matter: IMatter = Matter(TauNeutrino::class, AntiTauNeutrino::class),
) : Lepton(),
    IMatter by matter
{
    constructor() : this(
        Matter(TauNeutrino::class, AntiTauNeutrino::class),
    )
    init {
    }
    override fun i() : TauNeutrino {
        super.i()
        return this
    }
    override fun getClassId() : String {
        return matter.getClassId()
    }

}