package symmetrical.cosmic._physics._subatomic.matter.leptons

import symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons.AntiMuon
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter

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