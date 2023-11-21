package symmetrical.cosmic._physics.atomic.substance.metals

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

class Metal(
    private val fermion: IFermion = Fermion(Metal::class),
) :
    IFermion by fermion
{

    constructor() : this(
        Fermion(Metal::class),
    )
    override fun getClassId() : String {
        return fermion.getClassId()
    }
}