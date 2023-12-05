package symmetrical.cosmic.dictionary

import symmetrical.cosmic._physics.atomic.atoms.states.strings.QString
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

class UseridFld(
    private val antiMatter: IAntiMatter = AntiMatter(UseridFld::class, UseridFld::class),
) : QString(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(UseridFld::class, UseridFld::class),
    )


    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
}