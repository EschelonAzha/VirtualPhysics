package symmetrical.cosmic._physics.atomic.matter

import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

class Material(
    private val luminescent: ILuminescent = Luminescent(Material::class),
) :
    ILuminescent by luminescent
{
    constructor() : this(
        Luminescent(Material::class),
    )
    override fun getClassId() : String {
        return luminescent.getClassId()
    }
}