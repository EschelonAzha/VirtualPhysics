package symmetrical.cosmic._physics._subatomic.matter.leptons

import symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons.AntiMuon
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

class Muon(
    private val luminescent: ILuminescent = Luminescent(Muon::class),
) : Lepton(),
    ILuminescent by luminescent
{
    constructor() : this(
        Luminescent(Muon::class),
    )
    init {
        setAntiMatter(AntiMuon::class)
    }

    override fun getClassId() : String {
        return luminescent.getClassId()
    }
    override fun i() : Muon {
        super.i()
        return this
    }
}