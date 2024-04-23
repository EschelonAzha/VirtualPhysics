package symmetrical.dictionary.protons.quarks.formats

import symmetrical.physics.subatomic.balanced.Particle
import symmetrical.physics.subatomic.bosons.Photon
import symmetrical.physics.subatomic.luminescent.IMatter
import symmetrical.physics.subatomic.luminescent.Matter
import symmetrical.physics.subatomic.matter.bosons.ZBoson
import symmetrical.physics.subatomic.matter.quarks.Quark
import symmetrical.physics.subatomic.matter.quarks.Up
import symmetrical.transpectors.transpectors.Strings

class CRLFTerminatedFormat(
    private val matterAntiMatter: IMatter = Matter().with(CRLFTerminatedFormat::class),
) : Up(),
    IMatter by matterAntiMatter
{

    override fun mediate(value: Quark, constraints:Quark, zBoson:ZBoson) : ZBoson {
        setContent(Strings.crlfTerminated(value.getWavelength().getField().toString()))
        return zBoson
    }





    // ########################### EMISSIONS ###########################
    override fun absorb(photon: Photon) : Photon {
        var remainder = photon.propagate()
        remainder = super.absorb(remainder)
        return remainder
    }
    override fun emit() : Photon {
        return Photon().with(radiate())
    }
    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }
    private fun radiate() : String {
        if (Particle.Static.debuggingOn) {
            println("CRLFTerminated")
        }
        val classId:String = matterAntiMatter.getClassId()
        val quark  :String = super.emit().radiate()
        return classId+quark
    }
    // ########################### EMISSIONS ###########################
}