package symmetrical.cosmic.physics.atomic.atoms.states.doubles

import symmetrical.cosmic.physics.atomic.atoms.Atom
import symmetrical.cosmic.physics.subatomic.luminescent.IMatter
import symmetrical.cosmic.physics.subatomic.luminescent.Matter
import symmetrical.cosmic.physics.subatomic.matter.quarks.Quark


class QDouble(
    private val matter: IMatter = Matter(QDouble::class, QDouble::class),
) : Atom(),
    IMatter by matter
{
    constructor() : this(
        Matter(QDouble::class, QDouble::class),
    ) init {
        setDouble(0.0)
    }

    override fun getClassId() : String {
        return matter.getClassId()
    }
    override fun getElectronWavelength() : Double {
        return super.getElectronWavelength() as Double
    }
    fun setDouble(value:Double) : QDouble {
        Quark.value(this).setWavelength(value)
        return this
    }
}