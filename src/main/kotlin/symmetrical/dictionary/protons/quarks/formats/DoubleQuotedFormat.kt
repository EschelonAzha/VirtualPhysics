package symmetrical.dictionary.protons.quarks.formats

import symmetrical.physics.subatomic.balanced.Particle
import symmetrical.physics.subatomic.bosons.Photon
import symmetrical.physics.subatomic.luminescent.IMatter
import symmetrical.physics.subatomic.luminescent.Matter
import symmetrical.physics.subatomic.matter.bosons.ZBoson
import symmetrical.physics.subatomic.matter.quarks.Quark
import symmetrical.physics.subatomic.matter.quarks.Up
import symmetrical.transpectors.transpectors.Strings

class DoubleQuotedFormat (
    private val matterAntiMatter: IMatter = Matter().with(DoubleQuotedFormat::class),
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

    override fun run(value: Quark, constraints: Quark) : ZBoson {
        setContent(Strings.doubleQuoted(value.getWavelength().getField().toString()))
        return ZBoson()
    }
    private fun radiate() : String {
        if (Particle.Static.debuggingOn) {
            println("DoubleQuotedFormat")
        }
        val classId:String = matterAntiMatter.getClassId()
        val quark  :String = super.emit().radiate()
        return classId+quark
    }
}