package symmetrical.cosmic._physics._subatomic.forces.weak_force

import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

class ChargedWeak(
    private val antiMatter: IAntiMatter = AntiMatter(ChargedWeak::class),
) : Particle(),
    IAntiMatter by antiMatter
{
    // can emit a charged W Boson that can alter the charge of a Proton by
    // altering the structure of its quarks
    constructor() : this(
        AntiMatter(ChargedWeak::class),
    )

    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
    fun i() : ChargedWeak {
        return this
    }
}