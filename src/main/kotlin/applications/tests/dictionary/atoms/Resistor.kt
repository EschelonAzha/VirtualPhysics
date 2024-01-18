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
    private val matterAntiMatter: IMatter,
) : Atom(),
    IMatter by matterAntiMatter
{
    constructor() : this(
        Matter(Resistor::class),
    ) init {

    }
    constructor(content:Any?) : this(){
        Quark.value(this).setWavelength(content)
    }
    override fun valueChange(proton: Proton, valueQuark: Down, zBoson: ZBoson) : ZBoson {
     //   accept(valueQuark, zBoson)

        reject(20, "Nope!", zBoson)

        return zBoson
    }
    override fun absorb(photon: Photon) : Photon {
        matterAntiMatter.check(photon);

        var remainder = photon.propagate()
        remainder = super.absorb(remainder)
        return remainder
    }
    override fun emit() : Photon {
        val classId = matterAntiMatter.getClassId()
        return Photon(radiate())
    }
    private fun radiate() : String {
        return matterAntiMatter.getClassId()+super.emit().radiate()
    }

}