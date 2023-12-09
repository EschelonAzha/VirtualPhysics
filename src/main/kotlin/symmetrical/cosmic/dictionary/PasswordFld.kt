package symmetrical.cosmic.dictionary

import symmetrical.cosmic._physics.atomic.atoms.states.strings.QString
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter

class PasswordFld(
    private val matter: IMatter = Matter(PasswordFld::class, PasswordFld::class),
) : QString(),
    IMatter by matter
{
    constructor() : this(
        Matter(PasswordFld::class, PasswordFld::class),
    )

    override fun getClassId() : String {
        return matter.getClassId()
    }

}