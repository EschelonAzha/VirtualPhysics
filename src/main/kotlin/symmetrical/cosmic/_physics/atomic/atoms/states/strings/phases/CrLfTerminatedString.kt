package symmetrical.cosmic._physics.atomic.atoms.states.strings.phases

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.angularMomentum.CRLFTerminatedMomentum
import symmetrical.cosmic._physics.atomic.atoms.states.strings.QString

class CrLfTerminatedString : QString {
    constructor() {
 //       setGreen(CRLFTerminatedColor())
        setQuarkMomentum(CRLFTerminatedMomentum())
     //   setQuarkSpin(CRLFTerminatedSpin())
    }
    constructor(value:String) : super(value) {
   //     setGreen(CRLFTerminatedColor())
        setQuarkMomentum(CRLFTerminatedMomentum())
     //   setQuarkSpin(CRLFTerminatedSpin())
    }

    private fun getLocalClassId() : String {
        return Absorber.getClassId(CrLfTerminatedString::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }

}