package symmetrical.cosmic._physics._subatomic.anti_matter.anti_quarks

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IQuantumEntanglement
import symmetrical.cosmic._physics._subatomic.fermions.QuantumEntanglement

class AntiUp(
    private val fermion: IQuantumEntanglement = QuantumEntanglement(),
) : AntiQuark(),
    IQuantumEntanglement by fermion
{
    constructor() : this(
        QuantumEntanglement()
    )


    private fun getLocalClassId() : String {
        return Absorber.getClassId(AntiUp::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
}