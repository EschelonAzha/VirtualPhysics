package symmetrical.cosmic._physics._subatomic.matter.leptons

import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

class TauNeutrino(
    private val fermion: ILuminescent = Luminescent(TauNeutrino::class),
) : Lepton(),
    ILuminescent by fermion
{
    constructor() : this(
        Luminescent(TauNeutrino::class),
    )

    override fun getClassId() : String {
        return fermion.getClassId()
    }
    override fun i() : TauNeutrino {
        super.i()
        return this
    }
}