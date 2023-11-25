package symmetrical.cosmic._physics.atomic.matter

import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

open class Matter(
    private val fermion: ILuminescent = Luminescent(Matter::class),
) :
    ILuminescent by fermion
{

    constructor() : this(
        Luminescent(Matter::class),
    )
    override fun getClassId() : String {
        return fermion.getClassId()
    }
}