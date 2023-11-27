package symmetrical.cosmic._physics.atomic.atoms.states.vectors

import symmetrical.cosmic._physics._subatomic.spacial.Beam
import symmetrical.cosmic._physics._subatomic.spacial.IBeam
import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

open class QMass(
    private val antiMatter: AntiMatter = AntiMatter(QMass::class),
) : Atom(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(QMass::class),
    )
    init {
        setMass(Beam(0))
    }

    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
    override fun red() : IBeam {
        return nucleons.getValueProton().red() as IBeam
    }
    fun setMass(value: IBeam) : QMass {
        setQuarkValue(value)
        return this
    }
}