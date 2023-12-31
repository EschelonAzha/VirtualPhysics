package symmetrical.cosmic._physics.atomic.atoms.states.booleans

import symmetrical.cosmic._physics._subatomic.luminescent.*
import symmetrical.cosmic._physics._subatomic.matter.quarks.Quark
import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic.dictionary.protons.ValueProton

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
    override fun red() : Boolean {
        return nucleons.getProton(ValueProton::class).red() as Boolean
    }
    fun setBoolean(value:Boolean) : QBoolean {
        Quark.value(this).setWavelength(value)
        return this
    }
}