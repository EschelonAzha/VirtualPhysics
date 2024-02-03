package applications.tests.dictionary.atoms

import symmetrical.physics.atomic.atoms.Atom
import symmetrical.physics.atomic.atoms.elements.Hydrogen
import symmetrical.physics.subatomic.luminescent.IMatter
import symmetrical.physics.subatomic.luminescent.Matter
import symmetrical.physics.subatomic.bosons.Photon
import symmetrical.physics.subatomic.matter.bosons.ZBoson
import symmetrical.physics.subatomic.matter.hadrons.baryons.Proton
import symmetrical.physics.subatomic.matter.quarks.Down
import symmetrical.physics.subatomic.matter.quarks.Quark

class Resistor(
    private val matterAntiMatter: IMatter = Matter().with(Resistor::class),
) : symmetrical.physics.atomic.atoms.elements.Hydrogen(),
    IMatter by matterAntiMatter
{

    override fun valueChange(proton: symmetrical.physics.subatomic.matter.hadrons.baryons.Proton, valueQuark: Down, zBoson: symmetrical.physics.subatomic.matter.bosons.ZBoson) : symmetrical.physics.subatomic.matter.bosons.ZBoson {
        // accept(valueQuark, zBoson)

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