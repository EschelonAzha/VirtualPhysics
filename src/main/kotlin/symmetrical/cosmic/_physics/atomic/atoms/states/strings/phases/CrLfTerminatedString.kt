package symmetrical.cosmic._physics.atomic.atoms.states.strings.phases

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.angularMomentum.CRLFTerminatedMomentum
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.spin.Spin
import symmetrical.cosmic._physics.atomic.atoms.states.strings.QString

class CrLfTerminatedString : QString {
    constructor() {
        setQuarkMomentum(CRLFTerminatedMomentum())
        setQuarkSpin(Spin())
    }
    constructor(value:String) : super(value) {
        setQuarkMomentum(CRLFTerminatedMomentum())
        setQuarkSpin(Spin())
    }

    private fun getLocalClassId() : String {
        return Absorber.getClassId(CrLfTerminatedString::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }

}