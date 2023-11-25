package symmetrical.cosmic._physics._subatomic.matter.leptons

import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

class Muon(
    private val fermion: ILuminescent = Luminescent(Muon::class),
) : Lepton(),
    ILuminescent by fermion
{
    constructor() : this(
        Luminescent(Muon::class),
    )

    override fun getClassId() : String {
        return fermion.getClassId()
    }
    override fun i() : Muon {
        super.i()
        return this
    }
}