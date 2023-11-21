package symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.values.Field
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion


class AntiTau(
    private val fermion: IFermion = Fermion(AntiTau::class),
) : AntiLepton(),
    IFermion by fermion
{
    constructor() : this(
        Fermion(AntiTau::class),
    )
    constructor(oldValue : Field) : this() {
        fundamentals.getWavelength().setField(oldValue)
    }

    override fun getClassId() : String {
        return fermion.getClassId()
    }
    override fun i() : AntiTau {
        super.i()
        return this
    }
}