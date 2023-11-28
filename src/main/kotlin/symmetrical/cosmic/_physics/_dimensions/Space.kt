package symmetrical.cosmic._physics._dimensions

import symmetrical.cosmic._physics._subatomic.balanced.IParticle
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter

class Space (
    private val antiMatter: IAntiMatter = AntiMatter(Space::class),
) :
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(Space::class),
    )

    var space: IParticle? = null

    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
    fun i() : Space {
        return this
    }
}