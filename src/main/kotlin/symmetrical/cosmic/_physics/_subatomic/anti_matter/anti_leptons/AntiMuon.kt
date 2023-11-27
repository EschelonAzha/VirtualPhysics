package symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons

import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

open class AntiMuon(
    private val antiMatter: IAntiMatter = AntiMatter(AntiMuon::class),
) : AntiLepton(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(AntiMuon::class),
    )

    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
    override fun i() : AntiMuon {
        super.i()
        return this
    }
}