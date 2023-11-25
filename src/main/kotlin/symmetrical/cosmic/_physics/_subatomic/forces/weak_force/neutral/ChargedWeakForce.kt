package symmetrical.cosmic._physics._subatomic.forces.weak_force.neutral

import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

class ChargedWeakForce(
    private val fermion: ILuminescent = Luminescent(ChargedWeakForce::class),
) :
    ILuminescent by fermion
{
    constructor() : this(
        Luminescent(ChargedWeakForce::class),
    )

    override fun getClassId() : String {
        return fermion.getClassId()
    }
    fun i() : ChargedWeakForce {
        return this
    }
}