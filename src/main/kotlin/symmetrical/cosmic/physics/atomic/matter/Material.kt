package symmetrical.cosmic.physics.atomic.matter

import symmetrical.cosmic.physics.subatomic.luminescent.IMatter
import symmetrical.cosmic.physics.subatomic.luminescent.Matter
/*
https://en.wikipedia.org/wiki/Material
 */
class Material(
    private val matter: IMatter = Matter(Material::class, Material::class),
) :
    IMatter by matter
{
    constructor() : this(
        Matter(Material::class, Material::class),
    )
    override fun getClassId() : String {
        return matter.getClassId()
    }
}