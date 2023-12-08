package symmetrical.cosmic._physics.atomic.atoms.states.integers

import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter


// Where do I add Validators?   Are they Neutrons or Protons
class QInt(
    private val matter: IMatter = Matter(QInt::class, QInt::class, true),
) : Atom(),
    IMatter by matter
{

    constructor() : this(
        Matter(QInt::class, QInt::class, true),
    )   init {
        setInt(0)
    }

    override fun getClassId() : String {
        return matter.getClassId()
    }
    override fun red() : Int {
        return nucleons.getValueProton().red() as Int
    }
    fun setInt(value:Int) : QInt {
        setQuarkValue(value)
        return this
    }
}