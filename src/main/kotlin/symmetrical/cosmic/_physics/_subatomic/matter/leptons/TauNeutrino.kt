package symmetrical.cosmic._physics._subatomic.matter.leptons

import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

class TauNeutrino(
    private val luminescent: ILuminescent = Luminescent(TauNeutrino::class),
) : Lepton(),
    ILuminescent by luminescent
{
    constructor() : this(
        Luminescent(TauNeutrino::class),
    )

    override fun getClassId() : String {
        return luminescent.getClassId()
    }
    override fun i() : TauNeutrino {
        super.i()
        return this
    }
}