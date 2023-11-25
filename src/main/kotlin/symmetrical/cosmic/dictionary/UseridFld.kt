package symmetrical.cosmic.dictionary

import symmetrical.cosmic._physics.atomic.atoms.states.strings.QString
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

class UseridFld(
    private val fermion: ILuminescent = Luminescent(UseridFld::class),
) : QString(),
    ILuminescent by fermion
{
    constructor() : this(
        Luminescent(UseridFld::class),
    )


    override fun getClassId() : String {
        return fermion.getClassId()
    }
}