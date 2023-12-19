package symmetrical.cosmic._physics.atomic.atoms.states.doubles

import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter
import symmetrical.cosmic._physics.atomic.atoms.Atom


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
    override fun red() : Double {
        return nucleons.getValueProton().red() as Double
    }
    override fun getElectronWavelength() : Double {
        return super.getElectronWavelength() as Double
    }
    fun setDouble(value:Double) : QDouble {
        setQuarkValue(value)
        return this
    }
}