package symmetrical.cosmic._physics._subatomic.forces.weak_force

import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

class ChargedWeak(
    private val fermion: ILuminescent = Luminescent(ChargedWeak::class),
) : Particle(),
    ILuminescent by fermion
{
    // can emit a charged W Boson that can alter the charge of a Proton by
    // altering the structure of its quarks
    constructor() : this(
        Luminescent(ChargedWeak::class),
    )

    override fun getClassId() : String {
        return fermion.getClassId()
    }
    fun i() : ChargedWeak {
        return this
    }
}