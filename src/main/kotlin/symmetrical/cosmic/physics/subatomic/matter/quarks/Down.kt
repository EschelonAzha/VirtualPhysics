package symmetrical.cosmic.physics.subatomic.matter.quarks

import symmetrical.cosmic.physics.subatomic.bosons.Photon
import symmetrical.cosmic.physics.subatomic.anti_matter.anti_quarks.AntiDown
import symmetrical.cosmic.physics.subatomic.balanced.Particle
import symmetrical.cosmic.physics.subatomic.luminescent.IMatter
import symmetrical.cosmic.physics.subatomic.luminescent.Matter
import symmetrical.cosmic.physics.subatomic.matter.hadrons.baryons.Baryon

/*
https://en.wikipedia.org/wiki/DownQuark
 */

class Down(
    private val matter: IMatter = Matter(Down::class, AntiDown::class),
) : Quark(),
    IMatter by matter
{
    constructor() : this(
        Matter(Down::class, AntiDown::class),
    )
    init {
    }
    constructor(baryon: Baryon) : this() {
        this.p_baryon = baryon
    }
    companion object {
        const val VALUE            = "VALUE"
        const val FIELD_NAME       = "FIELD-NAME"
        const val TEST_PROPERTY    = "TEST_PROPERTY"
    }
    override fun i() : Down {
        super.i()
        return this
    }

    override fun absorb(photon: Photon) : Photon {
        var remainder = photon.propagate()
        remainder = super.absorb(remainder)
        return remainder
    }
    override fun dissipate() : Unit {
        // Recycler.Down_dissipate(this)
    }
    override fun emit() : Photon {
        return Photon(radiate())
    }

    override fun getClassId() : String {
        return matter.getClassId()
    }


    private fun radiate() : String {
        if (Particle.Static.debuggingOn) {
            println("Down")
        }
        val classId : String = matter.getClassId()
        val quark   : String = super.emit().radiate()
        return classId+quark

    }
}