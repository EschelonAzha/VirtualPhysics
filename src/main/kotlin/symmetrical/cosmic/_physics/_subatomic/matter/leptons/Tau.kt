package symmetrical.cosmic._physics._subatomic.matter.leptons

import symmetrical.cosmic._physics._subatomic.balanced.values.Field
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent


class Tau(
    private val fermion: ILuminescent = Luminescent(Tau::class),
) : Lepton(),
    ILuminescent by fermion
{
    constructor() : this(
        Luminescent(Tau::class),
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