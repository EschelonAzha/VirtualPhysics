package symmetrical.cosmic._physics.atomic.atoms.states.vectors

import symmetrical.cosmic._physics._subatomic.spatial.Beam
import symmetrical.cosmic._physics._subatomic.spatial.IBeam
import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

open class QMass(
    private val luminescent: Luminescent = Luminescent(QMass::class),
) : Atom(),
    ILuminescent by luminescent
{
    constructor() : this(
        Luminescent(QMass::class),
    )
    init {
        setMass(Beam(0))
    }

    override fun getClassId() : String {
        return luminescent.getClassId()
    }
    override fun red() : IBeam {
        return nucleons.getValueProton().red() as IBeam
    }
    fun setMass(value: IBeam) : QMass {
        setQuarkValue(value)
        return this
    }
}