package symmetrical.cosmic._physics.atomic.matter

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

open class Matter(
    private val fermion: IFermion = Fermion(Matter::class),
) :
    IFermion by fermion
{

    constructor() : this(
        Fermion(Matter::class),
    )
    override fun getClassId() : String {
        return fermion.getClassId()
    }
}