package symmetrical.cosmic._physics.atomic.matter

import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter
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