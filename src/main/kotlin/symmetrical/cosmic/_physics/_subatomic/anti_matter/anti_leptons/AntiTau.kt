package symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.values.Field
import symmetrical.cosmic._physics._subatomic.fermions.IQuantumEntanglement
import symmetrical.cosmic._physics._subatomic.fermions.QuantumEntanglement


class AntiTau(
    private val entanglement: IQuantumEntanglement = QuantumEntanglement(),
) : AntiLepton(entanglement),
    IQuantumEntanglement by entanglement
{
    constructor() : this(
        QuantumEntanglement()
    )
    constructor(oldValue : Field) : this() {
        fundamentals.getWavelength().setField(oldValue)
    }

    private fun getLocalClassId() : String {
        return Absorber.getClassId(AntiTau::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    override fun i() : AntiTau {
        super.i()
        return this
    }
}