package symmetrical.cosmic._physics._subatomic.matter.quarks

import symmetrical.cosmic.__recycle.Recycler
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_quarks.AntiDown
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent


class Down(
    private val luminescent: ILuminescent = Luminescent(Down::class),
) : Quark(),
    ILuminescent by luminescent
{
    constructor() : this(
        Luminescent(Down::class),
    )
    init {
        setAntiMatter(AntiDown::class)
    }
    companion object {
        const val VALUE            = "VALUE"
        const val FIELD_NAME       = "FIELD-NAME"
        const val TEST_PROPERTY    = "TEST_PROPERTY"
    }


    override fun absorb(photon: Photon) : Photon {
        return super.absorb(photon.propagate())
    }
    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return luminescent.getClassId()+super.emit().radiate()
    }
    override fun getClassId() : String {
        return luminescent.getClassId()
    }
    override fun i() : Down {
        super.i()
        return this
    }

    override fun dissipate() : Unit {
        Recycler.Down_dissipate(this)
    }
}