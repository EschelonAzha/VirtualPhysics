package symmetrical.cosmic.physics.atomic.atoms.states.booleans

import symmetrical.cosmic.physics.atomic.atoms.Atom
import symmetrical.cosmic.physics.subatomic.matter.quarks.Quark
import symmetrical.cosmic.physics.subatomic.luminescent.IMatterAntiMatter
import symmetrical.cosmic.physics.subatomic.luminescent.MatterAntiMatter

class QBoolean(
    private val matterAntiMatter: IMatterAntiMatter = MatterAntiMatter(QBoolean::class, QBoolean::class),
) : Atom(),
    IMatterAntiMatter by matterAntiMatter
{
    constructor() : this(
        MatterAntiMatter(QBoolean::class, QBoolean::class),
    )  init {
        setBoolean(false)
    }

    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }
    fun setBoolean(value:Boolean) : QBoolean {
        Quark.value(this).setWavelength(value)
        return this
    }
}