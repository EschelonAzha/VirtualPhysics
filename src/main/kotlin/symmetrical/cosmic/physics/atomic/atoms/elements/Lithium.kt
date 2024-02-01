package symmetrical.cosmic.physics.atomic.atoms.elements

import symmetrical.cosmic.physics.atomic.atoms.Atom
import symmetrical.cosmic.physics.subatomic.bosons.Photon
import symmetrical.cosmic.physics.subatomic.luminescent.IMatter
import symmetrical.cosmic.physics.subatomic.luminescent.Matter
import symmetrical.cosmic.physics.subatomic.matter.hadrons.baryons.Proton

open class Lithium (
    private val matterAntiMatter: IMatter = Matter().with(Lithium::class),
) : Atom(),
    IMatter by matterAntiMatter
{
    fun protons(proton1: Proton, proton2:Proton) : Lithium {
        addProtons(arrayOf(proton1, proton2))
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