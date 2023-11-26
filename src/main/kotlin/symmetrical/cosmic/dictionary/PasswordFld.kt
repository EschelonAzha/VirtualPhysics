package symmetrical.cosmic.dictionary

import symmetrical.cosmic._physics.atomic.atoms.states.strings.QString
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

class PasswordFld(
    private val luminescent: ILuminescent = Luminescent(PasswordFld::class),
) : QString(),
    ILuminescent by luminescent
{
    constructor() : this(
        Luminescent(PasswordFld::class),
    )

    override fun getClassId() : String {
        return luminescent.getClassId()
    }

}