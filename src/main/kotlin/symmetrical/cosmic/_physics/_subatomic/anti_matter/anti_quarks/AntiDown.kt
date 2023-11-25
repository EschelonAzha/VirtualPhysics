package symmetrical.cosmic._physics._subatomic.anti_matter.anti_quarks

import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

class AntiDown(
    private val luminescent: ILuminescent = Luminescent(AntiDown::class),
) : AntiQuark(),
    ILuminescent by luminescent
{
    constructor() : this(
        Luminescent(AntiDown::class),
    )

    override fun getClassId() : String {
        return luminescent.getClassId()
    }
}