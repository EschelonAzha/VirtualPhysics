package symmetrical.cosmic.physics.atomic.atoms.states.integers

import symmetrical.cosmic.physics.atomic.atoms.Atom
import symmetrical.cosmic.physics.subatomic.luminescent.IMatter
import symmetrical.cosmic.physics.subatomic.luminescent.Matter
import symmetrical.cosmic.physics.subatomic.matter.quarks.Quark


// Where do I add Validators?   Are they Neutrons or Protons
class QInt(
    private val matter: IMatter = Matter(QInt::class, QInt::class),
) : Atom(),
    IMatter by matter
{

    constructor() : this(
        Matter(QInt::class, QInt::class),
    )   init {
        setInt(0)
    }

    override fun getClassId() : String {
        return matter.getClassId()
    }
    fun setInt(value:Int) : QInt {
        Quark.value(this).setWavelength(value)
        return this
    }
}