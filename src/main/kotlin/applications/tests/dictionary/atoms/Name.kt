package applications.tests.dictionary.atoms

import symmetrical.cosmic.physics.subatomic.matter.quarks.Quark
import symmetrical.cosmic.physics.atomic.atoms.Atom
import symmetrical.cosmic.physics.atomic.atoms.states.strings.QString
import symmetrical.cosmic.physics.subatomic.bosons.Photon
import symmetrical.cosmic.physics.subatomic.luminescent.IMatter
import symmetrical.cosmic.physics.subatomic.luminescent.Matter

class Name (
    private val matterAntiMatter: IMatter,
) : Atom(),
    IMatter by matterAntiMatter
{
    constructor() : this(
        Matter(Name::class),
    )   init {
        Quark.value(this).setWavelength("")
    }

    constructor(value:String) : this() {
        Quark.value(this).setWavelength(value)
    }
    override fun absorb(photon: Photon) : Photon {
        matterAntiMatter.check(photon)
        return super.absorb(photon.propagate())
    }
    override fun emit() : Photon {
        return Photon(radiate())
    }


    private fun radiate() : String {
        return matterAntiMatter.getClassId()+super.emit().radiate()
    }

}