package symmetrical.cosmic._physics.atomic.atoms.states.strings.phases

import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.angularMomentum.CRLFTerminatedMomentum
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.spin.Spin
import symmetrical.cosmic._physics.atomic.atoms.states.strings.QString
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

class CrLfTerminatedString(
    private val antiMatter: IAntiMatter = AntiMatter(CrLfTerminatedString::class),
) : QString() ,
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(CrLfTerminatedString::class),
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
        return antiMatter.getClassId()
    }

}