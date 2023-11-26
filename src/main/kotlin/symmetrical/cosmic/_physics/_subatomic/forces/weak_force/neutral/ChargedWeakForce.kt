package symmetrical.cosmic._physics._subatomic.forces.weak_force.neutral

import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

class ChargedWeakForce(
    private val luminescent: ILuminescent = Luminescent(ChargedWeakForce::class),
) :
    ILuminescent by luminescent
{
    constructor() : this(
        Luminescent(ChargedWeakForce::class),
    )

    override fun getClassId() : String {
        return luminescent.getClassId()
    }
    fun i() : ChargedWeakForce {
        return this
    }
}