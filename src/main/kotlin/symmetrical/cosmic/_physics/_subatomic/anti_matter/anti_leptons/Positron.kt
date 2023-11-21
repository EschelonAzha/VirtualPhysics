package symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

class Positron (
    private val fermion: IFermion = Fermion(Positron::class),
) : AntiLepton(),
    IFermion by fermion
{
    constructor() : this(
        Fermion(Positron::class),
    )
    override fun getClassId() : String {
        return fermion.getClassId()
    }
    override fun i() : Positron {
        super.i()
        return this
    }

}