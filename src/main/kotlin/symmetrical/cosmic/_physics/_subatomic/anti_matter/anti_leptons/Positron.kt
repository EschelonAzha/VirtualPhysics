package symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IQuantumEntanglement
import symmetrical.cosmic._physics._subatomic.fermions.QuantumEntanglement

class Positron (
    private val fermion: IQuantumEntanglement = QuantumEntanglement(),
) : AntiLepton(),
    IQuantumEntanglement by fermion
{
    constructor() : this(
        QuantumEntanglement()
    )
    private fun getLocalClassId() : String {
        return Absorber.getClassId(Positron::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    override fun i() : Positron {
        super.i()
        return this
    }

}