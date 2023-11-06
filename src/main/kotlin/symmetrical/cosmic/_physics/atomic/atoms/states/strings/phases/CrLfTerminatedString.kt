package symmetrical.cosmic._physics.atomic.atoms.states.strings.phases

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.spin.CRLFTerminatedSpin
import symmetrical.cosmic._physics.atomic.atoms.states.strings.QString

class CrLfTerminatedString : QString {
    constructor() {
 //       setGreen(CRLFTerminatedColor())
        setQuarkSpin(CRLFTerminatedSpin())
    }
    constructor(value:String) : super(value) {
   //     setGreen(CRLFTerminatedColor())
        setQuarkSpin(CRLFTerminatedSpin())
    }

    private fun getLocalClassId() : String {
        return Absorber.getClassId(CrLfTerminatedString::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }

}