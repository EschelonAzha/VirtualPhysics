package symmetrical.cosmic.dictionary

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics.atomic.atoms.states.strings.QString
import symmetrical.cosmic._physics._subatomic.fermions.IQuantumEntanglement
import symmetrical.cosmic._physics._subatomic.fermions.QuantumEntanglement

class PasswordFld(
    private val entanglement: IQuantumEntanglement = QuantumEntanglement()
) : QString(entanglement),
    IQuantumEntanglement by entanglement
{
    constructor() : this(
        QuantumEntanglement()
    )

    private fun getLocalClassId() : String {
        return Absorber.getClassId(PasswordFld::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }

}