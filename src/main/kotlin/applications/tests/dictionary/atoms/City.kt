package applications.tests.dictionary.atoms

import symmetrical.cosmic.dictionary.protons.AccessLevelProton
import symmetrical.cosmic.dictionary.protons.FieldNameProton
import symmetrical.cosmic.physics.subatomic.matter.quarks.Quark
import symmetrical.cosmic.physics.atomic.atoms.Atom
import symmetrical.cosmic.physics.atomic.atoms.elements.Helium
import symmetrical.cosmic.physics.atomic.atoms.elements.Hydrogen
import symmetrical.cosmic.physics.atomic.atoms.elements.Lithium
import symmetrical.cosmic.physics.subatomic.bosons.Photon
import symmetrical.cosmic.physics.subatomic.luminescent.IMatter
import symmetrical.cosmic.physics.subatomic.luminescent.Matter
import symmetrical.cosmic.physics.subatomic.matter.hadrons.baryons.Proton

class City(
    private val matterAntiMatter: IMatter = Matter().with(City::class)
) : Lithium(),
    IMatter by matterAntiMatter
{
    init {
        setContent("", true)

        val fieldName   : Proton = FieldNameProton().with("City")
        val accessLevel : Proton = AccessLevelProton().with(AccessLevelProton.Static.READ_ONLY)
        protons(fieldName, accessLevel)
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