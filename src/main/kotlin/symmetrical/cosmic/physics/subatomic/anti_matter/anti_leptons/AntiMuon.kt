package symmetrical.cosmic.physics.subatomic.anti_matter.anti_leptons

import symmetrical.cosmic.physics.subatomic.luminescent.IAntiMatter
import symmetrical.cosmic.physics.subatomic.luminescent.AntiMatter
import symmetrical.cosmic.physics.subatomic.matter.leptons.Muon
/*
https://en.wikipedia.org/wiki/Muon
 */
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