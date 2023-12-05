package symmetrical.cosmic._physics._subatomic.matter.leptons

import symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons.AntiMuon
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

class Muon(
    private val antiMatter: IAntiMatter = AntiMatter(Muon::class, AntiMuon::class),
) : Lepton(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(Muon::class, AntiMuon::class),
    )
    init {
    }

    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
    override fun i() : Muon {
        super.i()
        return this
    }
}