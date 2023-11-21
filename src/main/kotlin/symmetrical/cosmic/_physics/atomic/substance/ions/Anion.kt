package symmetrical.cosmic._physics.atomic.substance.ions

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

class Anion(
    val fermion: IFermion = Fermion(Anion::class),
) : Ion(),
    IFermion by fermion
{
    constructor() : this(
        Fermion(Anion::class),
    )
    override fun getClassId() : String {
        return fermion.getClassId()
    }
    // Negative charge
}