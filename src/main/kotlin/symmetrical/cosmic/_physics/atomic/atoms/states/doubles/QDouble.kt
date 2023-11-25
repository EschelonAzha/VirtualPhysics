package symmetrical.cosmic._physics.atomic.atoms.states.doubles

import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent


class QDouble(
    private val fermion: Luminescent = Luminescent(QDouble::class),
) : Atom(),
    ILuminescent by fermion
{
    constructor() : this(
        Luminescent(QDouble::class),
    ) init {
        setDouble(0.0)
    }

    override fun getClassId() : String {
        return fermion.getClassId()
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