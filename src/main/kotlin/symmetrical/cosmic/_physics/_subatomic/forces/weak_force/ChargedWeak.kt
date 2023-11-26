package symmetrical.cosmic._physics._subatomic.forces.weak_force

import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

class ChargedWeak(
    private val luminescent: ILuminescent = Luminescent(ChargedWeak::class),
) : Particle(),
    ILuminescent by luminescent
{
    // can emit a charged W Boson that can alter the charge of a Proton by
    // altering the structure of its quarks
    constructor() : this(
        Luminescent(ChargedWeak::class),
    )

    override fun getClassId() : String {
        return luminescent.getClassId()
    }
    fun i() : ChargedWeak {
        return this
    }
}