package symmetrical.cosmic.physics.subatomic.matter.leptons

import symmetrical.cosmic.physics.subatomic.anti_matter.anti_leptons.AntiMuonNeutrino
import symmetrical.cosmic.physics.subatomic.luminescent.IMatter
import symmetrical.cosmic.physics.subatomic.luminescent.Matter
/*
https://en.wikipedia.org/wiki/MuonNeutrino
 */
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
    override fun i() : MuonNeutrino {
        super.i()
        return this
    }
    override fun getClassId() : String {
        return matter.getClassId()
    }

}