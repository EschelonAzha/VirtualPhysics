package symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons

import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

class AntiTauNeutrino  (
    private val luminescent: ILuminescent = Luminescent(AntiTauNeutrino::class),
) : AntiLepton(),
    ILuminescent by luminescent
{
    constructor() : this(
        Luminescent(AntiTauNeutrino::class),
    ) {
        luminescent.setKClass(AntiTauNeutrino::class)
    }


    override fun getClassId() : String {
        return luminescent.getClassId()
    }
    override fun i() : AntiTauNeutrino {
        super.i()
        return this
    }
}