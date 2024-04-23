package symmetrical.physics.atomic.atoms.elements

import symmetrical.physics.atomic.atoms.Atom
import symmetrical.physics.subatomic.bosons.Photon
import symmetrical.physics.subatomic.luminescent.IMatter
import symmetrical.physics.subatomic.luminescent.Matter
import symmetrical.physics.subatomic.matter.hadrons.baryons.Proton

open class Beryllium (
    private val matterAntiMatter: IMatter = Matter().with(Beryllium::class),
) : Atom(),
    IMatter by matterAntiMatter
{
    override fun with(value:Any?) : Beryllium {
        super.with(value)
        return this
    }
    fun protons(proton1: Proton, proton2: Proton, proton3: Proton) : Beryllium {    // All Atoms are  automatically constructed with one Proton
        addProtons(arrayOf(proton1, proton2, proton3)) // To make Beryllium we must supply 3 more protons beyond Hydrogen
        return this
    }




    // ########################### EMISSIONS ###########################
    override fun absorb(photon: Photon) : Photon {
        return super.absorb(matterAntiMatter.check(photon).propagate())
    }
    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }
    override fun emit() : Photon {
        return Photon().with(radiate())
    }
    private fun radiate() : String {
        return matterAntiMatter.getClassId()+super.emit().radiate()
    }
    // ########################### EMISSIONS ###########################
}