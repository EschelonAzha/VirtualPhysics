package symmetrical.cosmic._physics.atomic.bonds.mixtures

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics.atomic.matter.Matter
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

class Mixture(
    private val fermion: IFermion = Fermion()
) : Matter(),
    IFermion by fermion
{
    constructor() : this(
        Fermion()
    )
    // mixtures may be regular classes with all kinds of things
    // mixed together that are other classes but not Atoms or Molecules

    private fun getLocalClassId() : String {
        return Absorber.getClassId(Mixture::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
}