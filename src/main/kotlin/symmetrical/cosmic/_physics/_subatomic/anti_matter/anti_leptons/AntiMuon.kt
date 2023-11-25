package symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons

import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

open class AntiMuon(
    private val luminescent: ILuminescent = Luminescent(AntiMuon::class),
) : AntiLepton(),
    ILuminescent by luminescent
{
    constructor() : this(
        Luminescent(AntiMuon::class),
    )

    override fun getClassId() : String {
        return luminescent.getClassId()
    }
    override fun i() : AntiMuon {
        super.i()
        return this
    }
}