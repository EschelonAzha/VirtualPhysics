package symmetrical.cosmic._physics.atomic.atoms.states.vectors

import symmetrical.cosmic._physics._subatomic.spacial.Beam
import symmetrical.cosmic._physics._subatomic.spacial.IBeam
import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter
import symmetrical.cosmic._physics._subatomic.matter.quarks.Quark
import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic.dictionary.protons.ValueProton

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