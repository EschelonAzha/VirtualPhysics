package symmetrical.cosmic._physics.atomic.substance.ions

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

class Cation(
    private val fermion: IFermion = Fermion(Cation::class),
) : Ion(),
    IFermion by fermion
{
    constructor() : this(
        Fermion(Cation::class),
    )
    override fun getClassId() : String {
        return fermion.getClassId()
    }
    // plus
}