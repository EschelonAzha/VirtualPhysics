package symmetrical.cosmic._physics._subatomic.forces.weak_force.neutral

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

class ChargedWeakForce(
    private val fermion: IFermion = Fermion(ChargedWeakForce::class),
) :
    IFermion by fermion
{
    constructor() : this(
        Fermion(ChargedWeakForce::class),
    )

    override fun getClassId() : String {
        return fermion.getClassId()
    }
    fun i() : ChargedWeakForce {
        return this
    }
}