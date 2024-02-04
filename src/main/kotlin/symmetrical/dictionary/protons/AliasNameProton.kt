package symmetrical.dictionary.protons

import symmetrical.physics.subatomic.balanced.Particle
import symmetrical.physics.subatomic.bosons.Photon
import symmetrical.physics.subatomic.luminescent.IMatter
import symmetrical.physics.subatomic.luminescent.Matter
import symmetrical.physics.subatomic.matter.hadrons.baryons.Proton

class AliasNameProton(
    private val matterAntiMatter: IMatter = Matter().with(AliasNameProton::class),
) : Proton(),
    IMatter by matterAntiMatter
{
    override fun absorb(photon: Photon) : Photon {
        matterAntiMatter.check(photon);

        var remainder = photon.propagate()
        remainder = super.absorb(remainder)
        return remainder
    }
    override fun emit() : Photon {
        val classId = matterAntiMatter.getClassId()
        return Photon().with(radiate())
    }

    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }
    private fun radiate() : String {
        if (Particle.Static.debuggingOn) {
            println("AliasNameProton")
        }
        val classId : String = matterAntiMatter.getClassId()
        val proton  : String = super.emit().radiate()
        return classId+proton

    }

}