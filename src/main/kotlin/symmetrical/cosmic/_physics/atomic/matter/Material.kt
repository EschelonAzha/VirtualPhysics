package symmetrical.cosmic._physics.atomic.matter

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

class Material(
    private val fermion: IFermion = Fermion(Material::class),
) :
    IFermion by fermion
{
    constructor() : this(
        Fermion(Material::class),
    )
    override fun getClassId() : String {
        return fermion.getClassId()
    }
}