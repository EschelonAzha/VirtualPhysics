package symmetrical.cosmic.dictionary

import symmetrical.cosmic._physics.atomic.atoms.states.strings.QString
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter

class UseridFld(
    private val matter: IMatter = Matter(UseridFld::class, UseridFld::class, true),
) : QString(),
    IMatter by matter
{
    constructor() : this(
        Matter(UseridFld::class, UseridFld::class, true),
    )


    override fun getClassId() : String {
        return matter.getClassId()
    }
}