package symmetrical.cosmic._physics.atomic.substance.ions

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

open class Ion(
    private val fermion: IFermion = Fermion(Ion::class),
) :
    IFermion by fermion
{

    constructor() : this(
        Fermion(Ion::class),
    )
    override fun getClassId() : String {
        return fermion.getClassId()
    }
}