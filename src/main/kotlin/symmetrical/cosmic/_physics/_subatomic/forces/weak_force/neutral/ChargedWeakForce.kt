package symmetrical.cosmic._physics._subatomic.forces.weak_force.neutral

import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

class ChargedWeakForce(
    private val antiMatter: IAntiMatter = AntiMatter(ChargedWeakForce::class),
) :
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(ChargedWeakForce::class),
    )

    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
    fun i() : ChargedWeakForce {
        return this
    }
}