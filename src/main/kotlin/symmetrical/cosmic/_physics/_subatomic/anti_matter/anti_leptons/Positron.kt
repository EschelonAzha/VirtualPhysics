package symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons

import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

class Positron (
    private val luminescent: ILuminescent = Luminescent(Positron::class),
) : AntiLepton(),
    ILuminescent by luminescent
{
    constructor() : this(
        Luminescent(Positron::class),
    )
    override fun getClassId() : String {
        return luminescent.getClassId()
    }
    override fun i() : Positron {
        super.i()
        return this
    }

}