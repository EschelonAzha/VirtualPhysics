package symmetrical.cosmic._physics.atomic.atoms.states.doubles

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion


class QDouble(
    private val fermion: Fermion = Fermion(QDouble::class),
) : Atom(),
    IFermion by fermion
{
    constructor() : this(
        Fermion(QDouble::class),
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