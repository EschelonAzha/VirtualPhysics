package symmetrical.physics.atomic.atoms.elements

import symmetrical.physics.atomic.atoms.Atom
import symmetrical.physics.subatomic.bosons.Photon
import symmetrical.physics.subatomic.luminescent.IMatter
import symmetrical.physics.subatomic.luminescent.Matter
import symmetrical.physics.subatomic.matter.hadrons.baryons.Proton

class Boron (
    private val matterAntiMatter: IMatter = Matter().with(Boron::class),
) : Atom(),
    IMatter by matterAntiMatter
{
    override fun with(value:Any?) : Boron {
        super.with(value)
        return this
    }
    fun protons(proton1: Proton, proton2: Proton, proton3: Proton, proton4: Proton) : Boron {    // All Atoms are  automatically constructed with one Proton
        addProtons(arrayOf(proton1, proton2, proton3, proton4)) // To make Boron we must supply 4 more protons beyond Hydrogen
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