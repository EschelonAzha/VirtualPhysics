package symmetrical.cosmic._physics.atomic.atoms.states.strings.phases

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.angularMomentum.CRLFTerminatedMomentum
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.spin.Spin
import symmetrical.cosmic._physics.atomic.atoms.states.strings.QString
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

class CrLfTerminatedString(
    private val fermion: IFermion = Fermion(CrLfTerminatedString::class),
) : QString() {
    constructor() : this(
        Fermion(CrLfTerminatedString::class),
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