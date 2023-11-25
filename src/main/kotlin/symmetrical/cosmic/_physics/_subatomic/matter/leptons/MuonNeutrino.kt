package symmetrical.cosmic._physics._subatomic.matter.leptons

import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

class MuonNeutrino(
    private val fermion: ILuminescent = Luminescent(MuonNeutrino::class),
) : Lepton(),
    ILuminescent by fermion
{
    constructor() : this(
        Luminescent(MuonNeutrino::class),
    )

    override fun getClassId() : String {
        return fermion.getClassId()
    }
    override fun i() : MuonNeutrino {
        super.i()
        return this
    }
}