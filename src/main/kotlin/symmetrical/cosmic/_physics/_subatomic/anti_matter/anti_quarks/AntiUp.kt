package symmetrical.cosmic._physics._subatomic.anti_matter.anti_quarks

import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

class AntiUp(
    private val luminescent: ILuminescent = Luminescent(AntiUp::class),
) : AntiQuark(),
    ILuminescent by luminescent
{
    constructor() : this(
        Luminescent(AntiUp::class),
    )


    override fun getClassId() : String {
        return luminescent.getClassId()
    }
}