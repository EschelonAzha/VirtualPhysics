package symmetrical.cosmic.dictionary

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics.atomic.atoms.states.strings.QString
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

class PasswordFld(
    private val entanglement: IFermion = Fermion()
) : QString(entanglement),
    IFermion by entanglement
{
    constructor() : this(
        Fermion()
    )

    private fun getLocalClassId() : String {
        return Absorber.getClassId(PasswordFld::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }

}