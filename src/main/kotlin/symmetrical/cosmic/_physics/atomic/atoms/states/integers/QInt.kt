package symmetrical.cosmic._physics.atomic.atoms.states.integers

import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter


// Where do I add Validators?   Are they Neutrons or Protons
class QInt(
    private val antiMatter: AntiMatter = AntiMatter(QInt::class),
) : Atom(),
    IAntiMatter by antiMatter
{

    constructor() : this(
        AntiMatter(QInt::class),
    )   init {
        setInt(0)
    }

    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
    override fun red() : Int {
        return nucleons.getValueProton().red() as Int
    }
    fun setInt(value:Int) : QInt {
        setQuarkValue(value)
        return this
    }
}