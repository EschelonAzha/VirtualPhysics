package symmetrical.cosmic.dictionary

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics.atomic.atoms.states.strings.QString
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

class UseridFld(
    private val fermion: IFermion = Fermion(UseridFld::class),
) : QString(),
    IFermion by fermion
{
    constructor() : this(
        Fermion(UseridFld::class),
    )


    override fun getClassId() : String {
        return fermion.getClassId()
    }
}