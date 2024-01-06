package symmetrical.cosmic.physics.atomic.atoms.states.vectors

import symmetrical.cosmic.physics.atomic.atoms.Atom
import symmetrical.cosmic.physics.subatomic.spacial.Beam
import symmetrical.cosmic.physics.subatomic.spacial.IBeam
import symmetrical.cosmic.physics.subatomic.luminescent.IMatter
import symmetrical.cosmic.physics.subatomic.luminescent.Matter
import symmetrical.cosmic.physics.subatomic.matter.quarks.Quark

open class QMass(
    private val matter: IMatter = Matter(QMass::class, QMass::class),
) : Atom(),
    IMatter by matter
{
    constructor() : this(
        Matter(QMass::class, QMass::class),
    )
    init {
        setMass(Beam(0))
    }

    override fun getClassId() : String {
        return matter.getClassId()
    }
    fun setMass(value: IBeam) : QMass {
        Quark.value(this).setWavelength(value)
        return this
    }
}