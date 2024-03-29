package applications.tests.dictionary.atoms

import symmetrical.dictionary.protons.AccessLevelProton
import symmetrical.dictionary.protons.FieldNameProton
import symmetrical.physics.atomic.atoms.elements.Lithium
import symmetrical.physics.subatomic.bosons.Photon
import symmetrical.physics.subatomic.luminescent.IMatter
import symmetrical.physics.subatomic.luminescent.Matter
import symmetrical.physics.subatomic.matter.hadrons.baryons.Proton

class Name (
    private val matterAntiMatter: IMatter = Matter().with(Name::class),
) : Lithium(),
    IMatter by matterAntiMatter
{
    init {
        setAtomicValue("", true)

        val fieldName   : Proton = FieldNameProton().with("Name")
        val accessLevel : Proton = AccessLevelProton().with(AccessLevelProton.Static.READ_ONLY)
        protons(fieldName, accessLevel)
    }

    fun with(value:String) : Name {
        setAtomicValue("", true)
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