package symmetrical.cosmic._physics._subatomic.matter.leptons

import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

class MuonNeutrino(
    private val luminescent: ILuminescent = Luminescent(MuonNeutrino::class),
) : Lepton(),
    ILuminescent by luminescent
{
    constructor() : this(
        Luminescent(MuonNeutrino::class),
    )

    override fun getClassId() : String {
        return luminescent.getClassId()
    }
    override fun i() : MuonNeutrino {
        super.i()
        return this
    }
}