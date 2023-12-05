package symmetrical.cosmic.dictionary

import symmetrical.cosmic._physics.atomic.atoms.states.strings.QString
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

class PasswordFld(
    private val antiMatter: IAntiMatter = AntiMatter(PasswordFld::class, PasswordFld::class),
) : QString(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(PasswordFld::class, PasswordFld::class),
    )

    override fun getClassId() : String {
        return antiMatter.getClassId()
    }

}