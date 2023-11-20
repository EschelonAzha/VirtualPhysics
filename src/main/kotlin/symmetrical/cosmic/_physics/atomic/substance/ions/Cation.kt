package symmetrical.cosmic._physics.atomic.substance.ions

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

class Cation(
    private val fermion: IFermion = Fermion()
) : Ion(),
    IFermion by fermion
{
    constructor() : this(
        Fermion()
    )
    private fun getLocalClassId() : String {
        return Absorber.getClassId(Cation::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    // plus
}