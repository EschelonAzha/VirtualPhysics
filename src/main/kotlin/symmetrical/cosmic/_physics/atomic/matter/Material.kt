package symmetrical.cosmic._physics.atomic.matter

import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

class Material(
    private val antiMatter: IAntiMatter = AntiMatter(Material::class, Material::class),
) :
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(Material::class, Material::class),
    )
    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
}