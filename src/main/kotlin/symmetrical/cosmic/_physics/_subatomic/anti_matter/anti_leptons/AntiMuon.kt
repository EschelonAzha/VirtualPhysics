package symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons

import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.matter.leptons.Muon

open class AntiMuon(
    private val antiMatter: IAntiMatter = AntiMatter(AntiMuon::class, Muon::class),
) : AntiLepton(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(AntiMuon::class, Muon::class),
    )


    override fun i() : AntiMuon {
        super.i()
        return this
    }
    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
}