package symmetrical.cosmic._physics._subatomic.forces.weak_force.neutral

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

class ChargedWeakForce(
    private val fermion: IFermion = Fermion(),
) :
    IFermion by fermion
{
    constructor() : this(
        Fermion()
    )

    private fun getLocalClassId() : String {
        return Absorber.getClassId(ChargedWeakForce::class)
    }
    open fun getClassId() : String {
        return getLocalClassId()
    }
    fun i() : ChargedWeakForce {
        return this
    }
}