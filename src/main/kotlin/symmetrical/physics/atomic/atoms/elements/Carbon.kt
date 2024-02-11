package symmetrical.physics.atomic.atoms.elements

import symmetrical.physics.atomic.atoms.Atom
import symmetrical.physics.subatomic.bosons.Photon
import symmetrical.physics.subatomic.luminescent.IMatter
import symmetrical.physics.subatomic.luminescent.Matter
import symmetrical.physics.subatomic.matter.hadrons.baryons.Proton

class Carbon (
    private val matterAntiMatter: IMatter = Matter().with(Carbon::class),
) : Atom(),
    IMatter by matterAntiMatter
{
    override fun with(value:Any?) : Carbon {
        super.with(value)
        return this
    }
    fun protons(proton1: Proton, proton2: Proton, proton3: Proton, proton4: Proton, proton5: Proton) : Carbon {    // All Atoms are  automatically constructed with one Proton
        addProtons(arrayOf(proton1, proton2, proton3, proton4, proton5))   // To make Carbon we must supply 5 more protons beyond Hydrogen
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