package applications.tests.dictionary.atoms

import symmetrical.cosmic.dictionary.protons.AccessLevelProton
import symmetrical.cosmic.dictionary.protons.FieldNameProton
import symmetrical.physics.subatomic.matter.quarks.Quark
import symmetrical.physics.atomic.atoms.Atom
import symmetrical.physics.atomic.atoms.elements.Helium
import symmetrical.physics.atomic.atoms.elements.Hydrogen
import symmetrical.physics.atomic.atoms.elements.Lithium
import symmetrical.physics.subatomic.bosons.Photon
import symmetrical.physics.subatomic.luminescent.IMatter
import symmetrical.physics.subatomic.luminescent.Matter
import symmetrical.physics.subatomic.matter.hadrons.baryons.Proton

class Address(
    private val matterAntiMatter: IMatter = Matter().with(Address::class),
) : Lithium(),
    IMatter by matterAntiMatter
{
    init {
        setContent("", true)
        val fieldName   : Proton = FieldNameProton().with("Address")
        val accessLevel : Proton = AccessLevelProton().with(AccessLevelProton.Static.READ_ONLY)
        protons(fieldName, accessLevel)
    }

    fun with(value:String) : Address {
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