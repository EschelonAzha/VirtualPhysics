package symmetrical.cosmic._physics.atomic.atoms.states.strings.phases

import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.angularMomentum.CRLFTerminatedMomentum
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.spin.Spin
import symmetrical.cosmic._physics.atomic.atoms.states.strings.QString
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter

class CrLfTerminatedString(
    private val matter: IMatter = Matter(CrLfTerminatedString::class, CrLfTerminatedString::class, true),
) : QString() ,
    IMatter by matter
{
    constructor() : this(
        Matter(CrLfTerminatedString::class, CrLfTerminatedString::class, true),
    ) {
        setQuarkMomentum(CRLFTerminatedMomentum())
        setQuarkSpin(Spin())
    }
    constructor(value:String) : this() {
        setString(value)
        setQuarkMomentum(CRLFTerminatedMomentum())
        setQuarkSpin(Spin())
    }


    override fun getClassId() : String {
        return matter.getClassId()
    }

}