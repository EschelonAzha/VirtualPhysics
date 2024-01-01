package websites.tests.dictionary

import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.matter.bosons.ZBoson
import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Proton
import symmetrical.cosmic._physics._subatomic.matter.quarks.Down
import symmetrical.cosmic._physics._subatomic.matter.quarks.Quark

class City(
    private val matter: IMatter = Matter(City::class, City::class),
) : Atom(),
    IMatter by matter
{
    constructor() : this(
        Matter(City::class, City::class),
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
        matter.check(photon);

        var remainder = photon.propagate()
        remainder = super.absorb(remainder)
        return remainder
    }
    override fun emit() : Photon {
        val classId = matter.getClassId()
        return Photon(radiate())
    }
    override fun getClassId() : String {
        return matter.getClassId()
    }
    private fun radiate() : String {
        return matter.getClassId()+
                super.emit().radiate();
    }


}