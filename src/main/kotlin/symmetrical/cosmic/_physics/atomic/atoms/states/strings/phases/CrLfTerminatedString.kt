package symmetrical.cosmic._physics.atomic.atoms.states.strings.phases

import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.angularMomentum.CRLFTerminatedMomentum
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.spin.SpinOld
import symmetrical.cosmic._physics.atomic.atoms.states.strings.QString
import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter

class CrLfTerminatedString(
    private val matter: IMatter = Matter(CrLfTerminatedString::class, CrLfTerminatedString::class),
) : QString() ,
    IMatter by matter
{
    constructor() : this(
        Matter(CrLfTerminatedString::class, CrLfTerminatedString::class),
    ) {
        setQuarkMomentum(CRLFTerminatedMomentum())
        setQuarkSpin(SpinOld())
    }
    constructor(value:String) : this() {
        setString(value)
        setQuarkMomentum(CRLFTerminatedMomentum())
        setQuarkSpin(SpinOld())
    }


    override fun getClassId() : String {
        return matter.getClassId()
    }

}