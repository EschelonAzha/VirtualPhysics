package symmetrical.cosmic.physics.subatomic.matter.leptons

import symmetrical.cosmic.physics.subatomic.anti_matter.anti_leptons.AntiMuon
import symmetrical.cosmic.physics.subatomic.luminescent.IMatter
import symmetrical.cosmic.physics.subatomic.luminescent.Matter
/*
https://en.wikipedia.org/wiki/Muon
 */
class Muon(
    private val matter: IMatter = Matter(Muon::class, AntiMuon::class),
) : Lepton(),
    IMatter by matter
{
    constructor() : this(
        Matter(Muon::class, AntiMuon::class),
    )
    init {
    }

    override fun i() : Muon {
        super.i()
        return this
    }
    override fun getClassId() : String {
        return matter.getClassId()
    }

}