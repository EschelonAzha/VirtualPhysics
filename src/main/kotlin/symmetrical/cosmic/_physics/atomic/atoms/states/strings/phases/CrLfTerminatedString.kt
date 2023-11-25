package symmetrical.cosmic._physics.atomic.atoms.states.strings.phases

import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.angularMomentum.CRLFTerminatedMomentum
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.spin.Spin
import symmetrical.cosmic._physics.atomic.atoms.states.strings.QString
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

class CrLfTerminatedString(
    private val fermion: ILuminescent = Luminescent(CrLfTerminatedString::class),
) : QString() {
    constructor() : this(
        Luminescent(CrLfTerminatedString::class),
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
        return fermion.getClassId()
    }

}