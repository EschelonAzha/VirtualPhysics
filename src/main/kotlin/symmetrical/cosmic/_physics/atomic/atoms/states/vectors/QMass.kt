package symmetrical.cosmic._physics.atomic.atoms.states.vectors

import symmetrical.cosmic._physics._subatomic.spacial.Beam
import symmetrical.cosmic._physics._subatomic.spacial.IBeam
import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter

open class QMass(
    private val matter: IMatter = Matter(QMass::class, QMass::class, true),
) : Atom(),
    IMatter by matter
{
    constructor() : this(
        Matter(QMass::class, QMass::class, true),
    )
    init {
        setMass(Beam(0))
    }

    override fun getClassId() : String {
        return matter.getClassId()
    }
    override fun red() : IBeam {
        return nucleons.getValueProton().red() as IBeam
    }
    fun setMass(value: IBeam) : QMass {
        setQuarkValue(value)
        return this
    }
}