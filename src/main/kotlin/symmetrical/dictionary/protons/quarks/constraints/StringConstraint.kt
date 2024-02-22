package symmetrical.dictionary.protons.quarks.constraints

import symmetrical.physics.subatomic.balanced.Particle
import symmetrical.physics.subatomic.bosons.Photon
import symmetrical.physics.subatomic.luminescent.IMatter
import symmetrical.physics.subatomic.luminescent.Matter
import symmetrical.physics.subatomic.matter.bosons.ZBoson
import symmetrical.physics.subatomic.matter.quarks.Quark
import symmetrical.physics.subatomic.matter.quarks.Up

class StringConstraint (
    private val matterAntiMatter: IMatter = Matter().with(StringConstraint::class),
) : Up(),
    IMatter by matterAntiMatter
{

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
    override fun mediate(value: Quark, format: Quark, zBoson:ZBoson) : ZBoson {
        if (value.getWavelength().getContent() == null) {
            zBoson.setAccepted(false)
            zBoson.setReason("Must not be null")
            zBoson.setReasonCode(-1);
        }
        return zBoson
    }

    private fun radiate() : String {
        if (Particle.Static.debuggingOn) {
            println("StringConstraint")
        }
        val classId:String = matterAntiMatter.getClassId()
        val quark  :String = super.emit().radiate()
        return classId+quark
    }
}