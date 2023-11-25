package symmetrical.cosmic._physics._dimensions.charge

import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

class Charge (
    private val luminescent: ILuminescent = Luminescent(Charge::class),
) :
    ILuminescent by luminescent
{
    constructor() : this(
        Luminescent(Charge::class),
    )

    override fun getClassId() : String {
        return luminescent.getClassId()
    }
    fun i() : Charge {
        return this
    }
}