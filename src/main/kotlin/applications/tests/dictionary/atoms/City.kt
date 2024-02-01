package applications.tests.dictionary.atoms

import symmetrical.cosmic.physics.subatomic.matter.quarks.Quark
import symmetrical.cosmic.physics.atomic.atoms.Atom
import symmetrical.cosmic.physics.atomic.atoms.elements.Hydrogen
import symmetrical.cosmic.physics.subatomic.bosons.Photon
import symmetrical.cosmic.physics.subatomic.luminescent.IMatter
import symmetrical.cosmic.physics.subatomic.luminescent.Matter

class City(
    private val matterAntiMatter: IMatter = Matter().with(City::class)
) : Hydrogen(),
    IMatter by matterAntiMatter
{
    init {
        setContent("", true)
    }

    fun with(value:String) : City {
        setContent(value, true)
        return this
    }

    override fun absorb(photon: Photon) : Photon {
        return super.absorb(matterAntiMatter.check(photon).propagate())
    }
    override fun emit() : Photon {
        return Photon().with(radiate())
    }
    private fun radiate() : String {
        return matterAntiMatter.getClassId()+super.emit().radiate()
    }

}