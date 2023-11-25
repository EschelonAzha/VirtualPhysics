package symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons

import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

class AntiMuonNeutrino(
    private val luminescent: ILuminescent = Luminescent(AntiMuonNeutrino::class),
) : AntiLepton(),
    ILuminescent by luminescent
{
    constructor() : this(
        Luminescent(AntiMuonNeutrino::class),
    )

    override fun getClassId() : String {
        return luminescent.getClassId()
    }
    override fun i() : AntiMuonNeutrino {
        super.i()
        return this
    }
}