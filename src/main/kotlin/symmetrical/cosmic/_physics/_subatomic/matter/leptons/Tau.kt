package symmetrical.cosmic._physics._subatomic.matter.leptons

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.values.Field
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion


class Tau(
    private val fermion: IFermion = Fermion(Tau::class),
) : Lepton(),
    IFermion by fermion
{
    constructor() : this(
        Fermion(Tau::class),
    )
    constructor(newValue : Field) : this() {
        fundamentals.getWavelength().setField(newValue)
    }
    override fun getClassId() : String {
        return fermion.getClassId()
    }
    override fun i() : Tau {
        super.i()
        return this
    }
}