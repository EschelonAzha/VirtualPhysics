package symmetrical.cosmic.dictionary.protons

import symmetrical.cosmic.physics.subatomic.balanced.Particle
import symmetrical.cosmic.physics.subatomic.bosons.Photon
import symmetrical.cosmic.physics.subatomic.luminescent.IMatter
import symmetrical.cosmic.physics.subatomic.luminescent.Matter
import symmetrical.cosmic.physics.subatomic.matter.hadrons.baryons.Proton

class AccessLevelProton (
    private val matterAntiMatter: IMatter = Matter().with(AccessLevelProton::class),
) : Proton(),
    IMatter by matterAntiMatter
{
    object Static {
        const val NO_ACCESS = "-1"
        const val READ_ONLY = "0"
        const val UPDATE    = "1"
    }
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
            println("AccessLevelProton")
        }
        val classId : String = matterAntiMatter.getClassId()
        val proton  : String = super.emit().radiate()
        return classId+proton

    }

}