package symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons

import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

class AntiNeutrino (
    private val luminescent: ILuminescent = Luminescent(AntiNeutrino::class),
) : AntiLepton(),
    ILuminescent by luminescent
{
    constructor() : this(
        Luminescent(AntiNeutrino::class),
    )
    override fun getClassId() : String {
        return luminescent.getClassId()
    }
    override fun i() : AntiNeutrino {
        super.i()
        return this
    }
}