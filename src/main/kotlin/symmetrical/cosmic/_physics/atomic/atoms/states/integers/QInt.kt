package symmetrical.cosmic._physics.atomic.atoms.states.integers

import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent


// Where do I add Validators?   Are they Neutrons or Protons
class QInt(
    private val fermion: Luminescent = Luminescent(QInt::class),
) : Atom(),
    ILuminescent by fermion
{

    constructor() : this(
        Luminescent(QInt::class),
    )   init {
        setInt(0)
    }

    override fun getClassId() : String {
        return fermion.getClassId()
    }
    override fun red() : Int {
        return nucleons.getValueProton().red() as Int
    }
    fun setInt(value:Int) : QInt {
        setQuarkValue(value)
        return this
    }
}