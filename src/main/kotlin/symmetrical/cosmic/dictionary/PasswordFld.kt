package symmetrical.cosmic.dictionary

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics.atomic.atoms.states.strings.QString
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion
import symmetrical.cosmic._physics.atomic.atoms.states.strings.phases.CrLfTerminatedString

class PasswordFld(
    private val fermion: IFermion = Fermion(PasswordFld::class),
) : QString(),
    IFermion by fermion
{
    constructor() : this(
        Fermion(PasswordFld::class),
    )

    override fun getClassId() : String {
        return fermion.getClassId()
    }

}