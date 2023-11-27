package symmetrical.cosmic._physics.atomic.atoms.states.doubles

import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter


class QDouble(
    private val antiMatter: AntiMatter = AntiMatter(QDouble::class),
) : Atom(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(QDouble::class),
    ) init {
        setDouble(0.0)
    }

    override fun getClassId() : String {
        return antiMatter.getClassId()
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