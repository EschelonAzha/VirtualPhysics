package symmetrical.cosmic._physics.atomic.atoms.states.strings.phases

import symmetrical.cosmic.dictionary.formats.CRLFTerminatedMomentum
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.spin.Spin
import symmetrical.cosmic._physics.atomic.atoms.states.strings.QString
import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter
import symmetrical.cosmic._physics._subatomic.matter.quarks.Quark

class CrLfTerminatedString(
    private val matter: IMatter = Matter(CrLfTerminatedString::class, CrLfTerminatedString::class),
) : QString() ,
    IMatter by matter
{
    constructor() : this(
        Matter(CrLfTerminatedString::class, CrLfTerminatedString::class),
    ) {
        Quark.value(this).setAngularMomentum(CRLFTerminatedMomentum())
        Quark.value(this).setSpin(Spin())
    }
    constructor(value:String) : this() {
        setString(value)
        Quark.value(this).setAngularMomentum(CRLFTerminatedMomentum())
        Quark.value(this).setSpin(Spin())
    }


    override fun getClassId() : String {
        return matter.getClassId()
    }

}