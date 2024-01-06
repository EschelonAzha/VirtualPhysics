package symmetrical.cosmic.physics.subatomic.matter.quarks

import symmetrical.cosmic.physics.subatomic.anti_matter.anti_quarks.AntiUp
import symmetrical.cosmic.physics.subatomic.bosons.Photon
import symmetrical.cosmic.physics.subatomic.luminescent.IMatter
import symmetrical.cosmic.physics.subatomic.luminescent.Matter
import symmetrical.cosmic.physics.subatomic.matter.hadrons.baryons.Baryon

/*
https://en.wikipedia.org/wiki/UpQuark
 */
class Up(
    private val matter: IMatter = Matter(Up::class, AntiUp::class),
) : Quark(),
    IMatter by matter
{
    constructor() : this(
        Matter(Up::class, AntiUp::class),
    )
    init {
    }
    constructor(baryon: Baryon) : this() {
        this.p_baryon = baryon
    }
    override fun i() : Up {
        super.i()
        return this
    }
    override fun absorb(photon: Photon) : Photon {
        var remainder = photon.propagate()
        remainder = super.absorb(remainder)
        return remainder
    }
    override fun emit() : Photon {
        return Photon(radiate())
    }

    override fun getClassId() : String {
        return matter.getClassId()
    }

    override fun dissipate() : Unit {
      //  Recycler.Up_dissipate(this)
    }
    private fun radiate() : String {
        if (symmetrical.cosmic.physics.subatomic.balanced.Particle.Static.debuggingOn) {
            println("Up")
        }
        val classId:String = matter.getClassId()
        val quark  :String = super.emit().radiate()
        return classId+quark
    }
}