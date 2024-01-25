package applications.tests.dictionary.atoms

import symmetrical.cosmic.physics.atomic.atoms.Atom
import symmetrical.cosmic.physics.subatomic.luminescent.IMatter
import symmetrical.cosmic.physics.subatomic.luminescent.Matter
import symmetrical.cosmic.physics.subatomic.bosons.Photon
import symmetrical.cosmic.physics.subatomic.matter.bosons.ZBoson
import symmetrical.cosmic.physics.subatomic.matter.hadrons.baryons.Proton
import symmetrical.cosmic.physics.subatomic.matter.quarks.Down
import symmetrical.cosmic.physics.subatomic.matter.quarks.Quark

class Resistor(
    private val matterAntiMatter: IMatter = Matter().with(Resistor::class),
) : Atom(),
    IMatter by matterAntiMatter
{

    override fun with(content:Any?) : Resistor {
        setContent("", true)
        return this
    }
    override fun valueChange(proton: Proton, valueQuark: Down, zBoson: ZBoson) : ZBoson {
     //   accept(valueQuark, zBoson)

        reject(20, "Nope!", zBoson)

        return zBoson
    }
    override fun absorb(photon: Photon) : Photon {
        return super.absorb(matterAntiMatter.check(photon).propagate())
    }
    override fun emit() : Photon {
        val classId = matterAntiMatter.getClassId()
        return Photon().with(radiate())
    }
    private fun radiate() : String {
        return matterAntiMatter.getClassId()+super.emit().radiate()
    }
}