package symmetrical.cosmic.dictionary.protons

import symmetrical.cosmic._physics._subatomic.anti_matter.anti_hadrons.anti_baryons.AntiProton
import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter
import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Baryon
import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Proton

class ValueProton(
    private val matter: IMatter = Matter(ValueProton::class, ValueProton::class),
) : Proton(),
    IMatter by matter
{
    constructor() : this(
        Matter(ValueProton::class, ValueProton::class),
    ) init {

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
        if (Particle.Static.debuggingOn) {
            println("ValueProton")
        }
        val classId : String = matter.getClassId()
        val proton  : String = super.emit().radiate()
        return classId+proton

    }

}